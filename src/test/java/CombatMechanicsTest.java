import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombatMechanicsTest {

    //instance of the CombatMechanics class that will be used for the all of the tests
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
    void playerAttacksEnemyWithLowestBaseAttackTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        cm.attackOrder(player, enemy);
        assertEquals(99, enemy.getHealth());
    }

    @Test
    void playerAttacksEnemyWithHigherThanPossibleBaseAttackTest() {
        Hero player = new Hero("player");
        player.setAttack(516);
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        cm.attackOrder(player, enemy);
        assertEquals(49, enemy.getHealth());
    }

    @Test
    void playerAttacksEnemyWithLowerThanPossibleBaseAttackTest() {
        Hero player = new Hero("player");
        player.setAttack(9);
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        cm.attackOrder(player, enemy);
        assertEquals(99, enemy.getHealth());
    }

    @Test
    void playerAttacksEnemyWithZeroAttackTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        player.setAttack(0);
        cm.attackOrder(player, enemy);
        assertEquals(99, enemy.getHealth());
    }

    @Test
    void playerAttacksEnemyWithNegativeAttackTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        player.setAttack(-100);
        cm.attackOrder(player, enemy);
        assertEquals(99, enemy.getHealth());
    }

    @Test
    void playerAttacksEnemyWhichHasLowestBaseDefenseTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        player.setAttack(100);
        enemy.setDefense(10);
        cm.attackOrder(player, enemy);
        assertEquals(90, enemy.getHealth());
    }

    @Test
    void playerAttacksEnemyWhichHasHigherThanPossibleDefenseTest() {
        Hero player = new Hero("player");
        player.setAttack(516);
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        player.setAttack(100);
        enemy.setDefense(516);
        cm.attackOrder(player, enemy);
        assertEquals(99, enemy.getHealth());
    }

    @Test
    void playerAttacksEnemyWhichHasLowerThanPossibleDefenseTest() {
        Hero player = new Hero("player");
        player.setAttack(9);
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        player.setAttack(100);
        enemy.setDefense(1);
        cm.attackOrder(player, enemy);
        assertEquals(0, enemy.getHealth());
        assertFalse(enemy.isAlive());
    }

    @Test
    void playerAttacksEnemyWhichHasZeroDefenseTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        player.setAttack(100);
        enemy.setDefense(0);
        cm.attackOrder(player, enemy);
        assertEquals(0, enemy.getHealth());
        assertFalse(enemy.isAlive());
    }

    @Test
    void playerAttacksEnemyWhichHasNegativeDefenseTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        player.setAttack(100);
        enemy.setDefense(-10);
        cm.attackOrder(player, enemy);
        assertEquals(0, enemy.getHealth());
        assertFalse(enemy.isAlive());
    }

    @Test
    void enemyAttacksPlayerWithLowestBaseAttackTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 1, 10, 10, 100, 100, 10, 5, false, false);
        cm.attackOrder(enemy, player);
        assertEquals(99, player.getHealth());
    }

    @Test
    void enemyAttacksPlayerWithHigherThanPossibleBaseAttackTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 1, 10, 10, 100, 100, 10, 5, false, false);
        enemy.setAttack(516);
        cm.attackOrder(enemy, player);
        assertEquals(49, player.getHealth());
    }

    @Test
    void enemyAttacksPlayerWithLowerThanPossibleAttackTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 1, 10, 10, 100, 100, 10, 5, false, false);
        enemy.setAttack(9);
        cm.attackOrder(enemy, player);
        assertEquals(99, player.getHealth());
    }

    @Test
    void enemyAttacksPlayerWithZeroAttackTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 1, 10, 10, 100, 100, 10, 5, false, false);
        enemy.setAttack(0);
        cm.attackOrder(enemy, player);
        assertEquals(99, player.getHealth());
    }

    @Test
    void enemyAttacksPlayerWithNegativeAttackTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 1, 10, 10, 100, 100, 10, 5, false, false);
        enemy.setAttack(-100);
        cm.attackOrder(enemy, player);
        assertEquals(99, player.getHealth());
    }

    @Test
    void playerMagicAttacksEnemyWithLowestBaseAttackTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        cm.magicAttack(player, enemy);
        assertEquals(80, player.getMana());
        assertEquals(80, enemy.getHealth());
    }

    @Test
    void playerMagicAttacksEnemyWithHigherThanPossibleAttackTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        player.setAttack(516);
        cm.magicAttack(player, enemy);
        assertEquals(80, player.getMana());
        assertEquals(0, enemy.getHealth());
    }

    @Test
    void playerMagicAttacksEnemyWithLowerThanPossibleAttackTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        player.setAttack(9);
        cm.magicAttack(player, enemy);
        assertEquals(80, player.getMana());
        assertEquals(82, enemy.getHealth());
    }

    @Test
    void playerMagicAttacksEnemyWithZeroAttackTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        player.setAttack(0);
        cm.magicAttack(player, enemy);
        assertEquals(80, player.getMana());
        assertEquals(100, enemy.getHealth());
    }

    @Test
    void playerMagicAttacksEnemyWithNegativeAttackTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        player.setAttack(-10);
        cm.magicAttack(player, enemy);
        assertEquals(80, player.getMana());
        assertEquals(120, enemy.getHealth());
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
    void playerAttacksEnemyWithNegativeDefenseTest() {
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, -10, 100, 100, 10, 5, false, false);
        cm.attackOrder(player, enemy);
        assertEquals(90, enemy.getHealth());
    }

    @Test
    void enemyAttacksPlayerWithZeroDefenseTest() {
        Hero player = new Hero("player");
        player.setDefense(0);
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        cm.attackOrder(enemy, player);
        assertEquals(90, player.getHealth());
    }

    @Test
    void enemyAttacksPlayerWithNegativeDefenseTest() {
        Hero player = new Hero("player");
        player.setDefense(-10);
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        cm.attackOrder(enemy, player);
        assertEquals(90, player.getHealth());
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

    @Test
    void setEnemyImmunityToPhysicalAttackTest(){
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        enemy.setImmunityToPhysicalAttack(true);
        cm.attackOrder(player, enemy);
        assertTrue(enemy.getImmunityToPhysicalAttack());
        assertEquals(100, enemy.getHealth());
    }

    @Test
    void setEnemyImmunityToMagicAttackTest(){
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        enemy.setImmunityToMagicAttack(true);
        cm.magicAttack(player, enemy);
        assertTrue(enemy.getImmunityToMagicAttack());
        assertEquals(100, enemy.getHealth());
    }

    @Test
    void setEnemyImmunityToPhysicalAndMagicAttackTest(){
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, false);
        enemy.setImmunityToPhysicalAttack(true);
        enemy.setImmunityToMagicAttack(true);
        cm.attackOrder(player, enemy);
        cm.magicAttack(player, enemy);
        assertTrue(enemy.getImmunityToPhysicalAttack());
        assertTrue(enemy.getImmunityToMagicAttack());
        assertEquals(100, player.getMana());
        assertEquals(100, enemy.getHealth());
    }

    @Test
    void removeEnemyImmunityToPhysicalAttackTest(){
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, true, false);
        enemy.setImmunityToPhysicalAttack(false);
        cm.attackOrder(player, enemy);
        assertFalse(enemy.getImmunityToPhysicalAttack());
        assertEquals(99, enemy.getHealth());
    }

    @Test
    void removeEnemyImmunityToMagicAttackTest(){
        Hero player = new Hero("player");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, true);
        enemy.setImmunityToMagicAttack(false);
        cm.attackOrder(player, enemy);
        assertFalse(enemy.getImmunityToMagicAttack());
        assertEquals(99, enemy.getHealth());
    }

    @Test
    void bothHeroAndEnemyKillable(){
        Hero hero = new Hero("hero");
        Enemy enemy = new Enemy("enemy", 10, 10, 10, 100, 100, 10, 5, false, true);
        enemy.setImmunityToPhysicalAttack(true);
        enemy.setImmunityToMagicAttack(true);
        hero.setDefense(11);
        cm.attackOrder(hero,enemy);
        cm.attackOrder(enemy,hero);
        assertEquals(100,enemy.getHealth());
        assertEquals(99, hero.getHealth());
    }

    @Test
    void heroDamageAndKillEnemy(){
        Hero hero = new Hero("hero");
        Enemy enemy = new Enemy("enemy", 10, 10, 0, 100, 100, 10, 5, false, false);
        while(enemy.isAlive()){
            cm.attackOrder(hero, enemy);
            cm.attackOrder(enemy, hero);
        }
        assertFalse(enemy.isAlive());
        assertTrue(hero.isAlive());
    }

    @Test
    void EnemyDamageAndKillHero(){
        Hero hero = new Hero("hero");
        Enemy enemy = new Enemy("enemy", 10, 100, 10, 100, 100, 10, 5, false, false);
        while(hero.isAlive()){
            cm.attackOrder(hero, enemy);
            cm.attackOrder(enemy, hero);
        }
        assertFalse(hero.isAlive());
        assertTrue(enemy.isAlive());
    }

    @Test
    void magicSpellAttackUsesAttackSpell(){
        Hero hero = new Hero("hero");
        Enemy enemy = new Enemy("enemy", 10, 100, 10, 100, 100, 10, 5, false, false);
        Fireball fireball = new Fireball();
        hero.addSpellToSpellBook(fireball);
        cm.magicSpellAttack(hero,enemy,fireball);
        assertEquals(60,enemy.getHealth());
    }

    @Test
    void magicSpellAttackWithInsufficientMana(){
        Hero hero = new Hero("hero");
        Enemy enemy = new Enemy("enemy", 10, 100, 10, 100, 100, 10, 5, false, false);
        Fireball fireball = new Fireball();
        hero.addSpellToSpellBook(fireball);
        hero.setMana(1);     //fireball manacost is 5
        cm.magicSpellAttack(hero,enemy,fireball);
        assertEquals(100,enemy.getHealth()); //enemy should be undamaged
    }

    @Test
    void magicSpellAttackOnImmuneEnemy(){
        Hero hero = new Hero("hero");
        Enemy enemy = new Enemy("enemy", 10, 100, 10, 100, 100, 10, 5, false, false);
        Fireball fireball = new Fireball();
        hero.addSpellToSpellBook(fireball);
        enemy.setImmunityToMagicAttack(true);
        cm.magicSpellAttack(hero,enemy,fireball);
        assertEquals(100,enemy.getHealth());
    }

    @Test
    void magicSpellAttackUntilEnemyDead(){
        Hero hero = new Hero("hero");
        Enemy enemy = new Enemy("enemy", 10, 100, 10, 100, 100, 10, 5, false, false);
        Fireball fireball = new Fireball();
        hero.addSpellToSpellBook(fireball);
        while (enemy.isAlive())
            cm.magicSpellAttack(hero,enemy,fireball);
        assertFalse(enemy.isAlive());
        assertEquals(0,enemy.getHealth());
    }

}
