package Exception;

/**
 *
 * @author Erick
 */

public class ErrorTipoDeDato extends NullPointerException {
    public ErrorTipoDeDato(){
        super ("El dato introducido es incorrecto, "
                + "solo se admiten numeros");    
       }
    public ErrorTipoDeDato(String msg){
        super(msg);
       }
}