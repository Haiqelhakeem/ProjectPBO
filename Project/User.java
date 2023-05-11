package Project;
public class User {
    private String UIDuser;
    private String PINuser;
    int saldo;

    public User(String UIDuser, String PINuser, int saldo){
        this.PINuser = PINuser;
        this.UIDuser = UIDuser;
        this.saldo = saldo;
    }

    String getUID(){
        return UIDuser;
    }

    String getPIN(){
        return PINuser;
    }
}
