/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import ticketbookingsystem.Enclosure;
import ticketbookingsystem.Ground;
import ticketbookingsystem.MatchDetails;
import ticketbookingsystem.PaymentMethod;
import ticketbookingsystem.Ticket;
import ticketbookingsystem.User;

/**
 *
 * @author Motile
 */
public class PaymentMethodGUI extends javax.swing.JFrame {

    private UserJframe ujf;
    private Ground g;
    private MatchDetails md;
    private Enclosure e = new Enclosure();
    private ArrayList<Enclosure> eList;
    private int totalEnclosures;
    private String[] eType;
    private double[] ePrice;
    private PaymentMethod pm;
    private User u;
    private ArrayList<Ticket> tkList;
    private ArrayList<String> uRows;
    private Ticket tobj;

    public PaymentMethodGUI(MatchDetails md, Ground g, User u, UserJframe ujf) {
        initComponents();
        tobj = new Ticket();
        tobj.setG(g);
        tobj.setU(u);
        tobj.setMd(md);
        this.md = md;
        this.g = g;
        this.u = u;
        loadEnclosure();
        this.ujf = ujf;
        this.icon1.setIcon(ujf.getIcon1());
        this.icon2.setIcon(ujf.getIcon2());
        this.jtamatchdetail.setText(ujf.getJtamatchdetail());
        calculateTotalPrice();
        setPaymentIcon();
    }

    public void removeRow() {
        int j = 0;
        uRows = tobj.getUnavailableRows(enclosurecb.getSelectedItem().toString());
        if (uRows != null) {
            for (j = 0; j < uRows.size(); j++) {
                Object o = uRows.get(j);
                rowcb.removeItem(o);
            }
        }
    }

    public void loadEnclosure() {
        eList = e.getEnclosureData(g.getName());
        totalEnclosures = eList.size() - 1;
        eType = new String[eList.size()];
        ePrice = new double[eList.size()];
        for (int i = 0; i <= totalEnclosures; i++) {
            e = eList.get(i);
            eType[i] = e.getType();
            ePrice[i] = e.getPrice();
            enclosurecb.addItem(e);
        }
    }

    public PaymentMethodGUI() {
        initComponents();
        setPaymentIcon();

    }

