package br.com.netshoes.netshoes.question3;

/**
 * Implementação da interface <code>Stream</code> 
 * para objetos <code>String</code>.
 * 
 * @author Marcos Salomão (salomao.marcos@gmail.com)
 */
public class StringStream implements Stream {

    /**
     * Stream.
     */
    private String stream;
    
    /**
     * Índice atual do cursor de leitura.
     */
    private int indexOf = 0;
    
    /**
     * Construtor com o <code>String</code>.
     * 
     * @param stream Stream.
     */
    public StringStream(String stream) {
	this.stream = stream;
    }
    
    /**
     * Retorna próximo caracter do stream.
     */
    public char getNext() {
	return this.stream.charAt(indexOf++);
    }

    /**
     * Possui mais caracteres a serem lidos.
     */
    public boolean hasNext() {
	return (this.stream.length() > indexOf);
    }

}
