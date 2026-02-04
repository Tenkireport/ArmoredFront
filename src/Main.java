import java.util.InputMismatchException;
import java.util.Scanner;

// Classe principal responsável por iniciar o jogo
// e controlar o fluxo geral do combate.
public class Main {

    // Ponto de entrada do programa.
    // Responsável por criar os objetos do jogo
    // e controlar o loop principal de combate.
    public static void main(String[] args){

        // Scanner único para leitura de entrada do jogador
        Scanner leitor = new Scanner(System.in);

        // --- FASE 1: OFICINA ---
        // Criação das armas e dos Mechas antes do combate

        // Armas disponíveis
        Weapon metralhadora = new Weapon("Metralhadora", 15,2);
        Weapon canhao = new Weapon("Canhão de Plasma", 45,8);



        // Mecha 1: focado em resistência (tank)
        Mecha p1 = new Mecha(
                "TITAN",
                new Peca("Tronco", 150),
                new Peca("Braço Esq.", 50),
                new Peca("Braço Dir.", 50),
                new Peca("Pernas", 100),
                metralhadora
        );

        // Mecha 2: focado em alto dano (glass cannon)
        Mecha p2 = new Mecha(
                "VIPER",
                new Peca("Tronco", 90),
                new Peca("Braço Esq.", 40),
                new Peca("Braço Dir.", 40),
                new Peca("Pernas", 60),
                canhao
        );

        Mapa map1 = new Mapa();
        map1.posicionar(p1,0,0);
        map1.posicionar(p2,9,9);


        // Mensagens iniciais de combate
        System.out.println("Combate Iniciado: " + p1.name + " VS " + p2.name);
        System.out.println("-----------------------------------------");

        BattleManager juiz = new BattleManager();

        map1.exibir();
        // Loop principal do jogo.
        // O combate continua enquanto ambos os Mechas estiverem vivos.

        double dist = map1.calcDist(p1,p2);


        juiz.startBattle(p1,p2,map1);
        map1.exibir();

    }
}
