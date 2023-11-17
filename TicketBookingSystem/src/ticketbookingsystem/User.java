package ticketbookingsystem;

public class User {
    private String name, email, CNIC;

    public User(String name, String email, String CNIC) {
        this.name = name;
        this.email = email;
        this.CNIC = CNIC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    @Override
    public String toString() {
        return  "Name: "+getName()+ "\nCNIC: "+getCNIC()+"\nEmail: "+getEmail();
    }
    
}
