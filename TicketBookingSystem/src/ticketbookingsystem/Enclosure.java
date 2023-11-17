package ticketbookingsystem;

import Connection.ConnectionToDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Enclosure {

    private String type;
    private String eName;
    private double price;
    private int totalSeats;
    private final int ROWS = 10;
    private int[][] rowSeats;
    private Ground g;
    private ArrayList<Enclosure> e = new ArrayList<>();
    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = con.EstablishConnection();
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;
    ResultSet rs = null;

    public Enclosure(int totalSeats, String eName, String type, double price, Ground g) {
        this.totalSeats = totalSeats;
        this.eName = eName;
        this.type = type;
        this.price = price;
        this.g = g;
        rowSeats = new int[ROWS][(totalSeats / 10)];
    }

    public Enclosure(String type, String eName, double price) {
        this.type = type;
        this.eName = eName;
        this.price = price;
    }

    public Enclosure() {
    }

    public ArrayList<Enclosure> getEnclosureData(String gName) {
        String str = "SELECT * FROM tbl_enclosure WHERE GroundName='" + gName + "'";
        try {
            pstmt = con_obj.prepareStatement(str);
            res = pstmt.executeQuery();
            while (res.next()) {
                this.price = res.getInt("Price");
                this.type = res.getString("Type");
                this.eName = res.getString("EnclosureName");
                Enclosure obj=new Enclosure(type, eName, price);
                e.add(obj);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return e;
    }

    public int[][] getRowSeats() {
        return rowSeats;
    }

    public void setRowSeats(int[][] rowseats) {
        this.rowSeats = rowseats;
    }

    public Ground getG() {
        return g;
    }

    public void setG(Ground g) {
        this.g = g;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    @Override
    public String toString() {
//        System.out.println(g.toString());
        return eName;
    }

}
