/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.servlet;

import br.com.map.dao.DAOMateria;
import br.com.map.dao.DAOProva;
import br.com.map.dao.DAOQuestao;
import br.com.map.dao.DaoException;
import br.com.map.facade.ProvaFacade;
import br.com.map.model.Materia;
import br.com.map.model.Prova;
import br.com.map.model.Questao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Desen
 */
public class ProvaServlet extends HttpServlet {

    private  ProvaFacade facade;

    public ProvaServlet() {
        facade = new ProvaFacade();
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "gerar":
                gerar(request);
                response.sendRedirect("prova/listar.jsp?msg=0");
                break;
            case "editar":
                editar(request);
                //response.sendRedirect("questao/listar.jsp?msg=1");
                break;
            case "excluir":
                //excluir(request);
                //response.sendRedirect("questao/listar.jsp?msg=2");
                break;
        }
    }

    private void editar(HttpServletRequest request) {

    }

    private void gerar(HttpServletRequest request) {
        String[] idsMaterias = request.getParameterValues("materias");
        String titulo = request.getParameter("titulos");
        
        try {
            facade.salvarProva(titulo, idsMaterias);
        } catch (DaoException ex) {
            Logger.getLogger(ProvaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
