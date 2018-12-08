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
            <h2 style="color:greenyellow;">Gerada com sucesso!</h2>
        </c:if>
        <c:if test="${param.msg eq 1}">
            <h2 style="color:green;">Editado com sucesso!</h2>
        </c:if>
        <c:if test="${param.msg eq 2}">
            <h2 style="color:red;">Excluido com sucesso!</h2>
        </c:if>
        <c:if test="${param.msg eq 3}">
            <h2 style="color:red;">Erro questões insuficientes!</h2>
        </c:if>

        <h1>Prova</h1>

        <br><a href="gerar.jsp"><button>Gerar</button></a>
        <a href="../index.html"><button>Voltar</button></a><br>

        <jsp:useBean id="dao" class="br.com.map.dao.DAOProva"/>
        <br><table border="1" cellpadding="4" cellspacing="0">
            <tr>
                <th>Título</th>
                <th>Detalhes</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>
            <c:forEach var="prova" items="${dao.all()}">
                <tr>
                    <td>${prova.titulo}</td>
                    <td><a href="detalhes.jsp?id=${prova.id}"><button>Ver</button></a></td>
                    <td><a href="editar.jsp?id=${prova.id}"><button>Editar</button></a></td>
                    <td><form method="POST" action="../ProvaServlet?op=excluir&id=${prova.id}"><input type="submit" value="Excluir"/></form></td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>