package com.CaseStudy.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.CaseStudy.models.UserSignUp;
import com.google.gson.Gson;
import com.welcomeHomeRealtyCaseStudy.entities.Apartment;
import com.welcomeHomeRealtyCaseStudy.entities.Building;
import com.welcomeHomeRealtyCaseStudy.entities.Invoice;
import com.welcomeHomeRealtyCaseStudy.entities.Tenant;
import com.welcomeHomeRealtyCaseStudy.entities.UserLogin;
import com.welcomeHomeRealtyCaseStudy.services.ApartmentServices;
import com.welcomeHomeRealtyCaseStudy.services.BuildingServices;
import com.welcomeHomeRealtyCaseStudy.services.InvoiceServices;
import com.welcomeHomeRealtyCaseStudy.services.TenantServices;
import com.welcomeHomeRealtyCaseStudy.services.UserLoginServices;
@Controller
@SessionAttributes("userLogin")
public class MainController {
	BuildingServices buildingService = new BuildingServices();
	ApartmentServices apartmentService = new ApartmentServices();
	TenantServices tenantService = new TenantServices();
	InvoiceServices invoiceService = new InvoiceServices();
	UserLoginServices userLoginService = new UserLoginServices();
	
	@ModelAttribute("userLogin")
	public UserLogin setUpUserLogin() {
		
		return new UserLogin();
	}
	
	@RequestMapping(value = {"/","/index"})  
	public String indexHandler() {
		
		return "index"; 
	}
	
	@RequestMapping("/loginProfile")  
	public String loginProfileHandler() {
		return "login";
	}
	@RequestMapping("/login")  
	public ModelAndView loginHandler(@ModelAttribute("userLogin") UserLogin userLogin) {
		ModelAndView mav = new ModelAndView();
		String message ="";
		boolean result = userLoginService.validateUserLoginService(userLogin.getUserName(), userLogin.getPassword());
		
		if(result) {
			
			UserLogin newLogin = userLoginService.getUserLoginByUsernameService(userLogin.getUserName());
			userLogin.setUserName(newLogin.getUserName());
			userLogin.setPassword(newLogin.getPassword());
			userLogin.setTenant(newLogin.getTenant());
			userLogin.setRole(newLogin.getRole());
			System.out.println(userLogin);
			mav.addObject("userLogin",userLogin);
			mav.setViewName("index");
		}
		else {
			message = "Invalid login. Please try again or call the office for assistance.";
			mav.addObject("message",message);
			mav.setViewName("login");
		}

		return mav; 
	}
	
	@RequestMapping("/logout")
	public String logoutHandler(HttpSession session, SessionStatus status){
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		sessionUser.setUserName(null);
		System.out.println(sessionUser);
		status.setComplete();
		session.invalidate();
		return "login";
	}
	
	
	@RequestMapping("/signUpProfile")  
	public ModelAndView signUpProfileHandler(@ModelAttribute("message") String message) {
		ModelAndView mav= new ModelAndView("signUp");
		List<Building> buildingList = buildingService.showAllBuildingsService();
		Map<Integer,Map<Integer,String>> buildingApartmentMap = new HashMap<>();
		Building building = buildingService.showAllBuildingsService().get(0);
		List<Apartment> apartmentList = apartmentService.showAllApartmentsByBuildingService(building);
		for(Building b:buildingList) {
			List<Apartment>listApartments = apartmentService.showAllApartmentsByBuildingService(b);
			Map<Integer,String> mapApartmentIdBuilding = new HashMap<>();
			for(Apartment a: listApartments) {
				mapApartmentIdBuilding.put(a.getApartmentId(),a.getApartmentName());
			}
			buildingApartmentMap.put(b.getBuildingId(), mapApartmentIdBuilding);
		}

		
		mav.addObject("buildingApartmentMap",buildingApartmentMap);
		mav.addObject("buildingList",buildingList);
		mav.addObject("building",building);
		mav.addObject("apartmentList", apartmentList);
		return mav; 
	}
	@RequestMapping("/signup")
	public String signUpHandler(@ModelAttribute("userSignUp") UserSignUp userSignUp){
		String message ="";
		Apartment apartment = apartmentService.getApartmentByIdService(userSignUp.getApartmentId());
		Tenant tenant = new Tenant(apartment,userSignUp.getFirstName(),userSignUp.getLastName(), userSignUp.getPhoneNumber(),userSignUp.getEmail());
		int result = userLoginService.validateUserSignUpService(tenant, userSignUp.getUserName(), userSignUp.getPassword());
		if(result==1) {
			message = "User Account Created";
		}
		else if(result ==2) {
			message ="Error: That username is taken. Please pick another";
		}
		else if(result ==3) {
			message ="Error: You already Have an account. Call the office for help.";
		}
		else {
			message = "Error: Tenant account not found. Call the office for help.";
		}
		return "redirect:/signUpProfile?message=" + message;
		}
	
	
	
