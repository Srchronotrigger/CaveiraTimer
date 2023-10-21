package com.srchronotrigger.main.caveiratimer;

/**
 *
 * @author srchronotrigger
 * 
 *  O CaveiraTimer é distribuido gratuitamente sob a licença MIT, é permitido a modificação e a redistribuição desde que mantido os créditos ao autor (Srchronotrigger). 
 *  Email para contato: sr.chronotrigger@gmail.com
 *  fonte alarm_clock.ttf por David J Patterson. Disponível em: https://www.dafont.com/pt/alarm-clock.font
 */

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;

public class Timer implements Runnable {
    public int maxTime = 1;
    private boolean running = false;
    public int horas = 0;
    public int minutos = 0;
    public int segundos = 0;
    public int dias = 0;
    public int hoursaux = 0;
    public int savefrequ = 1;
    public int minaux = 0;
    
   
    private boolean watchDone = false;
    private Window_Timer window;
    //public JLabel jLabel;
    private String timerclock;
    public boolean isStarted = false;
    public boolean isTimerEnded = false;
    
    public Timer() {
        window = new Window_Timer(1);
//        jLabel = new JLabel("00 : 00 : 00");
//        jLabel.setVisible(true);
//        jLabel.setBounds(279, 331, 100, 10);
        
    }
    
    public void delete(){
          File arquivo = new File("tempo.txt");
        if (arquivo.delete()) {
            System.out.println("Arquivo deletado com sucesso.");
        } else {
            System.out.println("Falha ao deletar arquivo.");
        }
    }
    
    public void save(){
         BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("tempo.txt"));
        } catch (IOException ex) {
            Logger.getLogger(Window_Stopwatch.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            writer.write("segundos=" + segundos);
            writer.newLine();
            writer.write("minutos=" + minutos);
            writer.newLine();
            writer.write("horas=" + horas);
            writer.newLine();
            writer.write("dias=" + dias);
            writer.newLine();
            writer.write("horasParaoFimDaLive=" + maxTime);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Window_Stopwatch.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao escrever no arquivo! tentando criar uma cópia na área de trabalho.");
            
             try {
                 FileSystemView view = FileSystemView.getFileSystemView();
                    File desktop = view.getHomeDirectory();
                    File file = new File(desktop, "tempo.txt");
                    writer = new BufferedWriter(new FileWriter(file));
                    
                writer.write("segundos=" + segundos);
                writer.newLine();
                writer.write("minutos=" + minutos);
                writer.newLine();
                writer.write("horas=" + horas);
                writer.newLine();
                writer.write("dias=" + dias);
                writer.newLine();
                writer.write("horasParaoFimDaLive=" + maxTime);
                writer.close();
                    
             } catch (IOException ex1) {
                 Logger.getLogger(Window_Stopwatch.class.getName()).log(Level.SEVERE, null, ex1);
             }
                
        }
    }
    
    public void report() {
    BufferedWriter writer = null;
    Date date = null;
    SimpleDateFormat dateFormat = null;

    try {
        date = new Date();
        dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm");

        String fileName = "relatório da live " + dateFormat.format(date) + ".txt";
        File file = new File(fileName);

        int count = 1;
        while (file.exists()) {
            fileName = "relatório da live " + dateFormat.format(date) + " (" + count + ").txt";
            file = new File(fileName);
            count++;
        }

        writer = new BufferedWriter(new FileWriter(file));
        writer.write("Relatório de live gerado na data: " + dateFormat.format(date));
        writer.newLine();
        writer.write("Tempo total: " + String.format("%02d : %02d : %02d", horas, minutos, segundos));
        writer.newLine();
        writer.write("Dias totais: " + dias);
        writer.close();
    } catch (IOException ex) {
        Logger.getLogger(Window_Stopwatch.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Erro ao escrever no arquivo! tentando criar uma cópia na área de trabalho.");

        
        
        try {
            FileSystemView view = FileSystemView.getFileSystemView();
            File desktop = view.getHomeDirectory();
            File file = new File(desktop, "relatório da live " + dateFormat.format(date) + ".txt");
            int i = 2;
            
            
            
            while (file.exists()) {
             file = new File(desktop, "relatório da live " + dateFormat.format(date) + " (" + i + ").txt");
             i++;
        }
            writer = new BufferedWriter(new FileWriter(file));


            writer.write("Relatório de live gerado na data: " + dateFormat.format(date));
            writer.newLine();
            writer.write("Tempo total: " + String.format("%02d : %02d : %02d", horas, minutos, segundos));
            writer.newLine();
            writer.write("Dias totais: " + dias);
            writer.close();

        } catch (IOException ex1) {
            Logger.getLogger(Window_Stopwatch.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }
}

    public void clear(){
     window.jLabel4.setForeground(new Color(255, 0, 51));
     pause();
     horas = 0;
     minutos = 0;
     segundos = 0;
     maxTime = 1;
     dias = 0;
     window.jLabel4.setText("00 : 00 : 00");
     
    }
    
    public void pause() {
        running = false;
    }

    public void resume() {
        running = true;
    }

    public boolean isWatchDone() {
        return watchDone;
    }

    @Override
    public void run() { 
//     horas = maxTime / 3600;
//     minutos = (maxTime % 3600) / 60;
//     segundos = maxTime % 60;

        while (horas >= 0 && minutos >= 0 && segundos >= 0) {
            
    if (running) {
        window.jLabel4.setText(String.format("%02d : %02d : %02d\n", horas, minutos, segundos));
        
        if (horas == 0 && minutos == 0 && segundos == 0 && isStarted) {
                //System.out.println("test");
                isTimerEnded = true;
        break; // interrompe o loop
    }
        
        segundos--;
        if (segundos < 0) {
            segundos = 59;
            minutos--;
            minaux++;
        }
        if (minutos < 0) {
            minutos = 59;
            horas--;
            hoursaux++;
        }
        
        if (hoursaux == 24) {
                   hoursaux = 0;
                   dias++;
                   if(dias == 1)
                        window.jLabel5.setText(dias + " DIA EM LIVE");
                   if(dias != 1)
                        window.jLabel5.setText(dias + " DIAS EM LIVE");
               }
                
                if (minaux == savefrequ && segundos == 0 && savefrequ != 0) {
                    minaux = 0;
                    save();
                }
        
        //System.out.printf("%02d:%02d:%02d\n", horas, minutos, segundos);
        
    }

    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
    //System.out.println(maxTime);
}

        watchDone = true;
        System.out.println("Timer concluído");
       if(isTimerEnded && isStarted){
        //window.jLabel4.setForeground(Color.green);
        //window.jLabel5.setForeground(Color.green);
        if(maxTime == 1){
        window.jLabel1.setText("FIM DA LIVE DE " + maxTime + " HORA =)");} else{
            window.jLabel1.setText("FIM DA LIVE DE " + maxTime + " HORAS =)");
        }
        window.jLabel1.setForeground(Color.green);
        window.jLabel4.setForeground(Color.green);
        window.jLabel5.setForeground(Color.green);
        window.jButton1.setVisible(false);
        window.jButton2.setVisible(false);
        window.jButton1.setEnabled(false);
        window.jButton2.setEnabled(false);
        window.jButton4.setEnabled(false);
        window.jButton4.setVisible(false);
      //  window.jButton5.setVisible(false);
        report();
        delete();
        window.del = true; }
    }
}