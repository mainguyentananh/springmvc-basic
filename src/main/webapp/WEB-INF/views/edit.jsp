<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Post Config</h1>
</div>
<hr/>
<div style="margin-bottom:14%">
	<c:url value="/saveedit" var="saveedit"/>
  <form:form action="${saveedit}" method="POST"
    modelAttribute="ptk" >
   
    
    <div class="visually-hidden">
     	
     	<form:input type="hidden" path="id" />
      </div>
    <div class=" col-md-6 col-sm-12" >
     	<label class="text-dark">Page ID</label>
     	<form:input path="id_page" class="form-control"/> 
      </div>
      
      <div class="col-md-6 col-sm-12">
     	<label class="text-dark">Page Name</label>
     	<form:input path="name_page" class="form-control"/> 
      </div>
    
    <div class="col-md-6 col-sm-12">
     	<label class="text-dark">Page Link</label>
     	<form:input path="link_page" class="form-control"/> 
      </div>
   
    <div class="col-md-6 col-sm-12">
     	<label class="text-dark">AccessToken</label>
<form:input path="token" class="form-control"/> 
      </div>
    
    <div class="col-md-6 col-sm-12" style="margin-top:10px;">
     	 <button type="submit" class="btn btn-primary btn rounded-0 ">Config</button>
      </div>
      
   
  </form:form>
</div>