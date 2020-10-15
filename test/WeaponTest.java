import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    @Test
    void createLevelOneSword() {
        Sword rustySword = new Sword("Rusty Sword", 1);
        assertEquals("Rusty Sword", rustySword.getName());
        assertEquals(1, rustySword.getLevel());
        assertEquals(5, rustySword.getAttack());
    }

    @Test
    void createSwordHigherThanLevelOne() {
        Sword excalibur = new Sword("Excalibur", 10);
        assertEquals("Excalibur", excalibur.getName());
        assertEquals(10, excalibur.getLevel());
        assertEquals(25, excalibur.getAttack());
    }

    @Test
    void createLevelOneStaff() {
        Staff woodenStaff = new Staff("Wooden Staff", 1);
        assertEquals("Wooden Staff", woodenStaff.getName());
        assertEquals(1, woodenStaff.getLevel());
        assertEquals(5, woodenStaff.getIntelligence());
    }

    @Test
    void createStaffHigherThanLevelOne() {
        Staff goldenStaff = new Staff("Golden Staff", 10);
        assertEquals("Golden Staff", goldenStaff.getName());
        assertEquals(10, goldenStaff.getLevel());
        assertEquals(25, goldenStaff.getIntelligence());
    }

    @Test
    void createWeaponWithBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new Sword(" ", 10));
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