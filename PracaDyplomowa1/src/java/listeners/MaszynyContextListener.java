/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import config.DBManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Marcin
 */
public class MaszynyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
 DBManager.getManager().createEntityManagerFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    DBManager.getManager().closeEntityManagerFactory();
    }
    
}
