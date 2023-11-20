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
        var currentPage = 1;
        var totalPages = Math.ceil(20 / 5); // Calculate the total number of pages
        
        function showInputs(page) {
        	 var inputs = document.getElementsByClassName("form-input"); //18
             for (var i = 0; i < inputs.length; i++) {
            	 inputs[i].style.display = "none";
            	 
            }
            
            var startIndex = (page - 1) * 5;
            var endIndex = startIndex + 5;
            
            for (var j = startIndex; j < endIndex; j++) {
                if (j < inputs.length) {
                    inputs[j].style.display = "block";
                    
                }
            }
            
            /*  if (page === totalPages) {
            	 
                // Show the "Submit" button on the last page
                document.getElementById("submitBtn").style.display = "block";
                document.getElementById("nextBtn").style.display = "none";
                document.getElementById("prevBtn").style.display = "block";
            } else {
                document.getElementById("submitBtn").style.display = "none";
                document.getElementById("nextBtn").style.display = "block";
                document.getElementById("prevBtn").style.display = "block";
            }
        }  */
        
        //block equal show
        if (page === totalPages) {
        	 // Show the "Submit" button on the last page
            document.getElementById("submitBtn").style.display = "block";
            document.getElementById("nextBtn").style.display = "none";
            document.getElementById("prevBtn").style.display = "block";
        } else if(page === 1){
            
            document.getElementById("submitBtn").style.display = "none";
            document.getElementById("nextBtn").style.display = "block";
            document.getElementById("prevBtn").style.display = "none";
        }else{
            document.getElementById("submitBtn").style.display = "none";
            document.getElementById("nextBtn").style.display = "block";
            document.getElementById("prevBtn").style.display = "block";
        }
    } 
        
                
        function nextPage() {
            if (currentPage < totalPages) {
                currentPage++;
                showInputs(currentPage);
            }
        }
        
        function prevPage() {
            if (currentPage > 1) {
                currentPage--;
                showInputs(currentPage);
            }
        }
    </script>
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
									<h3 class="card-title textheader">Create Biblio</h3>
								</div>
		
		           <form:form method="post" action="savebiblio"  role="form">
									<div class="row">
										<!-- card row -->  
										<div class="col-md-6">
											<!-- card left column -->
											<div class="card-body">
											
												
											  <div class="form-input" style="display: block;">
           										 <label>Title Statement - 245(a)</label>
           										 <input type="text" class="form-control" 
              									  placeholder="Enter Corporate Name" name="title" required="required">
       										 </div>
       										 <div class="form-input" style="display: block;">
           										 <label>Author Statement - 245(c))</label>
            									 <input type="text" class="form-control" 
                								placeholder="Enter Corporate Name" name="author" required="required">
        									 </div>
         									 <div class="form-input" style="display: block;">
            									 <label>Added Entry Personal Name - 700(a,c,d,g)</label>
            									 <input type="text" class="form-control" 
                								placeholder="Enter Corporate Name" name="coauthor1" required="required">
        									</div>
       										<div class="form-input" style="display: block;">
            									<label>Added Entry Corporate Name - 710(a,b,c,d)</label>
            									<input type="text" class="form-control" 
                								placeholder="Enter Corporate Name" name="coauthor2" required="required">
        									</div>
          									<div class="form-input" style="display: block;">
                                                <label>Main Entry Corporate Name - 110(a,b,c,d)</label>
                                                <input type="text" class="form-control" 
                                               placeholder="Enter Corporate Name" name="coauthor3" required="required">
                                            </div>
                                            <div class="form-input" style="display: block;">
                                                <label>Main Entry Personal Name - 100(a,b,c,g,d,q)</label>
                                                <input type="text" class="form-control" 
                                               placeholder="Enter Corporate Name" name="coauthor4" required="required">
                                            </div>
                                            <div class="form-input" style="display: block;">
                                                <label>General Note - 500(a)</label>
                                                <input type="text" class="form-control" 
                                                placeholder="Enter Corporate Name" name="collection" required="required">
                                            </div>
                                            <div class="form-input" style="display: block;">
                                                 <label>Publication, Distribution,etc(pubicationyear) - 260(c)</label>
                                                 <input type="text" class="form-control" 
                                                placeholder="Enter Corporate Name" name="publicationyear" required="required">
                                             </div>
                                             <div class="form-input" style="display: block;">
                                                 <label>Publication, Distribution,etc(pubishercode) - 260(b)</label>
                                                 <input type="text" class="form-control" 
                                                placeholder="Enter Corporate Name" name="publishercode" required="required">
                                             </div>
                                             <div class="form-input" style="display: block;">
                                                 <label>Publication, Distribution,etc(place) - 260(a)</label>
                                                 <input type="text" class="form-control" 
                                                  placeholder="Enter Corporate Name" name="place" required="required">
                                             </div>
                                             <div class="form-input" style="display: block;">
                                                 <label>Subject Added Entry Personal Name - 600(a,b,c,d,e,f,h,v,x,y,z)</label>
                                                 <input type="text" class="form-control" 
                                                  placeholder="Enter Corporate Name" name="subject1" required="required">
                                             </div>
                                             <div class="form-input" style="display: block;">
                                                 <label>Subject Added Entry Coroprate Name - 610(a,b,c,d,e,f,h,v,x,y,z)</label>
                                                 <input type="text" class="form-control" 
                                                  placeholder="Enter Corporate Name" name="subject2" required="required">
                                              </div>
                                              <div class="form-input" style="display: block;">
                                                  <label>Subject Added Entry Topical Term - 650(a,v,x,y,z)</label>
                                                  <input type="text" class="form-control" 
                                                  placeholder="Enter Corporate Name" name="subject3" required="required">
                                              </div>
                                              <div class="form-input" style="display: block;">
                                                   <label>Subject Added Entry Geographic Name - 651(a,v,x,y,z)</label>
                                                   <input type="text" class="form-control" 
                                                   placeholder="Enter Corporate Name" name="subject4" required="required">
                                              </div>
                                              <div class="form-input" style="display: block;">
                                                   <label>Edition Statement - 250(a)</label>
                                                   <input type="text" class="form-control" 
                                                  placeholder="Enter Corporate Name" name="editionstatement" required="required">
                                              </div>
                                              <div class="form-input" style="display: block;">
                                                   <label>Formatted Contents Note - 505(a)</label>
                                                   <input type="text" class="form-control" 
                                                  placeholder="Enter Corporate Name" name="content" required="required">
                                               </div>
                                               <div class="form-input" style="display: block;">
                                                     <label>Summary - 520(a)</label>
                                                     <input type="text" class="form-control" 
                                                     placeholder="Enter Corporate Name" name="summary" required="required">
                                                </div>
                                                <div class="form-input" style="display: block;">
                                                      <label>Physical Description - 300(a,b,c)</label>
                                                      <input type="text" class="form-control" 
                                                       placeholder="Enter Corporate Name" name="description" required="required">
                                                  </div>
                                                  
												<div class="form-input" style="display: block;">
													<label>Collection</label>
													<form:select class="form-control combo" path="collection" >
														<c:forEach var="user" items="${list}">
														<option value="">Choose Collection Name</option>
															<option value="${user.collection}">${user.collection}</option>
														</c:forEach>
													</form:select>
												</div>
         <br>
         
        
        <!-- Add similar blocks for input2 to input5 -->
        
        <div id="submitBtn" style="display: none;">
        <button type="submit" class="btn btncreate"
		onclick="return Validate()" style="float: right;">Submit</button>
          
        </div>
        
        <div id="nextBtn">
            <button type="button" class="btn btncreate" onclick="nextPage()" style="float: right;"><i class="fa-solid fa-angles-right"></i></button>
        </div>
        
         <div id="prevBtn" style="display: none;">
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<button type="button" class="btn btncreate" onclick="prevPage()"><i class="fa-solid fa-angles-left"></i></button>
        </div> 
											 
											</div>
										</div>
									</div>
												
	</form:form>	
	<script>
        showInputs(currentPage);
    </script>
	</div>
	</div>
	</div>
	</div>
	</section>
	</div>
			
</div>	
</body>	
</html>