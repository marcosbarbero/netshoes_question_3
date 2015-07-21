package br.com.netshoes.netshoes.question3;

import org.junit.Test;

import br.com.netshoes.netshoes.question3.CharNotFoundException;
import br.com.netshoes.netshoes.question3.Question3App;
import br.com.netshoes.netshoes.question3.Stream;
import br.com.netshoes.netshoes.question3.StringStream;

/**
 * @author marcos.salomao
 */
public class Question3TestCase {

    @Test
    public void validar() {
	
	try {
	    Stream stream = new StringStream("aAbBABac");
	    
	    long time = System.currentTimeMillis();

	    char c = Question3App.firstChar(stream);
	    
	    System.out.println(String.format(
	    	"Identificado primeiro caracter único %s com tempo de %d ms de execução.",
	    	c, (System.currentTimeMillis() - time)));
	} catch (CharNotFoundException e) {
	    
	}
	
    }
    
    @Test
    public void validarPrimeiraPosicao() {
	
	try {
	    Stream stream = new StringStream("baABABac");
	    
	    long time = System.currentTimeMillis();

	    char c = Question3App.firstChar(stream);
	    
	    System.out.println(String.format(
	    	"Identificado primeiro caracter único %s com tempo de %d ms de execução.",
	    	c, (System.currentTimeMillis() - time)));
	} catch (CharNotFoundException e) {
	    
	}
	
    }
    
    @Test
    public void validarUltimaPosicao() {
	
	try {
	    Stream stream = new StringStream("aABABab");
	    
	    long time = System.currentTimeMillis();

	    char c = Question3App.firstChar(stream);
	    
	    System.out.println(String.format(
	    	"Identificado primeiro caracter único %s com tempo de %d ms de execução.",
	    	c, (System.currentTimeMillis() - time)));
	} catch (CharNotFoundException e) {
	    
	}
	
    }
    
    
}
