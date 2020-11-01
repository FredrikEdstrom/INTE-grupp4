import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeadArmorTest {
    //Helmet gives health and more defense, while
    //cap gives mana and a little defense

    //Level 1 helmet have a standard value of 10 health, and 5 defense
    @Test
    void createLevelOneHelmet() {
        Helmet rustyHelmet = new Helmet("Rusty Helmet", 1);
        assertEquals("Rusty Helmet", rustyHelmet.getName());
        assertEquals(1, rustyHelmet.getLevel());
        assertEquals(10, rustyHelmet.getHealth());
        assertEquals(5, rustyHelmet.getDefense());
    }

    //Level 1 cap have a standard value of 10 mana, and 2 defense
    @Test
    void createLevelOneCap() {
        Cap tornCap = new Cap("Torn Cap", 1);
        assertEquals("Torn Cap", tornCap.getName());
        assertEquals(1, tornCap.getLevel());
        assertEquals(10, tornCap.getMana());
        assertEquals(2, tornCap.getDefense());
    }

    //Helmets health increases every level by 5 * level, and
    // defense by 3 * level
    @Test
    void createHelmetHigherThanLevelOne() {
        Helmet skullHelmet = new Helmet("Skull Helmet", 15);
        assertEquals("Skull Helmet", skullHelmet.getName());
        assertEquals(15, skullHelmet.getLevel());
        assertEquals(85, skullHelmet.getHealth());
        assertEquals(50, skullHelmet.getDefense());
    }

    //Caps mana increases every level by 5 * level, and
    // defense by 0.5 * level
    @Test
    void createCapHigherThanLevelOne() {
        Cap priestCap = new Cap("Priest Cap", 15);
        assertEquals("Priest Cap", priestCap.getName());
        assertEquals(15, priestCap.getLevel());
        assertEquals(85, priestCap.getMana());
        assertEquals(9, priestCap.getDefense());
    }

    //Creating head armor with empty name is not allowed
    @Test
    void createHeadArmorEmptyName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Helmet("", 10));
    }

    //Creating head armor with blank name is not allowed
    @Test
    void createHeadArmorBlankName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Helmet("    ", 5));
    }

    //Creating head armor lower than level 1 is not allowed
    @Test
    void createHeadArmorLowerThanLevelOne() {
        assertThrows(IllegalArgumentException.class, () ->
                new Helmet("Rusty Helmet", 0));
    }

    //Creating head armor higher than level 100 is not allowed
    @Test
    void createHeadArmorHigherThanLevelOneHundred() {
        assertThrows(IllegalArgumentException.class, () ->
                new Cap("High Priest Cap", 101));
    }
}