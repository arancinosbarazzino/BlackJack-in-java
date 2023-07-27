import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BlackJack {

  public static void creaMazzo(ArrayList<Carta> mazzo) throws CartaNonValidaException {
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
    //il mazzo viene mischiato
    Collections.shuffle(mazzo);
  }

  public static void main(String[] args) throws CartaNonValidaException {
    ArrayList<Carta> mazzo = new ArrayList<Carta>();
    creaMazzo(mazzo);
    Scanner tastiera = new Scanner(System.in);
    System.out.println("Con quanti soldi vuoi iniziare?");
    Giocatore giocatore= new Giocatore(tastiera.nextInt()); 

    tastiera.close();
  }
}
