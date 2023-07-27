public class Carta {

  private int valore;
  private String seme;

  public Carta(int v, String s) throws CartaNonValidaException {
    setSeme(s);
    setValore(v);
  }

  public int getValore() {
    return valore;
  }

  private void setValore(int valore) throws CartaNonValidaException {
    if (valore < 1 || valore > 13) throw new CartaNonValidaException(
      "Valore maggiore di 13 o minore di 1"
    );
    this.valore = valore;
  }

  public String getSeme() {
    return seme;
  }

  private void setSeme(String seme) throws CartaNonValidaException {
    if (
      !(
        seme.equals("Cuori") ||
        seme.equals("Fiori") ||
        seme.equals("Picche") ||
        seme.equals("Quadri")
      )
    ) throw new CartaNonValidaException("Seme non esistente");
    this.seme = seme;
  }

  public String toString() {
    return valore + " di " + seme;
  }
}
