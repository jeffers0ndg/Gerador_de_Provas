package br.com.map.facade;

import br.com.map.dao.DAOMateria;
import br.com.map.dao.DAOQuestao;
import br.com.map.dao.DaoException;
import br.com.map.model.Materia;
import br.com.map.model.Questao;
import br.com.map.servlet.QuestaoServlet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestaoFacade {

    private DAOQuestao daoq;
    private DAOMateria daom;

    public QuestaoFacade() {
        daoq = new DAOQuestao();
        daom = new DAOMateria();
    }

    public void salvarQuetao(long materia, int dificuldade, String enunciado, String resolucao,
            String[] alternativas) throws DaoException {
        //Recupera o objeto da materia pelo id passado pela pagina
        Materia m = new Materia();
        m = daom.find(materia);

        //Cria objeto questao com as variaveis recebidas da pagina e salva no banco
        Questao q = new Questao(m, enunciado, resolucao, dificuldade, alternativas[0],
                alternativas[1], alternativas[2], alternativas[3], alternativas[4]);

        daoq.save(q);
    }

    public void editarQuestao(long id, long materia, int dificuldade, String enunciado, String resolucao,
    String[] alternativas) throws DaoException  {
        
        Materia m = new Materia();

        m = daom.find(materia);

        //Cria objeto questao com as variaveis recebidas da pagina e salva no banco
        Questao q = new Questao();
        q = daoq.find(id);
        q.setMateria(m);
        q.setEnunciado(enunciado);
        q.setResolucao(resolucao);
        q.setDificuldade(dificuldade);
        q.setAltLetraA(alternativas[0]);
        q.setAltLetraB(alternativas[1]);
        q.setAltLetraC(alternativas[2]);
        q.setAltLetraD(alternativas[3]);
        q.setAltLetraE(alternativas[4]);
        daoq.update(q);
    }
    
    public void excluirQuestao(long id) throws DaoException{
        Questao q = daoq.find(id);
        daoq.remove(q);
    }
}
