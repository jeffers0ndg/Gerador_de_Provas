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
        <title>Provas em detalhes</title>
        <style>
            textArea{width: 50%;}

            select{width: 25%;}

            table{text-align: center;}
        </style>
    </head>
    <body>
    <center>


        <h1>Prova</h1>

        <a href="listar.jsp"><button>Voltar</button></a><br>

        <jsp:useBean id="dao" class="br.com.map.dao.DAOProva"/>
        <c:set var="prova" value="${dao.find(param.id)}"/>
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
            </tr>
            
            <c:forEach var="questoes" items="${prova.questoes}">
                <tr>
                    <td>${questoes.materia.nome}</td>
                    <c:if test="${questoes.dificuldade eq 1}">
                        <td>Facil</td>
                    </c:if>
                    <c:if test="${questoes.dificuldade eq 2}">
                        <td>Medio</td>
                    </c:if>
                    <c:if test="${questoes.dificuldade eq 3}">
                        <td>Difil</td>
                    </c:if>

                    <td>${questoes.enunciado}</td>
                    <td>${questoes.resolucao}</td>
                    <td>${questoes.altLetraA}</td>
                    <td>${questoes.altLetraB}</td>
                    <td>${questoes.altLetraC}</td>
                    <td>${questoes.altLetraD}</td>
                    <td>${questoes.altLetraE}</td>

                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>