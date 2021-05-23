<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" >
<meta name="author" >

<title>My App</title>

<!-- Custom fonts for this template-->

<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/all.min.css"/>">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/sb-admin-2.min.css"/>">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/fontawesome/css/all.css"/>">

 


</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper" >

		<!-- Sidebar -->
		<ul
			class="navbar-nav  bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="<c:url value="/home" />">
				<div class="sidebar-brand-icon">
					<i class="fab fa-java"></i>
					<div class="sidebar-brand-text mx-3">My App</div>
				</div>

			</a>

			<!-- Sidebar - Brand -->


			<hr class="sidebar-divider my-0">

			<div style="margin-top: 50px;">
			




				<li class="nav-item active"><a class="nav-link"
					href="<c:url value="/home" />"> <i class="fas fa-home"></i> <span>Home</span></a>
				</li>



				<li class="nav-item "><a class="nav-link"
					href="<c:url value="/postlist" />"> <i class="fas fa-list-alt"></i>
						<span>Post List</span>
				</a></li>


				<li class="nav-item "><a class="nav-link"
					href="<c:url value="/postconfig" />"> <i class="fas fa-cog"></i>
						<span>Post Config</span>
				</a></li>

				<li class="nav-item "><a class="nav-link"
					href="<c:url value="/createpost" />"> <i
						class="fas fa-newspaper"></i> <span>Create Post</span>
				</a></li>

				<li class="nav-item "><a class="nav-link"
					href="<c:url value="/contact" />"> <i class="fas fa-id-card"></i>
						<span>Contact</span>
				</a></li>

				<hr class="sidebar-divider my-0" />
				
				<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li class="nav-item ">
					<a class="nav-link"
					href="<c:url value="/admin" />"> <i class="fas fa-user-tie"></i>
						<span>Admin</span>
					</a>
				</li>
				</sec:authorize>
				<li class="nav-item "><a class="nav-link"
					href="<c:url value="/logout" />"> <i
						class="fas fa-sign-out-alt"></i> <span>Logout</span>
				</a></li>



			</div>

		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					


					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">


						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">${pageContext.request.userPrincipal.name}</span>

						</a></li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				
				<div class="container" >
					
					<!-- Page Heading -->



					<!-- Content Row -->
					
				
					<tiles:insertAttribute name="content" />
			
					<!-- /.container-fluid -->

				</div>
			
				<!-- End of Main Content -->

				<!-- Footer -->
				<footer class="sticky-footer bg-white ">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright &copy; MNTA</span>
						</div>
					</div>
				</footer>
				<!-- End of Footer -->

			</div>
			<!-- End of Content Wrapper -->

		</div>
		<!-- End of Page Wrapper -->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>

		<!-- Bootstrap core JavaScript-->
		<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
		<script src="<c:url value="/resources/js/bootstrap.bundle.min.js" />"></script>


		<!-- Custom scripts for all pages-->
		<script src="<c:url value="/resources/js/sb-admin-2.min.js" />"></script>
		
		
		<!-- xử lí kéo ngang-->
		<script type="text/javascript">
		$(document).ready(function(){
			  if(window.innerWidth < 1275){
				  $(".test").css("overflow-x","auto");
			  }
			 
			});
		
		</script>
		
</body>

</html>

