package ticketbookingsystem;

import java.util.ArrayList;

public class Teams {

    ArrayList<String> tName;

    public Teams() {
        tName = new ArrayList<>();
    }
     public Teams(String teamA, String teamB) {
        tName = new ArrayList<>();
        tName.add(teamA);
        tName.add(teamB);
    }

    public void addTeam(String team) {
        tName.add(team);
    }
    public String getTeam(int i){
        return tName.get(i);
    }
    public void addTeam(int i, String team){
        tName.add(i, team);
    }
    public String toString(){
        return "\n" + getTeam(0) + " VS " + getTeam(1)+"\n";
    }
}

