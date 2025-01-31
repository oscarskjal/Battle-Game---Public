import java.io.Serializable;

public class Player extends GameCharacter implements Serializable {

    public Player(int hp, String name, Weapon equippedWeapon, double dexterity) {
        super(hp, name, equippedWeapon, dexterity);
    }

    public int usePotion(Potion potion) {
        int healingAmount = potion.getHealingAmount();
        int newHp = this.getHp() + healingAmount;

        int maxHp = 100;
        if (newHp > maxHp) {
            newHp = maxHp;
        }

        this.setHp(newHp);

        System.out.println(this.getName() + " used a potion and healed " + healingAmount + " HP!");
        return this.getHp();
    }
}
