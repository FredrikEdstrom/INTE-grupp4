import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FootArmorTest {

    @Test
    void checkIfBootsHaveRightArmorType() {
        FootArmor boots = new FootArmor("Boots", 20, true);
        assertTrue(boots.isBoots());
        assertFalse(boots.isShoes());
    }

    @Test
    void checkIfShoesHaveRightArmorType() {
        FootArmor shoes = new FootArmor("Shoes", 20, false);
        assertTrue(shoes.isShoes());
        assertFalse(shoes.isBoots());
    }

    @Test
    void checkIfBootsHaveRightStats() {
        FootArmor boots = new FootArmor("Boots", 60, true);
        assertEquals("Boots", boots.getName());
        assertEquals(60, boots.getLevel());
        assertEquals(300, boots.getHealth());
        assertEquals(0, boots.getMana());
        assertEquals(180, boots.getDefense());
        assertEquals(0, boots.getAttack());
        assertEquals(0, boots.getIntelligence());
        assertEquals(30, boots.getAgility());
    }

    @Test
    void checkIfShoesHaveRightStats() {
        FootArmor shoes = new FootArmor("Shoes", 100, false);
        assertEquals("Shoes", shoes.getName());
        assertEquals(100, shoes.getLevel());
        assertEquals(0, shoes.getHealth());
        assertEquals(500, shoes.getMana());
        assertEquals(50, shoes.getDefense());
        assertEquals(0, shoes.getAttack());
        assertEquals(0, shoes.getIntelligence());
        assertEquals(300, shoes.getAgility());
    }
}