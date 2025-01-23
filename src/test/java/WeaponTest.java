import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WeaponTest {

    @Test
    void testWeaponNameAssignment() {
        String expectedName = "Excalibur";
        int damage = 50;

        Weapon weapon = new Weapon(expectedName, damage);

        if (expectedName.equals(weapon.getName())) {
            System.out.println("Test Passed: The weapon's name is correctly assigned as " + weapon.getName());
        } else {
            System.out.println("Test Failed: Expected weapon name '" + expectedName + "' but got '" + weapon.getName() + "'");
        }

        assertEquals(expectedName, weapon.getName());
    }

    @Test
    void testWeaponDamageAssignment() {
        String name = "Battle Axe";
        int expectedDamage = 30;

        Weapon weapon = new Weapon(name, expectedDamage);

        if (expectedDamage == weapon.getDamage()) {
            System.out.println("Test Passed: The weapon's damage is correctly assigned as " + weapon.getDamage());
        } else {
            System.out.println("Test Failed: Expected weapon damage '" + expectedDamage + "' but got '" + weapon.getDamage() + "'");
        }

        assertEquals(expectedDamage, weapon.getDamage());
    }

    @Test
    void testChangeWeaponName() {
        Weapon weapon = new Weapon("Old Sword", 25);
        String newName = "Flaming Sword";

        weapon.setName(newName);

        if (newName.equals(weapon.getName())) {
            System.out.println("Test Passed: The weapon's name was successfully updated to " + weapon.getName());
        } else {
            System.out.println("Test Failed: Expected updated weapon name '" + newName + "' but got '" + weapon.getName() + "'");
        }

        assertEquals(newName, weapon.getName());
    }
}
