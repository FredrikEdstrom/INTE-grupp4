import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    @Test
    void createLevelOneSword() {
        Sword sword = new Sword("excalibur", 1);
        assertEquals("excalibur", sword.getName());
        assertEquals(1, sword.getLevel());
        assertEquals(5, sword.getAttack());
    }

    @Test
    void createSwordHigherThanLevelOne() {
        Sword sword = new Sword("excalibur", 10);
        assertEquals("excalibur", sword.getName());
        assertEquals(10, sword.getLevel());
        assertEquals(25, sword.getAttack());
    }

    @Test
    void createLevelOneStaff() {
        Staff staff = new Staff("darkness staff", 1);
        assertEquals("darkness staff", staff.getName());
        assertEquals(1, staff.getLevel());
        assertEquals(5, staff.getIntelligence());
    }

    @Test
    void createStaffHigherThanLevelOne() {
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
    void createWeaponWithLevelLowerThanOne() {
        assertThrows(IllegalArgumentException.class, () ->
                new Sword("excalibur", 0));
    }

    @Test
    void createWeaponWithLevelHigherThanOneHundred() {
        assertThrows(IllegalArgumentException.class, () ->
                new Staff("darkness staff", 101));
    }
}