import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SaveGameTest {

    private static final String TEST_SAVE_FILE = "test_savegame.dat";

    @Test
    public void testSaveGame() {

        Weapon sword = new Weapon("Sword", 20);
        Player originalPlayer = new Player(100, "TestPlayer", sword, 0.8);
        ArrayList<Potion> potionInventory = new ArrayList<>();
        int totalRounds = 10;

        // Spara Player objekt i en fil
        saveGame(originalPlayer, potionInventory, totalRounds);

        // Läs player objekten från en fil
        Object[] loadedData = loadGame();
        Player loadedPlayer = (Player) loadedData[0];

        // Assert player's namn och weapon som samma som i originella filen
        assertNotNull(loadedPlayer, "Loaded player should not be null");
        assertEquals(originalPlayer.getName(), loadedPlayer.getName(), "Player names should be the same");
        assertEquals(originalPlayer.getEquippedWeapon().getName(), loadedPlayer.getEquippedWeapon().getName(), "Player weapons should be the same");

        // Allt funkar!
        System.out.println("Operation successful!");
    }

    private static void saveGame(Player player, ArrayList<Potion> potions, int rounds) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(TEST_SAVE_FILE))) {
            out.writeObject(player);
            out.writeObject(potions);
            out.writeInt(rounds);
        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }

    private static Object[] loadGame() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(TEST_SAVE_FILE))) {
            Player player = (Player) in.readObject();
            ArrayList<Potion> potions = (ArrayList<Potion>) in.readObject();
            int rounds = in.readInt();
            return new Object[]{player, potions, rounds};
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading game: " + e.getMessage());
            return null;
        }
    }
}
