/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import ticketbookingsystem.Ground;
import ticketbookingsystem.MatchDetails;
import ticketbookingsystem.User;

public class UserJframe extends javax.swing.JFrame {

    private MatchDetails md = new MatchDetails();
    private int matchNo;
    private TournamentScheduleStage1 tgui;
    private Series sgui;
    private Knockout sf;
    private Ground g;
    private User u;

    public UserJframe(int matchNo, Ground g, String matchGenre, String matchType, String teamA, String teamB, String date, String time, TournamentScheduleStage1 tgui) {
        this.matchNo = matchNo;
        md.setGenre(matchGenre);
        md.setType(matchType);
        this.tgui = tgui;
        md.setTeamA(teamA);
        md.setTeamB(teamB);
        md.setDate(date);
        md.setTime(time);
        this.g = g;
        initComponents();
        jtamatchdetail.setText(tgui.getMjt(matchNo));
        setIcon();

    }

    public UserJframe(int matchNo, Ground g, String matchGenre, String matchType, String teamA, String teamB, String date, String time, Series sgui) {
        this.matchNo = matchNo;
        md.setGenre(matchGenre);
        md.setType(matchType);
        this.sgui = sgui;
        md.setTeamA(teamA);
        md.setTeamB(teamB);
        md.setDate(date);
        md.setTime(time);
        this.g = g;
        initComponents();
        jtamatchdetail.setText(sgui.getMst(matchNo));
        setIcon();

    }
      public UserJframe(int matchNo, Ground g, String matchGenre, String matchType, String teamA, String teamB, String date, String time, Knockout sf) {
        this.matchNo = matchNo;
        md.setGenre(matchGenre);
        md.setType(matchType);
        this.sf = sf;
        md.setTeamA(teamA);
        md.setTeamB(teamB);
        md.setDate(date);
        md.setTime(time);
        this.g = g;
        initComponents();
        jtamatchdetail.setText(sf.getMkt(matchNo));
        setIcon();

    }

    public String getTxtcnic() {
        return txtcnic.getText();
    }

    public void setTxtcnic(JTextField txtcnic) {
        this.txtcnic = txtcnic;
    }

    public UserJframe() {
        initComponents();
    }

    public MatchDetails getMd() {
        return md;
    }

    public void setMd(MatchDetails md) {
        this.md = md;
    }

    public JPanel getMdpanel() {
        return mdpanel;
    }

    public Icon getIcon1() {
        return icon1.getIcon();
    }

    public Icon getIcon2() {
        return icon2.getIcon();
    }

    public String getJtamatchdetail() {
        return jtamatchdetail.getText();
    }

    public void setIcon() {
        switch (md.getTeamA()) {
            case "Pakistan":
                this.icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan ticket.jpg")));
                break;
            case "England":
                this.icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England ticket.jpg")));
                break;
            case "Australia":
                this.icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia ticket.jpg")));
                break;
            case "India":
                this.icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india ticket.jpg")));
                break;
            case "New Zealand":
                this.icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand ticket.jpg")));
                break;
            case "South Africa":
                this.icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica ticket.jpg")));
                break;
            default:
                break;
        }
        switch (md.getTeamB()) {
            case "Pakistan":
                this.icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan ticket.jpg")));
                break;
            case "England":
                this.icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England ticket.jpg")));
                break;
            case "Australia":
                this.icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia ticket.jpg")));

                break;
            case "India":
                this.icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india ticket.jpg")));
                break;
            case "New Zealand":
                this.icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand ticket.jpg")));
                break;
            case "South Africa":
                this.icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica ticket.jpg")));
                break;
            default:
                break;
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblname = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        lblcnic = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtcnic = new javax.swing.JTextField();
        nextbtn = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        mdpanel = new javax.swing.JPanel();
        jtamatchdetail = new javax.swing.JTextArea();
        icon2 = new javax.swing.JLabel();
        icon1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PCB-Logo-Small.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 255, 153));

        lblname.setText("Enter your full name");

        lblemail.setText("Enter your email");

        lblcnic.setText("Enter your CNIC number");

        nextbtn.setBackground(new java.awt.Color(51, 102, 255));
        nextbtn.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        nextbtn.setForeground(new java.awt.Color(255, 255, 255));
        nextbtn.setText("Next");
        nextbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextbtnActionPerformed(evt);
            }
        });

        backbtn.setBackground(new java.awt.Color(204, 255, 153));
        backbtn.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        backbtn.setForeground(new java.awt.Color(255, 255, 255));
        backbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back paint.jpg"))); // NOI18N
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        mdpanel.setBackground(new java.awt.Color(255, 255, 255));

        jtamatchdetail.setEditable(false);
        jtamatchdetail.setColumns(20);
        jtamatchdetail.setRows(5);
        jtamatchdetail.setText("T20\nPakistan VS India\n8:00PM\n5 February\nGaddafi Stadium, Lahore");
        jtamatchdetail.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtamatchdetail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtamatchdetail.setPreferredSize(new java.awt.Dimension(188, 84));

        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india ticket.jpg"))); // NOI18N

        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan ticket.jpg"))); // NOI18N

        javax.swing.GroupLayout mdpanelLayout = new javax.swing.GroupLayout(mdpanel);
        mdpanel.setLayout(mdpanelLayout);
        mdpanelLayout.setHorizontalGroup(
            mdpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mdpanelLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jtamatchdetail, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(icon2)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(mdpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mdpanelLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(icon1)
                    .addContainerGap(338, Short.MAX_VALUE)))
        );
        mdpanelLayout.setVerticalGroup(
            mdpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mdpanelLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(mdpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon2)
                    .addComponent(jtamatchdetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(mdpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mdpanelLayout.createSequentialGroup()
                    .addContainerGap(35, Short.MAX_VALUE)
                    .addComponent(icon1)
                    .addGap(25, 25, 25)))
        );

        jtamatchdetail.getAccessibleContext().setAccessibleParent(jPanel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("xxxxx-xxxxxxx-x");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblemail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblcnic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcnic, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                .addGap(107, 107, 107)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mdpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(134, 134, 134))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backbtn)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblemail))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcnic)
                            .addComponent(txtcnic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(128, 128, 128))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mdpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167))))
        );

        jLabel7.setFont(new java.awt.Font("Constantia", 1, 24)); // NOI18N
        jLabel7.setText("User Information");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(305, 305, 305)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(30, 30, 30)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbtnActionPerformed
        if (!txtname.getText().equals("") && !txtemail.getText().equals("") && !txtcnic.getText().equals("")) {
            setVisible(false);
            u = new User(txtname.getText(), txtemail.getText(), txtcnic.getText());
            PaymentMethodGUI pmj = new PaymentMethodGUI(md, g, u, this);
            pmj.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Error! Please fill all the fields!");
        }

    }//GEN-LAST:event_nextbtnActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        this.setVisible(false);
        if (md.getGenre().equals("Series")) {
            sgui.setVisible(true);
        } else if (md.getGenre().equals("Tournament")) {
            tgui.setVisible(true);
        }
    }//GEN-LAST:event_backbtnActionPerformed

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
            java.util.logging.Logger.getLogger(UserJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserJframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextArea jtamatchdetail;
    private javax.swing.JLabel lblcnic;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblname;
    private javax.swing.JPanel mdpanel;
    private javax.swing.JButton nextbtn;
    private javax.swing.JTextField txtcnic;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
