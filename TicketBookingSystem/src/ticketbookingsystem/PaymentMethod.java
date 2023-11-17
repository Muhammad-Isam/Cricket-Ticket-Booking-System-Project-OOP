package ticketbookingsystem;


public class PaymentMethod {
private String type;
private int accID;

    public PaymentMethod(String type, int accID) {
        this.type = type;
        this.accID = accID;
    }
    public PaymentMethod(){
        
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }
    

}
