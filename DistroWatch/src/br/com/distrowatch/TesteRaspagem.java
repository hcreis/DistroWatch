package br.com.distrowatch;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class TesteRaspagem {

	public static void main(String[] args) {
		LinkedHashMap<String, String> dados = Raspagem.getDadosDistroWatch("mint");
		
		for (Entry<String, String> valor : dados.entrySet()) {
			
			System.out.println("---------------------------------------------------");
			System.out.println("Chave: " + valor.getKey());
			System.out.println("Valor: " + valor.getValue());
			
		}
	}
}
