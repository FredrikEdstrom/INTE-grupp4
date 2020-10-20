import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyArmorTest {

    @Test
    void createBodyPlateLevelOne() {
        BodyPlate rustyPlate = new BodyPlate("Rusty Plate", 1);
        assertEquals("Rusty Plate", rustyPlate.getName());
        assertEquals(1, rustyPlate.getLevel());
        assertEquals(20, rustyPlate.getHealth());
        assertEquals(5, rustyPlate.getMana());
        assertEquals(10, rustyPlate.getAttack());
        assertEquals(10, rustyPlate.getDefense());
    }

    @Test
    void createRobeLevelOne() {
        Robe noviceRobe = new Robe("Novice Robe", 1);
        assertEquals(1, noviceRobe.getLevel());
        assertEquals(5, noviceRobe.getHealth());
        assertEquals(20, noviceRobe.getMana());
        assertEquals(10, noviceRobe.getIntelligence());
        assertEquals(5, noviceRobe.getDefense());
    }

    @Test
    void createBodyPlateHigherThanLevelOne() {
        BodyPlate steelPlate = new BodyPlate("Steel Plate", 33);
        assertEquals("Steel Plate", steelPlate.getName());
        assertEquals(33, steelPlate.getLevel());
        assertEquals(185, steelPlate.getHealth());
        assertEquals(38, steelPlate.getMana());
        assertEquals(109, steelPlate.getAttack());
        assertEquals(109, steelPlate.getDefense());
    }

    @Test
    void createRobeHigherThanLevelOne() {
        Robe priestRobe = new Robe("Priest Robe", 33);
        assertEquals(33, priestRobe.getLevel());
        assertEquals(38, priestRobe.getHealth());
        assertEquals(185, priestRobe.getMana());
        assertEquals(109, priestRobe.getIntelligence());
        assertEquals(38, priestRobe.getDefense());
    }

    @Test
    void createBodyArmorEmptyName() {
        assertThrows(IllegalArgumentException.class,
                () -> new BodyPlate("", 11));
    }

    @Test
    void createBodyArmorBlankName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Robe(" ", 22));
    }

    @Test
    void createBodyArmorLowerThanLevelOne() {
        assertThrows(IllegalArgumentException.class,
                () -> new BodyPlate("Melted Plate", 0));
    }

    @Test
    void createBodyArmorHigherThanLevelOneHundred() {
        assertThrows(IllegalArgumentException.class,
                () -> new Robe("Merlin Robe", 101));
    }
}