package br.com.map.facade;

import br.com.map.dao.DAOGabarito;
import br.com.map.dao.DAOProva;
import br.com.map.dao.DaoException;
import br.com.map.model.Gabarito;
import br.com.map.model.Questao;

public class GabaritoFacade {

    private DAOGabarito daog;
    private DAOProva daop;

    public GabaritoFacade() {
        daog = new DAOGabarito();
    }

    public void salvarGabarito(long idProva) throws DaoException {
        Gabarito g = new Gabarito();

            for (Questao p : daop.find(idProva).getQuestoes()) {
                //g.getRespostas().put(p.getId(), p.getResolucao());
            }
        
        daog.save(g);
    }

    public void editarGabarito(long id, long idProva) throws DaoException {

        Gabarito g = new Gabarito();
        g = daog.find(id);
            for (Questao p : daop.find(idProva).getQuestoes()) {
                //g.getRespostas().put(p.getId(), p.getResolucao());
            }
        daog.update(g);
    }

    public void excluirGabarito(long id) throws DaoException {
        Gabarito g = daog.find(id);
        daog.remove(g);
    }
}
