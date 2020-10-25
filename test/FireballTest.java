import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireballTest {

    @Test
    void constantValuesSet(){
        Fireball fireball = new Fireball();
        assertEquals("Fireball",fireball.getName());
        assertEquals(5,fireball.getCost());
        assertEquals(1,fireball.getLevelReq());
        assertEquals("Fire",fireball.getDamageType());
        assertEquals(20,fireball.getDefaultDamage());
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

    @Test
    void hashCodeSameForAllFireballs(){
        Fireball fireball = new Fireball();
        Fireball fireball2 = new Fireball();
        assertEquals(true,fireball.hashCode()==fireball2.hashCode());
    }

}