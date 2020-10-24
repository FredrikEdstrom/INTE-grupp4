import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombatMechanicsTest {

    CombatMechanics cm = new CombatMechanics();

    @Test
    void playerIsFasterTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 100, 100, 10, 5, 5, false, false);
        assertEquals(player, cm.firstMove(player, enemy));
    }

    @Test
    void enemyIsFasterTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 15, false, false);
        assertEquals(enemy, cm.firstMove(player, enemy));
    }

    @Test
    void playerAndEnemyAreEquallyFastTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 10, false, false);
        assertEquals(player, cm.firstMove(player, enemy));
    }

    @Test
    void enemyAndPlayerAreEquallyFastTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 10, false, false);
        assertEquals(enemy, cm.firstMove(enemy, player));
    }

    @Test
    void playerAttacksEnemyTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        cm.attackOrder(player, enemy);
        assertEquals(99, enemy.getHealth());
    }

    @Test
    void enemyAttacksPlayerTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        cm.attackOrder(enemy, player);
        assertEquals(99, player.getHealth());
    }

    @Test
    void playerMagicAttacksEnemyTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        cm.magicAttack(player, enemy);
        assertEquals(80, player.getMana());
        assertEquals(80, enemy.getHealth());
    }

    @Test
    void playerAttacksEnemyImmuneToPhysicalAttacksTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, true, false);
        cm.attackOrder(player, enemy);
        assertEquals(100, enemy.getHealth());
    }

    @Test
    void playerAttacksEnemyImmuneToMagicAttacksTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, true);
        cm.magicAttack(player, enemy);
        assertEquals(100, enemy.getHealth());
    }

    @Test
    void playerAttacksEnemyWithZeroDefenseTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 0, 100, 100, 10, 5, false, false);
        cm.attackOrder(player, enemy);
        assertEquals(90, enemy.getHealth());
    }

    @Test
    void enemyAttacksPlayerWithZeroDefenseTest() {
        Hero player = new Hero("player");
        player.setDefense(0);
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        cm.attackOrder(enemy, player);
        assertEquals(0, player.getDefense());
    }

    @Test
    void playerAttacksEnemyWithZeroDefenseWithMagicAttackTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 0, 100, 100, 10, 5, false, false);
        cm.magicAttack(player, enemy);
        assertEquals(80, player.getMana());
        assertEquals(80, enemy.getHealth());
    }

    @Test
    void playerAttacksWithMagicAttackWithoutSufficientManaTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        player.setMana(15);
        cm.magicAttack(player, enemy);
        assertEquals(15, player.getMana());
        assertEquals(100, enemy.getHealth());
    }

}
