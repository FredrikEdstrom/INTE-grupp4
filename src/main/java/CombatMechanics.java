public class CombatMechanics {

    public int attackOrder(Hero attacker, Enemy defender) {
        if(defender.getImmunityToPhysicalAttack()) {
            return 0;
        } else if(defender.getDefense() == 0){
            defender.setHealth(defender.getHealth() - (attacker.getAttack() / 1));
            return defender.getHealth();
        } else {
            defender.setHealth(defender.getHealth() - (attacker.getAttack() / defender.getDefense()));
            return defender.getHealth();
        }
    }

    public int attackOrder(Enemy attacker, Hero defender) {
        if(defender.getDefense() == 0) {
            defender.setHealth(defender.getHealth() - (attacker.getAttack() / 1));
            return defender.getHealth();
        } else {
            defender.setHealth(defender.getHealth() - (attacker.getAttack() / defender.getDefense()));
            return defender.getHealth();
        }
    }

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

    public Character firstMove(Character player, Character enemy) {
        if (player.getAgility() >= enemy.getAgility()) {
            return player;
        } else {
            return enemy;
        }
    }

}

