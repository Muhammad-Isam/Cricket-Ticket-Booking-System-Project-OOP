package GUI;

import javax.swing.JLabel;
import ticketbookingsystem.Groups;
import ticketbookingsystem.Teams;
import ticketbookingsystem.Tournament;

public class TournamentGUI extends javax.swing.JFrame {

    private Tournament t;
    private Teams teamGA, teamGB;
    private Groups gA;
    private Groups gB;

    public TournamentGUI() {
        gA = new Groups();
        gB = new Groups();
        t = new Tournament();
        teamGA = gA.getGroupATeams();
        teamGB = gB.getGroupBTeams();
        initComponents();
        setT(t.getTournamentData());
        setGroupTeams();
    }

    public void setGroupTeams() {
        lblgat1.setText(teamGA.getTeam(0));
        lblgat2.setText(teamGA.getTeam(1));
        lblgat3.setText(teamGA.getTeam(2));
        lblgbt1.setText(teamGB.getTeam(0));
        lblgbt2.setText(teamGB.getTeam(1));
        lblgbt3.setText(teamGB.getTeam(2));
    }

    public Tournament getT() {
        return t;
    }

    public void setT(String T) {
        lbltname.setText(T);
    }

    public JLabel getLblgat1() {
        return lblgat1;
    }

    public void setLblgat1(JLabel lblgat1) {
        this.lblgat1 = lblgat1;
    }

    public JLabel getLblgat2() {
        return lblgat2;
    }

    public void setLblgat2(JLabel lblgat2) {
        this.lblgat2 = lblgat2;
    }

    public JLabel getLblgat3() {
        return lblgat3;
    }

    public void setLblgat3(JLabel lblgat3) {
        this.lblgat3 = lblgat3;
    }

    public JLabel getLblgbt1() {
        return lblgbt1;
    }

    public void setLblgbt1(JLabel lblgbt1) {
        this.lblgbt1 = lblgbt1;
    }

    public JLabel getLblgbt2() {
        return lblgbt2;
    }

    public void setLblgbt2(JLabel lblgbt2) {
        this.lblgbt2 = lblgbt2;
    }

    public JLabel getLblgbt3() {
        return lblgbt3;
    }

    public void setLblgbt3(JLabel lblgbt3) {
        this.lblgbt3 = lblgbt3;
    }

    public JLabel getLblgroupA() {
        return lblgroupA;
    }

    public void setLblgroupA(JLabel lblgroupA) {
        this.lblgroupA = lblgroupA;
    }

    public JLabel getLblgroupB() {
        return lblgroupB;
    }

    public void setLblgroupB(JLabel lblgroupB) {
        this.lblgroupB = lblgroupB;
    }

    public JLabel getLbltname() {
        return lbltname;
    }

    public void setLbltname(JLabel lbltname) {
        this.lbltname = lbltname;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbltname = new javax.swing.JLabel();
        lblmatches = new javax.swing.JLabel();
        lblgroupB = new javax.swing.JLabel();
        lblgroupA = new javax.swing.JLabel();
        lblgat1 = new javax.swing.JLabel();
        lblgat2 = new javax.swing.JLabel();
        lblgbt1 = new javax.swing.JLabel();
        lblgbt2 = new javax.swing.JLabel();
        lblgat3 = new javax.swing.JLabel();
        lblgbt3 = new javax.swing.JLabel();
        btnvs = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 100));

        jPanel1.setBackground(new java.awt.Color(204, 255, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(916, 500));

        lbltname.setBackground(new java.awt.Color(0, 204, 255));
        lbltname.setFont(new java.awt.Font("Constantia", 1, 24)); // NOI18N
        lbltname.setText("T20 WORLDCUP 2022");

        lblmatches.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        lblmatches.setText("GROUPS");

        lblgroupB.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lblgroupB.setText("GROUP B");

        lblgroupA.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lblgroupA.setText("GROUP A");

        lblgat1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lblgat1.setText("Pakistan");

        lblgat2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lblgat2.setText("England");

        lblgbt1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lblgbt1.setText("Australia");

        lblgbt2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lblgbt2.setText("New Zealand");

        lblgat3.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lblgat3.setText("India");

        lblgbt3.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lblgbt3.setText("South Africa");

        btnvs.setBackground(new java.awt.Color(51, 102, 255));
        btnvs.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        btnvs.setForeground(new java.awt.Color(255, 255, 255));
        btnvs.setText("VIEW SCHEDULE");
        btnvs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvsActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back paint.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 102, 255));
        jButton2.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("View Points Table");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblgat1)
                    .addComponent(lblgroupA)
                    .addComponent(lblgat2)
                    .addComponent(lblgat3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblgroupB, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblgbt1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblgbt2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblgbt3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(215, 215, 215))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(352, 352, 352)
                        .addComponent(lbltname))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(491, 491, 491)
                        .addComponent(lblmatches))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(448, 448, 448)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnvs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(422, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(lbltname))
                .addGap(40, 40, 40)
                .addComponent(lblmatches)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblgroupB)
                    .addComponent(lblgroupA))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblgat1)
                    .addComponent(lblgbt1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblgat2)
                    .addComponent(lblgbt2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblgbt3)
                    .addComponent(lblgat3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnvs, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PCB-Logo-Small.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvsActionPerformed
        setVisible(false);
        TournamentScheduleStage1 tssj = new TournamentScheduleStage1();
        tssj.setVisible(true);
    }//GEN-LAST:event_btnvsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Home h = new Home();
        h.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PointsTableGUI pt=new PointsTableGUI();
        pt.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TournamentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TournamentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TournamentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TournamentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TournamentGUI().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnvs;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblgat1;
    private javax.swing.JLabel lblgat2;
    private javax.swing.JLabel lblgat3;
    private javax.swing.JLabel lblgbt1;
    private javax.swing.JLabel lblgbt2;
    private javax.swing.JLabel lblgbt3;
    private javax.swing.JLabel lblgroupA;
    private javax.swing.JLabel lblgroupB;
    private javax.swing.JLabel lblmatches;
    private javax.swing.JLabel lbltname;
    // End of variables declaration//GEN-END:variables
}
