
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author arman
 */
public class Exercicio3 {

    static class No {

        private No ant;
        private String conteudoAnterior;
        private String conteudo;
        private No prox;
        private String conteudoProximo;

        public String getConteudoAnterior() {
            return conteudoAnterior;
        }

        public void setConteudoAnterior(String anterior) {
            this.conteudoAnterior = anterior;
        }

        public String getConteudoProximo() {
            return conteudoProximo;
        }

        public void setconteudoProximo(String proximo) {
            this.conteudoProximo = proximo;
        }

        public No() {
            setProx(null);
        }

        public String getConteudo() {
            return conteudo;
        }

        public void setConteudo(String conteudo) {
            this.conteudo = conteudo;
        }

        public No getProx() {
            return prox;
        }

        public void setProx(No prox) {
            this.prox = prox;
        }

        public No getAnt() {
            return ant;
        }

        public void setAnt(No ant) {
            this.ant = ant;
        }

        

        
    }

    static class LDE {

        private No inicio;
        private No fim;
        private int tamanho;

        public LDE() {
            inicio = null;
            fim = null;
            tamanho = 0;
        }

        /**
         * Verifica se a Lista está vazia
         */
        public boolean vazia() {
            if (tamanho == 0) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * Obtém o tamanho da Lista
         */
        public int tamanho() {
            return tamanho;
        }

        /**
         * Obtém o i-ésimo elemento de uma lista Retorna o valor encontrado.
         */
        public No elemento(int pos) {
           if (pos > tamanho) {
            return null;
        }

	No n = inicio;
	for (int i = 0; i < pos; ++i) {
            n = n.getProx();
	}
	return n;
        }

        /**
         * Retorna a posição de um elemento pesquisado. Retorna 0 caso não seja
         * encontrado
         */
        public int posicao(int dado) {
            int cont = 1;
            No aux;

            /* Lista vazia */
            if (vazia()) {
                return -1;
            }

            /* Percorre a lista do inicio ao fim até encontrar o elemento*/
            aux = inicio;
            while (aux != null) {
                /* Se encontrar o elemento, retorna sua posicao n;*/
                if (aux.getConteudo().equals(dado)) {
                    return cont;
                }

                /* modifica "aux" para apontar para o proximo elemento da lista */
                aux = aux.getProx();
                cont++;
            }

            return -1;
        }

        
        public void insere(No dado) {
            
            if (tamanho != 0){ 
            No aux = inicio;
            while(aux.getProx() != null){
               aux = aux.getProx();
             }
               dado.setProx(null);
               aux.setProx(dado);
               dado.setAnt(fim);
               fim.setProx(dado);
               fim = dado;
               ++tamanho;
        
        }else{
           dado.setProx(inicio);
           dado.setAnt(null);
           fim = dado;
           inicio = dado;
           tamanho++;
        }
        }

        // Remove elemento do início de uma lista unitária
        private String removeInicioListaUnitaria() {
            String dado = inicio.getConteudo();
            inicio = null;
            fim = null;
            tamanho--;
            return dado;
        }

        /**
         * Remove elemento do início da lista
         */
        private String removeInicioLista() {
            No p = inicio;

            // Dado recebe o dado removido
            String dado = p.getConteudo();

            // Retira o 1o elemento da lista (p)
            inicio = p.getProx();
            p.getProx().setAnt(null);  // Nova instrucao

            tamanho--;

            // Sugere ao garbage collector que libere a memoria
            //  da regiao apontada por p
            p = null;

            return dado;
        }

        /**
         * Remove elemento no meio da lista
         */
        private String removeMeioLista(int pos) {
            No p = inicio;
            int n = 1;

            // Localiza o nó que será removido
            while ((n <= pos - 1) && (p != null)) {
                p = p.getProx();
                n++;
            }

            if (p == null) {
                return "-1"; // pos. inválida
            }

            String dado = p.getConteudo();
            p.getAnt().setProx(p.getProx());
            p.getProx().setAnt(p.getAnt());

            tamanho--;

            /* sugere ao garbage collector que libere a memoria
	     *  da regiao apontada por p*/
            p = null;
            return dado;
        }

        /**
         * Remove elemento do início da lista
         */
        private String removeFimLista() {
            No p = fim;
            String dado = p.getConteudo();

            fim.getAnt().setProx(null);
            fim = fim.getAnt();
            tamanho--;

            p = null;
            return dado;
        }

        /**
         * Remove um elemento de uma determinada posição Retorna o valor a ser
         * removido. -1 se a posição for inválida ou a lista estiver vazia
         */
        public String remove(int pos) {
            // Lista vazia 
            if (vazia()) {
                return "-1";
            }

            // Remoção do elemento da cabeça da lista 
            if ((pos == 1) && (tamanho() == 1)) {
                return removeInicioListaUnitaria();
            } else if (pos == 1) {
                return removeInicioLista();
            } // Remocao no fim da lista
            else if (pos == tamanho()) {
                return removeFimLista();
            } // Remoção em outro lugar da lista
            else {
                return removeMeioLista(pos);
            }
        }
    }
    
     static class PilhaEnc {
	No topo;
	int nElementos;
	
