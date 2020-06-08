/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progex.zoomanagementsoftware.guest;

import com.progex.zoomanagementsoftware.datatypes.Methods;
import com.progex.zoomanagementsoftware.main.MainMenuJFrame;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Oli
 */
public class ChooseAnimalAndTimeJFrame extends javax.swing.JFrame {

    /**
     * Creates new form AuswahlTierZeitJFrame
     */
    public ChooseAnimalAndTimeJFrame(JFrame goBackFrame) {

        initComponents();
        myInitComponents();
        this.goBackFrame = goBackFrame;

    }

    public ChooseAnimalAndTimeJFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void myInitComponents() {

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

            jComboBoxName.setFont(new java.awt.Font("Calibri", 0, 32));
            jComboTime.setFont(new java.awt.Font("Calibri", 0, 32));
            jLabelChoose.setFont(new java.awt.Font("Calibri", 1, 32));
            jLabelFindOut.setFont(new java.awt.Font("Calibri", 1, 48));
            jLabelName.setFont(new java.awt.Font("Calibri", 0, 32));
            jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 28));
            jLabelTime.setFont(new java.awt.Font("Calibri", 0, 32));

        }
        if (x == 1280 && y == 720) {

            jComboBoxName.setFont(new java.awt.Font("Calibri", 0, 28));
            jComboTime.setFont(new java.awt.Font("Calibri", 0, 28));
            jLabelChoose.setFont(new java.awt.Font("Calibri", 1, 28));
            jLabelFindOut.setFont(new java.awt.Font("Calibri", 1, 42));
            jLabelName.setFont(new java.awt.Font("Calibri", 0, 28));
            jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 22));
            jLabelTime.setFont(new java.awt.Font("Calibri", 0, 28));

        }

        //Combobox test
        jComboBoxName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{null, "Affe", "Tiger"}));
        jComboTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{null, "15:00-15:15", "15:15-15:30"}));

        Methods methods = new Methods();
        methods.showTimeAndDate(jLabelShowDateTime);

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
        jLabelFindOut = new javax.swing.JLabel();
        jLabelChoose = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jComboBoxName = new javax.swing.JComboBox<>();
        jComboTime = new javax.swing.JComboBox<>();
        jButtonSearch = new javax.swing.JButton();
        jLabelShowDateTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonBack.setText("Zurück");
        jButtonBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBackMouseClicked(evt);
            }
        });
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jLabelFindOut.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabelFindOut.setText("Finde heraus wann welches Tier gefüttert wird");

        jLabelChoose.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabelChoose.setText("Bitte treffe mindestens eine Auswahl");

        jLabelName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabelName.setText("Tiername:");

        jLabelTime.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabelTime.setText("Fütterungszeit:");

        jComboBoxName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNameActionPerformed(evt);
            }
        });

        jComboTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonSearch.setText("Suchen");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelShowDateTime.setText("TIME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelShowDateTime)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 475, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelFindOut)
                                .addGap(502, 502, 502))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelChoose, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                    .addComponent(jButtonSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelTime)
                                            .addComponent(jLabelName))
                                        .addGap(54, 54, 54)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboTime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(764, 764, 764))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelShowDateTime)
                    .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97)
                .addComponent(jLabelFindOut)
                .addGap(106, 106, 106)
                .addComponent(jLabelChoose)
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jComboBoxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTime)
                    .addComponent(jComboTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(458, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed

        //Fall1
        //Fall2
        //new ChooseTimeJFrame().toFront();
        //new ChooseTimeJFrame().setState(java.awt.Frame.NORMAL);
        //Beides
        this.setVisible(false);

        JFrame thisFrame = this;
        /* Create and display the form with the Zoo Map */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                //Fallunterscheidung
                if (jComboBoxName.getSelectedItem()!= null && jComboTime.getSelectedItem() == null) {

                    new ChooseAnimalJFrame(thisFrame).setVisible(true);
                }

                if (jComboBoxName.getSelectedItem() == null && jComboTime.getSelectedItem() != null) {
                    new ChooseTimeJFrame(thisFrame).setVisible(true);
                }
                if (jComboBoxName.getSelectedItem() != null && jComboTime.getSelectedItem() != null) {

                    new ChooseBoth(thisFrame).setVisible(true);
                }
            }
        });

        //wenn keine Eingabe
        //JOptionPane.showMessageDialog(null, "Sie haben keine Fütterungszeit und kein Tier ausgewählt\n\nBitte treffen sie mindestens eine Auswahl","Fehlermeldung", JOptionPane.CANCEL_OPTION);
        //wenn Tier keine Fütterungen mehr hat
        //JOptionPane.showMessageDialog(null, "Keine Fütterungen für 'Tier' heute!\n\nVielleicht haben sie an einem anderen Tag mehr Glück :)","Schade", JOptionPane.CANCEL_OPTION);
        //wenn Uhrzeit keine Fütterungen hat 
        // JOptionPane.showMessageDialog(null, "Es finden keine Fütterungen um diese Uhrzeit heute statt \n\nVielleicht haben sie an einem anderen Tag mehr Glück :)","Schade", JOptionPane.CANCEL_OPTION); 
        //wenn Tier und Uhrzeit false
        // JOptionPane.showMessageDialog(null, "Es finden keine Fütterungen für 'Tier' um  'Uhrzeit' heute statt!\n\nSuchen Sie nur nach dem Tier, um Verfügbare Uhrzeiten angezeigt zu bekommen","Schade", JOptionPane.CANCEL_OPTION);
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBackMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBackMouseClicked

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:

        goBackFrame.setVisible(true);
        //Close frame
        this.dispose();


    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jComboBoxNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNameActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jComboBoxNameActionPerformed

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
            java.util.logging.Logger.getLogger(ChooseAnimalAndTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseAnimalAndTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseAnimalAndTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseAnimalAndTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseAnimalAndTimeJFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox<String> jComboBoxName;
    private javax.swing.JComboBox<String> jComboTime;
    private javax.swing.JLabel jLabelChoose;
    private javax.swing.JLabel jLabelFindOut;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelShowDateTime;
    private javax.swing.JLabel jLabelTime;
    // End of variables declaration//GEN-END:variables

    private javax.swing.JFrame goBackFrame;

}
