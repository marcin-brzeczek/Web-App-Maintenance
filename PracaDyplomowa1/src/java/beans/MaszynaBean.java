/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import config.DBManager;
import entity.Maszyna;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Marcin
 */

@ManagedBean
public class MaszynaBean {
    
      public List getLista() {
        EntityManager em = DBManager.getManager().createEntityManager();
        List list = em.createNamedQuery("Maszyna.findAll").getResultList();
        em.close();
        return list;
    }
    private Maszyna maszyna = new Maszyna();

    public Maszyna getMaszyna() {
        return maszyna;
    }

    public void setMaszyna(Maszyna maszyna) {
        this.maszyna = maszyna;
    }
    
    public String dodaj() {
        
        //Uzyskanie dostępu do menedżera Enjci
        EntityManager em = DBManager.getManager().createEntityManager();
        
        // Rozpoczęcie transakcji
        em.getTransaction().begin();
        
        //Wyzerowanie Identyfikatora 
        maszyna.setId(null);
        
        //Zapisanie w bazie danych
        em.persist(maszyna);
        
        // Zakończenie transakcji
        em.getTransaction().commit();
        
        //Zamknięcie dostępu do managera encji
        em.close();
        
        //Wyświetl informację o dodaniu do tabeli
        this.dodajInformacje("Dodano Maszynę !");
        
        
        this.maszyna = new Maszyna();
        return null;
    }
     public void dodajInformacje(String s) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, s, ""));
    }
     
//     /***************************
    // Wydobycie Maszyny po id//
    public void maszynaListener(ActionEvent ae) {
        String ids = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("maszynaID").toString();
        int id = Integer.parseInt(ids);
        this.maszyna.setId(id);

    }
    
    
    

    public String zaladujDoEdycji() {
        EntityManager em = DBManager.getManager().createEntityManager();
        this.maszyna = em.find(Maszyna.class, maszyna.getId());
        em.close();
        return "/edytujmaszyne.xhtml";
    }

    public String usun() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        this.maszyna = em.find(Maszyna.class, maszyna.getId());
        em.remove(this.maszyna);
        this.maszyna = new Maszyna();
        em.getTransaction().commit();
        em.close();
        this.dodajInformacje("Usunięto Maszynę");
        return null;
    }
    

public String edytuj(){
    EntityManager em =  DBManager.getManager().createEntityManager();
    em.getTransaction().begin();
    em.merge(this.maszyna);
    em.getTransaction().commit();
    em.close();
    this.dodajInformacje("Zmieniono dane Maszyny !");
    this.maszyna = new Maszyna();
    return "/pokazmaszyny.xhtml";

}
}

