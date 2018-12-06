package br.com.map.servlet;

import br.com.map.dao.DaoException;
import br.com.map.facade.GabaritoFacade;
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
@WebServlet(name = "GabaritoServlet", urlPatterns = {"/GabaritoServlet"})
public class GabaritoServlet extends HttpServlet {
    
   private GabaritoFacade facade;

    public GabaritoServlet() {
        facade = new GabaritoFacade();
    }
   
   
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.getWriter().write("Cadastrado com Sucesso!!"+request.getParameter("enunciado"));
        String op = request.getParameter("op");
        switch(op){
            case "gerar":
                gerar(request);
                //response.sendRedirect("questao/listar.jsp?msg=0");
                break;
            case "editar":
                editar(request);
                //response.sendRedirect("questao/listar.jsp?msg=1");
                break;
            case "excluir":
                excluir(request);
                //response.sendRedirect("questao/listar.jsp?msg=2");
                break;
        }
        
    }
public void gerar(HttpServletRequest request){
    
        long idProva = Long.valueOf(request.getParameter("idProva"));
        
       try {
           facade.salvarGabarito(idProva);
       } catch (DaoException ex) {
           Logger.getLogger(QuestaoServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
}

public void editar(HttpServletRequest request){
        
        long id = Long.valueOf(request.getParameter("id"));
        long materia = Long.valueOf(request.getParameter("materia"));
        
       try {
           facade.editarGabarito(id, id);
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
            facade.excluirGabarito(id);
        } catch (DaoException ex) {
            Logger.getLogger(QuestaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
   
}
