package br.com.map.facade;

import br.com.map.dao.DAOMateria;
import br.com.map.dao.DaoException;
import br.com.map.model.Materia;
import br.com.map.model.Questao;

public class MateriaFacade {

    private DAOMateria daom;

    public MateriaFacade() {
        daom = new DAOMateria();
    }

    public void salvarMateria(String nome) throws DaoException {
        Materia m = new Materia();
        m.setNome(nome);

        daom.save(m);
    }

    public void editarMateria(long id, String nome) throws DaoException  {
        
        Materia m = new Materia();
        m = daom.find(id);
        m.setNome(nome);
        daom.update(m);
    }
    
    public void excluirMateria(long id) throws DaoException{
        Materia m = daom.find(id);
        daom.remove(m);
    }
}
