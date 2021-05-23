<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Post List</h1>
</div>
<hr>
  <div style='overflow-x:auto;'>
  <table class="table" style="margin-bottom:42%; ">
  <thead class="table-dark">
  	<tr>
      <th scope="col">Page ID</th>
      <th scope="col">Page Name</th>
      <th scope="col">Page Link</th>
      <th scope="col">AccessToken</th>
      <th scope="col">Content</th>
    </tr>
  </thead>
 
 
<tbody>
     <c:forEach var="lp" items="${listpost}">
   <tr>
      <th scope="col">${lp.id_page}</th>
      <th scope="col">${lp.name_page}</th>
      <th scope="col">${lp.link_page}</th>
      <th scope="col">${lp.access_token}</th>
      <th scope="col" >
     <textarea rows="10" cols="50" readonly class="bg-light">${lp.content}
     </textarea>
      </th>
      
    </tr>
     
    </c:forEach>  
</tbody>

</table> 

</div>

