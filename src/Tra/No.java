package Tra;

public class No {

	 private int valor;
	    private No filhoEsquerda;
	    private No filhoDireita;

	    // Acessores
	    public int getValor() {
	        return valor;
	    }
	    public void setValor(int valor) {
	        this.valor = valor;
	    }
	    public No getFilhoEsquerda() {
	        return filhoEsquerda;
	    }
	    public void setFilhoEsquerda(No filhoEsquerda) {
	        this.filhoEsquerda = filhoEsquerda;
	    }
	    public No getFilhoDireita() {
	        return filhoDireita;
	    }
	    public void setFilhoDireita(No filhoDireita) {
	        this.filhoDireita = filhoDireita;
	    }


	    // Construtores
	    public No(int valor) {
	        this.valor = valor;
	        this.filhoEsquerda = null;
	        this.filhoDireita = null;
	    }
		

	    // Override toString
	    @Override
		public String toString() {
			return + valor + ", filhoEsquerda=" + filhoEsquerda + ", filhoDireita=" + filhoDireita
					+ "]";
		}

	}


