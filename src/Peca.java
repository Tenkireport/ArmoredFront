// Representa uma peça estrutural de um Mecha.
// Cada peça possui HP próprio e pode ser destruída independentemente,
// influenciando o estado geral do Mecha em combate.
public class Peca {

    // Nome da peça (usado para UI e mensagens de combate)
    String name;

    // HP máximo da peça
    int maxHp;

    // HP atual da peça durante o combate
    int currentHp;

    // Construtor da peça.
    // Inicializa o HP atual com o valor máximo.
    public Peca(String name, int hp){
        this.name = name;
        this.maxHp = hp;
        this.currentHp = hp;
    }

    // Aplica dano à peça, garantindo que o HP
    // não fique abaixo de zero.
    public void takeDamage(int dmg){
        this.currentHp -= dmg;

        // Evita valores negativos de HP
        if (this.currentHp < 0)
            this.currentHp = 0;
    }


    public void heal(RepairKit heal){
        if(this.currentHp == this.maxHp){
            System.out.println("Vida cheia");
        } else if (isBroke()) {
            System.out.println("Impossivel concertar");
        } else {
            this.currentHp += heal.hp;
            if(this.currentHp > this.maxHp){
                this.currentHp = this.maxHp;
            }
            System.out.println(this.name + " Recuperou " + heal.hp + " Pontos de vida");
        }
    }

    // Indica se a peça foi destruída.
    // Uma peça é considerada quebrada quando seu HP chega a zero.
    public boolean isBroke(){
        return currentHp <= 0;
    }
}
