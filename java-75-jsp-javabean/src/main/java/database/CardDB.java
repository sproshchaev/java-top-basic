package database;

public class CardDB implements java.io.Serializable {
    private String clientName;

    public CardDB() {
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
