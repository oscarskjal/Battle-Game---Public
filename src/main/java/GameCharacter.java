public abstract class GameCharacter {

    private int damage;
    private int hp;
    private String name;
    Weapon Equippedweapon;


    public GameCharacter(int damage, int hp, String name) {
        this.damage = damage;
        this.hp = hp;
        this.name = name;
    }

    public GameCharacter(int hp, String name, Weapon Equippedweapon) {
        this.hp = hp;
        this.name = name;
        this.Equippedweapon = Equippedweapon;
    }

    public String getName() {
        return name;
    }

    public Weapon getEquippedweapon() {
        return Equippedweapon;
    }

    public void setEquippedweapon(Weapon equippedweapon) {
        Equippedweapon = equippedweapon;
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

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public void attack(GameCharacter defender) {
        if (this.Equippedweapon != null) {
            int weaponDamage = this.Equippedweapon.getDamage();
            System.out.println(this.name + " attacks " + defender.getName() + " with " + this.Equippedweapon.getName() + " for " + weaponDamage + " damage.");
            defender.takeDamage(weaponDamage);
        } else {
            System.out.println(this.name + " No weapon equipped.");
        }
    }
}
