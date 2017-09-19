/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;

/**
 *
 * @author aluno
 */
public class Exercicio1 {
    
    public static void main (String[] args){
        int n = 0;
        int[] s;
        int[] q;
        int[] a;
        int[] b;
        int ax = 0;
        int cont = 0;
        Scanner scan = new Scanner(System.in);
        
                
        
        n = Integer.valueOf(scan.nextLine());
        a = new int[n];
        s = new int[n]; 
         
        String input1[] = scan.nextLine().split(" ");        
        
        for(int i = 0; i < s.length; i++ ){  
            s[i] = Integer.parseInt(input1[i]);             
           }
           
        n = Integer.valueOf(scan.nextLine());   
        q = new int[n];
         
        String input2[] = scan.nextLine().split(" ");        
        
        for(int i = 0; i < q.length; i++ ){  
            q[i] = Integer.parseInt(input2[i]);             
           }
           
        for(int i = 0; i < s.length; i++){
                boolean aux = false;
           for(int j = 0; j < q.length; j++){
               
               if(s[i] == q[j]){
                   aux = true;
                   
               }
                
           }
              if(aux == false){
                  cont++;
                  a[cont-1] = s[i];
              }
        }
         
        b = new int[cont];
        
        for(int i = 0; i < cont; i++ ){
            b[i] = a[i];             
           }
        
        for(int i = 0; i < b.length; i++){
		for(int j = 0; j< b.length - 1; j++){
			if(b[j] > b[j + 1]){
				ax = b[j];
				b[j] = b[j+1];
				b[j+1] = ax;
			}
		}
	}
		
          
              
      String output = "";
        
      for(int i = 0; i < b.length; i++){
        output +=  "".concat(String.valueOf(b[i] + " "));
      }    
            System.out.println(output);
            
}
    
}