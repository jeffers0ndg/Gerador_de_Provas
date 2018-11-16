/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.servlet;

import br.com.map.dao.DAOMateria;
import br.com.map.dao.DAOQuestao;
import br.com.map.dao.DaoException;
import br.com.map.model.Materia;
import br.com.map.model.Questao;
import java.io.IOException;
import java.io.PrintWriter;
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
    
    private DAOQuestao daoq;
    private DAOMateria daom;

    public QuestaoServlet() {
        daoq = new DAOQuestao();
        daom = new DAOMateria();
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Variaveis que recebem conteudo da pagina passados por POST
        String materia = request.getParameter("materia");
        long materiaId = Long.valueOf(materia);
        String dificuldade = request.getParameter("dificuldade");
        int difi = Integer.valueOf(dificuldade);
        
        String enunciado = request.getParameter("enunciado"); 
        String resolucao = request.getParameter("resolucao");
        String altLetraA = request.getParameter("letraa");
        String altLetraB = request.getParameter("letrab");
        String altLetraC = request.getParameter("letrac");
        String altLetraD = request.getParameter("letrad");
        String altLetraE = request.getParameter("letrae");
        
        
        //Recupera o objeto da materia pelo id passado pela pagina
        Materia m = new Materia();
        try {
            m = daom.find(materiaId);
        } catch (DaoException ex) {
            Logger.getLogger(QuestaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //Cria objeto questao com as variaveis recebidas da pagina e salva no banco
        Questao q = new Questao(m, enunciado, resolucao, difi, altLetraA, altLetraB, altLetraC, altLetraD, altLetraE);
        try {
            daoq.save(q);
        } catch (DaoException ex) {
            Logger.getLogger(QuestaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
   
}
