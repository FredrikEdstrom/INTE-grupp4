import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuffSpellTest {

    @Test
    void constructorSetsBuffValueAndDuration(){
        BuffSpell spell = new BuffSpell("AttackUp",10,1,50, 3);
        assertEquals(50,spell.getBuffValue());
        assertEquals(3,spell.getDuration());
    }

    @Test
    void heroStatAffectedByBuffSpell(){
        Hero hero = new Hero("hero");
        BuffSpell spell1 = new BuffSpell("AttackUp",10,1,50,3);
        BuffSpell spell2 = new BuffSpell("DefenseUp",10,1,50,3);
        BuffSpell spell3 = new BuffSpell("IntelligenceUp",10,1,50,3);
        hero.castBuffSpell(spell1);
        hero.castBuffSpell(spell2);
        hero.castBuffSpell(spell3);
        assertEquals(60,hero.getAttack());
        assertEquals(60,hero.getDefense());
        assertEquals(60,hero.getIntelligence());

    }
}