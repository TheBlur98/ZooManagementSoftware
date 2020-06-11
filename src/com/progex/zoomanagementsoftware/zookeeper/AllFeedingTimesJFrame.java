/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progex.zoomanagementsoftware.zookeeper;

import com.progex.zoomanagementsoftware.datatypes.Methods;
import com.progex.zoomanagementsoftware.main.MainMenuJFrame;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author khali
 */
public class AllFeedingTimesJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NächsteFütterungJFrame
     */
    public AllFeedingTimesJFrame(JFrame goBack, JFrame goBack2, JFrame goBack3) {
        initComponents();
        myInitComponents();
        mainMenuJFrame = goBack;
        zookeeperModeHomePageFrame = goBack2;
        nextFeedingTimeFrame = goBack3;
        Methods methods = new Methods();
        methods.showTimeAndDate(jLabelTime);
    }
        private void myInitComponents(){
        
        //Done in netbeans window
        //this.setUndecorated(true);
        //this.setAlwaysOnTop(true);
        //this.setResizable(false);
       // this.setVisible(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int x =(int)tk.getScreenSize().getWidth();
        int y =(int)tk.getScreenSize().getHeight();
        setSize(x,y);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //abfrage welche auflösung dann grösse der komponenten anpassen (text grösse etc)
        if(x == 1920 && y == 1080){
            
            
            jLabelTime.setFont(new java.awt.Font("Calibri", 0, 32));

            
        }
        if(x == 1280 && y == 720){
            
            
            jLabelTime.setFont(new java.awt.Font("Calibri", 0, 28));

            
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

        buttonGroupConvertAmountOfFood = new javax.swing.ButtonGroup();
        jButtonLogout = new javax.swing.JButton();
        jButtonNextFeedingTime = new javax.swing.JButton();
        jScrollPaneTable = new javax.swing.JScrollPane();
        jTableAlleFütterungen = new javax.swing.JTable();
        jLabelTime = new javax.swing.JLabel();
        jButtonGoBack = new javax.swing.JButton();
        jRadioButtonAmountOfFoodInKiloGramm = new javax.swing.JRadioButton();
        jRadioButtonAmountOfFoodInGramm = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alle Fütterungen");
        setUndecorated(true);
        setResizable(false);

        jButtonLogout.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jButtonLogout.setText("Logout");
        jButtonLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLogoutMouseClicked(evt);
            }
        });
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jButtonNextFeedingTime.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButtonNextFeedingTime.setText("Nächste Fütterung anzeigen");
        jButtonNextFeedingTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNextFeedingTimeMouseClicked(evt);
            }
        });
        jButtonNextFeedingTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextFeedingTimeActionPerformed(evt);
            }
        });

        jScrollPaneTable.setToolTipText("");
        jScrollPaneTable.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableAlleFütterungen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fütterungszeit", "Tiername", "Futter", "Futtermenge", "Abstellraum", "Gehege"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneTable.setViewportView(jTableAlleFütterungen);

        jLabelTime.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabelTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTime.setText("X");
        jLabelTime.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelTime.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabelTimeAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jButtonGoBack.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jButtonGoBack.setText("Zurück");
        jButtonGoBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGoBackMouseClicked(evt);
            }
        });
        jButtonGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoBackActionPerformed(evt);
            }
        });

        buttonGroupConvertAmountOfFood.add(jRadioButtonAmountOfFoodInKiloGramm);
        jRadioButtonAmountOfFoodInKiloGramm.setSelected(true);
        jRadioButtonAmountOfFoodInKiloGramm.setText("Futtermenge in Kilogramm");
        jRadioButtonAmountOfFoodInKiloGramm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAmountOfFoodInKiloGrammActionPerformed(evt);
            }
        });

        buttonGroupConvertAmountOfFood.add(jRadioButtonAmountOfFoodInGramm);
        jRadioButtonAmountOfFoodInGramm.setText("Futtermenge in Gramm");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Meine Fütterungszeiten");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneTable)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonAmountOfFoodInKiloGramm, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonAmountOfFoodInGramm, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonGoBack)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLogout))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 56, Short.MAX_VALUE)
                        .addComponent(jButtonNextFeedingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 56, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLogout)
                    .addComponent(jLabelTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGoBack))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jScrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonAmountOfFoodInKiloGramm)
                    .addComponent(jRadioButtonAmountOfFoodInGramm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonNextFeedingTime)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelTimeAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabelTimeAncestorAdded
        // TODO add your handlig code here:
    }//GEN-LAST:event_jLabelTimeAncestorAdded

    private void jButtonGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoBackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        zookeeperModeHomePageFrame.setVisible(true);
    }//GEN-LAST:event_jButtonGoBackActionPerformed

    private void jButtonGoBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGoBackMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGoBackMouseClicked

    private void jButtonNextFeedingTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNextFeedingTimeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNextFeedingTimeMouseClicked

    private void jRadioButtonAmountOfFoodInKiloGrammActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAmountOfFoodInKiloGrammActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonAmountOfFoodInKiloGrammActionPerformed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        mainMenuJFrame.setVisible(true);
       
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jButtonLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLogoutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLogoutMouseClicked

    private void jButtonNextFeedingTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextFeedingTimeActionPerformed
        // TODO add your handling code here:
        
        if(nextFeedingTimeFrame != null){
            nextFeedingTimeFrame.setVisible(true);
            this.setVisible(false);
        }
        else{
            
            JFrame thisFrame = this;
            
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new NextFeedingTimeJFrame(mainMenuJFrame,zookeeperModeHomePageFrame,thisFrame,null).setVisible(true);
                }
            });                
            this.setVisible(false);
        }
      
        
        
        
        
    }//GEN-LAST:event_jButtonNextFeedingTimeActionPerformed

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
            java.util.logging.Logger.getLogger(AllFeedingTimesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllFeedingTimesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllFeedingTimesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllFeedingTimesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllFeedingTimesJFrame(null,null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupConvertAmountOfFood;
    private javax.swing.JButton jButtonGoBack;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonNextFeedingTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JRadioButton jRadioButtonAmountOfFoodInGramm;
    private javax.swing.JRadioButton jRadioButtonAmountOfFoodInKiloGramm;
    private javax.swing.JScrollPane jScrollPaneTable;
    private javax.swing.JTable jTableAlleFütterungen;
    // End of variables declaration//GEN-END:variables

   private javax.swing.JFrame mainMenuJFrame;
   private javax.swing.JFrame zookeeperModeHomePageFrame;
   private javax.swing.JFrame nextFeedingTimeFrame;

}
