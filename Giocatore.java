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

  private void setSoldi(int soldi) {
    if (soldi > 0) {
      this.soldi = soldi;
    }
  }

  public void riceviCarta(Carta c) {
    if (sommaValori() <= 21) {
      mano.add(c);
    } else {
      System.out.println("sforato con "+ c.toString());
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
}
