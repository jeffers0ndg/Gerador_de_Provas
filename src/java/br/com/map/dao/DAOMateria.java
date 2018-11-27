package br.com.map.dao;

import br.com.map.model.Materia;

public class DAOMateria extends DaoGeneric<Materia> {

    public Materia findByName(String name) throws DaoException {

        for (Materia m : all()) {
            if (m.getNome().equals(name)) {
                return m;
            }
        }
        return null;
    }
}
