package br.com.map.facade;

import br.com.map.dao.DAOMateria;
import br.com.map.dao.DAOProva;
import br.com.map.dao.DAOQuestao;
import br.com.map.dao.DaoException;
import br.com.map.model.Materia;
import br.com.map.model.Prova;
import br.com.map.model.Questao;
import br.com.map.servlet.ProvaServlet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProvaFacade {

    private DAOQuestao daoq;
    private DAOMateria daom;
    private DAOProva daop;

    public ProvaFacade() {
        daoq = new DAOQuestao();
        daom = new DAOMateria();
        daop = new DAOProva();
    }

    public void salvarProva(String titulo, String[] idsMaterias) throws DaoException {
        Collection<Materia> materias = new ArrayList();
        Collection<Questao> questoes = new ArrayList();
        

        int numPorMateria = 30 / idsMaterias.length, facil = 15, media = 10, dificil = 5;

        //Váriavel que deve ter o numero de posições igual o numero de materias selecionadas
        int[] x = new int[idsMaterias.length];

        //Preenche cada posição da variavel com o número de questões por matéria
        //Preenche a lista de questões com as questões selecionadas
        for (int i = 0; i < idsMaterias.length; i++) {
            x[i] = numPorMateria;
            materias.add(daom.find(Long.valueOf(idsMaterias[i])));
        }

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
    }
}
