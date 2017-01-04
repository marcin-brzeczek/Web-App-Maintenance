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
import config.DBManager;
import entity.Maszyna;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
public class DownloadBean {

    byte[] content = null;
    InputStream is = null;
    private StreamedContent file = null;
    EntityManager em = null;
    int size =0;
    /****** Metoda pobiera id maszyny i na tej podstawie indentyfikuje maszynę i dla niej pobiera 
             wartość pola dokumentacja która jest typu byte[] - następnie konwertujemy 
             na ByteArrayInputStream i tworzymy nowy obiekt file ******/
    public StreamedContent download(int id) {

        em = DBManager.getManager().createEntityManager();

        List<Maszyna> listaMaszyn = em.createQuery("from Maszyna m where m.id='" + id + "'").getResultList();
        for (Maszyna m : listaMaszyn) {
           content = m.getDokumentacja();
            size = content.length;
                    if(size!=0){
            byte b[] = new byte[size];
             is = new ByteArrayInputStream(content);
//                is.read(b); // zapisz dane
                file = new DefaultStreamedContent(is, "image/jpg", "Dokumentacja"+ m.getNazwaMaszyny()+".jpg");
        }
            
            return file;
        }
        return null;
        }
    
}

/**
 * ***Stary Kod **************
 * 
//    private static int count1 = 0;
//    private static int count2 = 0;
 */
//    public StreamedContent getFile() {
//        return file;
//    }

/*    public StreamedContent savefile(int id) {
        
    final String out = "/resources/images/maintenace" + count1++ + ".jpg";
   String outForFile = "C:/Users/Marcin/Documents/NetBeansProjects/PracaDyplomowa1/web/resources/images/maintenace"+count2++ +".jpg";
        File outputFile = new File(outForFile);
        FileOutputStream outputStream = null;
        EntityManager em = DBManager.getManager().createEntityManager(); 
     
//          Wyszukanie językiem JSTL - JSP standard tag library Znajdź taką listę
//         maszyn gdzie pole dokumentacja nie jest puste (null)
         
        List<Maszyna> listaMaszyn = em.createQuery("from Maszyna m where m.id='"+id+"'").getResultList();

//        Zapisanie nowego pliku obrazu w byte[] pod okreslna nazwa
             
            outputStream = new FileOutputStream(outputFile);

        for (Maszyna m : listaMaszyn) {
                outputStream.write(m.getDokumentacja());
            
        
        System.out.println("ID | Maszyna | Linia | Dokumentacja");

        System.out.println(maszyna.getId() + " | " + maszyna.getNazwaLinii() + " | " + maszyna.getNazwaMaszyny() + " | " + maszyna.getDokumentacja().toString());
        InputStream stream = m.getDokumentacja().;
                FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(out);
        file = new DefaultStreamedContent(stream, "image/jpg", "nowy.jpg");
        }
        return file; 
   
        
//
//    public static void main(String[] args)  {
//        FileDownloadView f = new FileDownloadView();
//        f.savefile(); }
//}
}
 */
