<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Create Biblio</title>
</head>
<body>
<link rel="icon" href="${context}/resources/mohnyinlogo.jpg" type="image/x-icon"/>
<meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet"
	href="resources/plugins/fontawesome-free/css/all.min.css">  

<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">  

 <link rel="stylesheet" href="resources/dist/css/adminlte.min.css"> 

<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet"> 
<style type="text/css"> 
aside {
	background-color: #266edb;
}

.header {
	background-color: #266edb;
}

.textheader {
	color: white;
}

.btncreate {
	background-color: #266edb;
	color: white;
}

.btncreate:hover {
	background-color: #667cc4;
	color: white;
}

.old i {
	margin-left: -30px;
	cursor: pointer;
}

.oldpassword {
	width: 99%;
	height: 40px;
	border-radius: 5px;
	border: 1px solid #CED4DA;
	padding: 10px;
}

.oldpassword:hover {
	border-color: skyblue;
}

.combo {
	width: 99%;
}
</style> 

<script>
document.getElementById('xmlForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the default form submission

    // Get form data
    const formData = new FormData(this);

    // Create XML
    let xml = `<?xml version="1.0" encoding="UTF-8"?>\n<record>\n`;

    // Mapping for tag numbers and their respective subfields
    const tagMapping = {
        '245': ['a', 'c'],
        '260': ['a', 'b', 'c']
        '700': ['a', 'b', 'c']
    };

    Object.entries(tagMapping).forEach(([tag, subfields]) => {
        xml += `\t<datafield tag="${tag}" ind1=" " ind2="0">\n`;
        subfields.forEach(subfield => {
            const value = formData.get(`${tag},${subfield}`);
            if (value) {
                xml += `\t\t<subfield code="${subfield}">${value}</subfield>\n`;
            }
        });
        xml += `\t</datafield>\n`;
    });

    xml += `</record>`; 

    // Log or send the generated XML (e.g., send it to the server using fetch or AJAX)
    console.log(xml);
    // You can also send this XML to the server using fetch or AJAX
});
</script>

<form id=xmlForm action="${context}/createXML" method="post">
     
       										 <div class="form-input" style="display: block;">
           										 <label>245</label>
           										 <br>
            								       									 
           										 <label>a</label>
            									 <input type="text" class="form-control" 
                								placeholder="Enter Corporate Name" name="245,a" required="required">
                								<label>b</label>
            									 <input type="text" class="form-control" 
                								placeholder="Enter Corporate Name" name="245,b" required="required">
        									 </div>
        									 <div class="form-input" style="display: block;">
           										 <label>260</label>
           										 <br>
            								       									 
           										 <label>a</label>
            									 <input type="text" class="form-control" 
                								placeholder="Enter Corporate Name" name="260,a" required="required">
                								<label>b</label>
            									 <input type="text" class="form-control" 
                								placeholder="Enter Corporate Name" name="260,b" required="required">
                								<label>c</label>
            									 <input type="text" class="form-control" 
                								placeholder="Enter Corporate Name" name="260,c" required="required">
        									 </div>
        									 <div class="form-input" style="display: block;">
           										 <label>700</label>
           										 <br>
            								       									 
           										 <label>a</label>
            									 <input type="text" class="form-control" 
                								placeholder="Enter Corporate Name" name="700,a" required="required">
                								<label>b</label>
            									 <input type="text" class="form-control" 
                								placeholder="Enter Corporate Name" name="700,b" required="required">
                								<label>c</label>
            									 <input type="text" class="form-control" 
                								placeholder="Enter Corporate Name" name="700,c" required="required">
        									 </div>
        									 
        							  <input type="submit" value="Submit">
</form>		 
            									 
        									
         									
  


</body>
</html>