public class Player extends GameCharacter{

    double dexterity = 0.8;


    public Player(int damage, int hp, String name) {
        super(damage, hp, name);
    }
    public Player(int hp, String name, Weapon Equippedweapon) {
        super(hp, name, Equippedweapon);
    }

}
