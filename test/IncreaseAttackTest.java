import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncreaseAttackTest {
    @Test
    void constantValuesSet(){
        IncreaseAttack increaseAttack = new IncreaseAttack();
        assertEquals("Increase Attack",increaseAttack.getName());
        assertEquals(25,increaseAttack.getCost());
        assertEquals(2,increaseAttack.getLevelReq());
        assertEquals(50,increaseAttack.getBuffValue());
        assertEquals(3,increaseAttack.getDuration());
    }

    @Test
    void heroAttackIncreased(){
        Hero hero = new Hero("hero");
        IncreaseAttack increaseAttack = new IncreaseAttack();
        hero.castBuffSpell(increaseAttack);
        assertEquals(60,hero.getAttack());
    }

    @Test
    void equalsOverride(){
        IncreaseAttack increaseAttack = new IncreaseAttack();
        IncreaseAttack increaseAttack2 = new IncreaseAttack();
        assertEquals(true,increaseAttack.equals(increaseAttack2));
    }

    @Test
    void hashCodeSameForAllIncreaseAttacks(){
        IncreaseAttack increaseAttack = new IncreaseAttack();
        IncreaseAttack increaseAttack2 = new IncreaseAttack();
        assertEquals(true,increaseAttack.hashCode() == increaseAttack2.hashCode());
    }
}