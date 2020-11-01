public class CombatMechanics {

    //A method that takes in an instance of a Hero and Enemy as parameters and deducts a certain amount of
    //health from the enemy object depending on the hero objects attack, and the enemy objects
    // defense and puts that value as the enemy objects new health value
    public int attackOrder(Hero attacker, Enemy defender) {
        if(defender.getImmunityToPhysicalAttack()) {
            return 0;
        } else {
            if(defender.getDefense() == 0){
                defender.setHealth(defender.getHealth() - attacker.getAttack());
            } else {
                defender.setHealth(defender.getHealth() - (attacker.getAttack() / defender.getDefense()));
            }
            return defender.getHealth();
        }
    }

    //A method that takes in an instance of a Hero and Enemy as parameters and deducts a certain amount of
    //health from the hero object depending on the enemy objects attack, and the hero objects defense and
    // puts that value as the hero objects new health value
    public int attackOrder(Enemy attacker, Hero defender) {
        if(defender.getDefense() == 0) {
            defender.setHealth(defender.getHealth() - attacker.getAttack());
        } else {
            defender.setHealth(defender.getHealth() - (attacker.getAttack() / defender.getDefense()));
        }
        return defender.getHealth();
    }

    //A method that takes in an instance of a Hero and Enemy as parameters and deducts a certain amount of
    //health from the enemy object depending on the hero objects attack while reducing the hero objects
    //mana value by 20
    public int magicAttack(Hero attacker, Enemy defender) {
        if(defender.getImmunityToMagicAttack()) {
            return 0;
        } else if(attacker.getMana() < 20) {
            return 0;
        }	else {
            attacker.setMana(attacker.getMana() - 20);
            defender.setHealth(defender.getHealth() - 2 * attacker.getAttack());
            return defender.getHealth();
        }
    }

    //A method that takes in an instance of a Hero and Enemy as parameters and compares their
    //agility values and returns the object with higher agility value or returns the hero if both objects
    //have the same ability value
    public Character firstMove(Character player, Character enemy) {
        if (player.getAgility() >= enemy.getAgility()) {
            return player;
        } else {
            return enemy;
        }
    }
}