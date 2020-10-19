import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandArmorTest {

    @Test
    void createLevelOneGauntlets() {
        Gauntlets rustyGauntlets = new Gauntlets("Rusty Gauntlets", 1);
        assertEquals("Rusty Gauntlets", rustyGauntlets.getName());
        assertEquals(1, rustyGauntlets.getLevel());
        assertEquals(10, rustyGauntlets.getHealth());
        assertEquals(5, rustyGauntlets.getAttack());
        assertEquals(5, rustyGauntlets.getDefense());
    }

    @Test
    void createGauntletsHigherThanLevelOne() {
        Gauntlets boneGauntlets = new Gauntlets("Bone Gauntlets", 28);
        assertEquals("Bone Gauntlets", boneGauntlets.getName());
        assertEquals(28, boneGauntlets.getLevel());
        assertEquals(150, boneGauntlets.getHealth());
        assertEquals(89,boneGauntlets.getAttack() ) ;
        assertEquals(89, boneGauntlets.getDefense());
    }

    @Test
    void createGlovesLevelOne() {
        Gloves tornGloves = new Gloves("Torn Gloves", 1);
        assertEquals("Torn Gloves", tornGloves.getName());
        assertEquals(1, tornGloves.getLevel());
        assertEquals(10, tornGloves.getMana());
        assertEquals(5, tornGloves.getIntelligence());
        assertEquals(5, tornGloves.getDefense());
    }

    @Test
    void createGlovesHigherThanLevelOne() {
        Gloves priestGloves = new Gloves("Priest Gloves", 56);
        assertEquals("Priest Gloves", priestGloves.getName());
        assertEquals(56, priestGloves.getLevel());
        assertEquals(290, priestGloves.getMana());
        assertEquals(173, priestGloves.getIntelligence());
        assertEquals(173, priestGloves.getDefense());
    }

    @Test
    void createHandArmorEmptyName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Gauntlets("", 17));
    }

    @Test
    void createHandArmorBlankName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Gloves(" ", 3));
    }

    @Test
    void createHandArmorLevelLowerThanLevelOne() {
        assertThrows(IllegalArgumentException.class, () ->
                new Gauntlets("Rusty Gauntlets", 0));
    }

    @Test
    void createHandArmorHigherThanLevelOneHundred() {
        assertThrows(IllegalArgumentException.class, () ->
                new Gloves("High Priest Gloves", 101));
    }
}