	@RequestMapping("/about")  
	public String aboutHandler() {
		return "about"; 
	}
	
	@RequestMapping("/contact")  
	public String contactHandler() {
		return "contact"; 
	}
		
	@RequestMapping("/buildings")  
	public ModelAndView buildingsHandler(@ModelAttribute Building building, @ModelAttribute("message") String message, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		String viewName = "";
		if(role>1) {
			viewName = "buildings";
			List<Building> buildingList = buildingService.showAllBuildingsService();
			mav.addObject("buildingList",buildingList);
			mav.addObject("message", message);
		}
		else {
			 viewName="login";
		}
		mav.setViewName(viewName);
		return mav; 
	}
	
	@RequestMapping("/buildingProfile/{urlBuildingId}")  
	public ModelAndView buildingProfileHandler(@PathVariable("urlBuildingId") int buildingId, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		if(role>1) {
			Building building = buildingService.getBuildingByIdService(buildingId);
			
			if(building == null) {
				building = new Building();
			}
			if(building.getDateSold()==null) {
				building.setDateSold(Date.valueOf("0001-01-01"));
			}
			
			mav.addObject("building",building);
			mav.setViewName("buildingProfile");
		}
		else {
			mav.setViewName("login");
		}
		return mav; 
	}
	
	@RequestMapping("/updateBuilding")
	public String updateBuilding(@ModelAttribute Building building,HttpSession session) {
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		String message = "";
		boolean result = false;
		if(role>1) {
			if(building.getBuildingId() == 0) {
				System.out.println(building);
				result = buildingService.addBuildingService(building);
				if(result) {
					message = "Building " + building.getBuildingName() + " succesfully added";
				}
				else {
					message = "Building " + building.getBuildingName() + " not added";
				}
			}
			else {
				result =buildingService.updateBuildingService(building.getBuildingId(), building);
				if(result) {
					message = "Building " + building.getBuildingName() + " succesfully updated";
				
				}
				else {
					message = "Building " + building.getBuildingName() + " not updated";
				}
				
			}
			return "redirect:/buildings?message=" + message;
		}
		else {
			return"login";
		}
	}
	
	@RequestMapping("/deleteBuilding/{urlBuildingId}")
	public String deleteBuildingHandler(@PathVariable("urlBuildingId") int buildingId, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String message = "";
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		if(role>1) {
			boolean result = false;
			result = buildingService.deleteBuildingService(buildingId);
			if(result) {
				message = "Building deleted";
			}
			else {
				message = "You cannot delete a building with asssociated apartments.";
			}
			
			mav.setViewName("buildings");
			return "redirect:/buildings?message=" + message;
		}
		else {
			return "login";
		}
	}
	
	

	@RequestMapping("/apartments/{urlBuildingId}")  
	public ModelAndView apartmentsHandler(@PathVariable("urlBuildingId") int buildingId, @ModelAttribute("message") String message, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		if(role>1) {
			Building building = buildingService.getBuildingByIdService(buildingId);
			List<Apartment> apartmentList = apartmentService.showAllApartmentsByBuildingService(building);
			mav.addObject("building",building);
			mav.addObject("apartmentList",apartmentList);
			mav.setViewName("apartments");
		}
		else {
			mav.setViewName("login");
		}
		return mav;
	}
	
