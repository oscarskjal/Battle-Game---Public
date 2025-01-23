import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameCharacterTest {

    @Test
    void testPlayerAttacksNpc() {

        Weapon sword = new Weapon("Sword", 20);
        Player player = new Player(100, "Hero", sword, 0.8);
        Weapon hammer = new Weapon("Hammer", 15);
        Npc npc = new Npc(50, "Monster", hammer, 0.6);


        int npcHpBefore = npc.getHp();
        player.attack(npc);
        int npcHpAfter = npc.getHp();


        if (npcHpAfter < npcHpBefore) {
            System.out.println(player.getName() + " successfully attacked " + npc.getName() +
                    " reducing its HP from " + npcHpBefore + " to " + npcHpAfter + ".");
        }
        assertTrue(npcHpAfter < npcHpBefore, "Npc's HP borde minska.");
    }

    @Test
    void testNpcAttacksPlayer() {

        Weapon sword = new Weapon("Sword", 20);
        Player player = new Player(100, "Hero", sword, 0.8);
        Weapon hammer = new Weapon("Hammer", 15);
        Npc npc = new Npc(50, "Monster", hammer, 0.6);


        int playerHpBefore = player.getHp();
        npc.attack(player);
        int playerHpAfter = player.getHp();


        if (playerHpAfter < playerHpBefore) {
            System.out.println(npc.getName() + " successfully attacked " + player.getName() +
                    " reducing its HP from " + playerHpBefore + " to " + playerHpAfter + ".");
        }
        assertTrue(playerHpAfter < playerHpBefore, "Player's HP borde minska.");
    }
}

