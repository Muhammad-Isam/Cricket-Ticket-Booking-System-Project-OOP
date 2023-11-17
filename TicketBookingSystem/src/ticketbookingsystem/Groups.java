package ticketbookingsystem;

import Connection.ConnectionToDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Groups {

    private Teams t = new Teams();
    private String grpName;
    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = con.EstablishConnection();
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet res = null;

    public Groups() {
        
    }

    public Groups(String t1, String t2, String t3) {
        t.addTeam(t1);
        t.addTeam(t2);
        t.addTeam(t3);
    }

    public Teams getT() {
        return t;
    }

    public void setT(Teams t) {
        this.t = t;
    }

    public String getGrpName() {
        return grpName;
    }

    public void setGrpName(String grpName) {
        this.grpName = grpName;
    }

    public Teams getGroupATeams(){
        int i=0;
        String sql="Select * from tbl_groupa";
        try {
            pstmt = con_obj.prepareStatement(sql);
            res = pstmt.executeQuery();
            while (res.next()) {
                t.addTeam(res.getString("Team"));
                i++;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return t;
    }



    public Teams getGroupBTeams() {
        int i = 0;
        String sql = "Select * from tbl_groupb";
        try {
            pstmt = con_obj.prepareStatement(sql);
            res = pstmt.executeQuery();
            while (res.next()) {
                t.addTeam(res.getString("Team"));
                i++;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return t;
    }

    @Override
    public String toString() {
        return "Group " +grpName+ " Teams: \n" + t.getTeam(0) + "\n" + t.getTeam(1) + "\n" + t.getTeam(2);
    }

}
