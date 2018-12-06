/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.servlet;

import br.com.map.dao.DAOMateria;
import br.com.map.dao.DaoException;
import br.com.map.facade.MateriaFacade;
import br.com.map.model.Materia;
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
@WebServlet(name = "MateriaServlet", urlPatterns = {"/MateriaServlet"})
public class MateriaServlet extends HttpServlet {
    
    private MateriaFacade facade;
    
    public MateriaServlet(){
        facade = new MateriaFacade();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "cadastrar":
                cadastrar(request);
                response.sendRedirect("materia/listar.jsp?msg=0");
                break;
            case "editar":
                editar(request);
                response.sendRedirect("materia/listar.jsp?msg=1");
                break;
            case "excluir":
                excluir(request);
                response.sendRedirect("materia/listar.jsp?msg=2");
                break;
        }
    }

    private void cadastrar(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        
        try {
            facade.salvarMateria(nome);
        } catch (DaoException ex) {
            Logger.getLogger(MateriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void editar(HttpServletRequest request) {
        long id = Long.valueOf(request.getParameter("id"));
        String nome = request.getParameter("nome");
        
        
        try {
            facade.editarMateria(id, nome);
        } catch (DaoException ex) {
            Logger.getLogger(MateriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void excluir(HttpServletRequest request) {
       long id = Long.valueOf(request.getParameter("id"));
        
        try {
            facade.excluirMateria(id);
        } catch (DaoException ex) {
            Logger.getLogger(MateriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
