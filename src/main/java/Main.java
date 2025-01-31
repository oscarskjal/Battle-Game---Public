import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final String SAVE_FILE = "savegame.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Player player1 = null;
        ArrayList<Potion> potionInventory = new ArrayList<>();
        int totalRounds = 0;
        boolean continueGame = true;


        if (new File(SAVE_FILE).exists()) {
            System.out.println("A saved game was found. Do you want to continue?");
            System.out.println("1: Yes");
            System.out.println("2: No (Start a new game)");
            System.out.print("Enter your choice: ");
            int choice = getValidInt(scanner);

            if (choice == 1) {
                player1 = loadGame();
                if (player1 != null) {
                    System.out.println("Game loaded successfully!");
                } else {
                    System.out.println("Failed to load the game. Starting a new game.");
                }
            }
        }


        if (player1 == null) {
            System.out.println("Welcome to the battle game!");
            System.out.print("Enter your name (press enter when ready): ");
            String playerName = scanner.nextLine();

            System.out.println("\nLet the battle begin, " + playerName + "!");
            Weapon sword = new Weapon("Sword", 20);
            Weapon axe = new Weapon("Axe", 20);
            player1 = new Player(100, playerName, sword, 0.8);

            player1.addWeaponToInventory(sword);
            player1.addWeaponToInventory(axe);
        }

        while (continueGame && player1.getHp() > 0) {
            GameCharacter monster = Npc.spawnNpc();
            System.out.println("\nA wild " + monster.getName() + " appears!");

            while (player1.getHp() > 0 && monster.getHp() > 0) {
                totalRounds++;
                System.out.println("\nRound " + totalRounds);
                System.out.println(player1.getName() + " HP: " + player1.getHp());
                System.out.println(monster.getName() + " HP: " + monster.getHp());
                System.out.println("Potions: " + potionInventory.size());

                System.out.println("\nIt's your turn! Choose an option:");
                System.out.println("1: Attack");
                System.out.println("2: Quit and Save");
                System.out.println("3: Choose weapon from inventory");
                System.out.println("4: Use a potion (" + potionInventory.size() + " left)");
                System.out.print("Enter your choice: ");

                int choice = getValidInt(scanner);

                if (choice == 2) {
                    System.out.println("Saving game and quitting...");
                    saveGame(player1, potionInventory, totalRounds);
                    continueGame = false;
                    break;
                } else if (choice == 3) {
                    if (player1.getInventory().isEmpty()) {
                        System.out.println("You have no weapons in your inventory!");
                    } else {
                        System.out.println("Choose a weapon from your inventory:");
                        for (int i = 0; i < player1.getInventory().size(); i++) {
                            System.out.println((i + 1) + ": " + player1.getInventory().get(i).getName());
                        }
                        System.out.print("Enter the weapon number to equip: ");
                        int weaponChoice = getValidInt(scanner);
                        if (weaponChoice >= 1 && weaponChoice <= player1.getInventory().size()) {
                            Weapon selectedWeapon = player1.getInventory().get(weaponChoice - 1);
                            player1.setEquippedWeapon(selectedWeapon);
                            System.out.println("You have equipped the " + selectedWeapon.getName());
                        } else {
                            System.out.println("Invalid choice. No weapon equipped.");
                        }
                    }
                } else if (choice == 4) {
                    if (potionInventory.isEmpty()) {
                        System.out.println("You have no potions!");
                    } else {
                        Potion potion = potionInventory.remove(0);
                        player1.usePotion(potion);
                        System.out.println("You used a potion! Potions left: " + potionInventory.size());
                    }
                } else if (choice == 1) {
                    player1.attack(monster);
                    if (monster.getHp() <= 0) {
                        System.out.println(monster.getName() + " has been defeated!");

                        System.out.println("Do you want to pick up " + monster.getName() + "'s weapon?");
                        System.out.println("1: Yes");
                        System.out.println("2: No");
                        System.out.print("Enter your choice: ");
                        int pickupChoice = getValidInt(scanner);
                        if (pickupChoice == 1) {
                            Weapon monsterWeapon = ((Npc) monster).getWeapon();
                            player1.addWeaponToInventory(monsterWeapon);
                            System.out.println("You picked up " + monsterWeapon.getName() + "!");
                        }

                        if (random.nextInt(100) < 20) { // kan ändras senare
                            Potion droppedPotion = new Potion(30);
                            potionInventory.add(droppedPotion);
                            System.out.println("The monster dropped a potion! You now have " + potionInventory.size() + " potions.");
                        }
                        break;
                    }
                } else {
                    System.out.println("Invalid choice. Skipping your turn!");
                    continue;
                }

                monster.attack(player1);
                if (player1.getHp() <= 0) {
                    System.out.println(player1.getName() + " has been defeated! Game over.");
                    continueGame = false;
                    break;
                }
            }

            if (!continueGame || player1.getHp() <= 0) {
                break;
            }

            System.out.println("\nDo you want to continue to the next battle?");
            System.out.println("1: Yes");
            System.out.println("2: No");
            System.out.print("Enter your choice: ");
            int nextChoice = getValidInt(scanner);

            if (nextChoice == 2) {
                System.out.println("Saving game and exiting...");
                saveGame(player1, potionInventory, totalRounds);
                continueGame = false;
            }
        }

        System.out.println("\nGame Over! You survived " + totalRounds + " rounds.");
        scanner.close();
    }

    private static int getValidInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please type in a number!");
                scanner.next();
            }
        }
    }

    private static void saveGame(Player player, ArrayList<Potion> potions, int rounds) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            out.writeObject(player);
            out.writeObject(potions);
            out.writeInt(rounds);
            System.out.println("Game saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }

    private static Player loadGame() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
            Player player = (Player) in.readObject();
            return player;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading game: " + e.getMessage());
            return null;
        }
    }
}

