import java.io.Serializable;
import java.util.Random;

public class Npc extends GameCharacter implements Serializable {

    private static final Weapon[] WEAPONS_LIST = {
            new Weapon("IronSword", 15),
            new Weapon("Bow", 9),
            new Weapon("Mace", 10),
            new Weapon("Knife", 6),
            new Weapon("Whip", 5),
            new Weapon("Club", 8)
    };

    private static final String[] MONSTER_NAMES = {"Witch", "Golem", "Zombie", "Undead", "Skeleton", "Tribesman"};

    public Npc(int hp, String name, Weapon equippedWeapon, double dexterity) {
        super(hp, name, equippedWeapon, dexterity);
    }

    public static GameCharacter spawnNpc() {
        Random random = new Random();


        String name = MONSTER_NAMES[random.nextInt(MONSTER_NAMES.length)];


        Weapon weapon = WEAPONS_LIST[random.nextInt(WEAPONS_LIST.length)];


        int hp = 50;
        double dexterity = 0.6;

        return new Npc(hp, name, weapon, dexterity);
    }
}
