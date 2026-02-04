// Representa uma arma equipada por um Mecha.
// Define apenas dados básicos de combate (nome e dano base),
// sem conter lógica de ataque.
public class Weapon extends Item {

    // Dano base causado pela arma em um ataque
    int dmg;
    int range;

    // Construtor padrão da arma
    // Recebe o nome e o valor de dano base
    public Weapon(String name, int dmg, int ranger){
        super(name);
        this.dmg = dmg;
        this.range = ranger;
    }
}
