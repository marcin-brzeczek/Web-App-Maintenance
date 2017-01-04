/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Marcin
 */
@ManagedBean(name = "gp")
@ViewScoped
public class Gp {

    public Gp() {
    }
    String lineProduction; //  linie produkcyjna
    private String machineProduction; // maszyna/gniazdo produkcyjne
    private String statusMachine;
    private Date machineStop;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

// StringBuilder wyłapie wszystkie informacje do przesłania maila     
    public static StringBuilder sb = new StringBuilder();
    static Set<String> set = new TreeSet<String>();
    // metoda zwróci wyłapane dane

    public String zlap() {

            set.remove("Czy maszyna zatrzymana :null"); 
                     set.remove("Linia: null");
                     set.remove("Maszyna: null");
                     set.remove("Opis awarii:null");
        for (String s : set) 
                sb.append(s + " \n");
        
            
        
        return sb.toString();
    }

    public Date getMachineStop() {
        return machineStop;
    }

    public void setMachineStop(Date machineStop) {
        this.machineStop = machineStop;
    }

    public String getFormattedDate() {
        if (this.getMachineStop() == null) {
            return "Maszyna nie zatrzymana !";
        }
        set.add("Data zatrzymania maszyny:" + sdf.format(machineStop));
        return sdf.format(machineStop);
    }

    private String desc;

    public String getDesc() {
        set.add("Opis awarii:" + desc);
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatusMachine() {
        set.add("Czy maszyna zatrzymana :" + statusMachine);
        return statusMachine;
    }

    public void setStatusMachine(String statusMachine) {
        this.statusMachine = statusMachine;
    }

    public String getMachineProduction() {
        set.add("Maszyna: " + machineProduction);
        return machineProduction;
    }

    public void setMachineProduction(String machineProduction) {
        this.machineProduction = machineProduction;
    }

    public String getLineProduction() {
        set.add("Linia: " + lineProduction);
        return lineProduction;
    }

    public void setLineProduction(String lineProduction) {
        this.lineProduction = lineProduction;
    }

    // Kontener z Liniami Produkcyjnymi
    String[] linie = new String[]{"Linia Lenhardt", "Linia Lisec"};
    ArrayList<String> lin = new ArrayList<String>(Arrays.asList(linie));

    public ArrayList<String> getLin() {
        return lin;
    }

    public void setLin(ArrayList<String> lin) {
        this.lin = lin;
    }

    //Kontener z maszynami produkcyjnymi linii Lenhardt
    String[] Lenhardtmachines = new String[]{"Transporter wejściowy", "Myjka Lenhardt", "Stacja nakładania ramek",
        "Prasa", "Robot tiokolujący", "Transporter wyjściowy"};

    ArrayList<String> LenMach = new ArrayList<String>(Arrays.asList(Lenhardtmachines));

    public ArrayList<String> getLenMach() {
        return LenMach;
    }

    public void setLenMach(ArrayList<String> LenMach) {
        this.LenMach = LenMach;
    }

//Kontener z maszynami produkcyjnymi linii Lisec
    String[] Lisecmachines = new String[]{"Transporter wejściowy", "Myjka Lisec", "Stacja nakładania ramek",
        "Prasa", "Transporter wyjściowy", "Nakładanie poliuretanu pistoletem"};
    ArrayList<String> LisMach = new ArrayList<String>(Arrays.asList(Lisecmachines));

    public ArrayList<String> getLisMach() {
        return LisMach;
    }

    public void setLisMach(ArrayList<String> LisMach) {
        this.LisMach = LisMach;
    }

    /**
     * Creates a new instance of Gp
     */
}
