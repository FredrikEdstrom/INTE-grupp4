import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestoreHealthTest {

    @Test
    void constantValuesSet(){
        RestoreHealth restoreHealth = new RestoreHealth();
        assertEquals("Restore Health",restoreHealth.getName());
        assertEquals(20,restoreHealth.getCost());
        assertEquals(1,restoreHealth.getLevelReq());;
        assertEquals(20,restoreHealth.getHealValue());
    }

    @Test
    void healValueAffectedByHeroIntelligence(){
        RestoreHealth restoreHealth = new RestoreHealth();
        Hero hero = new Hero("hero");
        assertEquals(40,restoreHealth.getModifiedHealValue(hero.getIntelligence()));
    }

    @Test
    void heroHealthHealed(){
        Hero hero = new Hero("hero");                    //intelligence 10
        RestoreHealth restoreHealth = new RestoreHealth();     //default heal 20
        hero.setHealth(60);
        hero.castHealSpell(restoreHealth);                    //healvalue is defaultheal + int*2
        assertEquals(100,hero.getHealth());
    }

    @Test
    void heroHealthOverhealStartValue(){
        Hero hero = new Hero("hero");
        RestoreHealth restoreHealth = new RestoreHealth();
        hero.castHealSpell(restoreHealth);
        assertEquals(100,hero.getHealth());
    }

    @Test
    void equalsOverride(){
        RestoreHealth restoreHealth = new RestoreHealth();
        RestoreHealth restoreHealth2 = new RestoreHealth();
        Fireball fireball = new Fireball();
        assertTrue(restoreHealth.equals(restoreHealth2));
        assertFalse(restoreHealth.equals(fireball));

    }

    @Test
    void hashCodeSameForALlRestoreHealths(){
        RestoreHealth restoreHealth = new RestoreHealth();
        RestoreHealth restoreHealth2 = new RestoreHealth();
        assertTrue(restoreHealth.hashCode() == restoreHealth2.hashCode());
    }

}