import java.util.ArrayList;

public class Giocatore {

  private ArrayList<Carta> mano;
  private int soldi;

  public Giocatore(int soldi) {
    mano = new ArrayList<Carta>();
    setSoldi(soldi);
  }

  public ArrayList<Carta> getMano(){
    return mano;
  }
  public int getSoldi() {
    return soldi;
  }

  private void setSoldi(int soldi) {
    if (soldi > 0) {
      this.soldi = soldi;
    }
  }

  public void riceviCarta(Carta c) {
    if (c != null) {
      mano.add(c);
      if (sommaValori() > 21) {
        System.out.println(
          "Hai sforato con " + c.toString() + ", la tua mano vale " + sommaValori()
        );
      }
    } else {
      System.out.println(
        "Finito il mazzo, riapri il gioco per fare una nuova partita"
      );
    }
  }

  public void stampaMano() {
    System.out.println("la tua mano è: ");
    for (Carta carta : mano) {
      System.out.println("- " + carta.toString());
    }
  }

  public int sommaValori() {
    int somma = 0;
    if (mano.size() == 2) {
      if (
        (mano.get(0).getValore() == 1 || mano.get(1).getValore() == 1) &&
        (mano.get(0).getValore() == 10 || mano.get(1).getValore() == 10)
      ) {
        return 21;
      }
    }
    for (Carta carta : mano) {
      somma += carta.getValore();
    }
    return somma;
  }

  public void cancellaMano() {
    mano.clear();
  }

  public void rimuoviSoldi(int valore) {
    setSoldi(getSoldi() - valore);
  }

  public void aggiungiSoldi(int valore){
    rimuoviSoldi(-valore);
  }
}
