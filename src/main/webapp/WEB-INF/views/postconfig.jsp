<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Post Config</h1>
</div>
<hr>
 	<div style="margin-bottom:10px; ">
  <a class="btn btn-primary btn rounded-0"  href="<c:url value="edit/${pageToken.id}"  />">Config</a>
  </div>
  <table class="table" style="margin-bottom:35.2%; ">
  <thead class="table-dark">
  	<tr>
      <th scope="col">Page ID</th>
      <th scope="col">Page Name</th>
      <th scope="col">Page Link</th>
      <th scope="col">AccessToken</th>
    </tr>
  </thead>
  <tbody>
   <tr>
      <th scope="col"> ${pageToken.id_page}</th>
      <th scope="col">${pageToken.name_page}</th>
      <th scope="col">${pageToken.link_page}</th>
      <th scope="col">${pageToken.token}</th>
    </tr>
  </tbody>
</table>