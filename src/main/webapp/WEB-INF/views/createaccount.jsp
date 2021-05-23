<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Create Account</h1>
</div>
<hr/>

<div style="margin-bottom:28.6%">

  <form:form action="save" method="POST" modelAttribute="nu"
   >
   
  
    <div class=" col-md-6 col-sm-12" >
     	<label class="text-dark">Username</label>
     	<form:input path="username" class="form-control"/> 
      </div>
      
      <div class="col-md-6 col-sm-12" style="margin-bottom:10px;">
     	<label class="text-dark">Password</label>
     	<form:input path="password" class="form-control" type="password"/> 
      </div>
    <span style="margin-left:450px;">${message}</span>
    <div class="col-md-6 col-sm-12" style="margin-top:-15px;">
     	 <button type="submit" class="btn btn-primary btn rounded-0 ">Create Account</button>
      </div>
      
   
  </form:form>
</div>