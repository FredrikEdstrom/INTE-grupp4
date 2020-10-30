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
        assertEquals(2, tornBoots.getAgility());
    }

    @Test
    void createShoesLevelOne() {
        Shoes tornShoes = new Shoes("Torn Shoes", 1);
        assertEquals("Torn Shoes", tornShoes.getName());
        assertEquals(1, tornShoes.getLevel());
        assertEquals(10, tornShoes.getMana());
        assertEquals(2, tornShoes.getDefense());
        assertEquals(5, tornShoes.getAgility());
    }

    @Test
    void createBootsHigherThanLevelOne() {
        Boots boneBoots = new Boots("Bone Boots", 67);
        assertEquals("Bone Boots", boneBoots.getName());
        assertEquals(67, boneBoots.getLevel());
        assertEquals(345, boneBoots.getHealth());
        assertEquals(206, boneBoots.getDefense());
        assertEquals(35, boneBoots.getAgility());

    }

    @Test
    void createShoesHigherThanLevelOne() {
        Shoes priestShoes = new Shoes("Priest Shoes", 67);
        assertEquals("Priest Shoes", priestShoes.getName());
        assertEquals(67, priestShoes.getLevel());
        assertEquals(345, priestShoes.getMana());
        assertEquals(35, priestShoes.getDefense());
        assertEquals(206, priestShoes.getAgility());
    }

    @Test
    void createFootArmorEmptyName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Boots("", 10));
    }

    @Test
    void createFootArmorBlankName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Shoes("    ", 5));
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