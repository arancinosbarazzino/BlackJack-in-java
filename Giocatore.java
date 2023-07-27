import java.util.ArrayList;

public class Giocatore {

  private ArrayList<Carta> mano;
  private int soldi;

  public Giocatore(int soldi) {
    mano = new ArrayList<Carta>();
    setSoldi(soldi);
  }

  public int getSoldi() {
    return soldi;
  }

  public void setSoldi(int soldi) {
    if (soldi > 0) {
      this.soldi = soldi;
    }
  }

  public void riceviCarta(Carta c) {
    if (sommaValori() <= 21) {
      mano.add(c);
    } else {
      System.out.println("Hai sforato");
    }
  }

  public void stampaMano() {
    for (Carta carta : mano) {
      System.out.println(carta.toString());
    }
  }

  public int sommaValori() {
    int somma = 0;
    for (Carta carta : mano) {
      somma += carta.getValore();
    }
    return somma;
  }
}
