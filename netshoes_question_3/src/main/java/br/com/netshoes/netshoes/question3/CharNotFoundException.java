package br.com.netshoes.netshoes.question3;

/**
 * Exceção lançada quando não for identificado caracter repetido.
 * 
 * @author Marcos Salomão (salomao.marcos@gmail.com).
 */
@SuppressWarnings("serial")
public class CharNotFoundException extends Exception {

    /**
     * Construtor padrão.
     */
    public CharNotFoundException() {
	super("Durante a análise não foi encontrato caracter que não tivesse repetição.");
    }
    
}
