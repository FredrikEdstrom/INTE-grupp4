import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyArmorTest {
    //Plate armor gives attack and more health and defense, while
    //robe gives intelligence and more mana.

    //Level 1 plate armor have a standard value of 20 health, 5 mana,
    //10 attack, and 10 defense.
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

    //Level 1 robe have a standard value of 5 health, 20 mana,
    //10 intelligence, and 5 defense.
    @Test
    void createRobeLevelOne() {
        Robe noviceRobe = new Robe("Novice Robe", 1);
        assertEquals(1, noviceRobe.getLevel());
        assertEquals(5, noviceRobe.getHealth());
        assertEquals(20, noviceRobe.getMana());
        assertEquals(10, noviceRobe.getIntelligence());
        assertEquals(5, noviceRobe.getDefense());
    }

    //Plate armors health increases by 5 * level, mana by 0.5 * level,
    //attack by 3 * level, and defense by 3 * level
    @Test
    void createBodyPlateHigherThanLevelOne() {
        BodyPlate steelPlate = new BodyPlate("Steel Plate", 33);
        assertEquals("Steel Plate", steelPlate.getName());
        assertEquals(33, steelPlate.getLevel());
        assertEquals(185, steelPlate.getHealth());
        assertEquals(21, steelPlate.getMana());
        assertEquals(109, steelPlate.getAttack());
        assertEquals(109, steelPlate.getDefense());
    }

    //Robes health increases by 0.5 * level, mana by 5 * level,
    //intelligence by 3 * level, and defense by 0.5 * level
    @Test
    void createRobeHigherThanLevelOne() {
        Robe priestRobe = new Robe("Priest Robe", 33);
        assertEquals(33, priestRobe.getLevel());
        assertEquals(21, priestRobe.getHealth());
        assertEquals(185, priestRobe.getMana());
        assertEquals(109, priestRobe.getIntelligence());
        assertEquals(21, priestRobe.getDefense());
    }

    //Creating body armor with empty name is not allowed
    @Test
    void createBodyArmorEmptyName() {
        assertThrows(IllegalArgumentException.class,
                () -> new BodyPlate("", 11));
    }

    //Creating body armor with blank name is not allowed
    @Test
    void createBodyArmorBlankName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Robe(" ", 22));
    }

    //Creating body armor lower than level 1 is not allowed
    @Test
    void createBodyArmorLowerThanLevelOne() {
        assertThrows(IllegalArgumentException.class,
                () -> new BodyPlate("Melted Plate", 0));
    }

    //Creating body armor higher than level 100 is not allowed
    @Test
    void createBodyArmorHigherThanLevelOneHundred() {
        assertThrows(IllegalArgumentException.class,
                () -> new Robe("Merlin Robe", 101));
    }
}