/*
Trabalho Prático
Linguagem de Programação I - 179
Guilherme Arguelho, João Bomfim
*/
import java.util.Scanner;

public class copia2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o nome do campeonato: ");
        String nomeCamp = sc.nextLine();
        nomeCamp = verificarNomeCampeonato(nomeCamp);
        
        System.out.print("Informe a quantidade de times: ");
        int qtdTimes = sc.nextInt();
        qtdTimes = verificarQtdTimes(qtdTimes);

        System.out.println("Escreva o nome dos " + qtdTimes + " times: ");
        String[] nomeTime = new String[qtdTimes];
        sc.nextLine();
        for (int i = 0; i < qtdTimes; i++){
            nomeTime[i] = sc.nextLine();
            while(nomeTime.length > 20) {
                nomeTime[i] = sc.nextLine();
                System.out.println("Nome muito grande, insira outro de no máximo 20 carac: ");
            }
           
            boolean c = verificarNomeTime(nomeTime[i]);
            while (c == true){
                System.out.print("Nome inválido, insira outro: ");
                nomeTime[i] = sc.nextLine();
                c = verificarNomeTime(nomeTime[i]);
            }
        } 

        int qtdJogos = 0;
        
        do {
            System.out.println("Informe a quantidade de jogos: ");
            qtdJogos = sc.nextInt();
            sc.nextLine();
            if(qtdJogos <= 0) {
                System.out.println("Quantidade inválida: ");
            }
        } while(qtdJogos <= 0);
        
        String result[] = new String [qtdJogos];
        int mat[][] = new int [qtdTimes][5];
        int valores1[] = new int[5];
        int valores2[] = new int[5];
        System.out.println("Informe os resultados: nomeDoTime1_golsDoTime1@golsDoTime2_nomeDoTime2");
            for (int j = 0; j < result.length; j++){
              int cont = 0;
              
              result[j] = sc.nextLine();
              String nomeTimeRes[] = result[j].split("_");
              String placar[] = nomeTimeRes[1].split("@");
              do {    
                cont = 0;
                if(Integer.parseInt(placar[0]) >= 0 && Integer.parseInt(placar[1]) >= 0) {
                    cont++;
                }
                for(int d = 0; d < nomeTime.length; d++) {
                  if(nomeTimeRes[0].equals(nomeTime[d])){
                    cont++; // se cont for +1 significa que o nome do time esta na array
                  } 
                  if(nomeTimeRes[2].equals(nomeTime[d])){
                    cont++; // se cont for +1 significa que o nome do time esta na array
                  }
                }
                if(cont < 3 || nomeTimeRes[0].equals(nomeTimeRes[2])) { // se um ou dois tiverem errados ele executa
                  System.out.println("Resultado inválido! Informe novamente: ");
                  result[j] = sc.nextLine();
                  nomeTimeRes = result[j].split("_");
                  placar = nomeTimeRes[1].split("@");
                }
              } while(cont < 3 || nomeTimeRes[0].equals(nomeTimeRes[2])); // vai pedir o resultado novamente caso nome não esteja na lista ou os times sejam iguais
              
              

              // TIME 1 
              if(Integer.parseInt(placar[0]) > Integer.parseInt(placar[1])) { //vitoria do time 1 e derrota do time 2
                valores1[0] = 3; //pontos
                valores1[1] = 1; // vitorias
                valores1[2] = Integer.parseInt(placar[0]); // gols marcados
                valores1[3] = Integer.parseInt(placar[1]); // gols sofridos
                valores1[4] = Integer.parseInt(placar[0]) - Integer.parseInt(placar[1]); // saldo de gols
              } else if(Integer.parseInt(placar[0]) < Integer.parseInt(placar[1])){ // derrota
                valores1[0] = 0; //pontos
                valores1[1] = 0; // vitorias
                valores1[2] = Integer.parseInt(placar[0]); // gols marcados
                valores1[3] = Integer.parseInt(placar[1]); // gols sofridos
                valores1[4] = Integer.parseInt(placar[0]) - Integer.parseInt(placar[1]); // saldo de gols
              } else {
                valores1[0] = 1; //pontos
                valores1[1] = 0; // vitorias
                valores1[2] = Integer.parseInt(placar[0]); // gols marcados
                valores1[3] = Integer.parseInt(placar[1]); // gols sofridos
                valores1[4] = Integer.parseInt(placar[0]) - Integer.parseInt(placar[1]); // saldo de gols
              }
              
              // TIME 2 
              if(Integer.parseInt(placar[0]) < Integer.parseInt(placar[1])) { //vitoria do time 2 e derrota do time 1
                valores2[0] = 3; //pontos
                valores2[1] = 1; // vitorias
                valores2[2] = Integer.parseInt(placar[1]); // gols marcados
                valores2[3] = Integer.parseInt(placar[0]); // gols sofridos
                valores2[4] = Integer.parseInt(placar[1]) - Integer.parseInt(placar[0]); // saldo de gols
              } else if(Integer.parseInt(placar[0]) > Integer.parseInt(placar[1])){ // derrota
                valores2[0] = 0; //pontos
                valores2[1] = 0; // vitorias
                valores2[2] = Integer.parseInt(placar[1]); // gols marcados
                valores2[3] = Integer.parseInt(placar[0]); // gols sofridos
                valores2[4] = Integer.parseInt(placar[1]) - Integer.parseInt(placar[0]); // saldo de gols
              } else {
                valores2[0] = 1; //pontos
                valores2[1] = 0; // vitorias
                valores2[2] = Integer.parseInt(placar[1]); // gols marcados
                valores2[3] = Integer.parseInt(placar[0]); // gols sofridos
                valores2[4] = Integer.parseInt(placar[1]) - Integer.parseInt(placar[0]); // saldo de gols
              }
              
              int g = 0;
              for(int d = 0; d < nomeTime.length; d++) {
                if(nomeTimeRes[0].equals(nomeTime[d])){
                  g = d;                  
                }
              }
                mat[g][0] += valores1[0];
                mat[g][1] += valores1[1];
                mat[g][2] += valores1[2];
                mat[g][3] += valores1[3];
                mat[g][4] += valores1[4];
                int h = 0;
                for(int d = 0; d < nomeTime.length; d++) {
                  if(nomeTimeRes[2].equals(nomeTime[d])){
                    h = d;
                  }
                }              
                mat[h][0] += valores2[0];
                mat[h][1] += valores2[1];
                mat[h][2] += valores2[2];
                mat[h][3] += valores2[3];
                mat[h][4] += valores2[4];          
            }

            System.out.println();
            System.out.println(nomeCamp);
            for(int m = 0; m < qtdTimes; m++) { // matriz sem ordenar
                System.out.print((m+1) + " | " + nomeTime[m] + " | ");
                System.out.print(mat[m][0] + " pontos | ");
                System.out.print(mat[m][1] + " vitórias | ");               
                System.out.print(mat[m][2] + " gols marcados | ");
                System.out.print(mat[m][3] + " gols sofridos | ");
                System.out.print(" saldo de gols: " + mat[m][4] );
                System.out.println();
            }     

            int[][] matAux = new int [qtdTimes][6];  //matriz auxiliar(ela só existe pq eu tava com medo de fazer bosta na matriz principal)
            matAux = mat;
            
            int[] vetor = new int[qtdTimes]; 
            int v = 0, aux;

                for(int n = 0; n < matAux.length; n++){  // vetor para armazenar todos os pontos de todos os times
                  vetor[v]=matAux[n][0];   
                  v++;        
                
            }    
            String nomeTime2[] = nomeTime; 
            String auxnome; 
            for (int n=0; n < qtdTimes-1; n++) {  // ordena as posições da matriz (troca simultaneamente as posiçoes dos pontos e a posição dos times)
              if (vetor[n] < vetor[n+1]) {
                aux = vetor[n+1]; 
                auxnome = nomeTime2[n+1];
                vetor[n+1] = vetor[n];
                nomeTime2[n+1] = nomeTime2[n];
                vetor[n] = aux;
                nomeTime2[n] = auxnome;
              }              
            }

            for(int n = 0; n < qtdTimes; n++) { //coloca na matriz ordenados por quem fez mais pontos
              mat[n][0] = vetor[n];
            }
            

            System.out.println();
            System.out.println(nomeCamp);
            for(int m = 0; m < qtdTimes; m++) {
                System.out.print((m+1) + " | " + nomeTime[m] + " | ");
                System.out.print(matAux[m][0] + " pontos | ");
                System.out.print(matAux[m][1] + " vitórias | ");               
                System.out.print(matAux[m][2] + " gols marcados | ");
                System.out.print(matAux[m][3] + " gols sofridos | ");
                System.out.print(" saldo de gols: " + matAux[m][4] );
                System.out.println();
            }       
              
        }
        
      
    

  static Boolean verificarNomeTime(String nomeTime){
      char g[] = nomeTime.toCharArray();
      boolean verifica = false;
      for (int i = 0; i < g.length; i++) {
          if(g[i] >= 33 && g[i] <= 47 || g[i] >= 58 && g[i] <= 64 || g[i] >= 91 && g[i] <= 96 || g[i] >= 123 && g[i] <= 255) {
              verifica = true;
          } 
      }
      return verifica;
  }
  public static String verificarNomeCampeonato(String a) {
      Scanner sc = new Scanner(System.in);
      while(a.length() > 100){
          System.out.println("Nome ultrapassou o limite de 100 caracteres, insira outro: ");
          a = sc.nextLine();
      }
      return a;
  }
  public static int verificarQtdTimes(int n) {
      Scanner sc = new Scanner(System.in);
      while (n < 2 || n > 20){
          System.out.println("Quantidade inválida de times. Insira outra: ");
          n = sc.nextInt();
      }
      return n;
  }
  public static void tabela(String nomeCamp, String v[]) {
    System.out.println();
  }
}      