	@RequestMapping("/apartmentProfile/{urlBuildingId}/{urlApartmentId}")  
	public ModelAndView apartmentProfileHandler(@PathVariable("urlBuildingId") int buildingId,@PathVariable("urlApartmentId") int apartmentId,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		if(role>1) {
			Apartment apartment= apartmentService.getApartmentByIdService(apartmentId);
			Building building = buildingService.getBuildingByIdService(buildingId);
			if(apartment == null) {
				apartment = new Apartment();
				apartment.setApartmentId(0);
				apartment.setBuilding(building);
				
			}
			else{
				building = apartment.getBuilding();
			
			}
			mav.addObject("building",building); 
			mav.addObject("apartment",apartment);
			mav.setViewName("apartmentProfile");
			System.out.println(apartment);
		}
		else {
			mav.setViewName("login");
		}
		return mav;
	}
	
	@RequestMapping("/updateApartment/{urlBuildingId}")
	public String updateApartment(@ModelAttribute Apartment apartment, @PathVariable("urlBuildingId") int buildingId,HttpSession session) {
		String message = "";
		System.out.println(apartment);
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		if(role>1) {
			Building building = buildingService.getBuildingByIdService(buildingId);
			apartment.setBuilding(building);
			
			boolean result =false;
			if(apartment.getApartmentId() == 0) {
				
				System.out.println(apartment);
				
				result = apartmentService.addApartmentService(apartment);
				if(result) {
					message = "Apartment " + apartment.getApartmentName() + " succesfully added";
				}
				else {
					message = "Apartment" + apartment.getApartmentName() + " not added";
				}
			}
			else {
				result =apartmentService.updateApartmentService(apartment.getApartmentId(), apartment);
				if(result) {
					message = "Apartment " + apartment.getApartmentName() + " succesfully updated";
					}
				else {
					message = "Apartment " + apartment.getApartmentName() + " not updated";
				}
				
			}
			return "redirect:/apartments/" + buildingId +"?message=" + message;
		}
		else {
			return "login";
		}
		
	}
	
	@RequestMapping("/deleteApartment/{urlApartmentId}")
	public String deleteApartmentHandler(@PathVariable("urlApartmentId") int apartmentId, HttpSession session) {
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		if(role>1) {
			int buildingId = apartmentService.getApartmentByIdService(apartmentId).getBuilding().getBuildingId();
			String message = "";
			boolean result = false;
			result = apartmentService.deleteApartmentService(apartmentId);
			if(result) {
				message = "Apartment Deleted";
			}
			else {
				message = "You cannot delete an apartment with asssociated tenants.";	
			}
			
			return "redirect:/apartments/" + buildingId +"?message=" + message;
		}
		else {
			return "login";
		}
	}
	
	
	@RequestMapping("/tenants")  
	public ModelAndView tenantsHandler(@ModelAttribute("message") String message,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		if(role>0) {
			//if landlord is logged in, display all tenants
			List<Tenant> tenantList = tenantService.showAllTenantsService();
			//if tenant is logged in, display only current tenant.
			if(role == 1) {
				tenantList = new ArrayList<>();
				Tenant loggedInTenant = tenantService.getTenantByIdService(sessionUser.getTenant().getTenantId());
				if(loggedInTenant!= null) {
					tenantList.add(loggedInTenant);
				}
			}
			mav.addObject("tenantList", tenantList);
			mav.setViewName("tenants");
		}
		else {
			mav.setViewName("login");
		}
		return mav;
	}
	
