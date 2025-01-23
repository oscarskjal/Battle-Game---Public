public class Main {
    public static void main(String[] args) {
        System.out.println("Let the battle begin!");


        Weapon sword = new Weapon("Sword", 10);
        Weapon claws = new Weapon("Hammer", 8);


        GameCharacter player1 = new Player(100, "Player1", sword);
        GameCharacter monster = new Npc(50, "Monster", claws);

        for (int round = 1; player1.getHp() > 0 && monster.getHp() > 0; round++) {
            System.out.println("\nRound " + round);
            System.out.println(player1.getName() + " HP: " + player1.getHp());
            System.out.println(monster.getName() + " HP: " + monster.getHp());


            player1.attack(monster);
            if (monster.getHp() <= 0) {
                System.out.println(monster.getName() + " has been defeated! You win!");
                break;
            }


            monster.attack(player1);
            if (player1.getHp() <= 0) {
                System.out.println(player1.getName() + " has been defeated! You lose!");
                break;
            }
        }
    }
}
