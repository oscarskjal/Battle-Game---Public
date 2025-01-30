import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the battle game!");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.println("\nLet the battle begin, " + playerName + "!");


        Weapon sword = new Weapon("Sword", 20);
        Weapon axe = new Weapon("Axe", 30);
        GameCharacter player1 = new Player(100, playerName, sword, 0.8);


        player1.addWeaponToInventory(sword);
        player1.addWeaponToInventory(axe);

        boolean continueGame = true;

        while (continueGame && player1.getHp() > 0) {
            GameCharacter monster = Npc.spawnNpc();

            System.out.println("\nA wild " + monster.getName() + " appears!");

            for (int round = 1; player1.getHp() > 0 && monster.getHp() > 0; round++) {
                System.out.println("\nRound " + round);
                System.out.println(player1.getName() + " HP: " + player1.getHp());
                System.out.println(monster.getName() + " HP: " + monster.getHp());

                System.out.println("\nIt's your turn! Choose an option:");
                System.out.println("1: Attack");
                System.out.println("2: Quit");
                System.out.println("3: Choose weapon from inventory");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                if (choice == 2) {
                    System.out.println("You chose to quit the game. Goodbye!");
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
                        int weaponChoice = scanner.nextInt();
                        if (weaponChoice >= 1 && weaponChoice <= player1.getInventory().size()) {
                            Weapon selectedWeapon = player1.getInventory().get(weaponChoice - 1);
                            player1.setEquippedWeapon(selectedWeapon);
                            System.out.println("You have equipped the " + selectedWeapon.getName());
                        } else {
                            System.out.println("Invalid choice. No weapon equipped.");
                        }
                    }
                } else if (choice == 1) {

                    player1.attack(monster);
                    if (monster.getHp() <= 0) {
                        System.out.println(monster.getName() + " has been defeated!");
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
            int nextChoice = scanner.nextInt();

            if (nextChoice == 2) {
                System.out.println("You chose to end your journey, " + playerName + "!");
                continueGame = false;
            }
        }

        if (player1.getHp() <= 0) {
            System.out.println("Your journey ends here. Better luck next time!");
        } else {
            System.out.println("Thanks for playing!");
        }

        scanner.close();
    }
}
