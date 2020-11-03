import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    @Test
    void createWeaponEmptyName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Weapon("", 17, true));
    }

    @Test
    void createWeaponBlankName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Weapon("    ", 3, false));
    }

    @Test
    void createWeaponLevelLowerThanLevelOne() {
        Weapon sword = new Weapon("Rusty Sword", 0, true);
        assertEquals(1, sword.getLevel());
    }

    @Test
    void createWeaponHigherThanLevelOneHundred() {
        Weapon staff = new Weapon("Merlin Staff", 101, false);
        assertEquals(100, staff.getLevel());
    }

    @Test
    void checkIfSwordHaveRightWeaponType() {
        Weapon sword = new Weapon("Steel Sword", 10, true);
        assertTrue(sword.isSword());
        assertFalse(sword.isStaff());
    }

    @Test
    void checkIfStaffHaveRightWeaponType() {
        Weapon staff = new Weapon("Golden Staff", 50, false);
        assertTrue(staff.isStaff());
        assertFalse(staff.isSword());
    }

    @Test
    void checkIfSwordHaveRightStats() {
        Weapon sword = new Weapon("Steel Sword", 10, true);
        assertEquals("Steel Sword", sword.getName());
        assertEquals(10, sword.getLevel());
        assertEquals(100, sword.getAttack());
        assertEquals(0, sword.getIntelligence());
    }

    @Test
    void checkIfStaffHaveRightStats(){
        Weapon staff = new Weapon("Golden Staff", 50, false);
        assertEquals("Golden Staff", staff.getName());
        assertEquals(50, staff.getLevel());
        assertEquals(500, staff.getIntelligence());
        assertEquals(0, staff.getAttack());
    }
}