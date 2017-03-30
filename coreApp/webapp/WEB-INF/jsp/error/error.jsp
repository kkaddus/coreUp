<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div class="container">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span6">
					<h1>에러 페이지</h1>
					<div class="number font-red">${args.errorCode }</div>
					<div class="details">
						<h3>${args.msgEn }</h3>
						<p>${args.msgKo }<br /> <a href="${ctx}/"> Go home!</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
