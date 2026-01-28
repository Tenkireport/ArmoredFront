import java.util.Random;

// Representa um Mecha completo em combate.
// Um Mecha é composto por partes (peças) e uma arma,
// e concentra a lógica principal de ataque e estado de vida.
public class Mecha {

    // Nome do Mecha (usado para UI e mensagens de combate)
    String name;

    // Partes estruturais do Mecha
    // Cada peça possui HP próprio e pode ser destruída
    Peca torso;
    Peca leftArm;
    Peca rightArm;
    Peca legs;

    // Arma equipada, responsável pelo dano base do ataque
    Weapon weapon;

    // Construtor que monta o Mecha com suas partes e arma
    public Mecha(String name, Peca torso, Peca leftArm, Peca rightArm, Peca legs, Weapon weapon){
        this.name = name;
        this.torso = torso;
        this.leftArm = leftArm;
        this.rightArm = rightArm;
        this.legs = legs;
        this.weapon = weapon;
    }

    // Verifica se o Mecha foi derrotado.
    // A condição de morte é a destruição do torso.
    public boolean isDead(){
        return torso.isBroke();
    }

    public void useItem(RepairKit item){
        this.torso.heal(item);
    }

    // Executa um ataque contra outro Mecha.
    // O alvo é escolhido de forma probabilística,
    // simulando um sistema de acerto por partes.
    public void attack(Mecha enemy){
        Random dado = new Random();
        int chance = dado.nextInt(100);

        // Peça atingida pelo ataque (definida pela rolagem)
        Peca alvoAtingido = null;

        // Distribuição de chance de acerto por parte
        if(chance < 40){
            alvoAtingido = enemy.torso;
            System.out.println("Tronco atingido");
        } else if (chance < 70) {
            alvoAtingido = enemy.legs;
            System.out.println("Pernas atingidas");
        } else if (chance < 85) {
            alvoAtingido = enemy.leftArm;
            System.out.println("Braço esquerdo atingido");
        } else {
            alvoAtingido = enemy.rightArm;
            System.out.println("Braço direito atingido");
        }

        // Caso a peça sorteada já esteja destruída,
        // o dano é redirecionado para o torso
        if(alvoAtingido.isBroke()){
            alvoAtingido = enemy.torso;
        }

        // Aplica o dano da arma na peça final escolhida
        alvoAtingido.takeDamage(this.weapon.dmg);
    }

    // Método alternativo de dano direto no torso.
    // Atualmente não é utilizado no fluxo principal de combate.
    public void causeDamage(Mecha enemy){
        enemy.torso.currentHp -= this.weapon.dmg;
    }
}
