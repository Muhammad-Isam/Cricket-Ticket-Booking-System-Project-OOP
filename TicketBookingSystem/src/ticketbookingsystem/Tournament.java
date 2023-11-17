package ticketbookingsystem;

import Connection.ConnectionToDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Tournament extends javax.swing.JFrame {

    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = con.EstablishConnection();
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;
    ResultSet rs = null;
    private String tName;

    public Tournament(String tName) {
        this.tName = tName;
    }

    public Tournament() {
    }

    public String getTName() {
        return tName;
    }

    public void setTName(String tName) {
        this.tName = tName;
    }

    public String getTournamentData() {
        String sql = "Select * from tbl_tournament";
        try {
            pstmt = con_obj.prepareStatement(sql);
            res = pstmt.executeQuery();
            if (res.next()) {
                setTName(res.getString("Name"));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return getTName();
    }

    @Override
    public String toString() {
        return tName;
    }
}
