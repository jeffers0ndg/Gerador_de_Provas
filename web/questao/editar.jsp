<%-- 
    Document   : Cadastarr
    Created on : 09/11/2018, 23:06:54
    Author     : Desen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../codificacao.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Questão</title>
        <style>
            textArea{
                width: 50%;
            }
            #materia{
                width: 50%;
            }
            select {
                width: 25%;
                text-align-last: center;
                text-align: center;
            }
        </style>
    </head>
    <body>
    <center>
        <h1>Editar Questões</h1>

        <p><strong>Materia:</strong></p>
        <jsp:useBean id="daoQuestao" class="br.com.map.dao.DAOQuestao"/>
        <c:set var="questao" value="${daoQuestao.find(param.id)}"/>
        <jsp:useBean id="daoMateria" class="br.com.map.dao.DAOMateria"/>
        <form method="POST" action="../QuestaoServlet?op=editar&id=${param.id}">
            <select id="materia" name="materia">
                <c:forEach var="materia" items="${daoMateria.all()}">

                    <c:if test="${materia.id eq questao.materia.id}">
                        <option selected value="${materia.id}">${materia.nome}</option>    
                    </c:if>
                    <c:if test="${materia.id != questao.materia.id}">
                        <option value="${materia.id}">${materia.nome}</option>    
                    </c:if>
                </c:forEach>
            </select>

            <p><strong>Resolução:</strong><strong style="margin-left: 19%">Dificuldade:</strong></p>

            <select name="resolucao">

                <c:if test="${questao.resolucao eq 'A'}">
                    <option selected value="A">A</option> 
                </c:if>
                <c:if test="${questao.resolucao != 'A'}">
                    <option value="A">A</option> 
                </c:if>
                <c:if test="${questao.resolucao eq 'B'}">
                    <option selected value="B">B</option> 
                </c:if>
                <c:if test="${questao.resolucao != 'B'}">
                    <option value="B">B</option> 
                </c:if>
                <c:if test="${questao.resolucao eq 'C'}">
                    <option selected value="C">C</option> 
                </c:if>
                <c:if test="${questao.resolucao != 'C'}">
                    <option value="C">C</option> 
                </c:if>
                <c:if test="${questao.resolucao eq 'D'}">
                    <option selected value="D">D</option> 
                </c:if>
                <c:if test="${questao.resolucao != 'D'}">
                    <option value="D">D</option> 
                </c:if>
                <c:if test="${questao.resolucao eq 'E'}">
                    <option selected value="E">E</option> 
                </c:if>
                <c:if test="${questao.resolucao != 'E'}">
                    <option value="E">E</option> 
                </c:if>




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

            <p><strong>A)</strong></p>
            <textarea name="letraa">${questao.altLetraA}</textarea><br>
            <p><strong>B)</strong></p>
            <textarea name="letrab">${questao.altLetraB}</textarea><br>
            <p><strong>C)</strong></p>
            <textarea name="letrac">${questao.altLetraC}</textarea><br>
            <p><strong>D)</strong></p>
            <textarea name="letrad">${questao.altLetraD}</textarea><br>
            <p><strong>E)</strong></p>
            <textarea name="letrae">${questao.altLetraE}</textarea><br><br>
            <input type="submit" value="Editar"/>
        </form>
        <br><a href="listar.jsp"><button>Voltar</button></a>
    </center> 
</body>
</html>
