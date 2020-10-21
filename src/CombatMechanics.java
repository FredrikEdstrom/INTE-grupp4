import java.util.Scanner;

public class CombatMechanics {

    Scanner sc = new Scanner(System.in);

    public void attackOrder(Hero attacker, Hero defender) {
        defender.setHealth(defender.getHealth() - (attacker.getAttack() / defender.getDefense()));
        System.out.println(defender.getName() + " health = " + defender.getHealth());
    }

    public void defenseOrder(Hero a, Hero b) {
        a.setHealth(a.getHealth() - (b.getAttack() / (a.getDefense() * 2)));
    }

    public void magicAttack(Hero attacker, Hero defender) {
        attacker.setMana(attacker.getMana() - 20);
        defender.setHealth(defender.getHealth() - 2 * attacker.getAttack());
        System.out.println(attacker.getName() + " mana = " + attacker.getMana());
        System.out.println(defender.getName() + " health = " + defender.getHealth());
    }

    public void move(Hero player, Hero opponent) {
        if (player.getName().equals("player")) {
            String command = sc.nextLine();
            switch (command) {
                case "attack":
                    attackOrder(player, opponent);
                    break;

                case "defend":
                    defenseOrder(player, opponent);
                    break;

                case "magic attack":
                    magicAttack(player, opponent);
                    break;
            }
        } else {
            attackOrder(player, opponent);
        }
        move(opponent, player);
    }

    public void firstMove(Hero player, Hero opponent) {
        if (player.getAgility() >= opponent.getAgility()) {
            System.out.println("player is faster");
            move(player, opponent);
        } else {
            System.out.println("opponent is faster");
            move(opponent, player);
        }
    }

}

