import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeadArmorTest {

    @Test
    void checkIfHelmetHaveRightArmorType() {
        HeadArmor helmet = new HeadArmor("Helmet", 10, true);
        assertTrue(helmet.isHelmet());
        assertFalse(helmet.isCap());
    }

    @Test
    void checkIfCapHaveRightArmorType() {
        HeadArmor cap = new HeadArmor("Cap", 50, false);
        assertTrue(cap.isCap());
        assertFalse(cap.isHelmet());
    }

    @Test
    void checkIfHelmetHaveRightStats() {
        HeadArmor helmet = new HeadArmor("Helmet", 20, true);
        assertEquals("Helmet", helmet.getName());
        assertEquals(20, helmet.getLevel());
        assertEquals(100 ,helmet.getHealth());
        assertEquals(0 ,helmet.getMana());
        assertEquals(60, helmet.getDefense());
        assertEquals(0 , helmet.getAttack());
        assertEquals(0 , helmet.getIntelligence());
        assertEquals(0 , helmet.getAgility());
    }

    @Test
    void checkIfCapHaveRightStats(){
        HeadArmor cap = new HeadArmor("Cap", 60, false);
        assertEquals("Cap", cap.getName());
        assertEquals(60, cap.getLevel());
        assertEquals(0 ,cap.getHealth());
        assertEquals(300 ,cap.getMana());
        assertEquals(30, cap.getDefense());
        assertEquals(0 , cap.getAttack());
        assertEquals(0 , cap.getIntelligence());
        assertEquals(0 , cap.getAgility());
    }

}