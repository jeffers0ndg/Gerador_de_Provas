<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : gerar
    Created on : 21/11/2018, 17:45:48
    Author     : Desen
--%>

<%@include file="../codificacao.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerar Prova</title>
    </head>
    <body>
    <center>

        <c:if test="${param.msg eq 0}">
            <h2 style="color:greenyellow;">Prova gerada com sucesso!</h2>
        </c:if>
        <h1>Gerar Prova</h1>

        <jsp:useBean id="daop" class="br.com.map.dao.DAOProva"/>
        <jsp:useBean id="facade" class="br.com.map.facade.ProvaFacade"/>
        <c:set var="prova" value="${daop.find(param.id)}"/>
        <form method="POST" action="../ProvaServlet?op=editar&id=${param.id}">
                    
            <p><strong>Título:</strong></p>
            <input type="text" name="titulos" value="${prova.titulo}"/><br><br>
            <table border="1" cellpadding="4" cellspacing="0">
                <tr>
                    <th>Matéria</th>
                </tr>

                <c:forEach var="materia" items="${prova.materias}">
                    <tr>
                        <td><label for="materias"><input checked multiple="multiple" name="materias" type="checkbox" value="${materia.id}"/>${materia.nome}</label></td>
                    </tr>
                </c:forEach>
                <c:forEach var="materia" items="${facade.materiasProva(param.id)}">
                    <tr>
                        <td><label for="materias"><input multiple="multiple" name="materias" type="checkbox" value="${materia.id}"/>${materia.nome}</label></td>
                    </tr>
                </c:forEach>

            </table>
            <br><input type="submit" value="Gerar" />
        </form>
        <br><a href="listar.jsp"><button>Voltar</button><br>
            </center>

            </body>
            </html>