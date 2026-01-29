import java.util.InputMismatchException;
import java.util.Scanner;

public class BattleManager {
    Scanner leitor = new Scanner(System.in);
    RepairKit kitone = new RepairKit ("Cura1",100);

    public void startBattle(Mecha p1, Mecha p2){
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

    // Executa um turno de combate entre dois Mechas.
    // O atacante realiza uma ação, e o defensor apenas recebe o efeito.
    // A função não decide vitória ou fim de jogo — apenas executa o turno.
    public  void turn(Mecha atk, Mecha def,RepairKit kit, Scanner op){
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

    // Exibe na tela o estado atual de um Mecha.
    // Funciona como uma HUD simples de combate em modo texto.
    public void battleUi(Mecha info){
        System.out.println(info.name);
        System.out.printf(
                "Torso: %d\nD.Arm: %d\nS.Arm: %d\nLegs: %d\n",
                info.torso.currentHp,
                info.rightArm.currentHp,
                info.leftArm.currentHp,
                info.legs.currentHp
        );
    }
}
