<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Add Catalog</title>
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
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
					href="#" role="btton"><i class="fas fa-bars"
						style="color: black;"></i></a></li>
			</ul>
			<%@ include file="navbar.jsp"%>

		</nav>

		<aside class="main-sidebar elevation-4">
			<%@ include file="sidebar.jsp"%>
		</aside> 

		<div class="content-wrapper">


			<section class="content-header">
				<div class="container-fluid"></div>
			</section>


			<section class="content">
				<div class="container-fluid">
					<div class="row">

						<div class="col-md-12">
							<div class="card">

								<div class="card-header header">
									<h3 class="card-title textheader">Welcome</h3>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>
								

</body>
</html>