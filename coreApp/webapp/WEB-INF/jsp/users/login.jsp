<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>coreApp :: 로그인</title>

<%@ include file="../commons/_head.jspf"%>

<script type="text/javascript">
$(document).ready(function (){
	
	$("#loginbtn").click(function(){
		if($("#loginid").val() == ""){
			alert("로그인 아이디를 입력해주세요");
			$("#loginid").focus();
		}else if($("#loginpwd").val() == ""){
			alert("로그인 비밀번호를 입력해주세요");
			$("#loginpwd").focus();
		}else{
			$("#loginfrm").attr("action", "<c:url value='/j_spring_security_check'/>");
			$("#loginfrm").submit();
		}
	});
		
});
</script>
</head>
<body>
	<%-- <%@ include file="../commons/_top.jspf"%> --%>

	<div class="container">
		<div class="row">
			<div class="span12">
				<section id="typography">
				<div class="page-header">
					<h1>로그인</h1>
				</div>
				
				<form id="loginfrm" name="loginfrm" cssClass="form-horizontal" action="<c:url value='${ctx}/j_spring_security_check'/>" method="POST">
					<div class="control-group">
						<label class="control-label" for="loginid">사용자 아이디</label>
						<div class="controls">
							<input type="text" id="loginid" name="loginid" value="${loginid}" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="loginpwd">비밀번호</label>
						<div class="controls">
							<input type="password" id="loginpwd" name="loginpwd" value="${loginpwd}" />
						</div>
					</div>
					<c:if test="${not empty securityexceptionmsg}">
					<div class="control-group">
						<div class="controls">
							<div class="error">${securityexceptionmsg}</div>							
						</div>
					</div>					
					</c:if>
					<div class="control-group">
						<div class="controls">
							<input type="button" id="loginbtn" class="btn btn-primary" value="로그인" />
						</div>
					</div>
					
					<input type="hidden" name="loginRedirect" value="${loginRedirect}" />
				</form>		
			</div>
		</div>
	</div>
</body>
</html>