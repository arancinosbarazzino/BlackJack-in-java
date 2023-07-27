
public class CartaNonValidaException extends Exception{
    public CartaNonValidaException(){
        super();
    }
    public CartaNonValidaException(String errore){
        super(errore);
    }   
}
