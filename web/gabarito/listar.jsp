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
        <title>Gabarito</title>
        <style>
            textArea{width: 50%;}

            select{width: 25%;}

            table{text-align: center;}
        </style>
    </head>
    <body>
    <center>

        <c:if test="${param.msg eq 0}">
            <h2 style="color:greenyellow;">Gerada com sucesso!</h2>
        </c:if>
        <c:if test="${param.msg eq 1}">
            <h2 style="color:green;">Editado com sucesso!</h2>
        </c:if>
        <c:if test="${param.msg eq 2}">
            <h2 style="color:red;">Excluido com sucesso!</h2>
        </c:if>
            
        <h1>Gabarito</h1>
        <strong>Selecione a prova:</strong><br><br>

       

        <jsp:useBean id="dao" class="br.com.map.dao.DAOProva"/>
        
            <select>
                <c:forEach var="prova" items="${dao.all()}">
                    <option value="${prova.id}">${prova.titulo}</option>
                </c:forEach>
            </select>
        <br><br><a href="prova.jsp"><button>Ver</button></a>
        <a href="../index.html"><button>Voltar</button></a><br>
    </center>
</body>
</html>