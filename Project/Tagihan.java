package Project;
public abstract class Tagihan {
    private String namaTagihan;
    private int totalTagihan;

    public Tagihan(String namaTagihan, int totalTagihan){
        this.namaTagihan = namaTagihan;
        this.totalTagihan = totalTagihan;
    }

    public String getNamaTagihan(){
        return namaTagihan;
    }

    public int getTotalTagihan(){
        return totalTagihan;
    }
}
