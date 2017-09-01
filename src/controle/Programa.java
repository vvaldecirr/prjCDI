package controle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

public class Programa {

	private static String nomeColecao;
	private static String nomeClasse;
	private static String numObjetos;

	private static Collection colecao;
	
	public static void carregarArquivoProperties() {
		try {
			Properties props = new Properties();
			InputStream in = Programa.class.getResourceAsStream("conf.properties");
			props.load(in);
			in.close();
			nomeColecao = props.getProperty("nomeColeção");
			nomeClasse = props.getProperty("nomeClasse");
			numObjetos = props.getProperty("numObjetos");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void instanciarObjetos() {
		try {
			//---- CDI - Injeção de Dependência ----//
			Class classeCollection = Class.forName(nomeColecao);
			Class classeObjetos = Class.forName(nomeClasse);
			int num = Integer.parseInt(numObjetos);
			
			//---- Inversão de Controle ----//
			colecao = (Collection)classeCollection.newInstance();
			for(int i = 0; i < num; i++) {
				Object obj = classeObjetos.newInstance();
				colecao.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public static void listarObjetos() {
		System.out.println("A coleção " + nomeColecao +
				           " tem " + numObjetos + " objetos:");
		for(Object o : colecao)
			System.out.println(o);
	}
	
	public static void main(String[] args) {
		carregarArquivoProperties();
		instanciarObjetos();
		listarObjetos();
	}
}















