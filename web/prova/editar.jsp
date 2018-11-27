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

        <jsp:useBean id="daom" class="br.com.map.dao.DAOMateria"/>
        <jsp:useBean id="daop" class="br.com.map.dao.DAOProva"/>
        
        <c:set var="todasMaterias" value="${daom.all()}"/>
        <c:set var="provaMaterias" value="${daop.find(param.id).materias}"/>
        <c:set var="tam" value="${daop.find(param.id).materias}"/>
        
        
        <form method="POST" action="../ProvaServlet?op=gerar">
            <p><strong>Título:</strong></p>
            <input type="text" name="titulos" value="${daop.find(param.id).titulo}"/><br><br>
            <table border="1" cellpadding="4" cellspacing="0">
                <tr>
                    <th>Matéria</th>
                </tr>

                <c:forEach var="i" begin="0" end="${daom.all().size()-1}" >
                    
                    <c:if test="${todasMaterias[i].id != provaMaterias[i].id}"> 
                        <tr>
                            <td><label for="materias"><input multiple="multiple" name="materias" type="checkbox" value="${todasMaterias[i].id}"/>${todasMaterias[i].nome}</label></td>
                        </tr>
                    </c:if>
                    <c:if test="${todasMaterias[i].id == provaMaterias[i].id}"> 
                        <tr>
                            <td><label for="materias"><input checked multiple="multiple" name="materias" type="checkbox" value="${todasMaterias[i].id}"/>${todasMaterias[i].nome}</label></td>
                        </tr>
                    </c:if>
                    
                       
                </c:forEach>
            </table>
            <br><input type="submit" value="Gerar" />
        </form>
        <br><a href="../index.html"><button>Voltar</button><br>
            </center>

            </body>
            </html>