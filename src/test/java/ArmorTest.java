import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {
    //Creating armor with empty name is not allowed
    @Test
    void createArmorEmptyName() {
        assertThrows(IllegalArgumentException.class, () ->
                new HeadArmor("", 17, true));
    }

    //Creating armor with blank name is not allowed
    @Test
    void createArmorBlankName() {
        assertThrows(IllegalArgumentException.class, () ->
                new BodyArmor("    ", 3, false));
    }

    //Creating armor lower than level 1 sets it to level 1
    @Test
    void createArmorLevelLowerThanLevelOne() {
        HandArmor rustyGauntlets = new HandArmor("Rusty Gauntlets", 0, true);
        assertEquals(1, rustyGauntlets.getLevel());
    }

    //Creating armor higher than level 100 sets it to 100
    @Test
    void createArmorHigherThanLevelOneHundred() {
        FootArmor highPriestBoots = new FootArmor("High Priest Boots", 101, true);
        assertEquals(100, highPriestBoots.getLevel());
    }

    @Test
    void armorDurabilityDroppedToZero() {
        Armor bodyPlate = new BodyArmor("Body Plate", 1, true);
        while(bodyPlate.getDurability() > 0) {
            bodyPlate.setDurability();
        }

        assertEquals(0, bodyPlate.getDurability());
        assertEquals(0, bodyPlate.getHealth());
        assertEquals(0, bodyPlate.getMana());
        assertEquals(0, bodyPlate.getAttack());
        assertEquals(0, bodyPlate.getIntelligence());
        assertEquals(0, bodyPlate.getDefense());
        assertEquals(0, bodyPlate.getAgility());
    }

}