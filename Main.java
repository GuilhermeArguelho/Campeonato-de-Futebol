/*
Trabalho Prático
Linguagem de Programação I - 179
Guilherme Arguelho, João Bomfim
*/
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int qtdJogos = 0;
    //System.out.print("Informe o nome do campeonato: ");
    String nomeCamp = sc.nextLine();
    nomeCamp = verificarNomeCampeonato(nomeCamp);
    //System.out.print("Informe a quantidade de times: ");
    int qtdTimes = sc.nextInt();
    qtdTimes = verificarQtdTimes(qtdTimes);
    //System.out.println("Escreva o nome dos " + qtdTimes + " times: ");
    String[] nomeTime = new String[qtdTimes];
    sc.nextLine();
    for (int i = 0; i < qtdTimes; i++){
        nomeTime[i] = sc.nextLine();
        while(nomeTime.length > 20) {
            nomeTime[i] = sc.nextLine();
            //System.out.println("Nome muito grande, insira outro de no máximo 20 carac: ");
        }
        boolean c = verificarNomeTime(nomeTime[i]);
        while (c == true){
            System.out.print("Nome inválido, insira outro: ");
            nomeTime[i] = sc.nextLine();
            c = verificarNomeTime(nomeTime[i]);
        }
    } 

    do {
        //System.out.println("Informe a quantidade de jogos: ");
        qtdJogos = sc.nextInt();
        sc.nextLine();
        if(qtdJogos <= 0) {
            //System.out.println("Quantidade inválida: ");
        }
    } while(qtdJogos <= 0);
    
    String result[] = new String [qtdJogos];
    int mat[][] = new int [qtdTimes][5];
    int valores[] = new int[5];
    //System.out.println("Informe os resultados: nomeDoTime1_golsDoTime1@golsDoTime2_nomeDoTime2");
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
          //System.out.println("Resultado inválido! Informe novamente: ");
          result[j] = sc.nextLine();
          nomeTimeRes = result[j].split("_");
          placar = nomeTimeRes[1].split("@");
        }
      } while(cont < 3 || nomeTimeRes[0].equals(nomeTimeRes[2])); // vai pedir o resultado novamente caso nome não esteja na lista ou os times sejam iguais
      if(Integer.parseInt(placar[0]) > Integer.parseInt(placar[1])) { // vitoria primeiro time
        valores[0] = 3; //pontos
        valores[1] = 1; // vitorias
        valores[2] = Integer.parseInt(placar[0]); // gols marcados
        valores[3] = Integer.parseInt(placar[1]); // gols sofridos
        valores[4] = Integer.parseInt(placar[0]) - Integer.parseInt(placar[1]); // saldo de gols
        for(int w = 0; w < nomeTime.length; w++){
          if(nomeTime[w].equals(nomeTimeRes[0])){
            for(int x = 0; x < 5; x++){
              mat[w][x] += valores[x];
            }
          }
        }
      } else if(Integer.parseInt(placar[0]) < Integer.parseInt(placar[1])){ // derrota primeiro time
        valores[0] = 0; //pontos
        valores[1] = 0; // vitorias
        valores[2] = Integer.parseInt(placar[0]); // gols marcados
        valores[3] = Integer.parseInt(placar[1]); // gols sofridos
        valores[4] = Integer.parseInt(placar[0]) - Integer.parseInt(placar[1]); // saldo de gols
        for(int w = 0; w < nomeTime.length; w++){
          if(nomeTime[w].equals(nomeTimeRes[0])){
            for(int x = 0; x < 5; x++){
              mat[w][x] += valores[x];
            }
          }
        }
      }
      if(Integer.parseInt(placar[1]) > Integer.parseInt(placar[0])) { // vitoria segundo time
        valores[0] = 3; //pontos
        valores[1] = 1; // vitorias
        valores[2] = Integer.parseInt(placar[1]); // gols marcados
        valores[3] = Integer.parseInt(placar[0]); // gols sofridos
        valores[4] = Integer.parseInt(placar[1]) - Integer.parseInt(placar[0]); // saldo de gols
        for(int w = 0; w < nomeTime.length; w++){
          if(nomeTime[w].equals(nomeTimeRes[2])){
            for(int x = 0; x < 5; x++){
              mat[w][x] += valores[x];
            }
          }
        }
      } else if(Integer.parseInt(placar[1]) < Integer.parseInt(placar[0])){ // derrota segundo time
        valores[0] = 0; //pontos
        valores[1] = 0; // vitorias
        valores[2] = Integer.parseInt(placar[1]); // gols marcados
        valores[3] = Integer.parseInt(placar[0]); // gols sofridos
        valores[4] = Integer.parseInt(placar[1]) - Integer.parseInt(placar[0]); // saldo de gols
        for(int w = 0; w < nomeTime.length; w++){
          if(nomeTime[w].equals(nomeTimeRes[2])){
            for(int x = 0; x < 5; x++){
              mat[w][x] += valores[x];
            }
          }
        }
      }
      if(Integer.parseInt(placar[0]) == Integer.parseInt(placar[1])) { // empate
        valores[0] = 1; //pontos
        valores[1] = 0; // vitorias
        valores[2] = Integer.parseInt(placar[0]); // gols marcados
        valores[3] = Integer.parseInt(placar[1]); // gols sofridos
        valores[4] = Integer.parseInt(placar[0]) - Integer.parseInt(placar[1]); // saldo de gols
        for(int w = 0; w < nomeTime.length; w++){
          if(nomeTime[w].equals(nomeTimeRes[0]) || nomeTime[w].equals(nomeTimeRes[2])){
            for(int x = 0; x < 5; x++){
              mat[w][x] += valores[x];
            }
          }
        }
      }       
    }
    tabela(nomeCamp, nomeTime, mat, qtdTimes); // imprime o placar sem estar ordenada
    //tabela(nomeCamp, nomeTime2, matAux, qtdTimes); // imprime o placar ordenado        
  }
  public static Boolean verificarNomeTime(String nomeTime){
      char g[] = nomeTime.toCharArray();
      boolean verifica = false;
      int cont = 0;
      for (int i = 0; i < g.length; i++) {
          if(g[i] >= 33 && g[i] <= 47 || g[i] >= 58 && g[i] <= 64 || g[i] >= 91 && g[i] <= 96 || g[i] >= 123 && g[i] <= 255) {
              cont++;
          }
          if(cont > 0) {
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
  public static void tabela(String nomeCamp, String[] nomeTime, int[][] mat, int qtd) {
    System.out.println(nomeCamp);
    for(int m = 0; m < qtd; m++) {
      System.out.print(nomeTime[m] + " | ");
      System.out.print(mat[m][0] + " pontos | ");
      System.out.print(mat[m][1] + " vitória(s) | ");               
      System.out.print(mat[m][2] + " gols marcados | ");
      System.out.print(mat[m][3] + " gols sofridos | ");
      System.out.print(" saldo de gols: " + mat[m][4] );
      System.out.println();
    }
  }
}           