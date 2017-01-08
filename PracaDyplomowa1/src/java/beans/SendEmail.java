/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class SendEmail {

    // Aby działało to :
    //  1. Wyłącz ochronę antywirusową
   
    Gp gp = new Gp();

 
    String content = gp.zlap();

    public void sendMail() {

        String username = "user@gmail.com";
        String password = "password";
        String from = "from@gmail";
        String to = "to@gmail.com";
        String subject = "Zgłoszenie awarii";
        // Zawartość maila
//        String content = gp.sendMessage();

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from)); // Od kogo 
            message.setRecipients(Message.RecipientType.TO, to);
            message.setSubject(subject);
            message.setText(content);
            Transport.send(message);
            System.out.println("Sent succesfully!");

       
            FacesMessage facesMessage1 = new FacesMessage("Dane zostały zapisane w bazie !");
            FacesMessage facesMessage2 = new FacesMessage("Wysłano maile do UR !");
            facesMessage1.setSeverity(FacesMessage.SEVERITY_INFO);
            facesMessage2.setSeverity(FacesMessage.SEVERITY_INFO);

            FacesContext.getCurrentInstance().addMessage(null, facesMessage1);
            FacesContext.getCurrentInstance().addMessage(null, facesMessage2);

// Do jednego kogoś
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        sendMail();
StringBuilder sb = new StringBuilder();
sb.append("coś tam");
sb.append("\n");
sb.append("jeszcze raz coś tam :)");
System.out.println(Gp.sb);
    }
    
}
