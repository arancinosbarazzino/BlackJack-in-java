import java.util.Hashtable;

public class Scommesse {

  private Hashtable<Integer, Integer> scommesse;

  public Scommesse() {
    scommesse = new Hashtable<>();
  }

  public boolean aggiungi(int valore, Giocatore giocatore) {
    if (valore > 0 && giocatore.getSoldi()-valore>=0) {
      scommesse.put(giocatore.hashCode(), valore);
      return true;
    }
    return false;
  }

  public void azzera(){
    scommesse.clear();
  }
}
