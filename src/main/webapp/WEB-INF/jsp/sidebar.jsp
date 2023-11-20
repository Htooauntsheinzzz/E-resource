<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  <!-- use ref prefix=c looping, conditionals, and more eg.c:forEach and c:out-->
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  <!-- checking if a string , replacing parts of a string, splitting a string into an array, and so on.  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<style type="text/css">

.lowersidebar {
	background-color: #343a40;
}

.brand-link {
	background-color: #343a40;
	border-bottom: 1px solid #4b545c;
}

.badge {
	background-color: red;
}

a:hover {
	background-color: #39414a;
	color: white;
}
</style>
<c:set var="contextURL" value="${pageContext.request.contextPath }" />
<a href="${contextURL}/" class="brand-link"> <img
	src="${contextURL}/resources/mohnyinlogo.jpg" alt="AdminLTE Logo"
	class="brand-image img-circle elevation-3" style="opacity: .8"> <span
	class="brand-text font-weight-light text-light">University Mohnyin</span>
</a>
<div class="sidebar lowersidebar">
	<nav class="mt-2" id="navcolor">
		<ul class="nav nav-pills nav-sidebar flex-column"
			data-widget="treeview" role="menu" data-accordion="false">			
			 <li class="nav-item"><a href="${contextURL}/"
				class="nav-link ll"> <i class="nav-icon fas fa-tachometer-alt text-white"></i>
					<p class="text-white">Dashboard</p>
			</a></li> 
			<li class="nav-item"><a href="${contextURL}/createbiblio"
				class="nav-link ll"> <i class="nav-icon fas fa-edit text-white"></i>
					<p class="text-white">Create Biblio</p>
			</a></li>
			<li class="nav-item"><a href="${contextURL}/savebiblio"
				class="nav-link ll"> <i class="nav-icon fas fa-book text-white"></i>
					<p class="text-white">View Biblio</p>
			</a></li>
			<li class="nav-item"><a href="${contextURL}/collectionadd"
				class="nav-link ll"> <i class="nav-icon fas fa-book text-white"></i>
					<p class="text-white">Add Collection</p>
			</a></li>
			<li class="nav-item"><a href="${contextURL}/user"
				class="nav-link ll"> <i class="nav-icon fas fa-book text-white"></i>
					<p class="text-white">User List</p>
			</a></li>
			<li class="nav-item"><a href="${contextURL}/userform/create"
				class="nav-link ll"> <i class="nav-icon fas fa-book text-white"></i>
					<p class="text-white">Create User</p>
			</a></li>
					<li class="nav-item"><a href="${contextURL}/upload"
				class="nav-link ll"> <i class="nav-icon fas fa-book text-white"></i>
					<p class="text-white">Excel Upload</p>
			</a></li>
					
			
				
			
		</ul>
	</nav>
</div>
<script src="${contextURL}/resources/plugins/jquery/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$.ajax({
			url : '${contextURL}/specialrequest/count',
			success : function(response) {
				if (response) {
					$("#specialrequestcount").html(response);
				}
			}
		});
	});
</script>