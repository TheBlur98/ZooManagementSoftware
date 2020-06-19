/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progex.zoomanagementsoftware.guest;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.GuestModeManager;
import com.progex.zoomanagementsoftware.ManagersAndHandlers.ZooManager;
import com.progex.zoomanagementsoftware.datatypes.FeedingInfo;
import com.progex.zoomanagementsoftware.datatypes.Methods;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JFrame;


/**
 *
 * @author Oli
 */
public class ChooseBoth extends javax.swing.JFrame {

    /**
     * Creates new form AuswahlJFrame
     */
    public ChooseBoth(JFrame goBackFrame, ZooManager zooManager, String animal, String time) {

        this.goBackFrame = goBackFrame;
        this.zooManager = zooManager;
        this.guestModeManager = zooManager.getGuestModeManager();
        this.animal = animal;
        this.time = time;

        initComponents();
        myInitComponents();

    }

    private void myInitComponents() {
        setUndecorated(true);
        setAlwaysOnTop(true);
        setResizable(false);
        setVisible(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int x = (int) tk.getScreenSize().getWidth();
        int y = (int) tk.getScreenSize().getHeight();
        setSize(x, y);
        //abfrage welche auflösung dann grösse der komponenten anpassen (text grösse etc)
        if (x == 1920 && y == 1080) {
            jLabelAnimal.setFont(new java.awt.Font("Calibri", 0, 48));
            jLabelCompound.setFont(new java.awt.Font("Calibri", 0, 48));
            jLabelCompoundStatic.setFont(new java.awt.Font("Calibri", 0, 48));
            jLabelFeed.setFont(new java.awt.Font("Calibri", 0, 48));
            jLabelFeedStatic.setFont(new java.awt.Font("Calibri", 0, 48));
            jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 28));
            jLabelTime.setFont(new java.awt.Font("Calibri", 0, 48));

        }
        if (x == 1280 && y == 720) {

            jLabelAnimal.setFont(new java.awt.Font("Calibri", 0, 28));
            jLabelCompound.setFont(new java.awt.Font("Calibri", 0, 28));
            jLabelCompoundStatic.setFont(new java.awt.Font("Calibri", 0, 28));
            jLabelFeed.setFont(new java.awt.Font("Calibri", 0, 28));
            jLabelFeedStatic.setFont(new java.awt.Font("Calibri", 0, 28));
            jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 28));
            jLabelTime.setFont(new java.awt.Font("Calibri", 0, 28));

        }

        Methods methods = new Methods();
        methods.showTimeAndDate(jLabelShowDateTime);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Labels get values
        jLabelAnimal.setText(animal + ": ");
        jLabelTime.setText(time + " Uhr");

        //
        viewAnimalTime();

    }

    /*Load all relevant Data in Label: compound and food*/
    private void viewAnimalTime() {

        String tmp = time.concat(":00");
        SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");
        String str = dateformat.format(new Date());
        String day = str.substring(0, 2);
        String month = str.substring(3, 5);
        String year = str.substring(6, 10);
        String last = (year + "-" + month + "-" + day + " ").concat(tmp);

        LinkedList<FeedingInfo> feedingInfos = guestModeManager.getAnimalTimeFeedingInfo(last, animal);
        if (!feedingInfos.isEmpty()) {

            //String com = null;
            //String food = null;
            String com = feedingInfos.getFirst().getCompundName();
            LinkedList<String> foods = new LinkedList<String>();

            for (FeedingInfo feedingInfo : feedingInfos) {
                //Hier bekommt man die Spalten der Zeile

                foods.add(feedingInfo.getFoodName());

            }

            jLabelCompound.setText(com);

            String foodNames = foods.toString();
            jLabelFeed.setText(foodNames);

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

        jButtonBack = new javax.swing.JButton();
        jLabelShowDateTime = new javax.swing.JLabel();
        jLabelAnimal = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jLabelCompoundStatic = new javax.swing.JLabel();
        jLabelCompound = new javax.swing.JLabel();
        jLabelFeedStatic = new javax.swing.JLabel();
        jLabelFeed = new javax.swing.JLabel();
        labelKarte = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonBack.setText("Zurück");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelShowDateTime.setText("TIME");

        jLabelAnimal.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelAnimal.setText("Tiername :");

        jLabelTime.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelTime.setText("Zeit XX:XX -XX:XX");

        jLabelCompoundStatic.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelCompoundStatic.setText("Gehege:");

        jLabelCompound.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelCompound.setText("xxx Gehege");

        jLabelFeedStatic.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelFeedStatic.setText("Futter:");

        jLabelFeed.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelFeed.setText("xxx Futter");

        labelKarte.setAlignment(java.awt.Label.CENTER);
        labelKarte.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        labelKarte.setText("Karte");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelKarte, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(573, 573, 573))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1424, 1424, 1424)
                        .addComponent(jLabelShowDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(269, 269, 269))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelAnimal)
                    .addComponent(jLabelCompoundStatic, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFeedStatic, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTime)
                    .addComponent(jLabelCompound)
                    .addComponent(jLabelFeed))
                .addGap(658, 658, 658))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelShowDateTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(34, 34, 34))
                    .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAnimal)
                    .addComponent(jLabelTime))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCompoundStatic)
                    .addComponent(jLabelCompound))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFeedStatic)
                    .addComponent(jLabelFeed))
                .addGap(62, 62, 62)
                .addComponent(labelKarte, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        labelKarte.getAccessibleContext().setAccessibleName("");
        labelKarte.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed

        // TODO add your handling code here:
        goBackFrame.setVisible(true);
        //Close frame
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ChooseBoth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseBoth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseBoth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseBoth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        String url = "jdbc:mysql://localhost/";
        String username = "root";
        String password = "0000";
        String dbName = "zoo";

        ZooManager zooManager = new ZooManager(url, dbName, username, password);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseBoth(null, zooManager, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JLabel jLabelAnimal;
    private javax.swing.JLabel jLabelCompound;
    private javax.swing.JLabel jLabelCompoundStatic;
    private javax.swing.JLabel jLabelFeed;
    private javax.swing.JLabel jLabelFeedStatic;
    private javax.swing.JLabel jLabelShowDateTime;
    private javax.swing.JLabel jLabelTime;
    private java.awt.Label labelKarte;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JFrame goBackFrame;
    private ZooManager zooManager;
    private GuestModeManager guestModeManager;
    private String time;
    private String animal;
}
