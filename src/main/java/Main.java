public class Main {
    public static void main(String[] args) {

        System.out.println("Let the battle begin!");


        GameCharacter player1 = new GameCharacter(10, 100, "Player1");
        GameCharacter monster = new GameCharacter(15, 50, "Monster");


        for (int round = 1; player1.getHp() > 0 && monster.getHp() > 0; round++) {

            System.out.println("Round " + round);
            System.out.println(player1.getName() + " HP: " + player1.getHp());
            System.out.println(monster.getName() + " HP: " + monster.getHp());


            System.out.println(player1.getName() + " attacks " + monster.getName());
            monster.takeDamage(player1.getDamage());


            if (monster.getHp() <= 0) {
                System.out.println(monster.getName() + " has been defeated!");
                break;
            }


            System.out.println(monster.getName() + " attacks " + player1.getName());
            player1.takeDamage(monster.getDamage());


            if (player1.getHp() <= 0) {
                System.out.println(player1.getName() + " has been defeated!");
                break;
            }
        }
    }
}

