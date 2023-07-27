import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class BlackJack {

  static Scanner tastiera = new Scanner(System.in);
  static Scommesse scommesse = new Scommesse();
  static Stack<Carta> mazzo = new Stack<Carta>();

  public static void creaNuovoMazzo(Stack<Carta> mazzo)
    throws CartaNonValidaException {
    mazzo.clear();
    //creazione del mazzo
    for (int i = 1; i < 13; i++) {
      int j = i;
      if (i >= 10) {
        j = 10;
      }
      mazzo.add(new Carta(j, "Cuori"));
      mazzo.add(new Carta(j, "Fiori"));
      mazzo.add(new Carta(j, "Picche"));
      mazzo.add(new Carta(j, "Quadri"));
      mazzo.add(new Carta(j, "Cuori"));
      mazzo.add(new Carta(j, "Fiori"));
      mazzo.add(new Carta(j, "Picche"));
      mazzo.add(new Carta(j, "Quadri"));
    }
    //il mazzo viene mischiato
    Collections.shuffle(mazzo);
  }

  //gestione delle scommesse di un giocatore
  public static int scommessaGiocatore(Giocatore g, int numeroGiocatore) {
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

  //questo metodo viene chiamato alla fine di ogni mano, tutte le carte date vengono tolte
  public static void pulisciCarte(Giocatore[] giocatori) {
    for (int i = 0; i < giocatori.length; i++) {
      giocatori[i].cancellaMano();
    }
  }

  //autoesplicativo
  public static void stampaSoldiGiocatori(Giocatore[] giocatori) {
    int i = 1;
    for (Giocatore g : giocatori) {
      System.out.println("Giocatore " + i + " hai " + g.getSoldi() + " Euro");
      i++;
    }
  }

  //autoesplicativo
  public static int numeroGiocatori() {
    System.out.print("Quanti giocatori? ");
    int numeroGiocatori = tastiera.nextInt();
    if (numeroGiocatori <= 0) {
      System.out.println("inserisci un numero valido");
      numeroGiocatori = numeroGiocatori();
    }
    return numeroGiocatori;
  }

  //questo metodo fa un giro di carte però stampa anche tutti i valori delle carte date
  public static void giroDiCarteEsposte(Giocatore[] giocatori) {
    for (int i = 1; i < giocatori.length + 1; i++) {
      System.out.println(
        "Giocatore " + i + " Riceve " + mazzo.peek().toString()
      );
      giocatori[i - 1].riceviCarta(mazzo.pop());
    }
  }

  //giro di carte non esposte, il giocatore decide se prendere carta o fermarsi
  public static void giroDiCarte(Giocatore[] giocatori) {
    char scelta = ' ';
    for (int i = 1; i < giocatori.length + 1; i++) {
      while (giocatori[i - 1].sommaValori() <= 21 && scelta != 'f') {
        giocatori[i - 1].stampaMano();
        System.out.println("Attualmente il valore delle tue carte è: "+giocatori[i-1].sommaValori());
        System.out.print(
          "Giocatore " + i + " carta o ti fermi? (carta=c, fermati=f) "
        );
        scelta = tastiera.next().toLowerCase().charAt(0);
        while (!(scelta == 'c' || scelta == 'f')) {
          System.out.println("Riprova, non hai scelto nessuna delle 2...");
          System.out.print(
            "Giocatore " + i + " carta o ti fermi? (carta=c, fermarti=f) "
          );
          scelta = tastiera.next().toLowerCase().charAt(0);
        }
        if (scelta == 'c') {
          giocatori[i - 1].riceviCarta(mazzo.pop());
        } else {
          System.out.println(
            "Giocatore " + i + " Si ferma con " + giocatori[i - 1].sommaValori()
          );
        }
      }
    }
  }

  public static void main(String[] args) throws CartaNonValidaException {
    creaNuovoMazzo(mazzo);
    int scommessa;
    Dealer dealer = new Dealer();
    char tasto = ' ';
    Giocatore giocatori[] = new Giocatore[numeroGiocatori()];
    for (int i = 1; i < giocatori.length + 1; i++) {
      System.out.print("Giocatore " + i + " con quanti soldi vuoi iniziare? ");
      giocatori[i - 1] = new Giocatore(tastiera.nextInt());
    }
    while (tasto != 'x') {
      pulisciCarte(giocatori);
      for (int i = 1; i < giocatori.length + 1; i++) {
        scommessa = scommessaGiocatore(giocatori[i - 1], i);
        giocatori[i - 1].riceviCarta(mazzo.pop());
        giocatori[i - 1].rimuoviSoldi(scommessa);
      }
      dealer.riceviCarta(mazzo.pop());
      System.out.println("Carte coperte date, ora il giro di carte scoperte");
      giroDiCarteEsposte(giocatori);
      giroDiCarte(giocatori);
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
