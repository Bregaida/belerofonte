	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Belerofonte | Login</title>
		<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet" type="text/css"  />
	</head>
	<body>
		<c:import url="/public/header.jsp"></c:import>
		<div id="content">	
			<div class="container">
				<div class="box clearfix" id="dashboard">
					<div class="loginform">
						<h3>Login</h3>
						<c:forEach var="error" items="${errors}">
	    					${error.category} - ${error.message}<br />
						</c:forEach>
						<form id="formLogin" action="<c:url value="authenticates"/>" method="POST"> 
							<label class="labelLogin">Login: </label><input class="inputLogin" type="text" name="user.username"><br>
							<label class="labelLogin">Senha: </label><input class="inputLogin" type="password" name="user.password"><br>
							<label class="labelLogin"></label><input class="inputLogin" type="submit" value="Login">
						</form>	
						<br/>
						<span>Esqueceu a senha? Clique <a href="#">aqui</a>.</span><br><br>
						<span>N�o � usu�rio? <a href="#">Cadastre-se!</a></span>
					</div>
				</div>
			</div>
		</div>
		<c:import url="/public/footer.jsp"></c:import>	
	</body>
</html>