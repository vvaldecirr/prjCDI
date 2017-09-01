package dados;

import java.util.Random;

public class Exemplo implements Comparable {
	private int valor;

	public Exemplo() {
		Random r = new Random();
		this.setValor(r.nextInt() % 100);
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Exemplo [valor=" + valor + "]";
	}
	
	public int compareTo(Object o) {
		if(o instanceof Exemplo)
			return this.valor - ((Exemplo)o).valor;
		return -1;
	}
}
