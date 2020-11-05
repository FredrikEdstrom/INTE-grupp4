import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LegArmorTest {

    @Test
    void checkIfLegPlateHaveRightArmorType() {
        LegArmor legPlate = new LegArmor("Leg Plate", 1, true);
        assertTrue(legPlate.isPlate());
        assertFalse(legPlate.isTrousers());
    }

    @Test
    void checkIfTrousersHaveRightArmorType() {
        LegArmor trousers = new LegArmor("Trousers", 1, false);
        assertTrue(trousers.isTrousers());
        assertFalse(trousers.isPlate());
    }

    @Test
    void checkIfLegPlateHaveRightStats() {
        LegArmor legPlate = new LegArmor("Leg Plate", 50, true);
        assertEquals("Leg Plate", legPlate.getName());
        assertEquals(50, legPlate.getLevel());
        assertEquals(500, legPlate.getHealth());
        assertEquals(25, legPlate.getMana());
        assertEquals(150, legPlate.getDefense());
        assertEquals(0, legPlate.getAttack());
        assertEquals(0, legPlate.getIntelligence());
        assertEquals(25, legPlate.getAgility());
    }

    @Test
    void checkIfTrousersHaveRightStats() {
        LegArmor trousers = new LegArmor("Trousers", 90, false);
        assertEquals("Trousers", trousers.getName());
        assertEquals(90, trousers.getLevel());
        assertEquals(45, trousers.getHealth());
        assertEquals(900, trousers.getMana());
        assertEquals(45, trousers.getDefense());
        assertEquals(0, trousers.getAttack());
        assertEquals(0, trousers.getIntelligence());
        assertEquals(270, trousers.getAgility());
    }

    @Test
    void legPlateWithLevelHigherThanTrousers() {
        Armor legPlate = new LegArmor("Leg Plate", 10, true);
        Armor trousers = new LegArmor("Trousers", 1, false);

        assertTrue(legPlate.getHealth() > trousers.getHealth());
        assertFalse(legPlate.getMana() > trousers.getMana());
        assertTrue(legPlate.getDefense() > trousers.getDefense());
        assertTrue(legPlate.getAgility() > trousers.getAgility());
    }

    @Test
    void legPlateWithLevelLowerThanTrousers() {
        Armor legPlate = new LegArmor("Leg Plate", 20, true);
        Armor trousers = new LegArmor("Trousers", 50, false);

        assertTrue(legPlate.getHealth() > trousers.getHealth());
        assertFalse(legPlate.getMana() > trousers.getMana());
        assertTrue(legPlate.getDefense() > trousers.getDefense());
        assertFalse(legPlate.getAgility() > trousers.getAgility());
    }

    @Test
    void legPlateWithLevelEqualToTrousers() {
        Armor legPlate = new LegArmor("Leg Plate", 100, true);
        Armor trousers = new LegArmor("Trousers", 100, false);

        assertTrue(legPlate.getHealth() > trousers.getHealth());
        assertFalse(legPlate.getMana() > trousers.getMana());
        assertTrue(legPlate.getDefense() > trousers.getDefense());
        assertFalse(legPlate.getAgility() > trousers.getAgility());
    }

    @Test
    void legPlateAndTrousersHaveSameHealth() {
        Armor legPlate = new LegArmor("Leg Plate", 5, true);
        Armor trousers = new LegArmor("Trousers", 100, false);

        assertEquals(trousers.getHealth(), legPlate.getHealth());
        assertFalse(legPlate.getMana() > trousers.getMana());
        assertFalse(legPlate.getDefense() > trousers.getDefense());
        assertFalse(legPlate.getAgility() > trousers.getAgility());
    }

    @Test
    void legPlateAndTrousersHaveSameDefense() {
        Armor legPlate = new LegArmor("Leg Plate", 10, true);
        Armor trousers = new LegArmor("Trousers", 60, false);

        assertTrue(legPlate.getHealth() > trousers.getHealth());
        assertFalse(legPlate.getMana() > trousers.getMana());
        assertEquals(legPlate.getDefense(), trousers.getDefense());
        assertFalse(legPlate.getAgility() > trousers.getAgility());
    }
}