
package Admin;
import Connection.ConnectionToDB;
import GUI.AdminDashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Admin
{
    ConnectionToDB con=new ConnectionToDB();
    Connection con_obj=con.EstablishConnection();
    PreparedStatement pstmt=null;
    Statement stmt=null;
    ResultSet res=null;
public boolean loginAdmin(String aname,String apass)
    {
        boolean a = false;
        String login="select * from tbl_admin where AdminName='"+aname+"' and AdminPassword='"+apass+"' ";
        try
        {
            pstmt=con_obj.prepareStatement(login);
            res=pstmt.executeQuery();
            if(res.next())
            {
                a=true;
                JOptionPane.showMessageDialog(null,"Login Successful");
                
                AdminDashboard ad=new AdminDashboard();
                ad.setVisible(true);
                String adminsname=res.getNString("Name");
                ad.setAdminName(adminsname);
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Login Denied\n"+ex);
            a=false;
        }
        return a;
    }

    //TOURNAMENTS   
    public boolean deleteTournament(String tname)
    {
      boolean c=false;
      String delete="delete from tbl_tournament where Name='"+tname+"' ";
      try
        {
            stmt=con_obj.createStatement();
            int res=stmt.executeUpdate(delete);
            if(res > 0)
            {
                c=true;
                JOptionPane.showMessageDialog(null,"Tournament deleted Successfully");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error deleting Tournament\n"+ex);
            c=false;
        }
        return c;
    }
    public boolean addTournament(String tname)
    {
       boolean b=false;
       String add="insert into tbl_tournament(Name) values ('"+tname+"')"; 
       try
        {
            stmt=con_obj.createStatement();
            int res=stmt.executeUpdate(add);
            if(res > 0)
            {
                b=true;
                JOptionPane.showMessageDialog(null,"Tournament added Successfully");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error adding Tournament\n"+ex);
            b=false;
        }
        return b;
    }
    public boolean updateTournament(String oldtname,String newtname)
    {
        boolean e=false; 
        try
        {
            String update="update tbl_tournament set Name='"+newtname+"' where Name='"+oldtname+"'";                 
            stmt=con_obj.createStatement();
            int rset=stmt.executeUpdate(update);
            if(rset>0)
            {
                e=true;
                JOptionPane.showMessageDialog(null,"Tournament Updated Successfully");
            }
}
        catch(Exception ex)
        {
            e=false;
            JOptionPane.showMessageDialog(null, "Error updating Tournament\n"+ex);
        }
        return e;
    }
    public boolean searchTournament(String tname)
    {
        boolean d = false;
        String search="select * from tbl_tournament where Name='"+tname+"' ";
        try
        {
            pstmt=con_obj.prepareStatement(search);
            res=pstmt.executeQuery();
            if(res.next())
            {
                d=true;
                String id=res.getString("ID");
                String name=res.getString("Name");
                JOptionPane.showMessageDialog(null,"Tournament found"+"\nTournament ID : "+id+"\nTournament Name : "+name);
            }
        }
        catch(Exception ex)
        {
            d=false;
            JOptionPane.showMessageDialog(null, "Tournament not found\n"+ex);
        }
        return d;
    }
    
    //GROUND
    public boolean deleteGround(String gname)
    {
      boolean c=false;
      String delete="delete from tbl_Ground where ='"+gname+"' ";
      try
        {
            stmt=con_obj.createStatement();
            int res=stmt.executeUpdate(delete);
            if(res > 0)
            {
                c=true;
                JOptionPane.showMessageDialog(null,"Ground deleted Successfully");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error deleting Ground\n"+ex);
            c=false;
        }
        return c;
    }
    public boolean addGround(String gname,String gvenue,String gcapacity)
    {
       boolean b=false;
       String add="insert into tbl_ground(Name,Venue,TotalCapacity) values ('"+gname+"','"+gvenue+"','"+gcapacity+"')"; 
       try
        {
            stmt=con_obj.createStatement();
            int res=stmt.executeUpdate(add);
            if(res > 0)
            {
                b=true;
                JOptionPane.showMessageDialog(null,"Ground added Successfully");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error adding Ground\n"+ex);
            b=false;
        }
        return b;
    }
    public boolean updateGround(String gname,String gvenue,String gcapacity)
    {
        boolean e=false; 
        try
        {
            String update="update tbl_ground set Venue='"+gvenue+"',TotalCapacity='"+gcapacity+"' where Name='"+gname+"' ";                 
            stmt=con_obj.createStatement();
            int rset=stmt.executeUpdate(update);
            if(rset>0)
            {
                e=true;
                JOptionPane.showMessageDialog(null,"Ground Updated Successfully");
            }
}
        catch(Exception ex)
        {
            e=false;
            JOptionPane.showMessageDialog(null, "Error updating Ground\n"+ex);
        }
        return e;
    }
    public boolean searchGround(String gname)
    {
        boolean d = false;
        String search="select * from tbl_ground where Name='"+gname+"' ";
        try
        {
            pstmt=con_obj.prepareStatement(search);
            res=pstmt.executeQuery();
            if(res.next())
            {
                d=true;
                String id=res.getNString("ID");
                String venueName=res.getNString("Venue");
                String totalCapacity=res.getNString("TotalCapacity");
                JOptionPane.showMessageDialog(null,"Ground found"+"\nGround ID : "+id+"\nGround Name : "+venueName+"\nTotal Capacity :"  +totalCapacity);
            }
        }
        catch(Exception ex)
        {
            d=false;
            JOptionPane.showMessageDialog(null, "Ground not found\n"+ex);
        }
        return d;
    }
    
    //MATCH DETAILS
     public boolean deleteMatchDetails(String mid)
    {
      boolean c=false;
      String delete="delete from tbl_matchdetails where ID='"+mid+" ";
      try
        {
            stmt=con_obj.createStatement();
            int res=stmt.executeUpdate(delete);
            if(res > 0)
            {
                c=true;
                JOptionPane.showMessageDialog(null,"MatchDetails deleted Successfully");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error deleting MatchDetails\n"+ex);
            c=false;
        }
        return c;
    }
    public boolean addMatchDetails(String type, String date, String time, String teamA, String teamB, String genre,String gname,String gvenue,String gtotalcapacity)
    {
       boolean b=false; 


       String add="insert into tbl_matchDetails(Type,Date,Time,TeamA,TeamB,Genre,GroundName,Venue,TotalCapacity) values ('"+type+"','"+date+"','"+time+"','"+teamA+"','"+teamB+"','"+genre+"','"+gname+"','"+gvenue+"','"+gtotalcapacity+"')"; 
       try
        {
            stmt=con_obj.createStatement();
            int res=stmt.executeUpdate(add);
            if(res > 0)
            {
                b=true;
                JOptionPane.showMessageDialog(null,"MatchDetails added Successfully");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error adding MatchDetails\n"+ex);
            b=false;
        }
        return b;
    }
    public boolean updateMatchDetails(String type, String date, String time, String teamA, String teamB, String genre,String gname,String gvenue,String gtotalcapacity)
    {
        boolean e=false; 
        try
        {
            String update="update tbl_matchDetails set Type='"+type+"' , Date='"+date+"' , TeamA='"+teamA+"' , TeamB='"+teamB+"'  , Genre='"+genre+"', GroundName='"+gname+"', Venue='"+gvenue+"',TotalCapacity='"+gtotalcapacity+"'";                 
            stmt=con_obj.createStatement();
            int rset=stmt.executeUpdate(update);
            if(rset>0)
            {
                e=true;
                JOptionPane.showMessageDialog(null,"Match details updated successfully");
            }
}
        catch(Exception ex)
        {
            e=false;
            JOptionPane.showMessageDialog(null, "Error updating  match details\n"+ex);
        }
        return e;
    }
    public boolean searchMatchDetails(String mid)
    {
        boolean d = false;
        String search="select * from tbl_matchDetails where ID='"+mid+"'";
        try
        {
            pstmt=con_obj.prepareStatement(search);
            res=pstmt.executeQuery();
            if(res.next())
            {
                d=true;
                String id=res.getNString("ID");
                String type=res.getNString("Type");
                String date=res.getNString("Date");
                String time=res.getNString("Time");
                String teamA=res.getNString("TeamA");
                String teamB=res.getNString("TeamB");
                String genre=res.getNString("Genre");
                JOptionPane.showMessageDialog(null,"MatchDetails found"+"\nID : "+id+"\nType : "+type+"\nDate :"  +date+"\nTime : "+time+"\nTeamA : "+teamA+"\nTeamB : "+teamB+"\nGenre : "+genre);
            }
        }
        catch(Exception ex)
        {
            d=false;
            JOptionPane.showMessageDialog(null, "MatchDetails not found\n"+ex);
        }
        return d;
    }
    
    //Enclosure
    public boolean deleteEnclosure(String ename)
    {
      boolean c=false;
      String delete="delete from tbl_enclosure where EnclosureName='"+ename+"' ";
      try
        {
            stmt=con_obj.createStatement();
            int res=stmt.executeUpdate(delete);
            if(res > 0)
            {
                c=true;
                JOptionPane.showMessageDialog(null,"Enclosure deleted Successfully");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error deleting Enclosure\n"+ex);
            c=false;
        }
        return c;
    }
    public boolean AddEnclosure(String ename, String totaleSeats, String etype, String eprice, String erows,String gname,String gvenue,String gtotalcapacity)
    {
       boolean b=false; 
       
       String add="insert into tbl_enclosure(EnclosureName,TotalSeats,Type,Price,Rows,GroundName,Venue,TotalCapacity) values ('"+ename+"','"+totaleSeats+"','"+etype+"','"+eprice+"','"+erows+"','"+gname+"','"+gvenue+"','"+gtotalcapacity+"')"; 
       try
        {
            stmt=con_obj.createStatement();
            int res=stmt.executeUpdate(add);
            if(res > 0)
            {
                b=true;
                JOptionPane.showMessageDialog(null,"Enclosure added Successfully");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error adding Enclosure\n"+ex);
            b=false;
        }
        return b;
    }
    public boolean updateEnclosure(String ename, String totaleSeats, String etype, String eprice, String erows,String gname,String gvenue,String gtotalcapacity)
    {
        boolean e=false; 
        try
        {
            String update="update Enclosure set EncllosureName='"+ename+"' , TotalSeats='"+totaleSeats+"' , Type='"+etype+"' , Price='"+eprice+"'  , Rows='"+erows+"' , GroundName='"+gname+"', Venue='"+gvenue+"',TotalCapacity='"+gtotalcapacity+"'";                 
            stmt=con_obj.createStatement();
            int rset=stmt.executeUpdate(update);
            if(rset>0)
            {
                e=true;
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
            }
}
        catch(Exception ex)
        {
            e=false;
            JOptionPane.showMessageDialog(null, "Error updating  Enclosure\n"+ex);
        }
        return e;
    }
    public boolean searchEnclosure(String ename)
    {
        boolean d = false;
        String search="select * from Enclosure where EnclosureName='"+ename+"' ";
        try
        {
            pstmt=con_obj.prepareStatement(search);
            res=pstmt.executeQuery();
            if(res.next())
            {
                d=true;
                String id=res.getNString("ID");
                String name=res.getNString("EnclosureName");
                String totalSeats=res.getNString("TotalSeats");
                String type=res.getNString("Type");
                String price=res.getNString("Price");
                String rows=res.getNString("Rows");
              
                JOptionPane.showMessageDialog(null,"Enclosure found"+"\nID : "+id+"\nEnclosureName : "+name+"\nTotalSeats :"  +totalSeats+"\nType : "+type+"\nPrice : "+price+"\nRows : "+rows);
            }
        }
        catch(Exception ex)
        {
            d=false;
            JOptionPane.showMessageDialog(null, "Enclosure not found\n"+ex);
        }
        return d;
    }
    
    public void updateResult(String result,String id)
    {
        try
        {
            String update="update tbl_matchdetails set Result='"+result+"' where ID='"+id+"'";                 
            stmt=con_obj.createStatement();
            int rset=stmt.executeUpdate(update);
            if(rset>0)
            {
                JOptionPane.showMessageDialog(null,"Result Updated Successfully");
            }
}
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error updating Result\n"+ex);
        }
    }
}