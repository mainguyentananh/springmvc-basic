<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Create Post</h1>
</div>
<hr/>

	<c:url value="/save" var="save"/>
  <form:form action="${save}" method="POST"
    modelAttribute="Post_FB" style="margin-bottom:40px;">
    
    <div class="visually-hidden">
     	
     	<form:input path="id_user" type="hidden" value="${ptk.id_user}" />
      </div>
    <div class=" col-md-6 col-sm-12" >
     	<label class="text-dark">Page ID</label>
     	<form:input path="id_page" value="${ptk.id_page}" class="form-control" readonly="true"/> 
      </div>
      
      <div class="col-md-6 col-sm-12">
     	<label class="text-dark">Page Name</label>
     	<form:input path="name_page" value="${ptk.name_page}" class="form-control" readonly="true"/> 
      </div>
    
    <div class="col-md-6 col-sm-12">
     	<label class="text-dark">Page Link</label>
     	<form:input path="link_page" value="${ptk.link_page}" class="form-control" readonly="true"/> 
      </div>
   
    <div class="col-md-6 col-sm-12">
     	<label class="text-dark">AccessToken</label>
	
	<form:input path="access_token" value="${ptk.token}" class="form-control" readonly="true"/> 
      </div>
    
      <div class="col-md-6 col-sm-12">
     	<label class="text-dark">Content</label>
      </div>
    <div class="col-md-6 col-sm-12">
    	<form:textarea path="content" rows="10" cols="66"  style="text-align: left;"/>
    </div>
    
    <span style="margin-left:500px;">${message}</span>
   <div class="col-md-6 col-sm-12" style="margin:10px 0px; margin-top:-10px;" >
     	 <button type="submit" class="btn btn-primary btn rounded-0 ">Post</button>   	 
      </div>

  </form:form>
