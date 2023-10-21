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
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Window_Timer extends javax.swing.JFrame{
    public Font font;
    public int hours = 0;
    public boolean alwaysOnTop = false;
    
    public boolean start = false;
    public float baseFontSize = 15f;
    public boolean running;

    private Thread thread;
    private Timer timer;
    public String clock;
   // private boolean minusButtonIsEnabled = true;
    private boolean isPaused = false;
    private int frequenciaDeSaveEmMinutos;
    boolean del = false;
    private Utils utils;
    /**
     * Creates new form Window
     */
    
    public Window_Timer(int a){
        
    }
    
    public Window_Timer() throws FontFormatException, IOException {
        URL fontURL = Window_Timer.class.getResource("alarm_clock.ttf");
        InputStream is = fontURL.openStream();
        font = Font.createFont(Font.TRUETYPE_FONT, is);
        timer = new Timer();
        Thread thread = new Thread(timer);
        thread.start();
        initComponents();
        
     

        jPanel1.setVisible(true);
        
        jButton1.setVisible(true);
        jButton2.setVisible(true);
        
        if(timer.maxTime == 0){
            jButton1.setEnabled(false);
        }
        
        this.setResizable(true);
        
        this.setTitle("CaveiraTimer");
        
        
        //jPanel1.add(stopwatch.jLabel);
        File arquivo = new File("tempo.txt");
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
                FileWriter escritor = new FileWriter(arquivo);
                escritor.write("segundos=0\nminutos=0\nhoras=0\ndias=0\nhorasParaoFimDaLive=0\nFrequenciaDeSaveEmMinutos=1");
                escritor.close();
                System.out.println("Arquivo criado com sucesso!");
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo!");
                e.printStackTrace();
            }
        } else {
            System.out.println("O arquivo tempo.txt já existe no diretório! Lendo-o");
            String linha;
            try {
            BufferedReader br = new BufferedReader(new FileReader("tempo.txt"));
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split("=");
                if (partes.length == 2) {
                    switch (partes[0]) {
                        case "segundos":
                            timer.segundos = Integer.parseInt(partes[1]);
                            break;
                        case "minutos":
                            timer.minutos = Integer.parseInt(partes[1]);
                            break;
                        case "horas":
                            timer.horas = Integer.parseInt(partes[1]);
                            break;
                        case "dias":
                            timer.dias = Integer.parseInt(partes[1]);
                            break;
                        case "horasParaoFimDaLive":
                            int a = Integer.parseInt(partes[1]);
                            if(a != 0){
                            timer.maxTime = a;
                            hours = timer.maxTime;} else{
                                hours = 0;
                                timer.maxTime = 1;
                            }
                            break;
                        case "FrequenciaDeSaveEmMinutos":
                            frequenciaDeSaveEmMinutos = Integer.parseInt(partes[1]);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "O arquivo /'Tempo.txt/' está com alguma configuração inválida, delete-o ou corrija o erro.", "Atenção!", JOptionPane.WARNING_MESSAGE);
                            break;
                    }
                }
                
            }
            br.close();
            jLabel4.setText(String.format("%02d : %02d : %02d\n", timer.horas, timer.minutos, timer.segundos));
            if(timer.dias != 1){
            jLabel5.setText(timer.dias + " DIAS EM LIVE");} else{
                jLabel5.setText(timer.dias + " DIA EM LIVE");
            }
            if(hours== 1){
            jLabel1.setText("LIVE DE " + timer.maxTime + " HORA");} else{
              jLabel1.setText("LIVE DE " + timer.maxTime + " HORAS");  
            }
            
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo!");
        }
        }
            if(timer.dias != 0 || timer.horas != 0 || timer.minutos != 0 || timer.segundos != 0){
            start = true;
            timer.isStarted = start;
            jButton1.setEnabled(false);
            jButton1.setVisible(false);
            jButton2.setEnabled(false);
            jButton2.setVisible(false);
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        if(hours != 0) jButton1.setEnabled(true); else jButton1.setEnabled(false);
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(102, 102, 102));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });
        jPanel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanel1PropertyChange(evt);
            }
        });
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPanel1KeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 51));
        jButton1.setText("-");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 51));
        jButton2.setText("+");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(font.deriveFont(Font.BOLD, baseFontSize)
        );
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LIVE DE " + timer.maxTime + " HORAS");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Centraliza a câmera aqui burro");

        jLabel4.setFont(font.deriveFont(Font.BOLD, baseFontSize));
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(String.format("%02d : %02d : %02d\n", timer.horas, timer.minutos, timer.segundos));

        jLabel5.setFont(font.deriveFont(Font.BOLD, baseFontSize));
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("0 DIAS DE LIVE");

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setForeground(java.awt.Color.green);
        jButton4.setText("Começar");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 0, 51));
        jButton3.setText("Visível");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setForeground(new java.awt.Color(255, 0, 51));
        jButton5.setText("Botões");
        jButton5.setMaximumSize(new java.awt.Dimension(114, 22));
        jButton5.setMinimumSize(new java.awt.Dimension(114, 22));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton5KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged

    }//GEN-LAST:event_formWindowStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(hours == 1){
        jLabel1.setText("LIVE DE " + hours + " HORA");}else{
           jLabel1.setText("LIVE DE " + hours + " HORAS"); 
        }
    }//GEN-LAST:event_formWindowOpened

    
    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited

    }//GEN-LAST:event_formMouseExited

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //String imagePath = "Icon.png";
       utils = new Utils();
       utils.credits();
    }//GEN-LAST:event_formWindowClosing

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
       
    }//GEN-LAST:event_formKeyTyped

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed

    private void jPanel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyTyped

    private void jPanel1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanel1PropertyChange

    }//GEN-LAST:event_jPanel1PropertyChange

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        float currentHeight = getHeight();
        float heightDiff = currentHeight - prevHeight;
        float sizeChange = heightDiff / 20;

        if (sizeChange != 0) {
            prevFontSize = prevFontSize + sizeChange;
            prevHeight = currentHeight;
            jLabel4.setFont(font.deriveFont(Font.BOLD, prevFontSize));
            jLabel5.setFont(font.deriveFont(Font.BOLD, prevFontSize - 15f));
            jLabel1.setFont(font.deriveFont(Font.BOLD, prevFontSize - 15f));
        }
        //baseFontSize = this.getHeight() - 360;

    }//GEN-LAST:event_jPanel1ComponentResized

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        jButton3.setVisible(false);
        jButton5.setVisible(false);
        jButton4.setVisible(false);
    }//GEN-LAST:event_jPanel1MouseExited

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        jButton3.setVisible(true);
        jButton5.setVisible(true);
        
        if(hours == 0){
            jButton1.setEnabled(false);
        }
        
        jButton4.setVisible( !timer.isTimerEnded);
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jButton5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyTyped

    }//GEN-LAST:event_jButton5KeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //this.dispose();

        
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            
//            
//            
//            
//            public void run() {
//               try {
//            new Window_Stopwatch().setVisible(false);
//            if(undecorated) {
//                undecorated = false;}
//            else {
//                undecorated = true;
//            }
//            setUndecorated(undecorated);
//            setVisible(true);
//            setResizable(true);
//
//        } catch (FontFormatException ex) {
//            Logger.getLogger(Window_Stopwatch.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Window_Stopwatch.class.getName()).log(Level.SEVERE, null, ex);
//        } } });
        
      boolean undecorated = isUndecorated();
        dispose(); // fecha a janela para aplicar as mudanças
        setUndecorated(!undecorated);
        pack(); // revalida o layout do frame
        setVisible(true); // exibe o frame novamente

        if(this.isUndecorated()) {
            jButton5.setForeground(Color.green);}
        else {
            jButton5.setForeground(new Color(255,0,51));
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered

        jButton3.setVisible(true);
        jButton4.setVisible(!timer.isTimerEnded);
        jButton5.setVisible(true); 
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(alwaysOnTop){
            alwaysOnTop = false;
            jButton3.setForeground(new Color(255,0,51));
        } else {
            alwaysOnTop = true;
            jButton3.setForeground(Color.green);
        }

        this.setAlwaysOnTop(alwaysOnTop);
        // this.setUndecorated(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setVisible(true);
        jButton4.setVisible(!timer.isTimerEnded);
        jButton5.setVisible(true);
    }//GEN-LAST:event_jButton3MouseEntered


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      if(hours <= 0) {
        JOptionPane.showMessageDialog(null, "Para começar o cronômetro é necessário que tenha ao menos uma hora adicionada.", "Atenção!", JOptionPane.WARNING_MESSAGE);}else{
        
            if(start == false){
            start = true;
            timer.isStarted = start;
            jButton1.setEnabled(false);
            jButton1.setVisible(false);
            jButton2.setEnabled(false);
            jButton2.setVisible(false);
            timer.horas = hours;
            timer.maxTime = hours;
            timer.save();
        }
            
            
        if(isPaused){
            jButton4.setForeground(Color.green);
            jButton4.setText("Começar");
            isPaused = false;
            timer.pause();
            
        } else {
            jButton4.setForeground(new Color(255, 0, 51));
            jButton4.setText("Pausar");
            isPaused = true;
            timer.resume();
        } }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        jButton3.setVisible(true);
        jButton4.setVisible(!timer.isTimerEnded);
        jButton5.setVisible(true);
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(start == false){
            hours++;
            if(hours == 1){
            jLabel1.setText("LIVE DE " + hours + " HORA");}else{
                jLabel1.setText("LIVE DE " + hours + " HORAS");
            }
            jButton1.setEnabled(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        jButton3.setVisible(true);
        jButton4.setVisible(!timer.isTimerEnded);
        jButton5.setVisible(true);
    }//GEN-LAST:event_jButton2MouseEntered
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(hours != 0 && start == false){
            hours--;
            if(hours == 1){
            jLabel1.setText("LIVE DE " + hours + " HORA");}else{
                jLabel1.setText("LIVE DE " + hours + " HORAS");
            }
        }
        
        if(hours == 0){
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton3.setVisible(true);
        jButton4.setVisible(!timer.isTimerEnded);
        jButton5.setVisible(true);
        
        if(hours == 0){
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jButton1MouseEntered

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus

    }//GEN-LAST:event_formWindowLostFocus

    float prevHeight = getHeight();
    float prevFontSize = baseFontSize;
    /**
     * @param args the command line arguments
     */
    public static void start() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Window_Timer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window_Timer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window_Timer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window_Timer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Window_Timer().setVisible(true);
                } catch (FontFormatException ex) {
                    Logger.getLogger(Window_Timer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Window_Timer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton4;
    public static javax.swing.JButton jButton5;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    
}
