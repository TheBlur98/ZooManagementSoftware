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
import java.awt.Font;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * 
 * @author Oli
 * TODOO grösse in tabel ändern //abwarten mit datensätzen
 * 
 * 
 */
public class ChooseTimeJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ZeitjFrame
     */
    public ChooseTimeJFrame(JFrame goBackFrame,ZooManager zooManager, String time) {
       
        this.goBackFrame = goBackFrame; 
        this.zooManager = zooManager;
        this.guestModeManager = zooManager.getGuestModeManager();
        this.time = time;
        
        
        initComponents();
        myInitComponents();
        viewTimes();
    }
    
    public void myInitComponents(){
        
        setUndecorated(true);
        setAlwaysOnTop(true);
        setResizable(false);
        setVisible(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int x =(int)tk.getScreenSize().getWidth();
        int y =(int)tk.getScreenSize().getHeight();
        setSize(x,y);
        //abfrage welche auflösung dann grösse der komponenten anpassen (text grösse etc)
        if(x == 1920 && y == 1080){
            jLabelTime.setFont(new java.awt.Font("Calibri", 1, 60));
            jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 28));
        }
        if(x == 1280 && y == 720){
            jLabelTime.setFont(new java.awt.Font("Calibri", 1, 48));
            jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 22));
        }
        
        
        JTableHeader tableHeader = jTableTimeData.getTableHeader();
        Font headerFont = new Font("Calibri", 0, 22);
        tableHeader.setFont(headerFont);
        
        jLabelTime.setText(time);
        jTableTimeData.setRowHeight(40);
        
        
        Methods methods = new Methods();    
        methods.showTimeAndDate(jLabelShowDateTime);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    }
    
    public void viewTimes(){
    
        //Time String in Date
        String tmp = time.concat(":00");
        SimpleDateFormat dateformat =new SimpleDateFormat("dd.MM.yyyy");
        String str = dateformat.format(new Date());
        String day = str.substring(0, 2);
        String month = str.substring(3, 5);
        String year = str.substring(6, 10);
        String last = (year+"-"+month+"-"+day +" ").concat(tmp);
                   
        /*try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(last);
            System.out.println(date);
            //new ChooseTimeJFrame(thisFrame,zooManager,).setVisible(true);
            } catch (ParseException ex) {
            Logger.getLogger(ChooseAnimalAndTimeJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        */
        LinkedList<FeedingInfo> feedingInfos = guestModeManager.getTimeFeedingInfo(last);
        
        DefaultTableModel model = (DefaultTableModel)jTableTimeData.getModel();
        
        Object[] row = new Object[3]; 
        
        
        for (FeedingInfo feedingInfo : feedingInfos){
           //Hier bekommt man die Spalten der Zeile
           row[0] = feedingInfo.getAnimalName();
            System.out.println(row[0]);
           row[1] = feedingInfo.getCompundName();
           System.out.println(row[1]);
           row[2] = feedingInfo.getFoodName();
           System.out.println(row[2]);
           model.addRow(row);
         
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

        jScrollPaneAnimalTable = new javax.swing.JScrollPane();
        jTableTimeData = new javax.swing.JTable();
        jLabelTime = new javax.swing.JLabel();
        jLabelShowDateTime = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPaneAnimalTable.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableTimeData.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jTableTimeData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tiername", "Gehegename", "Futter"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTimeData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableTimeData.getTableHeader().setReorderingAllowed(false);
        jScrollPaneAnimalTable.setViewportView(jTableTimeData);

        jLabelTime.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabelTime.setText("Uhr");

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelShowDateTime.setText("TIME");

        jButtonBack.setText("Zurück");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1686, Short.MAX_VALUE)
                        .addComponent(jLabelShowDateTime)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPaneAnimalTable, javax.swing.GroupLayout.PREFERRED_SIZE, 1092, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(411, 411, 411))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTime)
                .addGap(922, 922, 922))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowDateTime))
                .addGap(74, 74, 74)
                .addComponent(jLabelTime)
                .addGap(116, 116, 116)
                .addComponent(jScrollPaneAnimalTable, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
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
            java.util.logging.Logger.getLogger(ChooseTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseTimeJFrame(null,zooManager).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JLabel jLabelShowDateTime;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JScrollPane jScrollPaneAnimalTable;
    private javax.swing.JTable jTableTimeData;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JFrame goBackFrame;
    private ZooManager zooManager;
    private GuestModeManager guestModeManager;
    private String time;
    private Date date;
    
}
