/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import ticketbookingsystem.Ground;
import ticketbookingsystem.MatchDetails;
import ticketbookingsystem.Teams;

/**
 *
 * @author Motile
 */
public class TournamentScheduleStage1 extends javax.swing.JFrame {

    private String teamA[];
    private String teamB[];
    private String date[], time[], matchType[];
    private MatchDetails md = new MatchDetails();
    private Ground gd = new Ground();
    private ArrayList<MatchDetails> mtobj;
    private ArrayList<Ground> gobj;
    private ArrayList<Teams> ttobj;
    private int tMatches;
    private int[] btnDisable;
    private String a[];

    public TournamentScheduleStage1() {
        initComponents();
        tMatches = md.getTournamentData();
        btnDisable = new int[tMatches];
        mtobj = md.getMtobj();
        gobj = md.getGobj();
        ttobj = md.getTtobj();
        setPanelVisible();
        setButtonVisible();
        setPanelsData();
        setButtonDisable();
        setLabelIcons();
    }

    public void setLabelIcons() {
        int j = 1, k = 2;
        for (int i = 0; i < mtobj.size(); i++) {
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
        for (int i = 0; i < mtobj.size(); i++) {
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

    public void setPanelsData() {
        teamA = new String[mtobj.size()];
        teamB = new String[mtobj.size()];
        date = new String[mtobj.size()];
        time = new String[mtobj.size()];
        matchType = new String[mtobj.size()];
        a = new String[mtobj.size()];
        try {
            for (int i = 0; i < mtobj.size(); i++) {
                MatchDetails s = mtobj.get(i);
                Ground g = gobj.get(i);
                Teams t = ttobj.get(i);
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
                setMjt(a);
                setTeamA(teamA);
                setTeamB(teamB);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
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
                case 4:
                    jButton4.setVisible(false);
                    break;
                case 5:
                    jButton5.setVisible(false);
                    break;
                case 6:
                    jButton6.setVisible(false);
                    break;
                default:
                    break;

            }
        }
    }

    public void setButtonVisible() {
        switch (tMatches) {
            case 1:
                jButton1.setVisible(true);
                jButton2.setVisible(false);
                jButton3.setVisible(false);
                jButton4.setVisible(false);
                jButton5.setVisible(false);
                jButton6.setVisible(false);
                break;
            case 2:
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(false);
                jButton4.setVisible(false);
                jButton5.setVisible(false);
                jButton6.setVisible(false);
                break;
            case 3:
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton4.setVisible(false);
                jButton5.setVisible(false);
                jButton6.setVisible(false);
                break;
            case 4:
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton4.setVisible(true);
                jButton5.setVisible(false);
                jButton6.setVisible(false);
                break;
            case 5:
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton4.setVisible(true);
                jButton5.setVisible(true);
                jButton6.setVisible(false);
                break;
            case 6:
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton4.setVisible(true);
                jButton5.setVisible(true);
                jButton6.setVisible(true);
                break;
            default:
                break;
        }
    }

    public void setMjt(String[] m) {
        switch (m.length) {
            case 1:
                this.mjt1.setText(m[0]);
                break;
            case 2:
                this.mjt1.setText(m[0]);
                this.mjt2.setText(m[1]);
                break;
            case 3:
                this.mjt1.setText(m[0]);
                this.mjt2.setText(m[1]);
                this.mjt3.setText(m[2]);
                break;
            case 4:
                this.mjt1.setText(m[0]);
                this.mjt2.setText(m[1]);
                this.mjt3.setText(m[2]);
                this.mjt4.setText(m[3]);
                break;
            case 5:
                this.mjt1.setText(m[0]);
                this.mjt2.setText(m[1]);
                this.mjt3.setText(m[2]);
                this.mjt4.setText(m[3]);
                this.mjt5.setText(m[4]);
                break;
            case 6:
                this.mjt1.setText(m[0]);
                this.mjt2.setText(m[1]);
                this.mjt3.setText(m[2]);
                this.mjt4.setText(m[3]);
                this.mjt5.setText(m[4]);
                this.mjt6.setText(m[5]);
                break;
            default:
                break;
        }
    }

    public void setPanelVisible() {
        switch (tMatches) {
            case 1:
                jPanel1.setVisible(true);
                jPanel2.setVisible(false);
                jPanel3.setVisible(false);
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jPanel6.setVisible(false);
                break;
            case 2:
                jPanel1.setVisible(true);
                jPanel2.setVisible(true);
                jPanel3.setVisible(false);
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jPanel6.setVisible(false);
                break;
            case 3:
                jPanel1.setVisible(true);
                jPanel2.setVisible(true);
                jPanel3.setVisible(true);
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jPanel6.setVisible(false);
                break;
            case 4:
                jPanel1.setVisible(true);
                jPanel2.setVisible(true);
                jPanel3.setVisible(true);
                jPanel4.setVisible(true);
                jPanel5.setVisible(false);
                jPanel6.setVisible(false);
                break;

            case 5:
                jPanel1.setVisible(true);
                jPanel2.setVisible(true);
                jPanel3.setVisible(true);
                jPanel4.setVisible(true);
                jPanel5.setVisible(true);
                jPanel6.setVisible(false);
                break;
            case 6:
                jPanel1.setVisible(true);
                jPanel2.setVisible(true);
                jPanel3.setVisible(true);
                jPanel4.setVisible(true);
                jPanel5.setVisible(true);
                jPanel6.setVisible(true);
                break;
            default:
                break;
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
                break;
            case 7:
                switch (num) {
                    case 1:
                        this.icon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
                break;
            case 8:
                switch (num) {
                    case 1:
                        this.icon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
                break;
            case 9:
                switch (num) {
                    case 1:
                        this.icon9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
                break;
            case 10:
                switch (num) {
                    case 1:
                        this.icon10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
                break;
            case 11:
                switch (num) {
                    case 1:
                        this.icon11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
                break;
            case 12:
                switch (num) {
                    case 1:
                        this.icon12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel0 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mjt1 = new javax.swing.JTextArea();
        icon1 = new javax.swing.JLabel();
        icon2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        mjt2 = new javax.swing.JTextArea();
        icon3 = new javax.swing.JLabel();
        icon4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        mjt4 = new javax.swing.JTextArea();
        icon7 = new javax.swing.JLabel();
        icon8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        mjt3 = new javax.swing.JTextArea();
        icon5 = new javax.swing.JLabel();
        icon6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        mjt5 = new javax.swing.JTextArea();
        icon9 = new javax.swing.JLabel();
        icon10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        mjt6 = new javax.swing.JTextArea();
        icon11 = new javax.swing.JLabel();
        icon12 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 100));
        setPreferredSize(new java.awt.Dimension(1400, 714));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PCB-Logo-Small.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Constantia", 1, 24)); // NOI18N
        jLabel2.setText("Tournaments");

        jPanel0.setBackground(new java.awt.Color(204, 255, 153));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mjt1.setEditable(false);
        mjt1.setColumns(20);
        mjt1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mjt1.setRows(5);
        mjt1.setText("     1ST ONE DAY INTERNATIONAL\n\tIndia VS Pakistan\n\t     5:00 PM\n\t23rd January 2023\n     National Stadium, Karachi");
        mjt1.setBorder(null);
        jScrollPane1.setViewportView(mjt1);

        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg"))); // NOI18N

        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pakistan paint.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton5.setBackground(new java.awt.Color(51, 102, 255));
        jButton5.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("tick it");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.setPreferredSize(new java.awt.Dimension(143, 62));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Book");
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
        jButton2.setText("tick it");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setPreferredSize(new java.awt.Dimension(143, 62));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        jButton4.setBackground(new java.awt.Color(51, 102, 255));
        jButton4.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("tick it");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setPreferredSize(new java.awt.Dimension(143, 62));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 102, 255));
        jButton6.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("tick it");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.setPreferredSize(new java.awt.Dimension(143, 62));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mjt2.setEditable(false);
        mjt2.setColumns(20);
        mjt2.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mjt2.setRows(5);
        mjt2.setText("     1ST ONE DAY INTERNATIONAL\n\tIndia VS Pakistan\n\t     5:00 PM\n\t23rd January 2023\n     National Stadium, Karachi");
        mjt2.setBorder(null);
        jScrollPane3.setViewportView(mjt2);

        icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg"))); // NOI18N

        icon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pakistan paint.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icon3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon4, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(icon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mjt4.setEditable(false);
        mjt4.setColumns(20);
        mjt4.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mjt4.setRows(5);
        mjt4.setText("     1ST ONE DAY INTERNATIONAL\n\tIndia VS Pakistan\n\t     5:00 PM\n\t23rd January 2023\n     National Stadium, Karachi");
        mjt4.setBorder(null);
        jScrollPane4.setViewportView(mjt4);

        icon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg"))); // NOI18N

        icon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pakistan paint.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon8)
                .addGap(93, 93, 93))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(icon7, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mjt3.setEditable(false);
        mjt3.setColumns(20);
        mjt3.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mjt3.setRows(5);
        mjt3.setText("     1ST ONE DAY INTERNATIONAL\n\tIndia VS Pakistan\n\t     5:00 PM\n\t23rd January 2023\n     National Stadium, Karachi");
        mjt3.setBorder(null);
        jScrollPane8.setViewportView(mjt3);

        icon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg"))); // NOI18N

        icon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pakistan paint.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon6, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon6, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(icon5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mjt5.setEditable(false);
        mjt5.setColumns(20);
        mjt5.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mjt5.setRows(5);
        mjt5.setText("     1ST ONE DAY INTERNATIONAL\n\tIndia VS Pakistan\n\t     5:00 PM\n\t23rd January 2023\n     National Stadium, Karachi");
        mjt5.setBorder(null);
        jScrollPane9.setViewportView(mjt5);

        icon9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg"))); // NOI18N

        icon10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pakistan paint.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon10, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(icon9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane10.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mjt6.setEditable(false);
        mjt6.setColumns(20);
        mjt6.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mjt6.setRows(5);
        mjt6.setText("     1ST ONE DAY INTERNATIONAL\n\tIndia VS Pakistan\n\t     5:00 PM\n\t23rd January 2023\n     National Stadium, Karachi");
        mjt6.setBorder(null);
        jScrollPane10.setViewportView(mjt6);

        icon11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg"))); // NOI18N

        icon12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pakistan paint.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon12, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(icon11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back paint.jpg"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(51, 102, 255));
        jButton7.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("View Knockout Stage");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home paint.jpg"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel0Layout = new javax.swing.GroupLayout(jPanel0);
        jPanel0.setLayout(jPanel0Layout);
        jPanel0Layout.setHorizontalGroup(
            jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel0Layout.createSequentialGroup()
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addComponent(jButton11)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7))
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jPanel0Layout.setVerticalGroup(
            jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel0Layout.createSequentialGroup()
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1007, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel0);

        jScrollPane5.setViewportView(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(443, 443, 443)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1022, 1022, 1022))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void bookBtn(int matchNo) {
        String matchGenre = "Tournament";
        UserJframe ujf = new UserJframe(matchNo, gobj.get(matchNo - 1), matchGenre, matchType[matchNo - 1], teamA[matchNo - 1], teamB[matchNo - 1], date[matchNo - 1], time[matchNo - 1], this);
        this.setVisible(false);
        ujf.setVisible(true);
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        bookBtn(5);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        bookBtn(1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        bookBtn(2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        bookBtn(3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        bookBtn(4);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        bookBtn(6);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        TournamentGUI tgui=new TournamentGUI();
        tgui.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Knockout k=new Knockout();
        k.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Home h=new Home();
        h.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    public String getMjt(int n) {
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
            case 4:
                j = mjt4.getText();
                break;
            case 5:
                j = mjt5.getText();
                break;
            case 6:
                j = mjt6.getText();
                break;
            default:
                break;
        }
        return j;
    }

    public JTextArea getMjt1() {
        return mjt1;
    }

    public void setMjt1(JTextArea mjt1) {
        this.mjt1 = mjt1;
    }

    public JTextArea getMjt2() {
        return mjt2;
    }

    public void setMjt2(JTextArea mjt2) {
        this.mjt2 = mjt2;
    }

    public JTextArea getMjt3() {
        return mjt3;
    }

    public void setMjt3(JTextArea mjt3) {
        this.mjt3 = mjt3;
    }

    public JTextArea getMjt4() {
        return mjt4;
    }

    public void setMjt4(JTextArea mjt4) {
        this.mjt4 = mjt4;
    }

    public JTextArea getMjt5() {
        return mjt5;
    }

    public void setMjt5(JTextArea mjt5) {
        this.mjt5 = mjt5;
    }

    public JTextArea getMjt6() {
        return mjt6;
    }

    public void setMjt6(JTextArea mjt6) {
        this.mjt6 = mjt6;
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
            java.util.logging.Logger.getLogger(TournamentScheduleStage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TournamentScheduleStage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TournamentScheduleStage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TournamentScheduleStage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TournamentScheduleStage1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon10;
    private javax.swing.JLabel icon11;
    private javax.swing.JLabel icon12;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel icon3;
    private javax.swing.JLabel icon4;
    private javax.swing.JLabel icon5;
    private javax.swing.JLabel icon6;
    private javax.swing.JLabel icon7;
    private javax.swing.JLabel icon8;
    private javax.swing.JLabel icon9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel0;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea mjt1;
    private javax.swing.JTextArea mjt2;
    private javax.swing.JTextArea mjt3;
    private javax.swing.JTextArea mjt4;
    private javax.swing.JTextArea mjt5;
    private javax.swing.JTextArea mjt6;
    // End of variables declaration//GEN-END:variables
}
