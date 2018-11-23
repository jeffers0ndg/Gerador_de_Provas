package br.com.map.singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ManagerSingleton {

    
  private static EntityManager entityManager = null;
  private static EntityManagerFactory entityManagerFactory = null;
    private ManagerSingleton() {

    }
    
    public static EntityManager getInstance(){
        try {
          if (entityManager == null || !entityManager.isOpen()) {
              entityManager = entityManagerFactory.createEntityManager();
          }
          return entityManager;
      } catch (Exception e) {
          e.printStackTrace();
          return null;
      }
    }
}
