package Tra;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Random;



public class Arvore {
private int i=0;

	private No raiz;

	public Arvore() {
		raiz = null;
		
	}

	public Arvore(No a) {
		raiz = a;
		
	}

	private boolean isEmpty() {
		if (raiz == null)
			return true;
		return false;

	}

	public int PreencherArvore() {
		Random gerador = new Random();
		for (int i = 0; i < 100; i++) {
			No a = new No(gerador.nextInt(100));
			if (isEmpty()) {
				raiz=a;
			}
			else if (!existe(a.getValor())) {
				 adicionar(raiz,a);
				 
			  }
		
		
			
		}
		return selecaonumero();
	}
	
	private int selecaonumero() {
		
		System.out.println("=====================================");
		 System.out.println("==============DivNum================");
		 System.out.println(" ==========O Jogo Adivinha========");
		 System.out.println("  ============Número===========");
		 Random gerador1=new Random();
		int selecao=gerador1.nextInt(100);
		
		return encontrar(selecao);
	}
	
	private int encontrar(int selecao) {
		Scanner ler =new Scanner(System.in);
		
		
	while (i!=7) {
		System.out.println("Qual é o numero certo?");
		int certo=ler.nextInt();
		
		if(selecao==certo) {
			System.out.println("Parabéns ! Numero correcto");
			return certo;
			
		} 
		
		if (selecao>certo) {
			System.out.println ("   Baixo");
			
		}else if (selecao <certo) {
			System.out.println("	Alto");
		}
		 i++;
       
		return encontrar(selecao);
	
		
		
}
		System.out.println ("Esgotou o nivel maximo de tentativas, tente outra vez! ");
		
		 return escolha(selecao);
	}
		
	
	
	private int escolha(int selecao) {
		
		Scanner ler =new Scanner(System.in);
		System.out.println("Deseja ver o numero certo (1 S || 0 N )?");
		int resposta=ler.nextInt();
		
		if (resposta ==1 ) {
			System.out.println(" Numero escolhido " + selecao);
	
		}
		System.out.println ("Vamos recomeçar o jogo");
		i=0;
		return PreencherArvore();	
		
	}
	
	

	
	public boolean existe(int valor) {
		return existe(raiz, valor);
	}

	private boolean existe(No raiz, int valor) {
		if (raiz == null)
			return false;

		if (raiz.getValor() == valor)
			return true;

		boolean res1 = existe(raiz.getFilhoEsquerda(),valor);
		if (res1)
			return true;

		boolean res2 = existe(raiz.getFilhoDireita(), valor);

		return res2;
	}

		
		
			
	

	private No adicionar(No raiz, No a) {
		
		if (isEmpty()) {
			raiz = a;
		}
		if (raiz.getValor() > a.getValor()) {
			// Segue pela esquerda
			if (raiz.getFilhoEsquerda() == null) {
				raiz.setFilhoEsquerda(a);
			} else
				adicionar(raiz.getFilhoEsquerda(), a);

		} else if (raiz.getValor() < a.getValor()) {
			// Segue pela direita
			if (raiz.getFilhoDireita() == null) {
				raiz.setFilhoDireita(a);
			} else
				adicionar(raiz.getFilhoDireita(), a);
		}

		return a;
	}



	public LinkedList<No> travessiaLargura() {
		LinkedList<No> nodes = new LinkedList<>();
		for (int i = 0; i < alturaArvore(raiz); i++) {
			travessiaLargura(raiz, nodes, i);
		}
		return nodes;
	}

	private int alturaArvore(No raiz) {
		if (raiz == null) {
			return 0;
		} else {
			return 1 + Math.max(alturaArvore(raiz.getFilhoEsquerda()), alturaArvore(raiz.getFilhoDireita()));
		}
	}

	private void travessiaLargura(No raiz, LinkedList<No> nodes, int level) {
		if (raiz == null)
			return;
		if (level == 0)
			visita(raiz, nodes);
		else if (level > 0) {
			travessiaLargura(raiz.getFilhoEsquerda(), nodes, level - 1);
			travessiaLargura(raiz.getFilhoDireita(), nodes, level - 1);
		}
	}

	private void visita(No no, LinkedList<No> nosVisitados) {
		nosVisitados.add(no);
	}

}
