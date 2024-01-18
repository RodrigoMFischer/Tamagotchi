/** Aluno: Rodrigo Marion Fischer
   Algoritmos e programação: Fundamentos Módulo 3*/

public class Tamagotchi{
    
    private String nome; /** Variáveis de instanciamento do tamagotchi */
    private int idade = 0;
    private int peso = 1;
    private int diasAcordado = 0;   
    private boolean vivo = true;
    
            public Tamagotchi (String nome){ /** Método construtor */
                this.nome = nome;                
        }
    
            public String getNome (){ /** Métodos de acesso - retorna nome */
                return nome;
        }
    
            public int getIdade (){ /** Métodos de acesso - retorna Idade */
                return idade;
        }   
    
            public int getPeso (){    /** Métodos de acesso - retorna Peso */
                return peso;
        }
    
            public int getDiasAcordado (){  /** Métodos de acesso - retorna os dias acordado */
                return diasAcordado; 
        }
        
            public boolean isVivo (){  /** Métodos de acesso - retorna se está vivo */
                return vivo; 
        }
    
            public void setNome (String nome){   /** Métodos de SET - redefine nome */
                this.nome = nome;
        }
    
            public void setIdade (int idade){     /** Métodos de SET - redefine idade */
                this.idade = idade;
        }
    
            public void setPeso (int peso){       /** Métodos de SET - redefine peso */
                this.peso = peso;
        }
    
            public void setDiasAcordado (int diasAcordado){         /** Métodos de SET - redefine os dias acordado */
                this.diasAcordado = diasAcordado;
        }
        
            public void setVivo (boolean vivo){    /** Métodos SET - redefine se está vivo */
                this.vivo = vivo;
        }
        
            public void mostraStatus (){ /** Método para acompanhar o tamagotchi*/
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Nome: "+ getNome() +" --- Idade: "+ getIdade() + " d" + " --- Peso: "+ getPeso() + " Kg  " +" --- Dias Acordado: "+ getDiasAcordado() + " d\n");                
        }   
    
            public void vitalidade () { 
                if (getPeso() >= 20 || getPeso() <= 0 || getIdade() >= 15) /** Verifica Morte do Tamagotchi */
                    setVivo (false);                
        }
        
            public void vontade () {
                int opcao = (int)(Math.random()*3)+1; /** Faz a opção randomica das vontades do tamagotchi entre 1 e 3 */
                                
                    if (opcao == 1)
                        sono();
                    else if (opcao == 2)
                        fome();
                    else
                        treino();
        }
        
        
            public void sono () {  /** Método do Sono */
                    if (getDiasAcordado() == 5){  /** Verifica quantos dias ele está acordado */  
                        System.out.println (getNome() +" sentiu sono, não aguentou e dormiu\n");
                        setDiasAcordado(0);
                        setIdade( getIdade() + 1);
                    }
                    else{  
                        System.out.println("Seu tamagotchi está com sono, ele pode:\n1 - Dormir\n2 - Ficar acordado\n");
                        int opcao = Teclado.leInt("Digite sua opção: ");  /** Lê a opção pelo teclado */ 
                            if (opcao == 1){
                                setIdade( getIdade() + 1); /** Dormiu - idade +1 */
                                setDiasAcordado (0); /** Zera os dias acordado */
                                System.out.println(getNome () +" dormiu\n");
                            }
                            else if (opcao == 2)
                                setDiasAcordado (getDiasAcordado() + 1);  /** Ficou acordado - diasAcordado +1 */
                    }    
        }
        
            public void fome (){ /** Método da Fome */
                System.out.println("Seu tamagotchi está com fome, ele pode:\n1 - Comer Muito\n2 - Comer Pouco\n3 - Não Comer\n");
                int opcao = Teclado.leInt("Digite sua opção: ");
                
                    if (opcao == 1){ /** Comeu muito, peso + 5 e idade + 1 porque dormiu */
                        setPeso( getPeso() + 5);
                        setIdade( getIdade() + 1); /** Dormiu */
                        setDiasAcordado (0); /** zera dias acordado */
                        System.out.println(nome +" comeu demais e dormiu\n");
                    }
                    else if (opcao == 2) /** Comeu pouco, peso + 1*/
                        setPeso( getPeso() + 1);
                        
                    else if (opcao == 3) /** Não comeu, perde 2 kg*/
                        setPeso( getPeso() - 2);
                        
        }
        
            public void treino () {  /** Método de exercícios */   
                System.out.println("Seu tamagotchi está entediado e precisa se exercitar:\n1 - Correr 10 minutos\n2 - Caminhar 10 minutos");
                int opcao = Teclado.leInt("Digite sua opção:\n");
                    if (opcao == 1)
                        setPeso( getPeso() + 1); /** correndo ele perde 4 kg e ganha 5 kg por comer muito, então peso +1 */
                    else if (opcao == 2){    /** Caminhou 10 minutos - perde 1 kg e chama o método fome */
                        setPeso( getPeso() - 1);  /** Pensei em verificar o peso antes de chamar o método fome, porém seria morte certa */
                        fome();                   /** caso esse metodo seja o primeiro a ser chamado */
                    }
        }
}
