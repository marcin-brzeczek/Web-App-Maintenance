/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Marcin
 */
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
@ManagedBean
public class PracownikGPLoginView implements Login {

RequestContext context;
    boolean loggedIn = false;
    String username;
    FacesMessage message = null;

    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Jeśli się zalogowałem to wrzuć mnie na stronę ze zgłaszaniem awarii
@Override
    public String pageoperator() {
        if (loggedIn == true) {

//            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome " + username, username);
            return "/pracownikzgloszenie.xhtml";
        }
        return null;
    }

  
@Override
    public String login(ActionEvent event) {
         context = RequestContext.getCurrentInstance();

        if (username != null && username.equals("Lenhardt1") && password != null && password.equals("Szyby")) {
            loggedIn = true;
            return "/pracownikzgloszenie.xhtml";
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Błąd logowania", "Nieprawidłowy login lub hasło");
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        return null;
    }

  
    
}
