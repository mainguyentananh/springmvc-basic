<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>




<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Admin</h1>
</div> 
<hr />

<div  style="margin-bottom: 10px;">

	<a class="btn btn-primary btn rounded-0"
		href="<c:url value="/admin/createaccount"  />">Create Account</a>
</div>

<div class="test" >
<table class="table" style="margin-bottom: 42%;">
	
	<thead class="table-dark">
		<tr>
			<th scope="col">ID User</th>
			<th scope="col">Page ID</th>
			<th scope="col">Page Name</th>
			<th scope="col">Page Link</th>
			<th scope="col">AccessToken</th>
			<th scope="col">Content</th>
			<th scope="col">
					<div class="dropdown show" >
  <a class="btn btn-secondary dropdown-toggle" 
  role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="margin-left:17px;">
   
  </a>

  <div class="dropdown-menu bg-dark" aria-labelledby="dropdownMenuLink">
    <a class="dropdown-item p-3  bg-dark text-white text-center"
		href="<c:url value="/admin"/>">List All</a>
    <a class="dropdown-item p-3  bg-dark text-white text-center"
		href="<c:url value="/admin/listposted"  />">List Posted</a>
    <a class="dropdown-item p-3  bg-dark text-white text-center"
		href="<c:url value="/admin/listnotposted"  />">List Not Posted</a>
  </div>

</div>
				
			</th>
		</tr>
	</thead>

	
	<tbody>
		<c:forEach var="lp" items="${listpost}">
			<tr>
				<th scope="col">${lp.id_user}</th>
				<th scope="col">${lp.id_page}</th>
				<th scope="col">${lp.name_page}</th>
				<th scope="col">${lp.link_page}</th>
				<th scope="col">${lp.access_token}</th>
				<th scope="col" >
					<textarea rows="10" cols="50"  class="bg-light" readonly="readonly" style="text-align: left;">${lp.content}
     				</textarea>
     			</th>
				<th scope="col">
					<c:if test="${lp.check_post != true}">
					<a class="nav-link"
					href="<c:url value="/update/${lp.id}" />">
					<span >Post</span>
					</a>
					<hr/>
					</c:if>
					<a class="nav-link"
					href="<c:url value="/delete/${lp.id}" />"><span>Delete</span>
					</a>
					<hr/>
					<c:if test="${lp.check_post == true}">
						<span class="btn btn-success btn-sm rounded-pill " style="margin-left:8px;margin-top:15px;">Done <i class="fas fa-check-circle"></i></span>
					</c:if>
					<c:if test="${lp.check_post != true}">
						<span class="btn btn-warning btn-sm rounded-pill" style="margin-left:8px;margin-top:15px;">Wait <i class="fas fa-spinner"></i></span>
					</c:if>
				</th>
			</tr>
		</c:forEach>	
	</tbody>
</table>
</div>
