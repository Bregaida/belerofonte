<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Belerofonte | Administração</title>
		<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet" type="text/css"  />
	</head>	
	<body>
		<c:import url="/public/header.jsp"></c:import>
		<div id="content">	
			<div class="container">
				<div class="box clearfix" id="dashboard">
					<h3>Administração</h3>
					<a href="plataforms">Plataformas</a>   |  |   
					<a href="categories">Categorias</a>
				</div>
			</div>
		</div>
		<c:import url="/public/footer.jsp"></c:import>	
	</body>
</html>