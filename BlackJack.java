import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class BlackJack {

  static Scommesse scommesse = new Scommesse();
  static Stack<Carta> mazzo = new Stack<Carta>();

  public static void creaNuovoMazzo(Stack<Carta> mazzo)
    throws CartaNonValidaException {
    mazzo.clear();
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

  public static int scommessaGiocatore(Giocatore g, int numeroGiocatore) {
    Scanner tastiera = new Scanner(System.in);
    System.out.print(
      "Giocatore " + numeroGiocatore + " quanto vuoi scommettere? "
    );
    int scommessa = tastiera.nextInt();
    while (scommesse.aggiungi(scommessa, g) == false) {
      System.out.println("Non hai abbastanza soldi per scommettere, riprova");
      System.out.print(
        "Giocatore " + numeroGiocatore + " quanto vuoi scommettere? "
      );
      scommessa = tastiera.nextInt();
    }
    return scommessa;
  }

  public static void pulisciCarte(Giocatore[] giocatori) {
    for (int i = 0; i < giocatori.length; i++) {
      giocatori[i].cancellaMano();
    }
  }

  public static void stampaSoldiGiocatori(Giocatore[] giocatori) {
    int i = 1;
    for (Giocatore g : giocatori) {
      System.out.println("Giocatore " + i + " hai " + g.getSoldi() + " Euro");
      i++;
    }
  }

  public static void main(String[] args) throws CartaNonValidaException {
    creaNuovoMazzo(mazzo);
    Scanner tastiera = new Scanner(System.in);
    int scommessa;
    Dealer dealer = new Dealer();
    char tasto = ' ';
    System.out.print("Quanti giocatori? ");
    int numeroGiocatori = tastiera.nextInt();
    Giocatore giocatori[] = new Giocatore[numeroGiocatori];
    for (int i = 1; i < numeroGiocatori + 1; i++) {
      System.out.print("Giocatore " + i + " con quanti soldi vuoi iniziare? ");
      giocatori[i - 1] = new Giocatore(tastiera.nextInt());
    }
    while (tasto != 'x') {
      pulisciCarte(giocatori);
      for (int i = 1; i < numeroGiocatori + 1; i++) {
        scommessa = scommessaGiocatore(giocatori[i - 1], i);
        giocatori[i - 1].riceviCarta(mazzo.pop());
        giocatori[i - 1].rimuoviSoldi(scommessa);
      }
      dealer.riceviCarta(mazzo.pop());
      System.out.println("Carte coperte date, ora il giro di carte scoperte");
      for (int i = 1; i < numeroGiocatori + 1; i++) {
        System.out.println(
          "Giocatore " + i + " Riceve " + mazzo.peek().toString()
        );
        giocatori[i - 1].riceviCarta(mazzo.pop());
      }
      System.out.print(
        "vuoi continuare? premi x per uscire o un altro tasto + invio per giocare di nuovo "
      );
      tasto = tastiera.next().toLowerCase().charAt(0);
      if (tasto != 'x') {
        scommesse.azzera();
        stampaSoldiGiocatori(giocatori);
      }
    }
    tastiera.close();
  }
}
