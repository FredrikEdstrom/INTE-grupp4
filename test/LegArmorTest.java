import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LegArmorTest {

    @Test
    void createLegArmorLevelOne() {
        LegArmor rustyLegPlate = new LegArmor("Rusty Leg Plate", 1);
        assertEquals("Rusty Leg Plate", rustyLegPlate.getName());
        assertEquals(1, rustyLegPlate.getLevel());
        assertEquals(20, rustyLegPlate.getHealth());
        assertEquals(20, rustyLegPlate.getMana());
        assertEquals(10, rustyLegPlate.getDefense());
    }

    @Test
    void createLegArmorHigherThanLevelOne() {
        LegArmor steelLegPlate = new LegArmor("Steel Leg Plate", 50);
        assertEquals("Steel Leg Plate", steelLegPlate.getName());
        assertEquals(50, steelLegPlate.getLevel());
        assertEquals(95, steelLegPlate.getHealth());
        assertEquals(95, steelLegPlate.getMana());
        assertEquals(85, steelLegPlate.getDefense());
    }

    @Test
    void createLegArmorEmptyName() {
        assertThrows(IllegalArgumentException.class,
                () -> new LegArmor("", 9));
    }

    @Test
    void createLegArmorBlankName() {
        assertThrows(IllegalArgumentException.class,
                () -> new LegArmor(" ", 35));
    }

    @Test
    void createLegArmorLowerThanLevelOne() {
        assertThrows(IllegalArgumentException.class,
                () -> new LegArmor("Melted Leg Plate", 0));
    }

    @Test
    void createLegArmorHigherThanLevelOneHundred() {
        assertThrows(IllegalArgumentException.class,
                () -> new LegArmor("Thor Leg Armor", 101));
    }
}