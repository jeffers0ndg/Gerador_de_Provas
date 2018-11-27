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
            select{

                width: 25%;
            }
        </style>
    </head>
    <body>
    <center>
        <h1>Cadastro de Questões</h1>

        <p><strong>Materia:</strong></p>
        <jsp:useBean id="dao" class="br.com.map.dao.DAOMateria"/>
        <form method="POST" action="../QuestaoServlet?op=cadastrar">
            <select id="materia" name="materia">
                <c:forEach var="materia" items="${dao.all()}">
                    <option value="${materia.id}">${materia.nome}</option>
                </c:forEach>
            </select>
            <p><strong>Resolução:</strong><strong style="margin-left: 19%">Dificuldade:</strong></p>

            <select name="resolucao">
                <option value="A">A</option>
                <option value="B">B</option>
                <option value="C">C</option>
                <option value="D">D</option>
                <option value="E">E</option>
            </select>

            <select name="dificuldade">
                <option value="1">Facil</option>
                <option value="2">Medio</option>
                <option value="3">Dificil</option>
            </select>
            <p><strong>Enunciado:</strong></p>
            <textarea name="enunciado" ></textarea><br>
            <p><strong>A)</strong></p>
            <textarea name="letraa"></textarea><br>
            <p><strong>B)</strong></p>
            <textarea name="letrab"></textarea><br>
            <p><strong>C)</strong></p>
            <textarea name="letrac"></textarea><br>
            <p><strong>D)</strong></p>
            <textarea name="letrad"></textarea><br>
            <p><strong>E)</strong></p>
            <textarea name="letrae"></textarea><br><br>
            <input type="submit" value="Cadastrar" />
        </form>
        <br><a href="listar.jsp"><button>Voltar</button></a>
    </center>
</body>
</html>