/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author Marcin
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Marcin
 */
public class DBManager {
    private static DBManager instance;
    private EntityManagerFactory emf;
    private DBManager(){}

    public  synchronized static DBManager getManager() {
   
        if(instance==null)
            instance = new DBManager();
        return  instance;
    }
    public EntityManagerFactory createEntityManagerFactory(){
        if(emf==null)
            emf= Persistence.createEntityManagerFactory("PracaDyplomowa1PU");
        return emf;
        
    }
    
    public EntityManager createEntityManager(){
        return this.createEntityManagerFactory().createEntityManager();
    }
    public void closeEntityManagerFactory(){
        if(emf!=null)
            emf.close();
    }
}

