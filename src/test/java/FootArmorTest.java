import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FootArmorTest {
    //Boots gives health, more defense, and little agility,
    // while shoes gives mana, little defense and more agility.

    //Level 1 boots have a standard value of 10 health, 5 defense,
    //and 2 agility.
    @Test
    void createLevelOneBoots() {
        Boots tornBoots = new Boots("Torn Boots", 1);
        assertEquals("Torn Boots", tornBoots.getName());
        assertEquals(1, tornBoots.getLevel());
        assertEquals(10, tornBoots.getHealth());
        assertEquals(5, tornBoots.getDefense());
        assertEquals(2, tornBoots.getAgility());
    }

    //Level 1 shoes have a standard value of 10 mana, 2 defense,
    //and 5 agility.
    @Test
    void createShoesLevelOne() {
        Shoes tornShoes = new Shoes("Torn Shoes", 1);
        assertEquals("Torn Shoes", tornShoes.getName());
        assertEquals(1, tornShoes.getLevel());
        assertEquals(10, tornShoes.getMana());
        assertEquals(2, tornShoes.getDefense());
        assertEquals(5, tornShoes.getAgility());
    }

    //Boots health increases by 5 * level, defense by 3 * level,
    //and agility by 0.5 * level
    @Test
    void createBootsHigherThanLevelOne() {
        Boots boneBoots = new Boots("Bone Boots", 67);
        assertEquals("Bone Boots", boneBoots.getName());
        assertEquals(67, boneBoots.getLevel());
        assertEquals(345, boneBoots.getHealth());
        assertEquals(206, boneBoots.getDefense());
        assertEquals(35, boneBoots.getAgility());

    }

    //Shoes mana increases by 5 * level, defense by 0.5 * level,
    //and agility by 3 * level
    @Test
    void createShoesHigherThanLevelOne() {
        Shoes priestShoes = new Shoes("Priest Shoes", 67);
        assertEquals("Priest Shoes", priestShoes.getName());
        assertEquals(67, priestShoes.getLevel());
        assertEquals(345, priestShoes.getMana());
        assertEquals(35, priestShoes.getDefense());
        assertEquals(206, priestShoes.getAgility());
    }

    //Creating foot armor with empty name is not allowed
    @Test
    void createFootArmorEmptyName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Boots("", 10));
    }

    //Creating foot armor with blank name is not allowed
    @Test
    void createFootArmorBlankName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Shoes("    ", 5));
    }

    //Creating foot armor lower than level 1 is not allowed
    @Test
    void createFootArmorLevelLowerThanOne() {
        assertThrows(IllegalArgumentException.class, () ->
                new Boots("Torn Boots", 0));
    }

    //Creating foot armor higher than level 100 is not allowed
    @Test
    void createFootArmorHigherThanLevelOneHundred() {
        assertThrows(IllegalArgumentException.class, () ->
                new Shoes("High Priest Shoes", 101));
    }
}