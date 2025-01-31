import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NpcTest {

    @Test
    public void testSpawnNpc() {
        for (int i = 0; i < 10; i++) {
            GameCharacter npc = Npc.spawnNpc();

            System.out.println("Spawned NPC " + (i + 1) + ":");
            System.out.println("Name: " + npc.getName());
            System.out.println("HP: " + npc.getHp());
            System.out.println("Weapon: " + npc.getEquippedWeapon().getName() + " (Damage: " + npc.getEquippedWeapon().getDamage() + ")");
            System.out.println("Dexterity: " + npc.getDexterity());
            System.out.println("-------------------------");

            // Om testen misslyckas:
            assertNotNull(npc.getName(), "NPC name should not be null");
            assertTrue(npc.getHp() > 0, "NPC HP should be greater than 0");
            assertNotNull(npc.getEquippedWeapon(), "NPC should have an equipped weapon");
            assertNotNull(npc.getEquippedWeapon().getName(), "Weapon name should not be null");
            assertTrue(npc.getEquippedWeapon().getDamage() > 0, "Weapon damage should be greater than 0");
            assertTrue(npc.getDexterity() >= 0, "NPC dexterity should be greater than 0");
        }
    }
}
