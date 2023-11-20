<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Create Biblio</title>

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

</head>
<body>
<form action="${context}/uploadsave" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="Upload Excel">
</form>

</body>
</html>