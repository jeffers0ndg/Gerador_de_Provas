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
        <title>Questões</title>
        <style>
            textArea{width: 50%;}
            
            select{width: 25%;}

            table{text-align: center;}
    </style>
</head>
<body>
    <center>

    <c:if test="${param.msg eq 0}">
        <h2 style="color:greenyellow;">Cadastrado com sucesso!</h2>
    </c:if>
    <c:if test="${param.msg eq 1}">
        <h2 style="color:green;">Editado com sucesso!</h2>
    </c:if>
    <c:if test="${param.msg eq 2}">
        <h2 style="color:red;">Excluido com sucesso!</h2>
    </c:if>

    <h1>Questões</h1>
    
    <br><a href="cadastrar.jsp"><button>Cadastrar</button></a>
    <a href="../index.html"><button>Voltar</button></a><br>

    <jsp:useBean id="dao" class="br.com.map.dao.DAOQuestao"/>
    <br><table border="1" cellpadding="4" cellspacing="0">
    <tr>
    <th>Materia</th>
    <th>Difi.</th>
    <th>Enunciado</th>
    <th>Resol.</th>
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
        </tr>
    </c:forEach>
    </table>
    
        
    </center>
    </body>
    </html>