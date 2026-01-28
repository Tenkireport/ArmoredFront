import java.util.InputMismatchException;
import java.util.Scanner;

// Classe principal responsável por iniciar o jogo
// e controlar o fluxo geral do combate.
public class Main {

    // Exibe na tela o estado atual de um Mecha.
    // Funciona como uma HUD simples de combate em modo texto.
    public static void battleUi(Mecha info){
        System.out.println(info.name);
        System.out.printf(
                "Torso: %d\nD.Arm: %d\nS.Arm: %d\nLegs: %d\n",
                info.torso.currentHp,
                info.rightArm.currentHp,
                info.leftArm.currentHp,
                info.legs.currentHp
        );
    }


    // Executa um turno de combate entre dois Mechas.
    // O atacante realiza uma ação, e o defensor apenas recebe o efeito.
    // A função não decide vitória ou fim de jogo — apenas executa o turno.
    public static void turn(Mecha atk, Mecha def,RepairKit kit, Scanner op){

        // Exibe primeiro o estado do defensor
        battleUi(def);

        // Separador visual entre os dois Mechas
        System.out.println("=================================");

        // Exibe o estado do atacante
        battleUi(atk);

        // Solicita a ação do jogador controlador do Mecha atacante
        System.out.println(atk.name + " Digite (1) para atacar >\n Digite (2) para atacar > ");

        // Lê a opção do jogador
        boolean valido = false;
        while (!valido){
            try {
                int x = op.nextInt();

                // Executa o ataque apenas se a opção for válida
                if (x == 1){
                    atk.attack(def);
                    valido = true;
                } else if (x == 2) {
                    atk.useItem(kit);
                    valido = true;
                } else {System.out.println("tente de novo");}
            } catch (InputMismatchException e) {
                System.out.print("Erro: opção invalida");
                op.next();
            }

        }


    }

    // Ponto de entrada do programa.
    // Responsável por criar os objetos do jogo
    // e controlar o loop principal de combate.
    public static void main(String[] args){

        // Scanner único para leitura de entrada do jogador
        Scanner leitor = new Scanner(System.in);

        // --- FASE 1: OFICINA ---
        // Criação das armas e dos Mechas antes do combate

        // Armas disponíveis
        Weapon metralhadora = new Weapon("Metralhadora", 15);
        Weapon canhao = new Weapon("Canhão de Plasma", 45);

        RepairKit kitone = new RepairKit ("Cura1",100);

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


        // Mensagens iniciais de combate
        System.out.println("Combate Iniciado: " + p1.name + " VS " + p2.name);
        System.out.println("-----------------------------------------");

        // Loop principal do jogo.
        // O combate continua enquanto ambos os Mechas estiverem vivos.
        while (true){

            // Turno do primeiro Mecha
            turn(p1, p2,kitone ,leitor);

            // Verifica se o defensor foi derrotado
            if (p2.isDead()){
                System.out.println(p1.name + " ganhou");
                break;
            }

            // Turno do segundo Mecha
            turn(p2, p1,kitone, leitor);

            // Verifica se o defensor foi derrotado
            if (p1.isDead()){
                System.out.println(p2.name + " ganhou");
                break;
            }
        }
    }
}
