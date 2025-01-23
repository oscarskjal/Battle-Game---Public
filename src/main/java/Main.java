import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the battle game!");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.println("\nLet the battle begin, " + playerName + "!");


        Weapon sword = new Weapon("Sword", 20);
        Weapon enemyWeapon = new Weapon("Hammer", 15);


        GameCharacter player1 = new Player(100, playerName, null, 0.8);

        boolean continueGame = true;

        while (continueGame && player1.getHp() > 0) {

            String enemyName = "Monster";
            GameCharacter monster = new Npc(50, enemyName, enemyWeapon, 0.6);

            System.out.println("\nA wild " + monster.getName() + " appears!");


            for (int round = 1; player1.getHp() > 0 && monster.getHp() > 0; round++) {
                System.out.println("\nRound " + round);
                System.out.println(player1.getName() + " HP: " + player1.getHp());
                System.out.println(monster.getName() + " HP: " + monster.getHp());


                System.out.println("\nIt's your turn! Do you want to attack or quit?");
                System.out.println("1: Attack");
                System.out.println("2: Quit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                // Ingen logik för string inputs ännu!

                if (choice == 2) {
                    System.out.println("You chose to quit the game. Goodbye!");
                    continueGame = false;
                    break;
                } else if (choice != 1) {
                    System.out.println("Invalid choice. Skipping your turn!");
                    continue;
                }


                player1.attack(monster);
                if (monster.getHp() <= 0) {
                    System.out.println(monster.getName() + " has been defeated!");
                    break;
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
                System.out.println("You chose to end your journey!" + playerName + "!");
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


    // Int oblikatoriska saker jag kan adda i framtiden: Update rundan i scanner till att matcha tillfälliga rundan
    // Currency och shop för t.ex healing och nya weapons, t.ex i scannern input 3: shop.

}
