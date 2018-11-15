/*
 * Update the Image filed in form after choose the file
 * Author: Yunwei Jiang
 * */
function updateImageField()
{
	alert("hello");
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
	//alert("Picture changed successfully!");
}

function renewImage() {
    alert("Image is loaded");
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