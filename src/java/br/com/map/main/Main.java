package br.com.map.main;

import antlr.collections.List;
import br.com.map.dao.DAOMateria;
import br.com.map.dao.DAOProva;
import br.com.map.dao.DAOQuestao;
import br.com.map.dao.DaoException;
import br.com.map.model.Materia;
import br.com.map.model.Prova;
import br.com.map.model.Questao;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

  public static void main(String[] args) throws DaoException {
            
      DAOProva daop = new DAOProva();
      
      for (Questao q : daop.find(1l).getQuestoes()) {
          System.out.println(q.getEnunciado());
      }
    
    //Livro l = new Livro();
    //l.setTitulo("Era uma vez");
    //l.setPreco(10.0);
    
    //DAOLivro dao = new DAOLivro();
    
    
    // Salvar
    //dao.save(l);
    
    // Buscar
    //Livro l2 = dao.find(1L);
    //System.out.println(l2.getTitulo());
    
    // Remover
    //dao.delete(l);
    
    //l.setTitulo("Era uma vez 2.0");
    // Atualizar
    //dao.update(l);

    // Listar
    
//    List<Livro> resultado = dao.all();
//      
//    for(Livro r: resultado) {
//      System.out.println(r.getTitulo());
//    }
//
  }

}
