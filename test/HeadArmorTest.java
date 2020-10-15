import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeadArmorTest {

    @Test
    void createLevelOneHelmet() {
        Helmet rustyHelmet = new Helmet("Rusty Helmet", 1);
        assertEquals("Rusty Helmet", rustyHelmet.getName());
        assertEquals(1, rustyHelmet.getLevel());
        assertEquals(10, rustyHelmet.getHealth());
        assertEquals(5, rustyHelmet.getDefense());
    }

    @Test
    void createHelmetHigherThanOne() {
        Helmet skullHelmet = new Helmet("Skull Helmet", 15);
        assertEquals("Skull Helmet", skullHelmet.getName());
        assertEquals(15, skullHelmet.getLevel());
        assertEquals(32, skullHelmet.getHealth());
        assertEquals(27, skullHelmet.getDefense());
    }
    @Test
    void createLevelOneCap() {
        Cap tornCap = new Cap("Torn Cap", 1);
        assertEquals("Torn Cap", tornCap.getName());
        assertEquals(1, tornCap.getLevel());
        assertEquals(10, tornCap.getMana());
        assertEquals(5, tornCap.getDefense());
    }

    @Test
    void createCapHigherThanOne() {
        Cap priestCap = new Cap("Priest Cap", 27);
        assertEquals("Priest Cap", priestCap.getName());
        assertEquals(27, priestCap.getLevel());
        assertEquals(50, priestCap.getMana());
        assertEquals(45, priestCap.getDefense());
    }
    @Test
    void createHeadArmorBlankName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Helmet(" ", 5));
    }
    @Test
    void createHeadArmorLevelLowerThanOne() {
        assertThrows(IllegalArgumentException.class, () ->
                new Helmet("Rusty Helmet", 0));
    }
    @Test
    void createHeadArmorHigherThanLevelOneHundred() {
        assertThrows(IllegalArgumentException.class, () ->
                new Cap ("High Priest Cap", 101));
    }
}