import java.util.ArrayList;

public class Dealer {

  private ArrayList<Carta> mano;

  public Dealer() {
    mano = new ArrayList<Carta>();
  }

  public void riceviCarta(Carta c) {
    if (c != null) {
      mano.add(c);
    }
  }

  public void stampaMano() {
    for (Carta carta : mano) {
      System.out.println(carta.toString());
    }
  }
}
