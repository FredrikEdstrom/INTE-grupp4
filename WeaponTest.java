import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    @Test
    void createWeaponSword() {
        Sword sword = new Sword("excalibur", 10);
        assertEquals("excalibur", sword.getName());
        assertEquals(10, sword.getLevel());
        assertEquals(25, sword.getAttack());
    }

    @Test
    void createWeaponStaff() {
        Staff staff = new Staff("darkness staff", 10);
        assertEquals("darkness staff", staff.getName());
        assertEquals(10, staff.getLevel());
        assertEquals(25, staff.getIntelligence());
    }

    @Test
    void createWeaponWithBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new Sword(" ", 10));
    }

    @Test
    void weaponLevelLowerThanOne() {
        assertThrows(IllegalArgumentException.class, () ->
                new Sword("excalibur", 0));
    }

    @Test
    void weaponLevelHigherThanOneHundred() {
        assertThrows(IllegalArgumentException.class, () ->
                new Staff("darkness staff", 101));
    }
}