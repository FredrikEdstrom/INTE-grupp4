import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LegArmorTest {
    //Leg plates gives health, little mana, more defense, and little agility,
    // while trousers gives little health, mana, little defense and more agility.

    //Level 1 leg plates have a standard value of 20 health, 5 mana, 10 defense,
    //and 5 agility.
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

    //Level 1 trousers have a standard value of 5 health, 20 mana, 5 defense,
    //and 10 agility.
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

    //Leg plates health increases by 5 * level, mana by 0.5 * level,
    //agility by 0.5 * level, and defense by 3 * level
    @Test
    void createLegPlateHigherThanLevelOne() {
        LegArmor steelLegPlate = new LegPlate("Steel Leg Plate", 50);
        assertEquals("Steel Leg Plate", steelLegPlate.getName());
        assertEquals(50, steelLegPlate.getLevel());
        assertEquals(270, steelLegPlate.getHealth());
        assertEquals(30, steelLegPlate.getMana());
        assertEquals(30, steelLegPlate.getAgility());
        assertEquals(160, steelLegPlate.getDefense());
    }

    //Leg plates health increases by 0.5 * level, mana by 5 * level,
    //agility by 3 * level, and defense by 0.5 * level
    @Test
    void createTrousersHigherThanLevelOne() {
        LegArmor priestTrousers = new Trousers("Priest Trousers", 50);
        assertEquals("Priest Trousers", priestTrousers.getName());
        assertEquals(50, priestTrousers.getLevel());
        assertEquals(30, priestTrousers.getHealth());
        assertEquals(270, priestTrousers.getMana());
        assertEquals(160, priestTrousers.getAgility());
        assertEquals(30, priestTrousers.getDefense());
    }

    //Creating leg armor with empty name is not allowed
    @Test
    void createLegArmorEmptyName() {
        assertThrows(IllegalArgumentException.class,
                () -> new LegPlate("", 9));
    }

    //Creating leg armor with blank name is not allowed
    @Test
    void createLegArmorBlankName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Trousers(" ", 35));
    }

    //Creating leg armor lower than level 1 is not allowed
    @Test
    void createLegArmorLowerThanLevelOne() {
        assertThrows(IllegalArgumentException.class,
                () -> new LegPlate("Melted Leg Plate", 0));
    }

    //Creating leg armor higher than level 100 is not allowed
    @Test
    void createLegArmorHigherThanLevelOneHundred() {
        assertThrows(IllegalArgumentException.class,
                () -> new Trousers("Thor Leg Armor", 101));
    }
}