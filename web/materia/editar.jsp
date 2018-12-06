<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../codificacao.jsp" %>

<jsp:useBean id="daom" class="br.com.map.dao.DAOMateria"/>
<c:set var="materia" value="${daom.find(param.id)}"/>

<form method="POST" action="../MateriaServlet?op=editar&id=${param.id}">
    
    <p><strong>Nome:</strong></p>
    <input type="text" name="nome" required autofocus value="${materia.nome}"/><br><br>
    <input type="submit" value="Editar"/><br>
           
</form>
        