public class Carta {
    private int valore;
    private String seme;
    public Carta(int v, String s){
        setSeme(s);
        setValore(v);
    }
    public int getValore() {
        return valore;
    }
    public void setValore(int valore) {
        this.valore = valore;
    }
    public String getSeme() {
        return seme;
    }
    public void setSeme(String seme) {
        this.seme = seme;
    }
    
}
