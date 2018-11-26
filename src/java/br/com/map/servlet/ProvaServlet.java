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
import br.com.map.model.Materia;
import br.com.map.model.Prova;
import br.com.map.model.Questao;
import java.io.IOException;
import java.io.PrintWriter;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "gerar":
                gerar(request);
                //response.sendRedirect("prova/listar.jsp?msg=0");
                break;
            case "editar":
                //editar(request);
                //response.sendRedirect("questao/listar.jsp?msg=1");
                break;
            case "excluir":
                //excluir(request);
                //response.sendRedirect("questao/listar.jsp?msg=2");
                break;
        }
    }

    private void gerar(HttpServletRequest request) {
        String[] idsMaterias = request.getParameterValues("materias");
        String titulo = request.getParameter("titulo");
        
        Collection<Materia> materias = new ArrayList();
        Collection<Questao> questoes = new ArrayList();
        
        DAOQuestao daoq = new DAOQuestao();
        DAOMateria daom = new DAOMateria();
        DAOProva daop = new DAOProva();

        int numPorMateria = 30 / idsMaterias.length, facil = 15, media = 10, dificil = 5;

        //Váriavel que deve ter o numero de posições igual o numero de materias selecionadas
        int[] x = new int[idsMaterias.length];

        //Preenche cada posição da variavel com o número de questões por matéria
        //Preenche a lista de questões com as questões selecionadas
        try {
            for (int i = 0; i < idsMaterias.length; i++) {
                x[i] = numPorMateria;
                materias.add(daom.find(Long.valueOf(idsMaterias[i])));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        try {
            for (Questao questao : daoq.all()) {
                for (int i = 0; i < idsMaterias.length; i++) {
                    if (questao.getMateria().getId() == Long.valueOf(idsMaterias[i])) {
                        if (questao.getDificuldade() == 1 && facil > 0 && x[i] > 0) {
                            x[i]--;
                            facil--;
                            questoes.add(questao);
                        } else {
                            if (questao.getDificuldade() == 2 && media > 0 && x[i] > 0) {
                                x[i]--;
                                media--;
                                questoes.add(questao);
                            } else {
                                if (dificil > 0 && x[i] > 0) {
                                    x[i]--;
                                    dificil--;
                                    questoes.add(questao);
                                }
                            }
                        }
                    }
                }

            }
            Prova p = new Prova();
            p.setTitulo(titulo);
            p.getMaterias().addAll(materias);
            p.getQuestoes().addAll(questoes);
            daop.save(p);
        } catch (DaoException ex) {
            Logger.getLogger(ProvaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
