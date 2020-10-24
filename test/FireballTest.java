import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireballTest {

    @Test
    void constantValuesSet(){
        Fireball fireball = new Fireball();
        assertEquals(20,fireball.getDefaultDamage());
        assertEquals("Fire",fireball.getDamageType());
        assertEquals(5,fireball.getDefaultManaCost());
        assertEquals(1,fireball.getLevelRequirement());
    }

    @Test
    void damageAffectedByHeroIntelligence(){
        Fireball fireball = new Fireball();
        Hero hero = new Hero("hero");
        assertEquals(40,fireball.getModifiedDamage(hero.getIntelligence()));
    }

    @Test
    void equalsOverride(){
        Fireball fireball = new Fireball();
        Fireball fireball2 = new Fireball();
        assertEquals(true,fireball.equals(fireball2));
    }

}