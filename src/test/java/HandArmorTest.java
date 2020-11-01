import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandArmorTest {
    //Gauntlets gives health, attack, and more defense, while
    //gloves gives mana, intelligence and a little defense

    //Level 1 gauntlets have a standard value of 10 health, 5 attack,
    //and 5 defense
    @Test
    void createLevelOneGauntlets() {
        Gauntlets rustyGauntlets = new Gauntlets("Rusty Gauntlets", 1);
        assertEquals("Rusty Gauntlets", rustyGauntlets.getName());
        assertEquals(1, rustyGauntlets.getLevel());
        assertEquals(10, rustyGauntlets.getHealth());
        assertEquals(5, rustyGauntlets.getAttack());
        assertEquals(5, rustyGauntlets.getDefense());
    }

    //Level 1 gloves have a standard value of 10 mana, 5 intelligence,
    //and 2 defense
    @Test
    void createGlovesLevelOne() {
        Gloves tornGloves = new Gloves("Torn Gloves", 1);
        assertEquals("Torn Gloves", tornGloves.getName());
        assertEquals(1, tornGloves.getLevel());
        assertEquals(10, tornGloves.getMana());
        assertEquals(5, tornGloves.getIntelligence());
        assertEquals(2, tornGloves.getDefense());
    }

    //Gauntlets health increases by 5 * level, attack by 3 * level,
    //and defense by 3 * level
    @Test
    void createGauntletsHigherThanLevelOne() {
        Gauntlets boneGauntlets = new Gauntlets("Bone Gauntlets", 28);
        assertEquals("Bone Gauntlets", boneGauntlets.getName());
        assertEquals(28, boneGauntlets.getLevel());
        assertEquals(150, boneGauntlets.getHealth());
        assertEquals(89,boneGauntlets.getAttack() ) ;
        assertEquals(89, boneGauntlets.getDefense());
    }

    //Gloves mana increases by 5 * level, intelligence by 3 * level,
    //and defense by 0.5 * level
    @Test
    void createGlovesHigherThanLevelOne() {
        Gloves priestGloves = new Gloves("Priest Gloves", 28);
        assertEquals("Priest Gloves", priestGloves.getName());
        assertEquals(28, priestGloves.getLevel());
        assertEquals(150, priestGloves.getMana());
        assertEquals(89, priestGloves.getIntelligence());
        assertEquals(16, priestGloves.getDefense());
    }

    //Creating hand armor with empty name is not allowed
    @Test
    void createHandArmorEmptyName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Gauntlets("", 17));
    }

    //Creating hand armor with blank name is not allowed
    @Test
    void createHandArmorBlankName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Gloves(" ", 3));
    }

    //Creating hand armor lower than level 1 is not allowed
    @Test
    void createHandArmorLevelLowerThanLevelOne() {
        assertThrows(IllegalArgumentException.class, () ->
                new Gauntlets("Rusty Gauntlets", 0));
    }

    //Creating hand armor higher than level 100 is not allowed
    @Test
    void createHandArmorHigherThanLevelOneHundred() {
        assertThrows(IllegalArgumentException.class, () ->
                new Gloves("High Priest Gloves", 101));
    }
}