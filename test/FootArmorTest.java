import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FootArmorTest {

    @Test
    void createLevelOneBoots() {
        Boots tornBoots = new Boots("Torn Boots", 1);
        assertEquals("Torn Boots", tornBoots.getName());
        assertEquals(1, tornBoots.getLevel());
        assertEquals(10, tornBoots.getHealth());
        assertEquals(5, tornBoots.getDefense());
    }

    @Test
    void createBootsHigherThanLevelOne() {
        Boots boneBoots = new Boots("Bone Boots", 16);
        assertEquals("Bone Boots", boneBoots.getName());
        assertEquals(16, boneBoots.getLevel());
        assertEquals(34, boneBoots.getHealth());
        assertEquals(29, boneBoots.getDefense());
    }

    @Test
    void createShoesLevelOne() {
        Shoes tornShoes = new Shoes("Torn Shoes", 1);
        assertEquals("Torn Shoes", tornShoes.getName());
        assertEquals(1, tornShoes.getLevel());
        assertEquals(10, tornShoes.getMana());
        assertEquals(5, tornShoes.getDefense());
    }

    @Test
    void createShoesHigherThanLevelOne() {
        Shoes priestShoes = new Shoes("Priest Shoes", 67);
        assertEquals("Priest Shoes", priestShoes.getName());
        assertEquals(67, priestShoes.getLevel());
        assertEquals(110, priestShoes.getMana());
        assertEquals(105, priestShoes.getDefense());
    }

    @Test
    void createFootArmorEmptyName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Boots("", 10));
    }

    @Test
    void createFootArmorBlankName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Shoes(" ", 5));
    }

    @Test
    void createFootArmorLevelLowerThanOne() {
        assertThrows(IllegalArgumentException.class, () ->
                new Boots("Torn Boots", 0));
    }

    @Test
    void createFootArmorHigherThanLevelOneHundred() {
        assertThrows(IllegalArgumentException.class, () ->
                new Shoes("High Priest Shoes", 101));
    }
}