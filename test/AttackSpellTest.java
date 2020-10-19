import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttackSpellTest {

    @Test
    void constructorSetsDamageTypeAndDefaultDamage(){
        AttackSpell spell = new AttackSpell("Fireball",20,1,"Fire",25);
        assertEquals("Fire",spell.getDamageType());
        assertEquals(25,spell.getDefaultDamage());
    }

    @Test
    void damageAffectedByHeroIntelligence(){
        Hero hero = new Hero("hero");
        AttackSpell spell = new AttackSpell("Fireball", 20,1,"Fire",25);
        assertEquals(35,spell.getModifiedDamage(hero.getIntelligence()));
    }

}