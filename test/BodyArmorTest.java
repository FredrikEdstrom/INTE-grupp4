import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyArmorTest {

    @Test
    void createBodyArmorLevelOne() {
        BodyArmor rustyPlate = new BodyArmor("Rusty Plate", 1);
        assertEquals("Rusty Plate", rustyPlate.getName());
        assertEquals(1, rustyPlate.getLevel());
        assertEquals(20, rustyPlate.getHealth());
        assertEquals(20, rustyPlate.getMana());
        assertEquals(10, rustyPlate.getDefense());
    }
    @Test
    void createBodyArmorHigherThanLevelOne() {
        BodyArmor steelPlate = new BodyArmor("Steel Plate", 33);
        assertEquals("Steel Plate", steelPlate.getName());
        assertEquals(33, steelPlate.getLevel());
        assertEquals(185, steelPlate.getHealth());
        assertEquals(185, steelPlate.getMana());
        assertEquals(109, steelPlate.getDefense());
    }
    @Test
    void createBodyArmorEmptyName() {
        assertThrows(IllegalArgumentException.class,
                () -> new BodyArmor("", 11));
    }
    @Test
    void createBodyArmorBlankName() {
        assertThrows(IllegalArgumentException.class,
                () -> new BodyArmor(" ", 22));
    }
    @Test
    void createBodyArmorLowerThanLevelOne() {
        assertThrows(IllegalArgumentException.class,
                () -> new BodyArmor("Melted Plate", 0));
    }
    @Test
    void createBodyArmorHigherThanLevelOneHundred() {
        assertThrows(IllegalArgumentException.class,
                () -> new BodyArmor("Thor Armor", 101));
    }
}