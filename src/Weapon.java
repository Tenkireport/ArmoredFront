// Representa uma arma equipada por um Mecha.
// Define apenas dados básicos de combate (nome e dano base),
// sem conter lógica de ataque.
public class Weapon extends Item {

    // Dano base causado pela arma em um ataque
    int dmg;

    // Construtor padrão da arma
    // Recebe o nome e o valor de dano base
    public Weapon(String name, int dmg){
        super(name);
        this.dmg = dmg;
    }
}
