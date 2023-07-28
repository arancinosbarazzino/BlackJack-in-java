import java.util.ArrayList;

public class Dealer {

  private ArrayList<Carta> mano;

  public Dealer() {
    mano = new ArrayList<Carta>();
  }

  public void riceviCarta(Carta c) {
    if (c != null) {
      mano.add(c);
      if (sommaValori() >= 21) {
        System.out.println(
          "Il dealer sfora con " + c.toString() + ", la sua mano vale " + sommaValori()
        );
      }
    } else {
      System.out.println(
        "Finito il mazzo, riapri il gioco per fare una nuova partita"
      );
    }
  }

  public void stampaMano() {
    System.out.println("mano del dealer: ");
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
}
