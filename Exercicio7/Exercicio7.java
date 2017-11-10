
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
public class Exercicio7 {
    static String s;
    static int n, aux, output;
    
    public static int max(int p, int q){
    
     return p > q ? p : q;
    
    }
    
    
    
    public static int tamanho(){
        if (s.charAt(output++) =='l'){
            return 1;
        }else{
            return max(tamanho(), tamanho())+1;
        }
                    }
    public static void main(String[] args){
        try{
       
            Scanner scan = new Scanner(System.in);
            boolean agrvai;            
            
            
             n = Integer.parseInt (scan.nextLine());
          
            for(int i = 0; i <= n; i++){
             s = scan.nextLine();
                
                output = 0;
                
                if (s.equals("l")) {
                    System.out.println(0);                  
                    continue;
                }
                
                System.out.println(tamanho() -1);
            } 
        }catch(Exception e){}
            
}}
