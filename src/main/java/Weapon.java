import java.io.Serializable;

public class Weapon implements Serializable {

    private String name;
    private int damage;

    public Weapon() {
        this.name = "Spoon";
        this.damage = 5;
    }

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
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


}
