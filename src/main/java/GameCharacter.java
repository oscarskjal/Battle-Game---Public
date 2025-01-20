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


    public String getName() {
        return name;
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
}
