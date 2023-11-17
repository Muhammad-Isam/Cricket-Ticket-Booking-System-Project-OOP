package ticketbookingsystem;

import Connection.ConnectionToDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PointsTable {

    private String[] team = new String[6];
    private int matches, wins, losses, points;
    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = con.EstablishConnection();
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet res = null;
    ResultSet rs = null;

    public PointsTable(String[] team, int matches, int wins, int losses, int points) {
        this.team = team;
        this.matches = matches;
        this.wins = wins;
        this.losses = losses;
        this.points = points;
    }

    public PointsTable(String team, int matches, int wins, int losses, int points) {
        this.team[0] = team;
        this.matches = matches;
        this.wins = wins;
        this.losses = losses;
        this.points = points;
    }

    public PointsTable() {
    }

    public ArrayList<PointsTable> getDataPTA() {
        ArrayList<PointsTable> pTAList = new ArrayList<>();
        String str = "SELECT * FROM tbl_pointstableA";
        try {
            pstmt = con_obj.prepareStatement(str);
            res = pstmt.executeQuery();
            while (res.next()) {
                this.team[0] = res.getString("Team");
                this.matches = res.getInt("Matches");
                this.wins = res.getInt("Wins");
                this.losses = res.getInt("Losses");
                this.points = res.getInt("Points");
                PointsTable p = new PointsTable(team[0], matches, wins, losses, points);
                pTAList.add(p);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return pTAList;
    }

    public ArrayList<PointsTable> getDataPTB() {
        ArrayList<PointsTable> pTBList = new ArrayList<>();
        String str = "SELECT * FROM tbl_pointstableB";
        try {
            pstmt = con_obj.prepareStatement(str);
            res = pstmt.executeQuery();
            while (res.next()) {
                this.team[0] = res.getString("Team");
                this.matches = res.getInt("Matches");
                this.wins = res.getInt("Wins");
                this.losses = res.getInt("Losses");
                this.points = res.getInt("Points");
                PointsTable p = new PointsTable(team[0], matches, wins, losses, points);
                pTBList.add(p);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return pTBList;
    }

    public void setPointsTable() {
        boolean b = false;
        String[] word;
        String t = "TBD", genre = "Tournament";
        String sql = "Select * FROM tbl_matchdetails where Genre='" + genre + "'";
        try {
            pstmt = con_obj.prepareStatement(sql);
            res = pstmt.executeQuery();
            while (res.next()) {
                String s = res.getString("Result");
                String u = res.getString("TeamA");
                String v = res.getString("TeamB");
                if (!s.equals("TBD")) {
                    word = s.split(" ");
                     if (word[0].equals("New"))
                    {
                    word[0]="New Zealand";
                    }
                    else if (word[0].equals("South"))
                    {
                        word[0]="South Africa";
                    }
                    this.team[0] = word[0];
                    if (word[0].equals(u)) {
                        this.team[1] = v;
                    } else if (word[0].equals(v)) {
                        this.team[1] = u;
                    }

                    String sql0 = "Select * FROM tbl_pointstableA WHERE Team='" + team[0] + "'";
                    pstmt = con_obj.prepareStatement(sql0);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                        this.matches = rs.getInt("Matches") + 1;
                        this.wins = rs.getInt("Wins") + 1;

                        this.points = rs.getInt("Points") + 2;
                        String sql2 = "Update tbl_pointstableA set Matches='" + this.matches + "',Wins='" + this.wins + "', Points='" + this.points + "' where Team='" + word[0] + "' ";
                        stmt = con_obj.createStatement();
                        int r = stmt.executeUpdate(sql2);
                        if (r > 0) {
                            b = true;
                        }
                        String sql1 = "Select * FROM tbl_pointstableA WHERE Team='" + team[1] + "'";
                        pstmt = con_obj.prepareStatement(sql1);
                        rs = pstmt.executeQuery();
                        if (rs.next()) {
                            this.matches = rs.getInt("Matches") + 1;
                            this.losses = rs.getInt("Losses") + 1;
                            sql2 = "Update tbl_pointstableA set Matches='" + this.matches + "',Losses='" + this.losses + "' where Team='" + team[1] + "' ";
                            stmt = con_obj.createStatement();
                            r = stmt.executeUpdate(sql2);
                            if (r > 0) {
                                b = true;
                            }
                        }

                    } else {
                        String sql3 = "Select * FROM tbl_pointstableB WHERE Team='" + team[0] + "'";
                        pstmt = con_obj.prepareStatement(sql3);
                        rs = pstmt.executeQuery();
                        if (rs.next()) {
                            this.matches = rs.getInt("Matches") + 1;
                            this.wins = rs.getInt("Wins") + 1;

                            this.points = rs.getInt("Points") + 2;
                            String sql4 = "Update tbl_pointstableB set Matches='" + this.matches + "',Wins='" + this.wins + "', Points='" + this.points + "' where Team='" + word[0] + "' ";
                            stmt = con_obj.createStatement();
                            int r = stmt.executeUpdate(sql4);
                            if (r > 0) {
                                b = true;
                            }
                            String sql5 = "Select * FROM tbl_pointstableB WHERE Team='" + team[1] + "'";
                            pstmt = con_obj.prepareStatement(sql5);
                            rs = pstmt.executeQuery();
                            if (rs.next()) {
                                this.matches = rs.getInt("Matches") + 1;
                                this.losses = rs.getInt("Losses") + 1;
                                String sql6 = "Update tbl_pointstableB set Matches='" + this.matches + "',Losses='" + this.losses + "' where Team='" + team[1] + "' ";
                                stmt = con_obj.createStatement();
                                r = stmt.executeUpdate(sql6);
                                if (r > 0) {
                                    b = true;
                                }
                            }
                        }
                    }

                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void resetPointsTable() {
        int i = 0;
        String sql = "Update tbl_pointstableA set Matches='" + i + "',Losses='" + i + "', Wins='" + i + "', Points='" + i + "'";
        try{
        stmt = con_obj.createStatement();
        stmt.executeUpdate(sql);
        sql = "Update tbl_pointstableB set Matches='" + i + "',Losses='" + i + "', Wins='" + i + "', Points='" + i + "'";        
        stmt = con_obj.createStatement();
        stmt.executeUpdate(sql);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public String getTeam1() {
        return team[0];
    }

    public String[] getTeam() {
        return team;
    }

    public void setTeam(String[] team) {
        this.team = team;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
