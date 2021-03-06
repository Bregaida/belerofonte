<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Belerofonte | Minha Conta</title>
		<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet" type="text/css"  />
	</head>
	<body>	
		<c:import url="/public/header.jsp"></c:import>
		<div id="content">	
			<div class="container">
				<div class="box clearfix" id="dashboard">
					<h3>Bem vindo, ${account.user.name}!</h3>
					<a id="editAccount" href="user/edit/${account.user.id}">Editar Conta</a>
					<br/><br/>
					<a href='<c:url value="/file/register" />'>Adicionar Aplicativo</a>
					<br/><br/>
					<c:forEach items="${account.user.files}" var="file">
						<li>
							<p><a href="<c:url value="/admin/plataform/${file.id}" />">${file.name}</a>   ${file.numberOfDownloads} downloads</p>
						</li><br/>
					</c:forEach>
				</div>
			</div>
		</div>
		<c:import url="/public/footer.jsp"></c:import>							
	</body>
</html>