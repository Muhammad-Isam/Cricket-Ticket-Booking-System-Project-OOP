package ticketbookingsystem;

import Connection.ConnectionToDB;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MatchDetails {

    private String type, time, date, genre, result;
    private Ground g;
    private Teams t;
    private int id;
    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = con.EstablishConnection();
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;
    ResultSet rs = null;
    private ArrayList<MatchDetails> msobj = new ArrayList<>();
    private ArrayList<MatchDetails> mtobj = new ArrayList<>();
    private ArrayList<MatchDetails> mkobj = new ArrayList<>();
    private ArrayList<Teams> ttobj = new ArrayList<>();
    private ArrayList<Teams> tsobj = new ArrayList<>();
    private ArrayList<Teams> tkobj = new ArrayList<>();
    private ArrayList<Ground> gobj = new ArrayList<>();

    public MatchDetails(String type, String time, String date, String genre, String result, Ground g, Teams t, int id) {
        this.type = type;
        this.time = time;
        this.date = date;
        this.genre = genre;
        this.result = result;
        this.g = g;
        this.t = t;
        this.id = id;
    }

    public MatchDetails(String type, String time, String date, String teamA, String teamB, String result) {
        this.type = type;
        this.time = time;
        this.date = date;
        t = new Teams();
        t.addTeam(0, teamA);
        t.addTeam(1, teamB);
        this.result = result;
    }

    public MatchDetails(String type, String time, String date, String teamA, String teamB) {
        this.type = type;
        this.time = time;
        this.date = date;
        t = new Teams();
        t.addTeam(0, teamA);
        t.addTeam(1, teamB);
    }

    public MatchDetails() {
    }

    public Ground getG() {
        return g;
    }

    public void setG(Ground g) {
        this.g = g;
    }

    public String getTeamA() {
        return tg.getTeam(0);
    }

    public String getTeamB() {
        return tg.getTeam(1);
    }

    private Teams tg = new Teams();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teams getTg() {
        return tg;
    }

    public void setTg(Teams tg) {
        this.tg = tg;
    }

    public void setTeamA(String teamA) {
        tg.addTeam(teamA);
    }

    public void setTeamB(String teamB) {
        tg.addTeam(teamB);
    }

    public String getmType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ArrayList<MatchDetails> getMsobj() {
        return msobj;
    }

    public void setMsobj(ArrayList<MatchDetails> msobj) {
        this.msobj = msobj;
    }

    public ArrayList<MatchDetails> getMtobj() {
        return mtobj;
    }

    public void setMtobj(ArrayList<MatchDetails> mtobj) {
        this.mtobj = mtobj;
    }

    public ArrayList<Ground> getGobj() {
        return gobj;
    }

    public void setGobj(ArrayList<Ground> gobj) {
        this.gobj = gobj;
    }

    public ArrayList<Teams> getTtobj() {
        return ttobj;
    }

    public void setTtobj(ArrayList<Teams> ttobj) {
        this.ttobj = ttobj;
    }

    public ArrayList<Teams> getTsobj() {
        return tsobj;
    }

    public void setTsobj(ArrayList<Teams> tsobj) {
        this.tsobj = tsobj;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ArrayList<MatchDetails> getAllMatchDetails() {
        ArrayList<MatchDetails> mList = new ArrayList<>();

        String sql = "Select * from tbl_matchdetails";
        try {
            pstmt = con_obj.prepareStatement(sql);
            res = pstmt.executeQuery();
            while (res.next()) {
                t = new Teams();
                g = new Ground();
                this.id = res.getInt("ID");
                this.type = res.getString("Type");
                this.date = res.getString("Date");
                this.time = res.getString("Time");
                this.genre = res.getString("Genre");
                this.result = res.getString("Result");
                g.setName(res.getString("GroundName"));
                g.setVenue(res.getString("Venue"));
                g.setTotalcapacity(res.getInt("TotalCapacity"));
                t.addTeam(0, res.getString("TeamA"));
                t.addTeam(1, res.getString("TeamB"));
                MatchDetails m = new MatchDetails(type, time, date, genre, result, g, t, id);
                mList.add(m);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return mList;
    }
    
    public String getFinalWinner() {
        t = new Teams();
        String winningTeam = "TBD";
        String a = "Knockout";
        int mCount = 0;
        String[] word;
        String sql = "Select Result, TeamA, TeamB from tbl_matchdetails WHERE Genre='" + a + "'";
        try {
            pstmt = con_obj.prepareStatement(sql);
            res = pstmt.executeQuery();
            while (res.next()) {
                mCount++;
                if (!res.getString("Result").equals("TBD") && mCount == 3) {
                    String s = res.getString("Result");                  
                    t.addTeam(0, res.getString("TeamA"));
                    t.addTeam(1, res.getString("TeamB"));
                    word = s.split(" ");
                     if (word[0].equals("New"))
                    {
                    word[0]="New Zealand";
                    }
                    else if (word[0].equals("South"))
                    {
                        word[0]="South Africa";
                    }
                    winningTeam = word[0];
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return winningTeam;
    }

    public int getSeriesData() {
        g = new Ground();
        t = new Teams();
        int totalSeriesMatches = 0;
        String a = "Series";
        String s = "SELECT * FROM tbl_matchdetails WHERE Genre='" + a + "'";
        try {
            pstmt = con_obj.prepareStatement(s);
            res = pstmt.executeQuery();
            while (res.next()) {
                if (res.getString("Result").equals("TBD")) {
                    this.type = res.getString("Type");
                    this.date = res.getString("Date");
                    this.time = res.getString("Time");
                    t.addTeam(0, res.getString("TeamA"));
                    t.addTeam(1, res.getString("TeamB"));
                    setTeamA(t.getTeam(0));
                    setTeamB(t.getTeam(1));
                    Teams tnew = new Teams(t.getTeam(0), t.getTeam(1));
                    tsobj.add(tnew);
                    this.result = res.getString("Result");
                    MatchDetails m = new MatchDetails(type, time, date, t.getTeam(0), t.getTeam(1), result);
                    msobj.add(m);
                    g.setName(res.getString("GroundName"));
                    g.setVenue(res.getString("Venue"));
                    g.setTotalcapacity(res.getInt("TotalCapacity"));
                    Ground grnd = new Ground(g.getName(), g.getVenue(), g.getTotalcapacity());
                    gobj.add(grnd);
                    totalSeriesMatches++;
                } else {
                    this.type = res.getString("Type");
                    this.date = res.getString("Date");
                    this.time = res.getString("Time");
                    t.addTeam(0, res.getString("TeamA"));
                    t.addTeam(1, res.getString("TeamB"));
                    setTeamA(t.getTeam(0));
                    setTeamB(t.getTeam(1));
                    Teams tnew = new Teams(t.getTeam(0), t.getTeam(1));
                    tsobj.add(tnew);
                    this.result = res.getString("Result");
                    MatchDetails m = new MatchDetails(type, time, date, t.getTeam(0), t.getTeam(1), result);
                    msobj.add(m);
                    g.setName(res.getString("GroundName"));
                    g.setVenue(res.getString("Venue"));
                    g.setTotalcapacity(res.getInt("TotalCapacity"));
                    Ground grnd = new Ground(g.getName(), g.getVenue(), g.getTotalcapacity());
                    gobj.add(grnd);
                    totalSeriesMatches++;
                }
            }
            setTsobj(tsobj);
            setMsobj(msobj);
            setGobj(gobj);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return totalSeriesMatches;
    }

    public int getTournamentData() {
        g = new Ground();
        t = new Teams();
        int totalTournamentMatches = 0;
        String a = "Tournament";
        String s = "SELECT * FROM tbl_matchdetails WHERE Genre='" + a + "'";
        try {
            pstmt = con_obj.prepareStatement(s);
            res = pstmt.executeQuery();
            while (res.next()) {
                if (res.getString("Result").equals("TBD")) {
                    this.type = res.getString("Type");
                    this.date = res.getString("Date");
                    this.time = res.getString("Time");
                    t.addTeam(0, res.getString("TeamA"));
                    t.addTeam(1, res.getString("TeamB"));
                    Teams tnew = new Teams(t.getTeam(0), t.getTeam(1));
                    ttobj.add(tnew);
                    setTeamA(t.getTeam(0));
                    setTeamB(t.getTeam(0));
                    this.result = res.getString("Result");
                    MatchDetails m = new MatchDetails(type, time, date, t.getTeam(0), t.getTeam(1), result);
                    mtobj.add(m);
                    g.setName(res.getString("GroundName"));
                    g.setVenue(res.getString("Venue"));
                    g.setTotalcapacity(res.getInt("TotalCapacity"));
                    Ground grnd = new Ground(g.getName(), g.getVenue(), g.getTotalcapacity());
                    gobj.add(grnd);
                    totalTournamentMatches++;
                } else {
                    this.type = res.getString("Type");
                    this.date = res.getString("Date");
                    this.time = res.getString("Time");
                    t.addTeam(0, res.getString("TeamA"));
                    t.addTeam(1, res.getString("TeamB"));
                    Teams tnew = new Teams(t.getTeam(0), t.getTeam(1));
                    ttobj.add(tnew);
                    setTeamA(t.getTeam(0));
                    setTeamB(t.getTeam(0));
                    this.result = res.getString("Result");
                    MatchDetails m = new MatchDetails(type, time, date, t.getTeam(0), t.getTeam(1), result);
                    mtobj.add(m);
                    g.setName(res.getString("GroundName"));
                    g.setVenue(res.getString("Venue"));
                    g.setTotalcapacity(res.getInt("TotalCapacity"));
                    Ground grnd = new Ground(g.getName(), g.getVenue(), g.getTotalcapacity());
                    gobj.add(grnd);
                    totalTournamentMatches++;
                }
            }
            setTtobj(ttobj);
            setMtobj(mtobj);
            setGobj(gobj);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return totalTournamentMatches;
    }

    public int getKnockoutData() {
        g = new Ground();
        t = new Teams();
        int totalKnockoutMatches = 0;
        String a = "Knockout";
        String s = "SELECT * FROM tbl_matchdetails WHERE Genre='" + a + "'";
        try {
            pstmt = con_obj.prepareStatement(s);
            res = pstmt.executeQuery();
            while (res.next()) {
                if (res.getString("Result").equals("TBD")) {
                    this.type = res.getString("Type");
                    this.date = res.getString("Date");
                    this.time = res.getString("Time");
                    t.addTeam(0, res.getString("TeamA"));
                    t.addTeam(1, res.getString("TeamB"));
                    Teams tnew = new Teams(t.getTeam(0), t.getTeam(1));
                    tkobj.add(tnew);
                    setTeamA(t.getTeam(0));
                    setTeamB(t.getTeam(0));
                    this.result = res.getString("Result");
                    MatchDetails m = new MatchDetails(type, time, date, t.getTeam(0), t.getTeam(1), result);
                    mkobj.add(m);
                    g.setName(res.getString("GroundName"));
                    g.setVenue(res.getString("Venue"));
                    g.setTotalcapacity(res.getInt("TotalCapacity"));
                    Ground grnd = new Ground(g.getName(), g.getVenue(), g.getTotalcapacity());
                    gobj.add(grnd);
                    totalKnockoutMatches++;
                } else {
                    this.type = res.getString("Type");
                    this.date = res.getString("Date");
                    this.time = res.getString("Time");
                    t.addTeam(0, res.getString("TeamA"));
                    t.addTeam(1, res.getString("TeamB"));
                    Teams tnew = new Teams(t.getTeam(0), t.getTeam(1));
                    tkobj.add(tnew);
                    setTeamA(t.getTeam(0));
                    setTeamB(t.getTeam(0));
                    this.result = res.getString("Result");
                    MatchDetails m = new MatchDetails(type, time, date, t.getTeam(0), t.getTeam(1), result);
                    mkobj.add(m);
                    g.setName(res.getString("GroundName"));
                    g.setVenue(res.getString("Venue"));
                    g.setTotalcapacity(res.getInt("TotalCapacity"));
                    Ground grnd = new Ground(g.getName(), g.getVenue(), g.getTotalcapacity());
                    gobj.add(grnd);
                    totalKnockoutMatches++;
                }
            }
            setTkobj(tkobj);
            setMkobj(mkobj);
            setGobj(gobj);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return totalKnockoutMatches;
    }

    public ArrayList<MatchDetails> getMkobj() {
        return mkobj;
    }

    public void setMkobj(ArrayList<MatchDetails> mkobj) {
        this.mkobj = mkobj;
    }

    public ArrayList<Teams> getTkobj() {
        return tkobj;
    }

    public void setTkobj(ArrayList<Teams> tkobj) {
        this.tkobj = tkobj;
    }

    public Teams getT() {
        return t;
    }

    public void setT(Teams t) {
        this.t = t;
    }

    public String resultString() {
        return type + "\n" + getTeamA() + " VS " + getTeamB() + "\n" + date + "\n" + result;
    }

    @Override
    public String toString() {
//        System.out.println(g.toString());
        return type + "\n" + getTeamA() + " VS " + getTeamB() + "\n" + time + "\n" + date;
    }

}
