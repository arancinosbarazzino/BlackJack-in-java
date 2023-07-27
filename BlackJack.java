import java.util.ArrayList;

public class BlackJack {

  public static void main(String[] args) {
    ArrayList<Carta> mazzo = new ArrayList<Carta>();
    //creazione del mazzo
    for (int i = 1; i < 13; i++) {
      mazzo.add(new Carta(i, "Cuori"));
      mazzo.add(new Carta(i, "Fiori"));
      mazzo.add(new Carta(i, "Picche"));
      mazzo.add(new Carta(i, "Quadri"));
      mazzo.add(new Carta(i, "Cuori"));
      mazzo.add(new Carta(i, "Fiori"));
      mazzo.add(new Carta(i, "Picche"));
      mazzo.add(new Carta(i, "Quadri"));
    }
  }
}