	public PilhaEnc(){
		topo = null;
		nElementos = 0;
	}
	
	/** Verifica se a Pilha está vazia*/
	public boolean vazia () {
	    if (nElementos == 0)
	        return true;
	    else
	        return false;
	}

	/** Obtém o tamanho da Pilha*/
	
	public String top (){
	    if (vazia()){
	        return "-1"; // Pilha vazia 
	    }

	    return topo.getConteudo();
	}

	/** Insere um elemento no topo da pilha.
	    Retorna true se a insercao funcionar*/
	public boolean push(String rara) {
	    
		// Aloca memoria para novo no e preenche conteudo 
	    No novoNo = new No();
	    novoNo.setConteudo(rara);

	    // Faz o novo no apontar pro atual topo da pilha
	    novoNo.setProx(topo);
	    
	    // Atualiza o topo da pilha que agora sera o novo nó 
	    topo = novoNo;

	    // Atualiza o tamanho da pilha 
	    nElementos++;
	    return true;
	}

	/** Retira o elemento do topo da pilha.
	    Retorna -1 se a pilha estiver vazia.
	    Caso contrário retorna o valor removido */
	public String pop () {
	    if (vazia()) {
	    		return "-1"; // pilha vazia 
	    }
	    // Guarda o nó que é topo da pilha e o seu conteudo
	    No p = topo;
	    String valor = p.getConteudo();

	    /* Modifica o topo da pilha para ser o proximo elemento (2o elemento da pilha) */
	    /* Isso equivale a retirar o 1o elemento (topo) da pilha */
	    topo = p.getProx();

	    // Decrementa o tamanho da pilha 
	    nElementos--;

	    /* sugere ao garbage collector que libere a memoria
	     *  da regiao apontada por p*/
	    p= null;

	    return valor;
	}

}
    

    public static void main(String[] args) {

        LDE lista = new LDE();
        Scanner scan = new Scanner(System.in);
        

        String input1 = scan.nextLine();
        No ptr1 = new No();
        int marca1 = input1.indexOf(" ");
        String pedaco1 = input1.substring(0, marca1);
        ptr1.setConteudo(pedaco1);
        int marca2 = input1.lastIndexOf(" ");
        String pedaco2 = input1.substring(marca1 + 1, marca2);
        ptr1.setConteudoAnterior(pedaco2);
        String ultPedaco1 = input1.substring(marca2 + 1, input1.length());
        ptr1.setconteudoProximo(ultPedaco1);
        lista.insere(ptr1);
        // ptr1 a cima e ptr2 a baixo
        String input2 = scan.nextLine();
        No ptr2 = new No();
        int marca3 = input2.indexOf(" ");
        String pedaco3 = input2.substring(0, marca3);
        ptr2.setConteudo(pedaco3);        
        int marca4 = input2.lastIndexOf(" ");
        String pedaco4 = input2.substring(marca3 + 1,marca4);
        ptr2.setConteudoAnterior(pedaco4);        
        String ultPedaco2 = input2.substring(marca4 + 1,input2.length());
        ptr2.setconteudoProximo(ultPedaco2);        
        lista.insere(ptr2);
        
        
        while(true){
          
            String inputs = scan.nextLine();
            if(inputs.isEmpty()){
                break;
            }
            
            No oxe = new No();
                               
            int marcaConte = inputs.indexOf(" ");
            String pedaco5 = inputs.substring(0, marcaConte);
            oxe.setConteudo(pedaco5);        
            int marcaAnte = inputs.lastIndexOf(" ");
            String pedaco6 = inputs.substring(marcaConte + 1,marcaAnte);
            oxe.setConteudoAnterior(pedaco6);
            String ultPedaco3 = inputs.substring(marcaAnte + 1,inputs.length());
            oxe.setconteudoProximo(ultPedaco3);           
            lista.insere(oxe);
        }
            PilhaEnc pilha = new PilhaEnc();
            int contador = 0;
            boolean teste1 = true;
            while(teste1){
            No voltando = ptr1;
            if(voltando != ptr2){
            		
		for (int i = 0; i < lista.tamanho(); i++) {                    
			if (voltando.getConteudoProximo().equals(lista.elemento(i).getConteudo())) {
                                
				pilha.push(lista.elemento(i).getConteudo());				
                                break;                                
			}
		}
		
		if (contador > lista.tamanho()) {			
			break;
		}
                ++contador;
	}
            else{teste1 = false;}   }
            
            
            int contador0 = 0;
            boolean teste2 = true;
            while(teste2){
            No voltando = ptr1;
            if(voltando != ptr2){
            		
		for (int i = 0; i < lista.tamanho(); i++) {                    
			if (voltando.getConteudoProximo().equals(lista.elemento(i).getConteudo())) {
                                
				pilha.pop();				
                                break;                                
			}
		}
		
		if (contador0 > lista.tamanho()) {			
			break;
		}
                ++contador0;
	}
            else{teste2 = false;}   }
        
        
        
            if(pilha.vazia()){
                System.out.println("sana");
            
            }else{
                System.out.println("insana");}
            
            
            
        }
        
        
        
        
        
        
    
    
    

   

}
