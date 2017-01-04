/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.event.ActionEvent;

/**
 *
 * @author Marcin
 */
/*  Klasy implementujące ten interfejs będą 
odpowiadały za logowanie do różnych kont*/

public interface Login {

    public String login(ActionEvent e);

    public String pageoperator();

}
