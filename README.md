# WelcomeHomeRealtyCaseStudy

Welcome Home Realty is a web app designed to support the business functions of a real estate management company.
Users:
1-Landlord: Landlord will be able to add buildings, apartments, tenants, and invoices.
2- Tenants: Tenants will be able to view their profile, balance, lease, and make payments.


# How does WelcomeHomeRealty work?
I downloaded Bootstrap v4.5 from this website:https://getbootstrap.com/docs/4.5/getting-started/introduction/ and included the files in my styles folder.
I also used the jQuery and JavaScript link below so that all the Bootstrap features would work.

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

I used the Bootstrap grid system for the layout features on the page, some added CSS for styling, and JavaScript for form verifications.

# Home Page - viewable to all visitors
The home page is the first page a user will see. It features a Bootstrap navbar with a dropdown menu with links to the Contact and Sign Up pages.
The next element is a large image that stretches across the entire page. 
I added Bootstrap cards with a header, body, footer for additional ways to navigate to the Contact and Sign Up pages.
The last element on the page is a footer with the company name and year it was established.

# AboutThe home page is the first page a user will see. It features a Bootstrap navbar with a dropdown menu with links to the Contact and Sign Up pages.
The about page contains the business contact information. It features a Bootstrap image caurosel with images of actual apartments, and contains a summary of the company and team member information.

# Contact Page - viewable to all visitors
The contact page uses the Bootstrap grid system to align text and images on the same row.
The first row uses an HTML table to list the company's contact information.
The second row uses an HTML that the user can fill out.  The form regex pattern validation to ensure form values are valid.
I used JavaScript to attach an event listener to the form submit event.
When the form is submitted, the JavaScript code will prevent the default submit event and take all the field values and add it to a Message Object. 
That Message Object will then be added to an array of Message Objects.  
I also created a method that prints out the Message Object in a readable format.  
Programmers familiar with scripting language can use these methods to send the company an email every time a new message is received.

# Sign Up Page- viewable to all visitors
This page is for new Tenants to sign up for a user account.  
The HTML form uses regex pattern validation to ensure form values are valid.
When the form is submitted, the Java code will verify the following:
1- The tenant exists in the company's database?
2- If Tenant exists, does the tenant already have a login?
3 -The username requested is available. (Usernames must be unique.)

If the tenant exists, is a new user, and the username requested is available, a message will appear underneath the form saying that the signup was successful.
If the tenant exists, is a new user, and the username requested is not available, a message will appear underneath the form saying that the username is taken and to choose another.
If the tenant exists and already has a username and password, a message will appear underneath the form saying that the tenant already signed up and to contact the office for assistance.
If the tenant does not exist, a message will appear underneath the form saying that the tenant does not exist and to contact the office for assistance.

# Login Page - viewable to all visitors
The login page is for existing users log in a access their account.
Java code verifies that the user exists in the UserLogin table and redirects to the home page.
The home page will now display "Welcome <username>" and "Logout" on the navbar in place of the "login" and "signup" links.
Also, the Card that previously linked to the Login page now links to the Tenant page.

# Tenants Page - viewable to logged in Tenant 
The tenant page displays the current tenant's record.  The tenant can update their name, phone and/or email, view their balance, view their lease, and make a payment.

# Lease Page 
The tenant can view, download, or print lease.
If lease is not found, message will display and tell user to contact the office.

# Make Payment Page
The tenant can see a list of open invoices and enter credit card information.
(This page does not actually charge the credit card. A card verification method must be added to the java code.)
If tenants credit card is verified, the tenant balance will be updated to reflect the payment.

# Tenants Page - viewable to logged in Landlord 
The tenants page displays a list of all tenants.
The landlord can  update all tenant information, view tenant lease, add a new tenant, or delete a tenant(only if tenant has no related records in other tables).

# Buildings Page - viewable to logged in Landlord 
The landlord can see a list of all buildings, update a building, add a new building, or delele a building with no related records in other tables.  
Landlord can also click the "Apartments" button to see a list of all apartments in that building.

# Apartments in Building Page - viewable to logged in Landlord 
The landlord can see a list of all apartments in a particular building, update the apartment, add a new apartment, and delete an apartment if it has not related records in other tables.

# Invoices Page - viewable to logged in Landlord 
The landlord can see a list of all ivoices in, update invoice, add a new invoice for a tenant, and delete an invoice.
If the landlord changed the paid status, the associated tenant's balance will be updated.

# Who uses WelcomeHomeRealty
This website can be used to support the business functions of a real estate management company.

# Goal
Create a template for a to support the business functions of a real estate management company that can be accessed by tenants and landlords.

# Future Improvements
1- Add logical constraints to the database
2- Make paympent processing work


# What is the license for this WelcomeHomeRealty? 
This website uses Bootstrap v4.5 and google fonts.
The rest of this project is in the public domain.

# Developer Contact Information
Valerie Loevinger
v.loevinger@gmail.com





