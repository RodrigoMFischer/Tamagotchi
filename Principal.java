/** Aluno: Rodrigo Marion Fischer
 *  Algoritmos e programação: Fundamentos Módulo 3
 * Professor, se possível, favor indicar onde não utilizei boas práticas ou se existirem erros, estou
 * começando na programação, e gostaria desde já a aprender utilizando boas praticas. Grato!! */ 

public class Principal{  
    public static void main (String [] args){
        Tamagotchi a = new Tamagotchi ("Majinboo");/** Instancia o Tamagotchi */
        a.mostraStatus();          
            while (a.isVivo()){  /** Se o tamagotchi estiver vivo */  
                a.vontade();    /**  executa os metodos da vontade */ 
                a.mostraStatus(); /** mostra status */ 
                a.vitalidade();   /** e verifica vitalidade, até ele morrer */                    
            }
            
            System.out.println ("Descanse em paz " + a.getNome()); /** Essa parte apenas imprime a cruz do tamagotchi no terminal */ 
            System.out.println("\n         XXX   \n         XXX   \n      XXXRIPXXX\n         XXX   \n         XXX   \n         XXX   \n         XXX   ");                  
                        
    }
}