    public void checkConditions() {
        try {
            tkList = new ArrayList<>();
            if (!accID.getText().equals("")) {
                e.seteName(enclosurecb.getSelectedItem().toString());
                pm = new PaymentMethod();
                pm.setType((String) pmcb.getSelectedItem());
                pm.setAccID(Integer.parseInt(accID.getText()));
                PaymentMethod pmobj = new PaymentMethod(pm.getType(), pm.getAccID());
                Enclosure eobj = new Enclosure(e.getType(), e.geteName(), e.getPrice());

                int tQuantity = tobj.checkSeatCapacity(ujf.getTxtcnic(), md.getTeamA(), md.getTeamB(), md.getDate(), md.getTime());
                System.out.println(tQuantity);
                int selectedQuantity = Integer.valueOf(ticketcb.getSelectedItem().toString());
                if (tQuantity == 5) {
                    JOptionPane.showMessageDialog(null, "Error! 5 tickets are already bought against this CNIC");
                } else if (tQuantity != 5 && selectedQuantity + tQuantity <= 5) {
                    for (int i = 0; i < Integer.parseInt(ticketcb.getSelectedItem().toString()); i++) {

                        Ticket t = new Ticket(md, g, eobj, rowcb.getSelectedItem().toString(), u, pmobj);
                        t.addTicketToTable();
                        tkList.add(t);
                    }
                    this.setVisible(false);
                    TicketGUI tjf = new TicketGUI(ujf, tkList);
                    tjf.setVisible(true);
                } else if (tQuantity != 5 && selectedQuantity + tQuantity > 5) {
                    JOptionPane.showMessageDialog(null, "Error! You can only purchase 5 ticket on a CNIC\nYou can only purchase " + (5 - tQuantity) + " more tickets on this CNIC");

                }

            } else {
                JOptionPane.showMessageDialog(null, "Please enter your account ID!");
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error! account field only accepts numeric data" + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pmcb = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtaccID = new javax.swing.JLabel();
        accID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        enclosurecb = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        rowcb = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        ticketcb = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txttktprice = new javax.swing.JTextField();
        btnnext = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        mdpanel = new javax.swing.JPanel();
        jtamatchdetail = new javax.swing.JTextArea();
        icon2 = new javax.swing.JLabel();
        icon1 = new javax.swing.JLabel();
        lblpayment = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jTextField3.setText("BOOK KARO YAR ;)");
        jTextField3.setBorder(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PCB-Logo-Small.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 255, 153));

        pmcb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "JazzCash", "MasterCard", "EasyPaisa", "VisaCard" }));
        pmcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmcbActionPerformed(evt);
            }
        });

        jLabel2.setText("Select payment method");

        txtaccID.setText("Account ID");

        accID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accIDActionPerformed(evt);
            }
        });

        jLabel4.setText("Select Enclosure");

        enclosurecb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enclosurecbActionPerformed(evt);
            }
        });

        jLabel5.setText("Select your row");

        rowcb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Row 1", "Row 2", "Row 3", "Row 4", "Row 5", "Row 6", "Row 7", "Row 8", "Row 9", "Row 10" }));
        rowcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rowcbActionPerformed(evt);
            }
        });

        jLabel6.setText("Select number of tickets");

        ticketcb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        ticketcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketcbActionPerformed(evt);
            }
        });

        jLabel8.setText("Price PKR");

        txttktprice.setEditable(false);

        btnnext.setBackground(new java.awt.Color(51, 102, 255));
        btnnext.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        btnnext.setForeground(new java.awt.Color(255, 255, 255));
        btnnext.setText("Proceed");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        btncancel.setBackground(new java.awt.Color(51, 102, 255));
        btncancel.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        btncancel.setForeground(new java.awt.Color(255, 255, 255));
        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
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

        lblpayment.setBackground(new java.awt.Color(204, 255, 153));
        lblpayment.setForeground(new java.awt.Color(204, 255, 153));
        lblpayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/master paint.jpeg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtaccID)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(105, 105, 105)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pmcb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accID)
                    .addComponent(enclosurecb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rowcb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ticketcb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txttktprice, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mdpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btncancel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pmcb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtaccID)
                            .addComponent(accID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(enclosurecb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rowcb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(ticketcb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(mdpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttktprice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btncancel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 71, Short.MAX_VALUE))))
        );

        jLabel7.setFont(new java.awt.Font("Constantia", 1, 24)); // NOI18N
        jLabel7.setText("Payment Details");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/payment.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275)
                .addComponent(jLabel7)
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accIDActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        checkConditions();
    }//GEN-LAST:event_btnnextActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        setVisible(false);
        Home h = new Home();
        h.setVisible(true);
    }//GEN-LAST:event_btncancelActionPerformed

    public void setPaymentIcon() {
        String pmIcon = pmcb.getSelectedItem().toString();
        switch (pmIcon) {
            case "VisaCard":
                lblpayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/visa paint.jpg")));
                break;
            case "MasterCard":
                lblpayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/master paint.jpeg")));
                break;
            case "EasyPaisa":
                lblpayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/easy paint.jpg")));
                break;
            case "JazzCash":
                lblpayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jazz paint.jpg")));
                break;
            default:
                break;
        }
    }
    private void pmcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmcbActionPerformed
        setPaymentIcon();
    }//GEN-LAST:event_pmcbActionPerformed

    private void ticketcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketcbActionPerformed
        calculateTotalPrice();
    }//GEN-LAST:event_ticketcbActionPerformed

    private void rowcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rowcbActionPerformed

    }//GEN-LAST:event_rowcbActionPerformed
    public void refreshRowCB() {
        rowcb.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Row 1", "Row 2", "Row 3", "Row 4", "Row 5", "Row 6", "Row 7", "Row 8", "Row 9", "Row 10"}));
    }
    private void enclosurecbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enclosurecbActionPerformed
        refreshRowCB();
        removeRow();
        if (!txttktprice.getText().equals("")) {
            calculateTotalPrice();
        }
    }//GEN-LAST:event_enclosurecbActionPerformed
    public void deleterowItem(int itemIndex) {
        rowcb.removeItemAt(itemIndex);
        // enter index no to delete row
    }

    public void calculateTotalPrice() {
        int s = ticketcb.getSelectedIndex() + 1;
        int e = enclosurecb.getSelectedIndex();
        double price = 0;
        if (eType[e].equals("VIP")) {
            price = s * ePrice[e];
        } else if (eType[e].equals("Premium")) {
            price = s * ePrice[e];
        }
        txttktprice.setText(Double.toString(price));
    }

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
            java.util.logging.Logger.getLogger(PaymentMethodGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentMethodGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentMethodGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentMethodGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentMethodGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accID;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnnext;
    private javax.swing.JComboBox enclosurecb;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextArea jtamatchdetail;
    private javax.swing.JLabel lblpayment;
    private javax.swing.JPanel mdpanel;
    private javax.swing.JComboBox pmcb;
    private javax.swing.JComboBox rowcb;
    private javax.swing.JComboBox ticketcb;
    private javax.swing.JLabel txtaccID;
    private javax.swing.JTextField txttktprice;
    // End of variables declaration//GEN-END:variables
}
