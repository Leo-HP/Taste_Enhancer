package com.leohp.tasteenhancer.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

    private static EntityManagerFactory emf;

    public PersistenceManager() {
        // TODO Auto-generated constructor stub
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("PU");
        }
        return emf;
    }

    public static void close() {
        if(emf != null && emf.isOpen()) {
            emf.close();
        }
    }

}
