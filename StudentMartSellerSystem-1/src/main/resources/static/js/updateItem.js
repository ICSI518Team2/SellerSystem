/*
 * Update the Image filed in form after choose the file
 * Author: Yunwei Jiang
 * */
function updateImageField()
{
	//alert("hello");
	//get file name
	var fileFullPath =  document.getElementById("fileUpload").value;
	var fileName = "";
	//var fullPath = document.getElementById('upload').value;
	if (fileFullPath) {
		var startIndex = (fileFullPath.indexOf('\\') >= 0 ? fileFullPath.lastIndexOf('\\') : fileFullPath.lastIndexOf('/'));
		fileName = fileFullPath.substring(startIndex);
		if (fileName.indexOf('\\') === 0 || fileName.indexOf('/') === 0) {
			fileName = fileName.substring(1);
		}
		//alert(fileName);
	}
	//alert(fileFullPath);
	//After get the file name, then set "Image" feild with file name
	document.getElementById("uploadFileName").value = fileName;
	
	
	//alert("Picture uploaded successfully!");
	
	//Now change the imagePreview to this path
	var imagepath =  document.getElementById("imagePreview").src;
	//alert(imagepath);
	document.getElementById("imagePreview").src = "/image/"+fileName;
	//alert(document.getElementById("imagePreview").src);
}

function loadImage() {
    //alert("Image is loaded");
    //get the src from uploadFileName if it's not null
    var imagepath =  document.getElementById("imagePreview");
    if(document.getElementById("uploadFileName").value != null)
	{
    	imagepath.src = "/image/"+document.getElementById("uploadFileName").value;
	}
    else
	{
    	imagepath.src = "/image/spring-boot-file-upload-example.png";
	}
    
}

function renewImage() {
    //alert("Image is loaded");
    //get the src from uploadFileName if it's not null
    var imagepath =  document.getElementById("imagePreview");
    if(document.getElementById("uploadFileName").value != null)
	{
    	imagepath.src = document.getElementById("uploadFileName").value;
    	
	}
    else
	{
    	imagepath.src = "/image/spring-boot-file-upload-example.png";
	}
    
}

//Send message to admin
function sendToAdmin()
{
	//var selectedTeam = "hello";
	alert("Your email has been sent successfully! We will get back to you soon.");
	$.ajax({
  	  type: "POST",
  	  url: "sendMail",
  	  /*
  	  dataType: "json",
  	  contentType: "application/json; charset=utf-8",
        data: JSON.stringify(selectedTeam),
        success: function (data) { alert(data); },
        failure: function (errMsg) {
            alert(errMsg);
        }
        */
  	});

}

//Seller login validation check
function loginCheck()
{
	var userid =  document.getElementById("userid");
	var password =  document.getElementById("password");
	var id = userid.value;
    if(userid.value != "" && password.value != "" )
	{
    	alert(userid.value);
    	alert("login!");
    	$.ajax({
      	  type: "POST",
      	  url: "sellerLogin",
      	  
      	  dataType: "json",
      	  contentType: "application/json; charset=utf-8",
            data: JSON.stringify(id),
      	  	//data: id,
            success: function (data) { alert(data); },
            failure: function (errMsg) {
                alert(errMsg);
            }
            
      	});
    	
	}
    else
	{
    	if(userid.value == "" && password.value == "")
		{
    		alert("Both user id and password are empty!")
		}
    	else if(userid.value == "")
    	{
    		alert("user id is empty!");
    	}
    	else
		{
    		alert("password is empty!")
		}	
	}
	
}


