package com.srchronotrigger.main.caveiratimer;

/**
 *
 * @author srchronotrigger
 * 
 *  O CaveiraTimer é distribuido gratuitamente sob a licença MIT, é permitido a modificação e a redistribuição desde que mantido os créditos ao autor (Srchronotrigger). 
 *  Email para contato: sr.chronotrigger@gmail.com
 *  fonte alarm_clock.ttf por David J Patterson. Disponível em: https://www.dafont.com/pt/alarm-clock.font
 */

import javax.swing.JOptionPane;


public class EntryPoint {
    
    private static Window_Stopwatch window_stopwatch;
    private static Window_Timer window_timer;
    private static Utils utils;
    
     public static void main(String args[]){
        int escolha = JOptionPane.showOptionDialog(
        null,
        "Você deseja um contador Progressivo ou Regressivo?",
        "Escolha",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        new String[]{"Progressivo", "Regressivo"},
        "Opção 1"
        );

        if (escolha == JOptionPane.YES_OPTION) {
                 window_stopwatch = new Window_Stopwatch(1);
                 window_stopwatch.start();
        } else if (escolha == JOptionPane.NO_OPTION) {
                 window_timer = new Window_Timer(1);
                 window_timer.start();
        } else {
            //String imagePath = "com/srchronotrigger/main/caveiratimer/Icon.png";
            utils = new Utils();
            utils.credits();
        }       

         
    }
     
      
    
}