	@RequestMapping("/tenantProfile/{urlTenantId}")
	public ModelAndView tenantProfileHandler(@PathVariable("urlTenantId") int tenantId, HttpSession session ){
		ModelAndView mav = new ModelAndView();
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		if(role>0) {
			Tenant tenant= tenantService.getTenantByIdService(tenantId);
			List<Building> buildingList = buildingService.showAllBuildingsService();
			List<Apartment> apartmentList = null;
			if(tenant == null) {
				tenant = new Tenant();
				Building building = buildingService.showAllBuildingsService().get(0);
				apartmentList = apartmentService.showAllApartmentsByBuildingService(building);
				
			}
			else {
				Apartment apartment = apartmentService.getApartmentByIdService(tenant.getApartment().getApartmentId());
				Building building = tenant.getApartment().getBuilding();
				apartmentList = apartmentService.showAllApartmentsByBuildingService(building);
				mav.addObject("apartment",apartment);
				mav.addObject("building",building);
			}
			
			//HashMap to send Building Apartment relationship to javascript
			Map<Integer,Map<Integer,String>> buildingApartmentMap = new HashMap<>();
			List<Building> buildingList2 = buildingService.showAllBuildingsService();
			for(Building b:buildingList2) {
				List<Apartment>listApartments = apartmentService.showAllApartmentsByBuildingService(b);
				Map<Integer,String> mapApartmentIdBuilding = new HashMap<>();
				for(Apartment a: listApartments) {
					mapApartmentIdBuilding.put(a.getApartmentId(),a.getApartmentName());
				}
				buildingApartmentMap.put(b.getBuildingId(), mapApartmentIdBuilding);
			}
	
			
			mav.addObject("buildingApartmentMap",buildingApartmentMap);
			mav.addObject("tenant",tenant);
			mav.addObject("buildingList",buildingList);
			mav.addObject("apartmentList",apartmentList);
			mav.setViewName("tenantProfile");
		}
		else {
			mav.setViewName("login");
		}
		return mav;
	}
	
	@RequestMapping("/tenantUpdate")
	public String tenantUpdateHandler(@ModelAttribute Tenant tenant, @RequestParam("apartmentId") int apartmentId, HttpSession session) {
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		if(role>0) {
			String message ="";
			System.out.println(tenant);
			boolean result = false;
			Apartment apartment = null;
			apartment = apartmentService.getApartmentByIdService(apartmentId);
			tenant.setApartment(apartment);
			if(tenant.getTenantId() == 0) {
				result = tenantService.addTenantService(tenant);
				if(result) {
					message="Tenant added succesfully.";
				}
				else {
					message="Error: Tenant not added.";
				}
			}
			else {
				result = tenantService.updateTenantService(tenant.getTenantId(), tenant);
				if(result) {
					message ="Tenant updated successfuly.";
				}
				else {
					message = "Error: Tenant not updated";
				}
			}
			
			
				return "redirect:/tenants/?message=" + message;
		}
		else {
			return "login";
		}
	}
	
	@RequestMapping("/deleteTenant/{urlTenantId}")
	public String deleteTenantHandler(@PathVariable("urlTenantId") int tenantId,HttpSession session ) {
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		if(role>1) {
			String message = "";
			boolean result = false;
			result = tenantService.deleteTenantService(tenantId);
			if(result) {
				message = "Tenant Deleted";
			}
			else {
				message = "Tenant could not be deleted.";	
			}
			return "redirect:/tenants/?message=" + message;
		}
		else {
			return "login";
		}
	}

	@RequestMapping("/lease/{urlLeaseName}")  
	public ModelAndView leaseHandler(@PathVariable("urlLeaseName") String leaseName,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		if(role>0) {
			leaseName += ".pdf";
			mav.addObject("leaseName", leaseName);
			mav.setViewName("lease");
		}
		else {
			mav.setViewName("login");
		}
		return mav;
	}
	
	@RequestMapping("/makePaymentProfile/{urlTenantId}")  
	public ModelAndView  makePaymentProfileHandler(@PathVariable("urlTenantId") int tenantId, @ModelAttribute("message") String message,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		if(role==1) {
			List<Invoice> invoiceList = invoiceService.showAllInvoicesByTenantService(tenantId,true);
			String userMessage = "";
			if(invoiceList.size()==0) {
				userMessage = "You have no open invoices.  Thank you for keeping your acount up to date.";
				mav.addObject("userMessage",userMessage);
			
			}
			mav.addObject("invoiceList",invoiceList);
			mav.setViewName("makePayment");
		}
		else {
			mav.setViewName("login");
		}
		
		return mav;
	}
	
