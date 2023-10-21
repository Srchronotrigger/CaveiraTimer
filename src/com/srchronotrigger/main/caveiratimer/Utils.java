package com.srchronotrigger.main.caveiratimer;

/**
 *
 * @author srchronotrigger
 * 
 *  O CaveiraTimer é distribuido gratuitamente sob a licença MIT, é permitido a modificação e a redistribuição desde que mantido os créditos ao autor (Srchronotrigger). 
 *  Email para contato: sr.chronotrigger@gmail.com
 *  fonte alarm_clock.ttf por David J Patterson. Disponível em: https://www.dafont.com/pt/alarm-clock.font
 */

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author srchr
 */
public class Utils {
    private final String version = "1.0";
    
    public void credits(){
        URL iconURL = EntryPoint.class.getResource("Icon.png");
        Icon icon = new ImageIcon(iconURL);
        
        JOptionPane.showMessageDialog(null, String.format("CaveiraTime Versão: "+ version +".\nBuild: " + getCurrentDate() + ".\nDesenvolvido por: Srchronotrigger.\nPara uso do canal Renanplay."), "Créditos", JOptionPane.INFORMATION_MESSAGE, icon);
    }
    
    public String getCurrentDate() {
        Date date = new Date();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        String formattedDate = format.format(date);

        return formattedDate;
    }
    
    
}
