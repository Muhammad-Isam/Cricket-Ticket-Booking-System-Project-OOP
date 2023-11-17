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
 * @author dell
 */
public class Series extends javax.swing.JFrame {

    private String teamA[];
    private String teamB[];
    private String date[], time[], matchType[];
    private MatchDetails md = new MatchDetails();
    private Ground gd = new Ground();
    private ArrayList<MatchDetails> msobj;
    private ArrayList<Ground> gobj;
    private ArrayList<Teams> tsobj;
    private int tMatches;
    private int[] btnDisable;
    private String a[];

    public Series() {
        initComponents();
        tMatches = md.getSeriesData();
        btnDisable = new int[tMatches];
        msobj = md.getMsobj();
        gobj = md.getGobj();
        tsobj = md.getTsobj();
        setPanelVisible();
        setButtonVisible();
        setPanelsData();
        setButtonDisable();
        setLabelIcons();

    }

    public void setLabelIcons() {
        int j = 1, k = 2;
        for (int i = 0; i < msobj.size(); i++) {
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
        for (int i = 0; i < msobj.size(); i++) {
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

    public String getMst(int n) {
        String j = null;
        switch (n) {
            case 1:
                j = mst1.getText();
                break;
            case 2:
                j = mst2.getText();
                break;
            case 3:
                j = mst3.getText();
                break;
            case 4:
                j = mst4.getText();
                break;
            case 5:
                j = mst5.getText();
                break;
            case 6:
                j = mst6.getText();
                break;
            case 7:
                j = mst7.getText();
            case 8:
                j = mst8.getText();
            case 9:
                j = mst9.getText();
            case 10:
                j = mst10.getText();
            default:
                break;
        }
        return j;
    }

    public void setPanelsData() {
        teamA = new String[msobj.size()];
        teamB = new String[msobj.size()];
        date = new String[msobj.size()];
        time = new String[msobj.size()];
        matchType = new String[msobj.size()];
        a = new String[msobj.size()];
         try {
            for (int i = 0; i < msobj.size(); i++) {
                MatchDetails s = msobj.get(i);
                Ground g = gobj.get(i);
                Teams t = tsobj.get(i);
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
                setMst(a);
                setTeamA(teamA);
                setTeamB(teamB);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
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
                case 7:
                    jButton7.setVisible(false);
                    break;
                case 8:
                    jButton8.setVisible(false);
                    break;
                case 9:
                    jButton8.setVisible(false);
                    break;
                case 10:
                    jButton10.setVisible(false);
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
                jButton7.setVisible(false);
                jButton8.setVisible(false);
                jButton9.setVisible(false);
                jButton10.setVisible(false);
                break;
            case 2:
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(false);
                jButton4.setVisible(false);
                jButton5.setVisible(false);
                jButton6.setVisible(false);
                jButton7.setVisible(false);
                jButton8.setVisible(false);
                jButton9.setVisible(false);
                jButton10.setVisible(false);
                break;
            case 3:
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton4.setVisible(false);
                jButton5.setVisible(false);
                jButton6.setVisible(false);
                jButton7.setVisible(false);
                jButton8.setVisible(false);
                jButton9.setVisible(false);
                jButton10.setVisible(false);
                break;
            case 4:
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton4.setVisible(true);
                jButton5.setVisible(false);
                jButton6.setVisible(false);
                jButton7.setVisible(false);
                jButton8.setVisible(false);
                jButton9.setVisible(false);
                jButton10.setVisible(false);
                break;
            case 5:
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton4.setVisible(true);
                jButton5.setVisible(true);
                jButton6.setVisible(false);
                jButton7.setVisible(false);
                jButton8.setVisible(false);
                jButton9.setVisible(false);
                jButton10.setVisible(false);
                break;
            case 6:
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton4.setVisible(true);
                jButton5.setVisible(true);
                jButton6.setVisible(true);
                jButton7.setVisible(false);
                jButton8.setVisible(false);
                jButton9.setVisible(false);
                jButton10.setVisible(false);
                break;
            case 7:
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton4.setVisible(true);
                jButton5.setVisible(true);
                jButton6.setVisible(true);
                jButton7.setVisible(true);
                jButton8.setVisible(false);
                jButton9.setVisible(false);
                jButton10.setVisible(false);
                break;
            case 8:
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton4.setVisible(true);
                jButton5.setVisible(true);
                jButton6.setVisible(true);
                jButton7.setVisible(true);
                jButton8.setVisible(true);
                jButton9.setVisible(false);
                jButton10.setVisible(false);
                break;
            case 9:
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton4.setVisible(true);
                jButton5.setVisible(true);
                jButton6.setVisible(true);
                jButton7.setVisible(true);
                jButton8.setVisible(true);
                jButton9.setVisible(true);
                jButton10.setVisible(false);
                break;
            case 10:
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton4.setVisible(true);
                jButton5.setVisible(true);
                jButton6.setVisible(true);
                jButton7.setVisible(true);
                jButton8.setVisible(true);
                jButton9.setVisible(true);
                jButton10.setVisible(true);
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
                jPanel7.setVisible(false);
                jPanel8.setVisible(false);
                jPanel9.setVisible(false);
                jPanel10.setVisible(false);
                break;
            case 2:
                jPanel1.setVisible(true);
                jPanel2.setVisible(true);
                jPanel3.setVisible(false);
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jPanel6.setVisible(false);
                jPanel7.setVisible(false);
                jPanel8.setVisible(false);
                jPanel9.setVisible(false);
                jPanel10.setVisible(false);
                break;
            case 3:
                jPanel1.setVisible(true);
                jPanel2.setVisible(true);
                jPanel3.setVisible(true);
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jPanel6.setVisible(false);
                jPanel7.setVisible(false);
                jPanel8.setVisible(false);
                jPanel9.setVisible(false);
                jPanel10.setVisible(false);
                break;
            case 4:
                jPanel1.setVisible(true);
                jPanel2.setVisible(true);
                jPanel3.setVisible(true);
                jPanel4.setVisible(true);
                jPanel5.setVisible(false);
                jPanel6.setVisible(false);
                jPanel7.setVisible(false);
                jPanel8.setVisible(false);
                jPanel9.setVisible(false);
                jPanel10.setVisible(false);
                break;

            case 5:
                jPanel1.setVisible(true);
                jPanel2.setVisible(true);
                jPanel3.setVisible(true);
                jPanel4.setVisible(true);
                jPanel5.setVisible(true);
                jPanel6.setVisible(false);
                jPanel7.setVisible(false);
                jPanel8.setVisible(false);
                jPanel9.setVisible(false);
                jPanel10.setVisible(false);
                break;
            case 6:
                jPanel1.setVisible(true);
                jPanel2.setVisible(true);
                jPanel3.setVisible(true);
                jPanel4.setVisible(true);
                jPanel5.setVisible(true);
                jPanel6.setVisible(true);
                jPanel7.setVisible(false);
                jPanel8.setVisible(false);
                jPanel9.setVisible(false);
                jPanel10.setVisible(false);
                break;
            case 7:
                jPanel1.setVisible(true);
                jPanel2.setVisible(true);
                jPanel3.setVisible(true);
                jPanel4.setVisible(true);
                jPanel5.setVisible(true);
                jPanel6.setVisible(true);
                jPanel7.setVisible(true);
                jPanel8.setVisible(false);
                jPanel9.setVisible(false);
                jPanel10.setVisible(false);
                break;
            case 8:
                jPanel1.setVisible(true);
                jPanel2.setVisible(true);
                jPanel3.setVisible(true);
                jPanel4.setVisible(true);
                jPanel5.setVisible(true);
                jPanel6.setVisible(true);
                jPanel7.setVisible(true);
                jPanel8.setVisible(true);
                jPanel9.setVisible(false);
                jPanel10.setVisible(false);
                break;
            case 9:
                jPanel1.setVisible(true);
                jPanel2.setVisible(true);
                jPanel3.setVisible(true);
                jPanel4.setVisible(true);
                jPanel5.setVisible(true);
                jPanel6.setVisible(true);
                jPanel7.setVisible(true);
                jPanel8.setVisible(true);
                jPanel9.setVisible(true);
                jPanel10.setVisible(false);
                break;
            case 10:
                jPanel1.setVisible(true);
                jPanel2.setVisible(true);
                jPanel3.setVisible(true);
                jPanel4.setVisible(true);
                jPanel5.setVisible(true);
                jPanel6.setVisible(true);
                jPanel7.setVisible(true);
                jPanel8.setVisible(true);
                jPanel9.setVisible(true);
                jPanel10.setVisible(true);
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
            case 13:
                switch (num) {
                    case 1:
                        this.icon13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
                break;
            case 14:
                switch (num) {
                    case 1:
                        this.icon14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
                break;
            case 15:
                switch (num) {
                    case 1:
                        this.icon15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
                break;
            case 16:
                switch (num) {
                    case 1:
                        this.icon16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
                break;
            case 17:
                switch (num) {
                    case 1:
                        this.icon17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
                break;
            case 18:
                switch (num) {
                    case 1:
                        this.icon18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
                break;
            case 19:
                switch (num) {
                    case 1:
                        this.icon19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
                break;
            case 20:
                switch (num) {
                    case 1:
                        this.icon20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/australia paint.jpg")));
                        break;
                    case 2:
                        this.icon20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/England paint.jpg")));
                        break;
                    case 3:
                        this.icon20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg")));
                        break;
                    case 4:
                        this.icon20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-zealand paint.jpg")));
                        break;
                    case 5:
                        this.icon20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pakistan paint.jpg")));
                        break;
                    case 6:
                        this.icon20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Southafrica paint.jpg")));
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }

    }

    public JTextArea getMst1() {
        return mst1;
    }

    public void setMst(String[] m) {
        switch (m.length) {
            case 1:
                this.mst1.setText(m[0]);
                break;
            case 2:
                this.mst1.setText(m[0]);
                this.mst2.setText(m[1]);
                break;
            case 3:
                this.mst1.setText(m[0]);
                this.mst2.setText(m[1]);
                this.mst3.setText(m[2]);
                break;
            case 4:
                this.mst1.setText(m[0]);
                this.mst2.setText(m[1]);
                this.mst3.setText(m[2]);
                this.mst4.setText(m[3]);
                break;
            case 5:
                this.mst1.setText(m[0]);
                this.mst2.setText(m[1]);
                this.mst3.setText(m[2]);
                this.mst4.setText(m[3]);
                this.mst5.setText(m[4]);
                break;
            case 6:
                this.mst1.setText(m[0]);
                this.mst2.setText(m[1]);
                this.mst3.setText(m[2]);
                this.mst4.setText(m[3]);
                this.mst5.setText(m[4]);
                this.mst6.setText(m[5]);
                break;
            case 7:
                this.mst1.setText(m[0]);
                this.mst2.setText(m[1]);
                this.mst3.setText(m[2]);
                this.mst4.setText(m[3]);
                this.mst5.setText(m[4]);
                this.mst6.setText(m[5]);
                this.mst7.setText(m[6]);
                break;
            case 8:
                this.mst1.setText(m[0]);
                this.mst2.setText(m[1]);
                this.mst3.setText(m[2]);
                this.mst4.setText(m[3]);
                this.mst5.setText(m[4]);
                this.mst6.setText(m[5]);
                this.mst7.setText(m[6]);
                this.mst8.setText(m[7]);
                break;
            case 9:
                this.mst1.setText(m[0]);
                this.mst2.setText(m[1]);
                this.mst3.setText(m[2]);
                this.mst4.setText(m[3]);
                this.mst5.setText(m[4]);
                this.mst6.setText(m[5]);
                this.mst7.setText(m[6]);
                this.mst8.setText(m[7]);
                this.mst9.setText(m[8]);
                break;
            case 10:
                this.mst1.setText(m[0]);
                this.mst2.setText(m[1]);
                this.mst3.setText(m[2]);
                this.mst4.setText(m[3]);
                this.mst5.setText(m[4]);
                this.mst6.setText(m[5]);
                this.mst7.setText(m[6]);
                this.mst8.setText(m[7]);
                this.mst9.setText(m[8]);
                this.mst10.setText(m[9]);
                break;
            default:
                break;
        }
    }

    public void setTeamA(String[] teamA) {
        this.teamA = teamA;
    }

    public void setTeamB(String[] teamB) {
        this.teamB = teamB;
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
        jScrollPane7 = new javax.swing.JScrollPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel0 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        mst1 = new javax.swing.JTextArea();
        icon1 = new javax.swing.JLabel();
        icon2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        mst2 = new javax.swing.JTextArea();
        icon3 = new javax.swing.JLabel();
        icon4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        mst4 = new javax.swing.JTextArea();
        icon7 = new javax.swing.JLabel();
        icon8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        mst3 = new javax.swing.JTextArea();
        icon5 = new javax.swing.JLabel();
        icon6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        mst5 = new javax.swing.JTextArea();
        icon9 = new javax.swing.JLabel();
        icon10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        mst6 = new javax.swing.JTextArea();
        icon11 = new javax.swing.JLabel();
        icon12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        mst7 = new javax.swing.JTextArea();
        icon13 = new javax.swing.JLabel();
        icon14 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        mst8 = new javax.swing.JTextArea();
        icon15 = new javax.swing.JLabel();
        icon16 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        mst9 = new javax.swing.JTextArea();
        icon17 = new javax.swing.JLabel();
        icon18 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        mst10 = new javax.swing.JTextArea();
        icon19 = new javax.swing.JLabel();
        icon20 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PCB-Logo-Small.png"))); // NOI18N

        jPanel0.setBackground(new java.awt.Color(204, 255, 153));
        jPanel0.setPreferredSize(new java.awt.Dimension(1300, 2876));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mst1.setEditable(false);
        mst1.setColumns(20);
        mst1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mst1.setRows(5);
        mst1.setText("     1ST ONE DAY INTERNATIONAL\n\tIndia VS Pakistan\n\t     5:00 PM\n\t23rd January 2023\n     National Stadium, Karachi");
        mst1.setBorder(null);
        jScrollPane9.setViewportView(mst1);

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
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jButton1.setText("tick it");
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

        jScrollPane10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane10.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mst2.setEditable(false);
        mst2.setColumns(20);
        mst2.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mst2.setRows(5);
        mst2.setText("     2ND ONE DAY INTERNATIONAL\n\tIndia VS Pakistan\n\t     5:00 PM\n\t23rd January 2023\n     National Stadium, Karachi");
        mst2.setBorder(null);
        mst2.setPreferredSize(new java.awt.Dimension(369, 140));
        jScrollPane10.setViewportView(mst2);

        icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg"))); // NOI18N

        icon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pakistan paint.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(icon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane11.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mst4.setEditable(false);
        mst4.setColumns(20);
        mst4.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mst4.setRows(5);
        mst4.setText("\tONE DAY INTERNATIONAL\n\tIndia VS Pakistan\n\t     5:00 PM\n\t23rd January 2023\n     National Stadium, Karachi");
        mst4.setBorder(null);
        jScrollPane11.setViewportView(mst4);

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
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane12.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mst3.setEditable(false);
        mst3.setColumns(20);
        mst3.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mst3.setRows(5);
        mst3.setText("\tONE DAY INTERNATIONAL\n\t India VS Pakistan\n\t     5:00 PM\n\t23rd January 2023\n     National Stadium, Karachi");
        mst3.setBorder(null);
        jScrollPane12.setViewportView(mst3);

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
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane13.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane13.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mst5.setEditable(false);
        mst5.setColumns(20);
        mst5.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mst5.setRows(5);
        mst5.setText("\t1ST TEST MATCH\n\tIndia VS Pakistan\n\t     5:00 PM\n\t23rd January 2023\n     National Stadium, Karachi");
        mst5.setBorder(null);
        jScrollPane13.setViewportView(mst5);

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
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(27, 27, 27)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane14.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane14.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mst6.setEditable(false);
        mst6.setColumns(20);
        mst6.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mst6.setRows(5);
        mst6.setText("      1ST T-20 INTERNATIONAL\n\tIndia VS Pakistan\n\t     5:00 PM\n\t23rd January 2023\n     National Stadium, Karachi");
        mst6.setToolTipText("");
        mst6.setBorder(null);
        jScrollPane14.setViewportView(mst6);

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
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon12, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(icon11, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane15.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane15.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mst7.setEditable(false);
        mst7.setColumns(20);
        mst7.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mst7.setRows(5);
        mst7.setText("    1ST ONE DAY INTERNATIONAL\n\tIndia VS Pakistan\n\t     5:00 PM\n\t23rd January 2023\n     National Stadium, Karachi");
        mst7.setBorder(null);
        jScrollPane15.setViewportView(mst7);

        icon13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg"))); // NOI18N

        icon14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pakistan paint.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon14, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(icon13, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton7.setBackground(new java.awt.Color(51, 102, 255));
        jButton7.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("tick it");
        jButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.setPreferredSize(new java.awt.Dimension(143, 62));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane16.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane16.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mst8.setEditable(false);
        mst8.setColumns(20);
        mst8.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mst8.setRows(5);
        mst8.setText("  3RD TEST MATCH INTERNATIONAL\n\tIndia VS Pakistan\n\t     5:00 PM\n\t23rd January 2023\n     National Stadium, Karachi");
        mst8.setBorder(null);
        jScrollPane16.setViewportView(mst8);

        icon15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg"))); // NOI18N

        icon16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pakistan paint.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon16, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(icon15, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane17.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane17.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mst9.setEditable(false);
        mst9.setColumns(20);
        mst9.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mst9.setRows(5);
        mst9.setText("  5TH TEST MATCH INTERNATIONAL\n\tIndia VS Pakistan\n\t     5:00 PM\n\t23rd January 2023\n     National Stadium, Karachi");
        mst9.setBorder(null);
        jScrollPane17.setViewportView(mst9);

        icon17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg"))); // NOI18N

        icon18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pakistan paint.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon18, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(icon17, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane18.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane18.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mst10.setEditable(false);
        mst10.setColumns(20);
        mst10.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        mst10.setRows(5);
        mst10.setText("     5TH ONE DAY INTERNATIONAL\t\n\tIndia VS Pakistan\n\t     5:00 PM\n\t23rd January 2023\n     National Stadium, Karachi");
        mst10.setBorder(null);
        jScrollPane18.setViewportView(mst10);

        icon19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/india paint.jpg"))); // NOI18N

        icon20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pakistan paint.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon20, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(icon19, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton8.setBackground(new java.awt.Color(51, 102, 255));
        jButton8.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("tick it");
        jButton8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.setPreferredSize(new java.awt.Dimension(143, 62));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(51, 102, 255));
        jButton9.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("tick it");
        jButton9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.setPreferredSize(new java.awt.Dimension(143, 62));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(51, 102, 255));
        jButton10.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("ti ck it");
        jButton10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton10.setPreferredSize(new java.awt.Dimension(143, 62));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
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

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back paint.jpg"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home paint.jpg"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel0Layout = new javax.swing.GroupLayout(jPanel0);
        jPanel0.setLayout(jPanel0Layout);
        jPanel0Layout.setHorizontalGroup(
            jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel0Layout.createSequentialGroup()
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(223, Short.MAX_VALUE))
        );
        jPanel0Layout.setVerticalGroup(
            jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel0Layout.createSequentialGroup()
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12))
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel0Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(215, 215, 215)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)))
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel0Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)))
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel0Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)))
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel0Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)))
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel0Layout.createSequentialGroup()
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)))
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel0Layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))))
        );

        jScrollPane8.setViewportView(jPanel0);

        jScrollPane7.setViewportView(jScrollPane8);

        jLabel2.setFont(new java.awt.Font("Constantia", 1, 24)); // NOI18N
        jLabel2.setText("Bilateral Series");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(523, 523, 523)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 2997, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void bookbuttonActionPerformed(int matchNo) {
        String matchGenre = "Series";
        UserJframe ujf = new UserJframe(matchNo, gobj.get(matchNo - 1), matchGenre, matchType[matchNo - 1], teamA[matchNo - 1], teamB[matchNo - 1], date[matchNo - 1], time[matchNo - 1], this);
        this.setVisible(false);
        ujf.setVisible(true);

    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        bookbuttonActionPerformed(5);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        bookbuttonActionPerformed(1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        bookbuttonActionPerformed(2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        bookbuttonActionPerformed(3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        bookbuttonActionPerformed(6);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        bookbuttonActionPerformed(7);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        bookbuttonActionPerformed(8);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        bookbuttonActionPerformed(9);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        bookbuttonActionPerformed(10);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        bookbuttonActionPerformed(4);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        Home h = new Home();
        h.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        Home h=new Home();
        h.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton12ActionPerformed

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
            java.util.logging.Logger.getLogger(Series.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Series.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Series.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Series.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Series().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon10;
    private javax.swing.JLabel icon11;
    private javax.swing.JLabel icon12;
    private javax.swing.JLabel icon13;
    private javax.swing.JLabel icon14;
    private javax.swing.JLabel icon15;
    private javax.swing.JLabel icon16;
    private javax.swing.JLabel icon17;
    private javax.swing.JLabel icon18;
    private javax.swing.JLabel icon19;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel icon20;
    private javax.swing.JLabel icon3;
    private javax.swing.JLabel icon4;
    private javax.swing.JLabel icon5;
    private javax.swing.JLabel icon6;
    private javax.swing.JLabel icon7;
    private javax.swing.JLabel icon8;
    private javax.swing.JLabel icon9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel0;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea mst1;
    private javax.swing.JTextArea mst10;
    private javax.swing.JTextArea mst2;
    private javax.swing.JTextArea mst3;
    private javax.swing.JTextArea mst4;
    private javax.swing.JTextArea mst5;
    private javax.swing.JTextArea mst6;
    private javax.swing.JTextArea mst7;
    private javax.swing.JTextArea mst8;
    private javax.swing.JTextArea mst9;
    // End of variables declaration//GEN-END:variables
}
