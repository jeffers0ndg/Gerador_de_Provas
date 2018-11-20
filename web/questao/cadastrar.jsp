<%-- 
    Document   : Cadastarr
    Created on : 09/11/2018, 23:06:54
    Author     : Desen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Questão</title>
        <style>
            textArea{
                width: 50%;
            }
            select{
                width: 25%;
            }
        </style>
    </head>
    <body>
        <h1>Cadastro de Questões</h1>
        <p><strong>Materia:</strong></p>
        <jsp:useBean id="dao" class="br.com.map.dao.DAOMateria"/>
        <form method="POST" action="../QuestaoServlet?op=cadastrar">
            <select name="materia">
                <c:forEach var="materia" items="${dao.all()}">
                    <option value="${materia.id}">${materia.nome}</option>
                </c:forEach>
            </select>
            <select name="dificuldade">
                <option value="1">Facil</option>
                <option value="2">Medio</option>
                <option value="3">Dificil</option>
            </select>
            
            <p><strong>Enunciado:</strong></p>
            <textarea name="enunciado" ></textarea><br>
            <p><strong>Resolução:</strong></p>
            <select name="resolucao">
                <option value="a">A</option>
                <option value="b">B</option>
                <option value="c">C</option>
                <option value="d">D</option>
                <option value="e">E</option>
            </select>
            <p><strong>A)</strong></p>
            <textarea name="letraa"></textarea><br>
            <p><strong>B)</strong></p>
            <textarea name="letrab"></textarea><br>
            <p><strong>C)</strong></p>
            <textarea name="letrac"></textarea><br>
            <p><strong>D)</strong></p>
            <textarea name="letrad"></textarea><br>
            <p><strong>E)</strong></p>
            <textarea name="letrae"></textarea><br>
            <p><input type="submit" value="Cadastrar"/></p>
        </form>    
    </body>
</html>
