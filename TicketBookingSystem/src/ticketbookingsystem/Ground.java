package ticketbookingsystem;

import Connection.ConnectionToDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ground {

    private String name, venue;
    private int totalcapacity;
    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = con.EstablishConnection();
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;
    ResultSet rs = null;
    private ArrayList<Ground> gobj = new ArrayList<>();

    public Ground(String name, String venue, int totalcapacity) {
        this.name = name;
        this.venue = venue;
        this.totalcapacity = totalcapacity;
    }

    public Ground() {
    }

    public ArrayList<Ground> getData() {
        String gr = "SELECT * FROM tbl_ground";
        try {
        pstmt = con_obj.prepareStatement(gr);
        rs = pstmt.executeQuery();
        while (res.next()) {
            this.name=res.getString("Name");
            this.venue=res.getString("Venue");
            this.totalcapacity=res.getInt("TotalCapacity");
            Ground grnd = new Ground(this.name, this.venue, this.totalcapacity);
            gobj.add(grnd);
        }
        }
        catch(Exception ex)
        {
                        JOptionPane.showMessageDialog(null, ex);

        }
        return gobj;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalcapacity() {
        return totalcapacity;
    }

    public void setTotalcapacity(int totalcapacity) {
        this.totalcapacity = totalcapacity;
    }

    @Override
    public String toString() {
        return "\n" + name + ", " + venue;
    }

}
