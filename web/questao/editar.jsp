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
        <h1>Editar Questões</h1>
        <p><strong>Materia:</strong></p>
        
        <jsp:useBean id="daoQuestao" class="br.com.map.dao.DAOQuestao"/>
        <c:set var="questao" value="${daoQuestao.find(param.id)}"/>
        
        <jsp:useBean id="daoMateria" class="br.com.map.dao.DAOMateria"/>
        
        <form method="POST" action="../QuestaoServlet">
            <select name="materia">
                <c:forEach var="materia" items="${daoMateria.all()}">
                    
                    <c:if test="${materia.id eq questao.materia.id}">
                        <option selected value="${materia.id}">${materia.nome}</option>    
                    </c:if>
                    <c:if test="${materia.id != questao.materia.id}">
                        <option value="${materia.id}">${materia.nome}</option>    
                    </c:if>
                </c:forEach>
            </select>
            <select name="dificuldade">
                <c:if test="${questao.dificuldade == 1}">
                    <option selected value="1">Facil</option>    
                </c:if>
                <c:if test="${questao.dificuldade == 2}">
                    <option selected value="2">Media</option>    
                </c:if>
                <c:if test="${questao.dificuldade == 3}">
                    <option selected value="3">Dificil</option>    
                </c:if>
                <c:if test="${questao.dificuldade != 1}">
                    <option value="1">Facil</option>    
                </c:if>
                <c:if test="${questao.dificuldade != 2}">
                    <option value="2">Media</option>    
                </c:if>
                <c:if test="${questao.dificuldade != 3}">
                    <option value="3">Dificil</option>    
                </c:if>
            </select>
            
        
            <p><strong>Enunciado:</strong></p>
            <textarea name="enunciado">${questao.enunciado}</textarea><br>
            <p><strong>Resolução:</strong></p>
            <select name="resolucao">
                <option value="a">A</option>
                <option value="b">B</option>
                <option value="c">C</option>
                <option value="d">D</option>
                <option value="e">E</option>
            </select>
            <p><strong>A)</strong></p>
            <textarea name="letraa">${questao.altLetraA}</textarea><br>
            <p><strong>B)</strong></p>
            <textarea name="letrab">${questao.altLetraB}</textarea><br>
            <p><strong>C)</strong></p>
            <textarea name="letrac">${questao.altLetraC}</textarea><br>
            <p><strong>D)</strong></p>
            <textarea name="letrad">${questao.altLetraD}</textarea><br>
            <p><strong>E)</strong></p>
            <textarea name="letrae">${questao.altLetraE}</textarea><br>
            <p><input type="submit" value="Cadastrar"/></p>
        </form>    
    </body>
</html>
