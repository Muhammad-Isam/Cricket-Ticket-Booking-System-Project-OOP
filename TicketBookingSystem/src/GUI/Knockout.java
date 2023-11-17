/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import ticketbookingsystem.Ground;
import ticketbookingsystem.MatchDetails;
import ticketbookingsystem.Teams;

/**
 *
 * @author Motile
 */
public class Knockout extends javax.swing.JFrame {

    private MatchDetails md = new MatchDetails();
    private Ground gd = new Ground();
    private String teamA[];
    private String teamB[];
    private String date[], time[], matchType[];
    private ArrayList<MatchDetails> mkobj;
    private ArrayList<Ground> gobj;
    private ArrayList<Teams> tkobj;
    private int tMatches;
    private int[] btnDisable;
    private String a[];
    /**
     * Creates new form SemiFinal
     */
    public Knockout() {
        initComponents();
        tMatches = md.getKnockoutData();
        btnDisable = new int[tMatches];
        mkobj = md.getMkobj();
        gobj = md.getGobj();
        tkobj = md.getTkobj();
        setButtonVisible();
        setPanelsData();
        setButtonDisable();
        setLabelIcons();
    }
    
    public void setButtonDisable() {
        for (int i = 0; i < btnDisable.length; i++) {
            switch (btnDisable[i]) {
                case 1:
                    jButton1.setVisible(false);
                    break;
                case 2:
                    jButton2.setVisible(false);
                    break;
                case 3:
                    jButton3.setVisible(false);
                    break;
                default:
                    break;

            }
        }
    }
    
