
import java.util.*;


class No{
    String conteudo;
    No prox;
    No ant;
    
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
 class FilaEnc{
    private No inicio;
    private No fim;
    private int nElementos;
    
    public FilaEnc(){
    inicio = null;
    fim = null;
    nElementos = 0;
    }
       
    public boolean vazia() {
        if (nElementos == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int tamanho() {
        return nElementos;
    }
    
   
    public void insereInc(String comando){
        No aux = new No();
        aux.setConteudo(comando);
        if(vazia()){
           
            inicio = aux;
            fim = aux;
            aux.setProx(inicio);
            aux.setAnt(fim);
            nElementos++;
        }
        else{
            
            aux.setAnt(inicio); 
            inicio.setProx(aux); 
            inicio = aux; 
            nElementos++;
        }
    }
    
    
        
    
    
    public void insereFim(String elemento){
        No aux = new No();
        aux.setConteudo(elemento);
        if(vazia()){            
            inicio = aux;
            fim = aux;
            aux.setProx(inicio);
            aux.setAnt(fim);
            nElementos++;
        }
        else{
            aux.setProx(fim);
            fim.setAnt(aux); 
            fim = aux; 
            nElementos++;
        }
    }
    
    public String removeInc(){
        if(vazia()){
            return null;
        }
        else{
            No aux = inicio; 
            inicio = inicio.getAnt();
            nElementos--;
            return aux.getConteudo();
        }
    }
    
    public String removeFim(){
        if(vazia()){
            return null;
        }
        else{
            No aux = fim;
            fim = fim.getProx(); 
            nElementos--;
            return aux.getConteudo();
        }
    }
    
     
}

    


public class Exercicio5 {

    public static void main(String[] args) {
            FilaEnc fila = new FilaEnc();
            String input[];
            int n;
            Scanner scan = new Scanner(System.in);        
            
            n = Integer.parseInt(scan.nextLine());
            
            boolean revert = false;
                    
                    
        for(int i = 0; i < n; i++){
            input = scan.nextLine().split(" ");
            
            
                    switch (input[0]) {
                        case "toFront":
                            if(revert){                        
                        fila.insereFim(input[1]);
                        break;
                    }
                            fila.insereInc(input[1]);
                            break;
                        case "front":
                            if(fila.vazia()){
                                System.out.println("No job for Ada?");
                            }else  if(revert){                        
                                System.out.println(fila.removeFim());
                                break;
                            }else{
                                System.out.println(fila.removeInc());
                            }       break;
                        case "push_back":
                             if(revert){                        
                        fila.insereInc(input[1]);
                        break;
                    }
                            fila.insereFim(input[1]);
                            break;
                        case "back":
                            if(fila.vazia()){
                                System.out.println("No job for Ada?");
                            }else if(revert){                        
                                System.out.println(fila.removeInc());
                                break;
                            }else{
                                System.out.println(fila.removeFim());
                            }          break;
                        case "reverse":
                           revert = !revert;
                            break;
                        default:
                            break;
                    }
        }
    }
}
