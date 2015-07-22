package br.com.netshoes.netshoes.question3;

import java.util.Arrays;

/**
 * Classe com o algoritmo de resolução da questão 3.</br> </br> Dada uma stream,
 * encontre o primeiro caracter que no se repita no resto da stream. O termino
 * da leitura da stream deve ser garantido atraves do metodo hasNext(), ou seja,
 * retorna falso para o termino da leitura da stream.
 * 
 * @author Marcos Salomão (salomao.marcos@gmail.com)
 */
public class Question3App {

	/**
	 * Retornar o primeiro caracter que não possui repetição no stream.</br>
	 * 
	 * @param input
	 *            Stream a ser analisado.
	 * @return primeiro caracter que não possui repetição no stream.
	 * @throws CharNotFoundException
	 *             Exceção indicando que não foi encontrado cenário que
	 *             atendesse o requisito.
	 */
	public static char firstChar(Stream input)
			throws UniqueCharNotFoundException {

		// inicialização das variáveis
		char c;
		int size = 5, index = 0;
		int found;

		// Array dos caracters encontrados na stream
		char[] chars = new char[size];

		// Array de controle, que indica se a quantidade dos caracteres
		// repetidos
		short[] quantidadeCharsRepetidos = new short[size];

		// Realizar toda iteração do stream
		while (input.hasNext()) {

			// Obter caracter pelo índice do cursor
			c = input.getNext();

			// Verificar se ele já possui na array
			found = indexOf(c, chars);

			// Se já existe, logo é repetido, portanto é atribuído +1 ao array
			// de controle
			if (found >= 0) {
				quantidadeCharsRepetidos[found]++;
			} else {

				// Senão existe ainda é adicionado ao array de controle
				chars[index] = c;
				quantidadeCharsRepetidos[index]++;
				index++;
			}

			// Redimencionar array quando necessário
			if (index == chars.length) {
				chars = Arrays.copyOf(chars, chars.length + size);
				quantidadeCharsRepetidos = Arrays.copyOf(quantidadeCharsRepetidos, chars.length + size);
			}

		}

		// Identificar o primeiro caracter que não esteja repetido
		int firstCharIndex = indexOfFirst(quantidadeCharsRepetidos);

		// Informar o usuário que não há caracter que não se repete
		if (firstCharIndex < 0) {
			throw new UniqueCharNotFoundException();
		}

		// Retornar o caracter
		return chars[firstCharIndex];
	}

	/**
	 * Retorna índice do primeiro caracter que se apresenta apenas uma vez.
	 * 
	 * @param quantidadeCharsRepetidos
	 *            Array com a quantidade de ocorrências do caracter (índice do array).
	 * @return Posição identificada.
	 */
	private static int indexOfFirst(short[] quantidadeCharsRepetidos) {
		for (int i = 0; i < quantidadeCharsRepetidos.length; i++) {
			if (quantidadeCharsRepetidos[i] == 1) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Pesquisa do caracter no array.
	 * 
	 * @param c
	 *            Caracter a ser pesquisado.
	 * @param chars
	 *            Array com os caracters.
	 * @return Posição identificada.
	 */
	private static int indexOf(char c, char[] chars) {
		for (int i = 0; i < chars.length; i++) {
			if (c == chars[i]) {
				return i;
			}
		}
		return -1;
	}

}
