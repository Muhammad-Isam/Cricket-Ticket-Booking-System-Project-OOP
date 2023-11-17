package ticketbookingsystem;

import Connection.ConnectionToDB;
import GUI.TicketGUI;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ticket {

    private Enclosure e;
    private MatchDetails md;
    private User u;
    private PaymentMethod pm;
    private Ground g;
    private int seatNo;
    private String rowNo;
    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = con.EstablishConnection();
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;
    private ArrayList<Ticket> t;

    public Ticket(Enclosure e, User u) {
        this.e = e;
        this.u = u;
    }

    public Ticket() {
        e = new Enclosure();
    }

    public Ticket(MatchDetails md, Ground g, Enclosure e, String rowNo, User u, PaymentMethod pm) {
        this.e = e;
        this.g = g;
        this.md = md;
        this.rowNo = rowNo;
        this.u = u;
        this.pm = pm;
        this.seatNo = generateSeatNo();
//        this.seatNo = 1;
    }

    public void setEnclosureName(String eName) {
        e.seteName(eName);
    }

    public ArrayList<String> getUnavailableRows(String eName) {
        ArrayList<String> uRows = new ArrayList<>();
        boolean b = false;
        int a = 500;
        String sql = "SELECT RowNo FROM tbl_ticket WHERE EnclosureName = '" + eName + "' AND TeamA = '" + md.getTeamA() + "' AND TeamB = '" + md.getTeamB() + "' AND MatchDate = '" + md.getDate() + "' AND MatchTime = '" + md.getTime() + "' AND SeatNo='" + a + "'";
        try {
            pstmt = con_obj.prepareStatement(sql);
            res = pstmt.executeQuery();
            while (res.next()) {
                b = true;
                uRows.add(res.getString("RowNo"));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Test" + ex);
        }
        if (b) {
            return uRows;
        } else {
            return null;
        }
    }

    public int generateSeatNo() {
        String sql = "SELECT SeatNo FROM tbl_ticket WHERE EnclosureName = '" + e.geteName() + "' AND TeamA = '" + md.getTeamA() + "' AND TeamB = '" + md.getTeamB() + "' AND MatchDate = '" + md.getDate() + "' AND MatchTime = '" + md.getTime() + "' AND RowNo= '" + rowNo + "'";
        boolean b = false;
        try {
            pstmt = con_obj.prepareStatement(sql);
            res = pstmt.executeQuery();
            while (res.next()) {
                seatNo = res.getInt("SeatNo");
                b = true;
                seatNo += 1;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        if (b == false) {
            return 1;
        }
        return seatNo;
    }

    public boolean addTicketToTable() {
        boolean b = false;
        String sql = "INSERT INTO tbl_ticket(SeatNo, CNIC, Name, Email, EnclosureName, Type, Price, RowNo, GroundName, Venue, TeamA,TeamB,MatchDate,MatchTime)values('" + seatNo + "','" + u.getCNIC() + "','" + u.getName() + "','" + u.getEmail() + "','" + e.geteName() + "','" + e.getType() + "','" + e.getPrice() + "','" + this.rowNo + "','" + g.getName() + "','" + g.getVenue() + "','" + md.getTeamA() + "','" + md.getTeamB() + "','" + md.getDate() + "','" + md.getTime() + "')";
        try {
            stmt = con_obj.createStatement();
            int r = stmt.executeUpdate(sql);
            if (r > 0) {
                b = true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            b = false;
        }
        return b;
    }

    public MatchDetails getMd() {
        return md;
    }

    public void setMd(MatchDetails md) {
        this.md = md;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public String getRowNo() {
        return rowNo;
    }

    public void setRowNo(String rowNo) {
        this.rowNo = rowNo;
    }

    public Enclosure getE() {
        return e;
    }

    public void setE(Enclosure e) {
        this.e = e;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public PaymentMethod getPm() {
        return pm;
    }

    public void setPm(PaymentMethod pm) {
        this.pm = pm;
    }

    public Ground getG() {
        return g;
    }

    public void setG(Ground g) {
        this.g = g;
    }

    @Override
    public String toString() {
        System.out.println(e.toString());
        return "\nSeat No: " + seatNo;
    }

    public int checkSeatCapacity(String cnic, String teamA, String teamB, String date, String time) {
        int quantity = 0;
        String check = "select COUNT(*) from tbl_ticket where CNIC = '" + cnic + "' AND TeamA='" + teamA + "' AND TeamB = '" + teamB + "' AND MatchDate='" + date + "' AND MatchTime='" + time + "' ";
        try {
            pstmt = con_obj.prepareStatement(check);
            res = pstmt.executeQuery();
            if (res.next()) {
                quantity = res.getInt(1);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return quantity;
    }
}
