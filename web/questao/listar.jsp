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
        <h1>Lista de Questões</h1>
        <c:if test="${param.msg eq 1}">
            <h2 style="color:greenyellow;">Editado com sucesso!</h2>
        </c:if>
        <c:if test="${param.msg eq 2}">
            <h2 style="color:red;">Excluido com sucesso!</h2>
        </c:if>
        <jsp:useBean id="dao" class="br.com.map.dao.DAOQuestao"/>
        <table border="1">
            <tr>
                <th>Materia</th>
                <th>Dificuldade</th>
                <th>Enunciado</th>
                <th>Resolucão</th>
                <th>a)</th>
                <th>b)</th>
                <th>c)</th>
                <th>d)</th>
                <th>e)</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>
            <c:forEach var="questao" items="${dao.all()}">
                <tr>
                    <td>${questao.materia.nome}</td>
                    <c:if test="${questao.dificuldade eq 1}">
                        <td>Facil</td>
                    </c:if>
                    <c:if test="${questao.dificuldade eq 2}">
                        <td>Medio</td>
                    </c:if>
                    <c:if test="${questao.dificuldade eq 3}">
                        <td>Dificil</td>
                    </c:if>
                    
                    <td>${questao.enunciado}</td>
                    <td>${questao.resolucao}</td>
                    <td>${questao.altLetraA}</td>
                    <td>${questao.altLetraB}</td>
                    <td>${questao.altLetraC}</td>
                    <td>${questao.altLetraD}</td>
                    <td>${questao.altLetraE}</td>
                    <td><a href="editar.jsp?id=${questao.id}"><button>Editar</button></a></td>
                    <td><form method="POST" action="../QuestaoServlet?op=excluir&id=${questao.id}"><input type="submit" value="Excluir"/></form></td>
                    <!--<td><a href="../QuestaoServlet?op=excluir">Excluir</a></td>-->
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