    public void setLabelIcons() {
        int j = 1, k = 2;
        for (int i = 0; i < mkobj.size(); i++) {
            switch (teamA[i]) {
                case "Pakistan":
                    setIcon(5, j);
                    break;
                case "Australia":
                    setIcon(1, j);
                    break;
                case "England":
                    setIcon(2, j);
                    break;
                case "India":
                    setIcon(3, j);
                    break;
                case "New Zealand":
                    setIcon(4, j);
                    break;
                case "South Africa":
                    setIcon(6, j);
                    break;
                default:
                    break;

            }
            j = j + 2;
        }
        for (int i = 0; i < mkobj.size(); i++) {
            switch (teamB[i]) {
                case "Australia":
                    setIcon(1, k);
                    break;
                case "England":
                    setIcon(2, k);
                    break;
                case "India":
                    setIcon(3, k);
                    break;
                case "New Zealand":
                    setIcon(4, k);
                    break;
                case "Pakistan":
                    setIcon(5, k);
                    break;
                case "South Africa":
                    setIcon(6, k);
                    break;
                default:
                    break;
            }
            k = k + 2;
        }
    }
    public void setIcon(int num, int in) {
        switch (in) {
            case 1:
                switch (num) {
                    case 1:
                        this.icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                switch (num) {
                    case 1:
                        this.icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                switch (num) {
                    case 1:
                        this.icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
                break;
            case 4:
                switch (num) {
                    case 1:
                        this.icon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
                break;
            case 5:
                switch (num) {
                    case 1:
                        this.icon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
                break;
            case 6:
                switch (num) {
                    case 1:
                        this.icon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
            default:
                break;
        }
    }
    
    public void setPanelsData() {
        teamA = new String[mkobj.size()];
        teamB = new String[mkobj.size()];
        date = new String[mkobj.size()];
        time = new String[mkobj.size()];
        matchType = new String[mkobj.size()];
        a = new String[mkobj.size()];
        try {
            for (int i = 0; i < mkobj.size(); i++) {
                MatchDetails s = mkobj.get(i);
                Ground g = gobj.get(i);
                Teams t = tkobj.get(i);
                s.setTeamA(t.getTeam(0));
                s.setTeamB(t.getTeam(1));
                if ((s.getResult().equals("TBD")) == true) {
                    a[i] = s.toString();
                    a[i] = a[i] + g.toString();
                    teamA[i] = s.getTeamA();
                    teamB[i] = s.getTeamB();
                    time[i] = s.getTime();
                    date[i] = s.getDate();
                    matchType[i] = s.getmType();
                } else {
                    a[i] = s.resultString()+ g.toString();
                    teamA[i] = s.getTeamA();
                    teamB[i] = s.getTeamB();
                    btnDisable[i] = i + 1;
                }
                setMkt(a);
                setTeamA(teamA);
                setTeamB(teamB);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
      public void setButtonVisible() {
        switch (tMatches) {
            case 1:
                jButton1.setVisible(true);
                jButton2.setVisible(false);
                jButton3.setVisible(false);
                break;
            case 2:
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(false);
                break;
            case 3:
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                break;
            
            default:
                break;
        }
    }
    public void setMkt(String[] m) {
        switch (m.length) {
            case 1:
                this.mjt1.setText(m[0]);
                icon1.setText("");
                icon2.setText("");
                break;
            case 2:
                this.mjt1.setText(m[0]);
                icon1.setText("");
                icon2.setText("");
                this.mjt2.setText(m[1]);
                icon3.setText("");
                icon4.setText("");
                break;
            case 3:
                this.mjt1.setText(m[0]);
                icon1.setText("");
                icon2.setText("");
                this.mjt2.setText(m[1]);
                icon3.setText("");
                icon4.setText("");
                this.mjt3.setText(m[2]);
                icon5.setText("");
                icon6.setText("");
                break;            
            default:
                break;
        }
    }

        public String getMkt(int n) {
        String j = null;
        switch (n) {
            case 1:
                j = mjt1.getText();
                break;
            case 2:
                j = mjt2.getText();
                break;
            case 3:
                j = mjt3.getText();
                break;
        }
        return j;
    }

    public String[] getTeamA() {
        return teamA;
    }

    public void setTeamA(String[] teamA) {
        this.teamA = teamA;
    }

    public String[] getTeamB() {
        return teamB;
    }

    public void setTeamB(String[] teamB) {
        this.teamB = teamB;
    }

        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel0 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mjt1 = new javax.swing.JTextArea();
        icon1 = new javax.swing.JLabel();
        icon2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        mjt3 = new javax.swing.JTextArea();
        icon5 = new javax.swing.JLabel();
        icon6 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        mjt2 = new javax.swing.JTextArea();
        icon3 = new javax.swing.JLabel();
        icon4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 100));
        setPreferredSize(new java.awt.Dimension(1380, 1796));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PCB-Logo-Small.png"))); // NOI18N

        jPanel0.setBackground(new java.awt.Color(204, 255, 153));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(833, 233));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mjt1.setEditable(false);
        mjt1.setColumns(20);
        mjt1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mjt1.setRows(5);
        mjt1.setText("\t\n\tT20 SEMI FINAL \n\tTBD VS TBD");
        mjt1.setBorder(null);
        jScrollPane1.setViewportView(mjt1);

        icon1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        icon1.setText("TBD");

        icon2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        icon2.setText("TBD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(icon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(icon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Tick IT");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setPreferredSize(new java.awt.Dimension(143, 62));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 102, 255));
        jButton2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Tick It");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setPreferredSize(new java.awt.Dimension(143, 62));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(833, 233));

        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mjt3.setEditable(false);
        mjt3.setColumns(20);
        mjt3.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mjt3.setRows(5);
        mjt3.setText("\t\n\tT20 FINAL \n\tTBD VS TBD");
        mjt3.setBorder(null);
        jScrollPane8.setViewportView(mjt3);

        icon5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        icon5.setText("TBD");

        icon6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        icon6.setText("TBD");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(icon5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon6, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(icon5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back paint.jpg"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 102, 255));
        jButton3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("tick it");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setPreferredSize(new java.awt.Dimension(143, 62));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home paint.jpg"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 102, 255));
        jButton5.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("View Winner");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(833, 233));

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mjt2.setEditable(false);
        mjt2.setColumns(20);
        mjt2.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mjt2.setRows(5);
        mjt2.setText("\t\n\tT20 SEMI FINAL \n\tTBD VS TBD");
        mjt2.setBorder(null);
        jScrollPane5.setViewportView(mjt2);

        icon3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        icon3.setText("TBD");

        icon4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        icon4.setText("TBD");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(icon3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(icon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel0Layout = new javax.swing.GroupLayout(jPanel0);
        jPanel0.setLayout(jPanel0Layout);
        jPanel0Layout.setHorizontalGroup(
            jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel0Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(249, Short.MAX_VALUE))
            .addGroup(jPanel0Layout.createSequentialGroup()
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(0, 1007, Short.MAX_VALUE))
        );
        jPanel0Layout.setVerticalGroup(
            jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel0Layout.createSequentialGroup()
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(245, 245, 245)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(725, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel0);

        jScrollPane4.setViewportView(jScrollPane2);

        jLabel2.setFont(new java.awt.Font("Constantia", 1, 24)); // NOI18N
        jLabel2.setText("Knockout Stage");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(420, 420, 420)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1350, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     private void bookBtn(int matchNo) {
        String matchGenre = "Knockout";
        UserJframe ujf = new UserJframe(matchNo, gobj.get(matchNo - 1), matchGenre, matchType[matchNo - 1], teamA[matchNo - 1], teamB[matchNo - 1], date[matchNo - 1], time[matchNo - 1], this);
        this.setVisible(false);
        ujf.setVisible(true);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        bookBtn(1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        bookBtn(2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        TournamentScheduleStage1 tss1=new TournamentScheduleStage1();
        tss1.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Home h=new Home();
        h.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Winner w=new Winner();
        w.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Knockout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Knockout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Knockout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Knockout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Knockout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel icon3;
    private javax.swing.JLabel icon4;
    private javax.swing.JLabel icon5;
    private javax.swing.JLabel icon6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel0;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextArea mjt1;
    private javax.swing.JTextArea mjt2;
    private javax.swing.JTextArea mjt3;
    // End of variables declaration//GEN-END:variables
}
