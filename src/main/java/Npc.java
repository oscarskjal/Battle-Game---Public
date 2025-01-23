public class Npc extends GameCharacter{

    double dexterity = 0.5;

    public Npc(int damage, int hp, String name) {
        super(damage, hp, name);
    }

    public Npc(int hp, String name, Weapon Equippedweapon) {
     super(hp, name, Equippedweapon);
    }
}
