import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandArmorTest {

    @Test
    void checkIfGauntletsHaveRightArmorType() {
        HandArmor gauntlets = new HandArmor("Gauntlets", 15, true);
        assertTrue(gauntlets.isGauntlets());
        assertFalse(gauntlets.isGloves());
    }

    @Test
    void checkIfGlovesHaveRightArmorType() {
        HandArmor gloves = new HandArmor("Gloves", 15, false);
        assertTrue(gloves.isGloves());
        assertFalse(gloves.isGauntlets());
    }

    @Test
    void checkIfGauntletsHaveRightStats() {
        HandArmor gauntlets = new HandArmor("Gauntlets", 40, true);
        assertEquals("Gauntlets", gauntlets.getName());
        assertEquals(40, gauntlets.getLevel());
        assertEquals(200 ,gauntlets.getHealth());
        assertEquals(0 ,gauntlets.getMana());
        assertEquals(120, gauntlets.getDefense());
        assertEquals(120 , gauntlets.getAttack());
        assertEquals(0 , gauntlets.getIntelligence());
        assertEquals(0 , gauntlets.getAgility());
    }

    @Test
    void checkIfGlovesHaveRightStats(){
        HandArmor gloves = new HandArmor("Gloves", 80, false);
        assertEquals("Gloves", gloves.getName());
        assertEquals(80, gloves.getLevel());
        assertEquals(0 ,gloves.getHealth());
        assertEquals(400 ,gloves.getMana());
        assertEquals(40, gloves.getDefense());
        assertEquals(0 , gloves.getAttack());
        assertEquals(240 , gloves.getIntelligence());
        assertEquals(0 , gloves.getAgility());
    }

}