import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    @Test
    void createLevelOneSword() {
        Sword rustySword = new Sword("Rusty Sword", 1);
        assertEquals("Rusty Sword", rustySword.getName());
        assertEquals(1, rustySword.getLevel());
        assertEquals(20, rustySword.getAttack());
    }

    @Test
    void createLevelOneStaff() {
        Staff woodenStaff = new Staff("Wooden Staff", 1);
        assertEquals("Wooden Staff", woodenStaff.getName());
        assertEquals(1, woodenStaff.getLevel());
        assertEquals(20, woodenStaff.getIntelligence());
    }

    @Test
    void createSwordHigherThanLevelOne() {
        Sword excalibur = new Sword("Excalibur", 11);
        assertEquals("Excalibur", excalibur.getName());
        assertEquals(11, excalibur.getLevel());
        assertEquals(75, excalibur.getAttack());
    }


    @Test
    void createStaffHigherThanLevelOne() {
        Staff goldenStaff = new Staff("Golden Staff", 11);
        assertEquals("Golden Staff", goldenStaff.getName());
        assertEquals(11, goldenStaff.getLevel());
        assertEquals(75, goldenStaff.getIntelligence());
    }

    @Test
    void createWeaponWithEmptyName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Sword("", 25));
    }

    @Test
    void createWeaponWithBlankName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Sword(" ", 10));
    }

    @Test
    void createWeaponWithLevelLowerThanOne() {
        assertThrows(IllegalArgumentException.class, () ->
                new Sword("Rusty Sword", 0));
    }

    @Test
    void createWeaponWithLevelHigherThanOneHundred() {
        assertThrows(IllegalArgumentException.class, () ->
                new Staff("Merlin Staff", 101));
    }
}