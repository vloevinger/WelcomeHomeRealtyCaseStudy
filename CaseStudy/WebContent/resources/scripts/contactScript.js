
// Contact Page
var contactForm=document.getElementById("contactForm");
var submitButton = document.getElementById("submitButttonContact");
var arrMessages = [];

//add event listener to form submit event
if(contactForm.addEventListener){
	//modern browsers
	contactForm.addEventListener("submit",addToMessageObj);
}
else if(contactForm.attachEvent){
	//old IE
	contactForm.attachEvent("onsubmit", addToMessageObj);
}


//add form values to message object and add message object to array of message objects
function addToMessageObj (e){
	e.preventDefault();
	//add form values to message object
	var messageObj = new MesssageObj(e.target[0].value,e.target[1].value,e.target[2].value,e.target[3].value)
	//add message objects to array
	arrMessages.push(messageObj);
	//print each message to the console
	arrMessages.forEach(function(x){
		printMessagesToConsole(x);
	});
	
	//add success message to html
	var successMessage= document.getElementById("successMessage")
	successMessage.style.color = "red";
	successMessage.style.border = "1px solid red";
	successMessage.style.textAlign = "center";
	successMessage.textContent = "Message sent";
	//contactForm.appendChild(successMessage);

	for(var i=0;i<4;i++){
		e.target[i].value ="";
	}
	
	
}

//create message object
var MesssageObj = function(name,phone,email,moreInfo){
	this.name=name;
	this.phone = phone;
	this.email = email;
	this.moreInfo= moreInfo;
}

//print messages to the console
function printMessagesToConsole(messageObj){
	//when i learn scripting languages I can use this method to email the message in a readable format
	for(i in messageObj){
		console.log(i+":" + messageObj[i]);
	}
	console.log("----------------------------------");
}




	