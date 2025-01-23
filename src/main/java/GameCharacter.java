import java.util.Random;

public abstract class GameCharacter {

    private int damage;
    private int hp;
    private String name;
    private Weapon equippedWeapon;
    private double dexterity;

    public GameCharacter(int damage, int hp, String name) {
        this.damage = damage;
        this.hp = hp;
        this.name = name;
    }

    public GameCharacter(int hp, String name, Weapon equippedWeapon, double dexterity) {
        this.hp = hp;
        this.name = name;
        this.equippedWeapon = equippedWeapon;
        this.dexterity = dexterity;
    }

    public String getName() {
        return name;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public double getDexterity() {
        return dexterity;
    }

    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public void attack(GameCharacter defender) {
        if (this.equippedWeapon != null) {
            int weaponDamage = this.equippedWeapon.getDamage();
            double minDamage = weaponDamage * dexterity;
            double maxDamage = weaponDamage;

            Random random = new Random();
            int actualDamage = (int) (minDamage + random.nextDouble() * (maxDamage - minDamage));

            System.out.println(this.name + " attacks " + defender.getName() + " with " + this.equippedWeapon.getName()
                    + " for " + actualDamage + " damage.");
            defender.takeDamage(actualDamage);
        } else {
            int spoonDamage = 5;
            System.out.println(this.name + " has no weapon equipped and attacks " + defender.getName() + " with a spoon for "
                    + spoonDamage + " damage.");
            defender.takeDamage(spoonDamage);
        }
    }
}
