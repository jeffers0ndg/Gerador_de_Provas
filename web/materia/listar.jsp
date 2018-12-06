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
        <script type="text/javascript" src="../javascript/ajax.js"></script>
        <title>Matéria</title>
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

        <h1>Matéria</h1>

        <div id="novo">
            <button onclick="cadastrar()">Nova</button>
        </div>
        <br>
        <a href="../index.html"><button>Voltar</button></a><br>

        <jsp:useBean id="dao" class="br.com.map.dao.DAOMateria"/>
        <br><table border="1" cellpadding="4" cellspacing="0">
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>
            <c:forEach var="materia" items="${dao.all()}">
                <tr>
                    <td>${materia.id}</td>
                    <td>${materia.nome}</td>
                    <td><button onclick="editar(${materia.id})">Editar</button></td>
                    <td><form method="POST" action="../MateriaServlet?op=excluir&id=${materia.id}"><input type="submit" value="Excluir"/></form></td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>