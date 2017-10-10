
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */

   public class Exercicio4 {
       
       static class No {
	private int conteudo;
	private No prox;
	
	public No(){
		setProx(null);
	}

	public int getConteudo() {
		return conteudo;
	}

	public void setConteudo(int conteudo) {
		this.conteudo = conteudo;
	}

	public No getProx() {
		return prox;
	}

	public void setProx(No prox) {
		this.prox = prox;
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
	    if(nElementos == 0)
	        return true;
	    else
	        return false;
	}

	/** Obtém o tamanho da Pilha*/
	public int tamanho() {
	    return nElementos;

	/*  No p = topo;
	    	int i = 0;
	    	while(p != null){
	       p = p.getProx();
	       i++;
	    }
	    return i;
	*/
	}

	/** Consulta o elemento do topo da Pilha
	    Retorna -1 se a pilha estiver vazia.*/
	public int top (){
	    if (vazia()){
	        return -1; // Pilha vazia 
	    }

	    return topo.getConteudo();
	}

	/** Insere um elemento no topo da pilha.
	    Retorna true se a insercao funcionar*/
	public boolean push(char letra) {
	    
		// Aloca memoria para novo no e preenche conteudo 
	    No novoNo = new No();
	    novoNo.setConteudo(letra);

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
	public char pop () {
	    
	    // Guarda o nó que é topo da pilha e o seu conteudo
	    No p = topo;
	    char letra = (char) p.getConteudo();

	    /* Modifica o topo da pilha para ser o proximo elemento (2o elemento da pilha) */
	    /* Isso equivale a retirar o 1o elemento (topo) da pilha */
	    topo = p.getProx();

	    // Decrementa o tamanho da pilha 
	    nElementos--;

	    /* sugere ao garbage collector que libere a memoria
	     *  da regiao apontada por p*/
	    p = null;

	    return letra;
	}

}


	public static void main(String[] args){

	
	String	normal = new String();
	int entradas;
        
        
        
        
        Scanner scan = new Scanner(System.in);
	entradas = scan.nextInt();
	
	while(entradas > 0){
            
	normal = scan.next();
	
        PilhaEnc pilha = new PilhaEnc();
	String saida = new String();
	
		
	for(int i = 0; i < normal.length(); i ++){
            
        
	if(normal.charAt(i) == '(' || normal.charAt(i) == '+' || 
                normal.charAt(i) == '-' || normal.charAt(i) == '*' || 
                normal.charAt(i) == '/' || normal.charAt(i) == '^' || 
                normal.charAt(i) == ')' ){
        
            if(normal.charAt(i) == '('){
                
        }            
            if(normal.charAt(i) == '+'){
                pilha.push(normal.charAt(i));
                
        }
            if(normal.charAt(i) == '-'){
                pilha.push(normal.charAt(i));
                
        }
            if(normal.charAt(i) == '*'){
                pilha.push(normal.charAt(i));
                
        }
            if(normal.charAt(i) == '/'){
                pilha.push(normal.charAt(i));
                
        }
            if(normal.charAt(i) == '^'){
                pilha.push(normal.charAt(i));
                
        }
            if(normal.charAt(i) == ')'){
                saida = saida + pilha.pop();
                
        }
        
        }else{
                saida = saida + normal.charAt(i);
                
            }
           
		}	
			
		
                System.out.println(saida);
		entradas --;
		}
	}
}
    