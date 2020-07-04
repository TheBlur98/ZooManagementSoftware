package com.progex.zoomanagementsoftware.zookeeper;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.UserManager;
import com.progex.zoomanagementsoftware.ManagersAndHandlers.ZooManager;
import com.progex.zoomanagementsoftware.datatypes.Methods;
import java.awt.Toolkit;
import javax.swing.JFrame;
import net.proteanit.sql.DbUtils;

public class AllFeedingTimesJFrame extends javax.swing.JFrame {

    /**
     * Creates new form AllFeedingTimesJFrame.
     *
     * @param mainMenuJFrame
     * @param zookeeperModeHomePageFrame
     * @param nextFeedingTimeFrame
     * @param zooManager The zooManager of the current programm session which
     * serves as interface
     */
    public AllFeedingTimesJFrame(JFrame mainMenuJFrame, JFrame zookeeperModeHomePageFrame, JFrame nextFeedingTimeFrame, ZooManager zooManager) {

        initComponents();
        myInitComponents();

        // init parameters and references
        this.mainMenuJFrame = mainMenuJFrame;
        this.zookeeperModeHomePageFrame = zookeeperModeHomePageFrame;
        this.nextFeedingTimeFrame = nextFeedingTimeFrame;
        this.zooManager = zooManager;
        this.userManager = zooManager.getUserManager();

        // Display Date
        Methods methods = new Methods();
        methods.showTimeAndDate(jLabelTime);

        // populate the table with default amount in Kilogram
        populateTableInKG();
        jTableAlleFütterungen.setDefaultEditor(Object.class, null);
    }

    private void myInitComponents() {

        Toolkit tk = Toolkit.getDefaultToolkit();
        int x = (int) tk.getScreenSize().getWidth();
        int y = (int) tk.getScreenSize().getHeight();
        setSize(x, y);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        if (x == 1920 && y == 1080) {

            jLabelTime.setFont(new java.awt.Font("Calibri", 0, 18));
        }
        if (x == 1280 && y == 720) {

            jLabelTime.setFont(new java.awt.Font("Calibri", 0, 16));
        }
    }

    private void populateTableInKG() {

        jTableAlleFütterungen.setModel(DbUtils.resultSetToTableModel(userManager.getAllFeedingTimeInKG()));
    }

    private void populateTableInGramm() {

        jTableAlleFütterungen.setModel(DbUtils.resultSetToTableModel(userManager.getAllFeedingTimeInGramm()));
    }

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
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jButtonNextFeedingTime.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButtonNextFeedingTime.setText("Nächste Fütterung anzeigen");
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
        jTableAlleFütterungen.setEditingColumn(0);
        jTableAlleFütterungen.setEditingRow(0);
        jScrollPaneTable.setViewportView(jTableAlleFütterungen);

        jLabelTime.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabelTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
        jButtonGoBack.setText("Zurück zum Hauptmenü");
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
        jRadioButtonAmountOfFoodInGramm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAmountOfFoodInGrammActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alle Fütterungen für heute");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneTable, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jRadioButtonAmountOfFoodInKiloGramm, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonAmountOfFoodInGramm, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButtonGoBack)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLogout))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 56, Short.MAX_VALUE)
                        .addComponent(jButtonNextFeedingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 56, Short.MAX_VALUE)))
                .addContainerGap())
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
    }//GEN-LAST:event_jLabelTimeAncestorAdded

    private void jButtonGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoBackActionPerformed

        zookeeperModeHomePageFrame.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButtonGoBackActionPerformed

    private void jRadioButtonAmountOfFoodInKiloGrammActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAmountOfFoodInKiloGrammActionPerformed
        populateTableInKG();

    }//GEN-LAST:event_jRadioButtonAmountOfFoodInKiloGrammActionPerformed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        userManager.logout();
        this.dispose();
        mainMenuJFrame.setVisible(true);
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jButtonNextFeedingTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextFeedingTimeActionPerformed

        if (nextFeedingTimeFrame != null) {
            nextFeedingTimeFrame.setVisible(true);
            this.setVisible(false);
        } else {

            JFrame thisFrame = this;

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new NextFeedingTimeJFrame(mainMenuJFrame, zookeeperModeHomePageFrame, thisFrame, zooManager).setVisible(true);
                }
            });
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButtonNextFeedingTimeActionPerformed

    private void jRadioButtonAmountOfFoodInGrammActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAmountOfFoodInGrammActionPerformed
        populateTableInGramm();
    }//GEN-LAST:event_jRadioButtonAmountOfFoodInGrammActionPerformed

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
    private ZooManager zooManager;
    private UserManager userManager;
}
