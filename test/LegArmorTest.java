import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LegArmorTest {

    @Test
    void createLegPlateLevelOne() {
        LegArmor rustyLegPlate = new LegPlate("Rusty Leg Plate", 1);
        assertEquals("Rusty Leg Plate", rustyLegPlate.getName());
        assertEquals(1, rustyLegPlate.getLevel());
        assertEquals(20, rustyLegPlate.getHealth());
        assertEquals(5, rustyLegPlate.getMana());
        assertEquals(5, rustyLegPlate.getAgility());
        assertEquals(10, rustyLegPlate.getDefense());
    }

    @Test
    void createTrousersLevelOne() {
        LegArmor noviceTrousers = new Trousers("Novice Trousers", 1);
        assertEquals("Novice Trousers", noviceTrousers.getName());
        assertEquals(1, noviceTrousers.getLevel());
        assertEquals(5, noviceTrousers.getHealth());
        assertEquals(20, noviceTrousers.getMana());
        assertEquals(10, noviceTrousers.getAgility());
        assertEquals(5, noviceTrousers.getDefense());
    }

    @Test
    void createLegPlateHigherThanLevelOne() {
        LegArmor steelLegPlate = new LegPlate("Steel Leg Plate", 50);
        assertEquals("Steel Leg Plate", steelLegPlate.getName());
        assertEquals(50, steelLegPlate.getLevel());
        assertEquals(270, steelLegPlate.getHealth());
        assertEquals(55, steelLegPlate.getMana());
        assertEquals(55, steelLegPlate.getAgility());
        assertEquals(160, steelLegPlate.getDefense());
    }

    @Test
    void createTrousersHigherThanLevelOne() {
        LegArmor priestTrousers = new Trousers("Priest Trousers", 50);
        assertEquals("Priest Trousers", priestTrousers.getName());
        assertEquals(50, priestTrousers.getLevel());
        assertEquals(55, priestTrousers.getHealth());
        assertEquals(270, priestTrousers.getMana());
        assertEquals(160, priestTrousers.getAgility());
        assertEquals(55, priestTrousers.getDefense());
    }

    @Test
    void createLegArmorEmptyName() {
        assertThrows(IllegalArgumentException.class,
                () -> new LegPlate("", 9));
    }

    @Test
    void createLegArmorBlankName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Trousers(" ", 35));
    }

    @Test
    void createLegArmorLowerThanLevelOne() {
        assertThrows(IllegalArgumentException.class,
                () -> new LegPlate("Melted Leg Plate", 0));
    }

    @Test
    void createLegArmorHigherThanLevelOneHundred() {
        assertThrows(IllegalArgumentException.class,
                () -> new Trousers("Thor Leg Armor", 101));
    }
}