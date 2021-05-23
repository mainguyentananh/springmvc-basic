<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Login</title>

<!-- Custom fonts for this template-->

<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/sb-admin-2.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/all.min.css"/>">
<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-8 ">

				<div class="card " style="margin-top: 85px;">
					<div class="card-body">
						<!-- Nested Row within Card Body -->
						<div class="row justify-content-center">

							<div class="col-lg-8">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">Please Sign In!</h1>
									</div>
									
									<form class="user"
										action="<c:url value='j_spring_security_check' />"
										method='POST'>
										
										<div class="form-group">
											<input type="text" class="form-control form-control-user"
												name='username' placeholder="Username">
										</div>
										<div class="form-group">
											<input type="password" class="form-control form-control-user"
												name='password' placeholder="Password">
										</div>
										${message}
										<hr>
										<button class="btn btn-primary btn-user btn-block"
											type="submit">Login</button>

									</form>

								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>


	<!-- Bootstrap core JavaScript-->
	<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.bundle.min.js" />"></script>


	<!-- Custom scripts for all pages-->
	<script src="<c:url value="/resources/js/sb-admin-2.min.js" />"></script>

</body>

</html>