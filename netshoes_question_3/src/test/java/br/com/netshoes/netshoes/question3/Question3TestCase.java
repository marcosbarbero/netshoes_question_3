package br.com.netshoes.netshoes.question3;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.logging.Logger;

import junit.framework.Assert;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

/**
 * Teste unitário para a implementação do algoritmo da questão 3.
 * 
 * @author marcos.salomao
 */
public class Question3TestCase {
	
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(Question3TestCase.class.getCanonicalName());
	
    /**
     * Método genérico para auxílio aos testes.
     */
	private char testFirstChar(Stream stream) throws UniqueCharNotFoundException {

		long time = System.currentTimeMillis();

		char c = Question3App.firstChar(stream);

		LOGGER.info(String.format(
				"Identificado primeiro caracter único '%s' com tempo de %d ms de execução.", 
				c, (System.currentTimeMillis() - time)));

		return c;
	}

	/**
	 * Buscar caracter do exemplo.
	 */
    @Test
    public void buscarCaracter() {
	
		try {
		
			char c = testFirstChar(new StringStream("aAbBABac"));

			Assert.assertEquals('b', c);
			
		} catch (UniqueCharNotFoundException e) {
			Assert.fail(e.getLocalizedMessage());
		}
	
    }

	/**
	 * Buscar caracter onde esteja na primeira posição.
	 */
    @Test
    public void buscarCaracterPrimeiraPosicao() {
	
		try {
			
			char c = testFirstChar(new StringStream("baABABac"));

			Assert.assertEquals('b', c);
			
		} catch (UniqueCharNotFoundException e) {
			Assert.fail(e.getLocalizedMessage());
		}
	
    }
    
	/**
	 * Buscar caracter onde esteja na última posição.
	 */
    @Test
    public void buscarCaracterUltimaPosicao() {
	
		try {
			
			char c = testFirstChar(new StringStream("aABABac"));

			Assert.assertEquals('c', c);
			
		} catch (UniqueCharNotFoundException e) {
			Assert.fail(e.getLocalizedMessage());
		}
	
    }
    
	/**
	 * Buscar caracter onde stream seja grande.
	 */
    @Test
    public void buscarCaracterBigStream() {
	
		try {
			
			StringBuilder builder = new StringBuilder();
			char firstChar = '0';
			
			// Gerar string com 100 mil linhas por 1000 colunas
			for (int i = 0; i < 100000; i++) {
				builder.append(RandomStringUtils.random(
						1000, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
			}
			
			// Em posição aleatória, inserir o caracter '0'
			int offset = new Random().nextInt(builder.length());
			builder.insert(offset, firstChar);

			// Obter tamanho da Stream em Kb
			long tamanhoStreamKb = (builder.toString().getBytes("UTF-8").length/1024);
			
			LOGGER.info(String.format("Gerado stream de tamanho %d kb.", tamanhoStreamKb));
			LOGGER.info(String.format("Inserido caracter '%s' na posição %d.", firstChar, offset));
			
			// realizar teste
			char c = testFirstChar(new StringStream(builder.toString()));

			// Validar
			Assert.assertEquals(firstChar, c);
			
		} catch (UniqueCharNotFoundException e) {
			Assert.fail(e.getLocalizedMessage());
		} catch (UnsupportedEncodingException e) {
			Assert.fail(e.getLocalizedMessage());
		}
	
    }
    
	/**
	 * Teste inverso.
	 */
    @Test
    public void testeInverso() {
	
		try {
			
			testFirstChar(new StringStream("aABABa"));
			Assert.fail("Localizou caracter incorretamente!");
			
		} catch (UniqueCharNotFoundException e) {
			// Erro esperado
			LOGGER.info(e.getMessage());
		}
	
    }
    
}
