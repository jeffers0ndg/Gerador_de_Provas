package br.com.map.servlet;

import br.com.map.facade.GabaritoFacade;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
        
                gerar(request, response);
        
    }
public void gerar(HttpServletRequest request, HttpServletResponse response) throws IOException{
    
        long idProva = Long.valueOf(request.getParameter("idProva"));
        
        response.setContentType("application/pdf"); 
        facade.gerarGabarito(idProva,response.getOutputStream());
        
        
}
   
}
