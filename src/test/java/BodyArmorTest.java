import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyArmorTest {

    @Test
    void checkIfBodyPlateHaveRightArmorType() {
        BodyArmor bodyPlate = new BodyArmor("Body Plate", 5, true);
        assertTrue(bodyPlate.isPlate());
        assertFalse(bodyPlate.isRobe());
    }

    @Test
    void checkIfRobeHaveRightArmorType() {
        BodyArmor robe = new BodyArmor("Robe", 5, false);
        assertTrue(robe.isRobe());
        assertFalse(robe.isPlate());
    }

    @Test
    void checkIfBodyPlateHaveRightStats() {
        BodyArmor bodyPlate = new BodyArmor("Body Plate", 30, true);
        assertEquals("Body Plate", bodyPlate.getName());
        assertEquals(30, bodyPlate.getLevel());
        assertEquals(300 ,bodyPlate.getHealth());
        assertEquals(15 ,bodyPlate.getMana());
        assertEquals(150, bodyPlate.getDefense());
        assertEquals(90 , bodyPlate.getAttack());
        assertEquals(0 , bodyPlate.getIntelligence());
        assertEquals(0 , bodyPlate.getAgility());
    }

    @Test
    void checkIfRobeHaveRightStats(){
        BodyArmor robe = new BodyArmor("Robe", 70, false);
        assertEquals("Robe", robe.getName());
        assertEquals(70, robe.getLevel());
        assertEquals(35 ,robe.getHealth());
        assertEquals(700 ,robe.getMana());
        assertEquals(35, robe.getDefense());
        assertEquals(0 , robe.getAttack());
        assertEquals(210 , robe.getIntelligence());
        assertEquals(0 , robe.getAgility());
    }
}