	@RequestMapping("/makePayment")
	public String makePaymentHandler(@ModelAttribute("invoiceId") int invoiceId,HttpSession session) {
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		if(role==1) {
			boolean result = invoiceService.verifyPaymentService();
			Invoice invoice = invoiceService.getInvoiceByIdService(invoiceId);
			int tenantId = invoice.getTenant().getTenantId();
			String message="";
			if(result) {
			
				invoice.setPaid(true);
				result = invoiceService.updateInvoiceService(invoiceId, invoice);
				if(result) {
					message ="Invoice paid and balance updated.";
				}
				else {
					message ="Error: Invoice not paid.";
				}
			}
			else {
				message="Error: Credit Card could not be verified.";
			}
			
			return "redirect:/makePaymentProfile/"+tenantId +"?message="+ message;
		}
		else {
			return "login";
		}
	}
	
	
	
	
	@RequestMapping("/invoices")  
	public ModelAndView invoiceHandler(@ModelAttribute("message") String message,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		if(role>1) {
			List<Invoice> invoiceList = invoiceService.showAllInvoicesService();
			mav.addObject("invoiceList", invoiceList);
			mav.setViewName("invoices");
		}
		else {
			mav.setViewName("login");
		}
		return mav;
	}
	
	@RequestMapping("/invoiceProfile/{urlInvoiceId}")
	public ModelAndView invoiceProifleHandler(@PathVariable("urlInvoiceId") int invoiceId,HttpSession session) {
		ModelAndView mav = new ModelAndView(); 
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		if(role>1) {
			Invoice invoice= invoiceService.getInvoiceByIdService(invoiceId);
			List<Tenant> tenantList = tenantService.showAllTenantsService();
			if(invoice == null) {
				invoice = new Invoice();
				
			}
			else {
				Tenant tenant = invoice.getTenant();
				mav.addObject("tenant",tenant);
			}
			mav.addObject("tenantList",tenantList);
			mav.addObject("invoice",invoice);
			mav.setViewName("invoiceProfile");
		}
		else {
			mav.setViewName("login");
		}
		return mav;
	}
	
	@RequestMapping("/invoiceUpdate")
	public String invoiceUpdateHandler(@ModelAttribute("Invoice") Invoice invoice, @RequestParam("tenantId") int tenantId,HttpSession session) {
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		if(role>1) {
			String message = "";
			boolean result= false;
			Tenant tenant = tenantService.getTenantByIdService(tenantId);
			invoice.setTenant(tenant);
			if(invoice.getInvoiceId()==0) {
				result = invoiceService.addInvoiceService(invoice);
				if(result) {
					message="Invoice added succesfully";
				}
				else {
					message="Error: Invoice not added";
				}
			}
			else {
				result=invoiceService.updateInvoiceService(invoice.getInvoiceId(), invoice);
				if(result) {
					message="Invoice updated successfully.";
				}
				else {
					message ="Error: Invoice not updated";
				}
			}
			
			return "redirect:/invoices/?message=" + message;
		}
		else {
			return "login";
		}
	}
	
	@RequestMapping("/deleteInvoice/{urlInvoiceId}")
	public String deleteInvoiceHandler(@PathVariable("urlInvoiceId") int invoiceId, HttpSession session) {
		UserLogin sessionUser = (UserLogin)session.getAttribute("userLogin");
		int role = sessionUser.getRole();
		if(role>1) {
			String message = "";
			boolean result = false;
			result = invoiceService.deleteInvoiceService(invoiceId);
			if(result) {
				message = "Invoice Deleted.";
			}
			else {
				message="Error: Invoice not deleted.";
			}
			return "redirect:/invoices?message=" + message;
		}
		else {
			return "login";
		}
	}
	
	

	
	
	
	
	
}
