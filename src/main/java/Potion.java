import java.io.Serializable;

public class Potion implements Serializable {
    private int healingAmount = 50;

    public Potion(int healingAmount) {
        this.healingAmount = healingAmount;
    }

    public int getHealingAmount() {
        return healingAmount;
    }
}
