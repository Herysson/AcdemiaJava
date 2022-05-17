<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="model.JavaBeans" %>
    <%@page import="java.util.ArrayList" %>
    
    <%
    	@ SuppressWarnings("unchecked")
    	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("alunos");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Listagem de Alunos</title>
</head>
<body>
	<h1>Lista de Alunos Cadastrados</h1>
	<table>
		<thead>
			<tr>
				<th>Matrícula</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Fone</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for(int i=0; i<lista.size(); i++){ %>
				<tr>
					<td><%=lista.get(i).getId() %></td>
					<td><%=lista.get(i).getNome() %></td>
					<td><%=lista.get(i).getEmail() %></td>
					<td><%=lista.get(i).getFone() %></td>
					<td><a href="javascript: confirmar(<%=lista.get(i).getId()%>)">Excluir</a></td>
				</tr>
				<%} %>
		</tbody>
	</table>
	<p>
	<a href="home">Sair</a>
	<script src="scripts/confirmador.js"></script>
</body>
</html>