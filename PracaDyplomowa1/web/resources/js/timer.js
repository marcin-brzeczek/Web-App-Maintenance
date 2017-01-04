/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

            // Funkcja to podprogram który ma konretne zadanie:
            function odliczanie()
            {


            var dzisiaj = new Date(); // pobieranie daty
            var dzien = dzisiaj.getDate(); // pobranie dnia miesiąca
            var miesiac = dzisiaj.getMonth() + 1; // miesiac
            var rok = dzisiaj.getFullYear(); // rok

            var godzina = dzisiaj.getHours();
            var minuta = dzisiaj.getMinutes();
            var sekunda = dzisiaj.getSeconds();
            if(sekunda <10){
                sekunda ="0"+sekunda;
            }
            if(minuta <10){
                minuta ="0"+minuta;
            }
//            var miesiace  = ["jaja","pisiory","pisiory","pisiory","pisiory","pisiory","pisiory","pisiory","pisiory","pisiory"];
//            switch(miesiac){
//                
//        case 9 : miesiace[9]; break;
//      
//                
//        default : 
//    }

//txt.fontcolor("green")

                  var txt =  dzien + "/" + miesiac + "/" + rok + " " + godzina + ":" + minuta + ":" + sekunda;
                  txt = txt.fontcolor('green').fontsize(2);
            document.getElementById("zegar").innerHTML = txt;
// Wywołuj tą funkcję co 1 sekundę // 
setTimeout("odliczanie()",1000);
            }
 