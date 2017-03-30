<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>coreApp :: 회원가입</title>
<%@ include file="../commons/_head.jspf"%>
</head>
<body>
	<%@ include file="../commons/_top.jspf"%>
	<c:choose>
		<c:when test="${empty currentId}">
			<c:set var="method" value="post" />
			<c:set var="pageTitle" value="회원가입" />
		</c:when>
		<c:otherwise>
			<c:set var="method" value="put" />
			<c:set var="pageTitle" value="개인정보수정" />
		</c:otherwise>
	</c:choose>
	<div class="container">
		<div class="row">
			<div class="span12">
				<section id="typography">
				<div class="page-header">
					<h1>${pageTitle}</h1>
				</div>

				<form:form modelAttribute="user" cssClass="form-horizontal"
					action="/users" method="${method}">
					<div class="control-group">
						<label class="control-label" for="userId">사용자 아이디</label>
						<div class="controls">
							<c:choose>
								<c:when test="${empty currentId}">
									<form:input path="userId" />
									<form:errors path="userId" cssClass="error" />
								</c:when>
								<c:otherwise>
							${currentId}
							<form:hidden path="userId" />
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">비밀번호</label>
						<div class="controls">
							<form:password path="password" />
							<form:errors path="password" cssClass="error" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="name">이름</label>
						<div class="controls">
							<form:input path="name" />
							<form:errors path="name" cssClass="error" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="auth">권한</label>
						<div class="controls">
							<form:input path="auth" />
							<form:errors path="auth" cssClass="error" />
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn btn-primary">${pageTitle}</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>