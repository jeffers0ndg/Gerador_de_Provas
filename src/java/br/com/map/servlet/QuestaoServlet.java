package br.com.map.servlet;

import br.com.map.dao.DAOMateria;
import br.com.map.dao.DAOQuestao;
import br.com.map.dao.DaoException;
import br.com.map.facade.QuestaoFacade;
import br.com.map.model.Materia;
import br.com.map.model.Questao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Desen
 */
@WebServlet(name = "QuestaoServlet", urlPatterns = {"/QuestaoServlet"})
public class QuestaoServlet extends HttpServlet {
    
   private QuestaoFacade facade;

    public QuestaoServlet() {
        facade = new QuestaoFacade();
    }
   
   
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.getWriter().write("Cadastrado com Sucesso!!"+request.getParameter("enunciado"));
        String op = request.getParameter("op");
        switch(op){
            case "cadastrar":
                cadastrar(request);
                response.sendRedirect("questao/listar.jsp?msg=0");
                break;
            case "editar":
                editar(request);
                response.sendRedirect("questao/listar.jsp?msg=1");
                break;
            case "excluir":
                excluir(request);
                response.sendRedirect("questao/listar.jsp?msg=2");
                break;
        }
        
    }
public void cadastrar(HttpServletRequest request){
    
        long materia = Long.valueOf(request.getParameter("materia"));
        int dificuldade = Integer.valueOf(request.getParameter("dificuldade"));
        
        String enunciado = request.getParameter("enunciado"); 
        String resolucao = request.getParameter("resolucao");
        String[] alternativas = {request.getParameter("letraa"),request.getParameter("letrab"),
        request.getParameter("letrac"),request.getParameter("letrad"),request.getParameter("letrae")};
        
       try {
           facade.salvarQuetao(materia, dificuldade, enunciado, resolucao, alternativas);
       } catch (DaoException ex) {
           Logger.getLogger(QuestaoServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
}

public void editar(HttpServletRequest request){
        
        long id = Long.valueOf(request.getParameter("id"));
        long materia = Long.valueOf(request.getParameter("materia"));
        int dificuldade = Integer.valueOf(request.getParameter("dificuldade"));
        
        String enunciado = request.getParameter("enunciado"); 
        String resolucao = request.getParameter("resolucao");
        String[] alternativas = {request.getParameter("letraa"),request.getParameter("letrab"),
        request.getParameter("letrac"),request.getParameter("letrad"),request.getParameter("letrae")};
        
       try {
           facade.editarQuestao(id, materia, dificuldade, enunciado, resolucao, alternativas);
       } catch (DaoException ex) {
           Logger.getLogger(QuestaoServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
       
}
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void excluir(HttpServletRequest request) {
        
        long id = Long.valueOf(request.getParameter("id"));
        try {
            facade.excluirQuestao(id);
        } catch (DaoException ex) {
            Logger.getLogger(QuestaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
   
}
