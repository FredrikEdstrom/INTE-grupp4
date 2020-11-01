import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    //Level 1 sword have a standard value of 20 attack
    @Test
    void createLevelOneSword() {
        Sword rustySword = new Sword("Rusty Sword", 1);
        assertEquals("Rusty Sword", rustySword.getName());
        assertEquals(1, rustySword.getLevel());
        assertEquals(20, rustySword.getAttack());
    }

    //Level 1 staff have a standard value of 20 intelligence
    @Test
    void createLevelOneStaff() {
        Staff woodenStaff = new Staff("Wooden Staff", 1);
        assertEquals("Wooden Staff", woodenStaff.getName());
        assertEquals(1, woodenStaff.getLevel());
        assertEquals(20, woodenStaff.getIntelligence());
    }

    //Swords attack increases for every level by 5 * level
    @Test
    void createSwordHigherThanLevelOne() {
        Sword excalibur = new Sword("Excalibur", 11);
        assertEquals("Excalibur", excalibur.getName());
        assertEquals(11, excalibur.getLevel());
        assertEquals(75, excalibur.getAttack());
    }

    //Staff intelligence increases for every level by 5 * level
    @Test
    void createStaffHigherThanLevelOne() {
        Staff goldenStaff = new Staff("Golden Staff", 11);
        assertEquals("Golden Staff", goldenStaff.getName());
        assertEquals(11, goldenStaff.getLevel());
        assertEquals(75, goldenStaff.getIntelligence());
    }

    //Creating weapon with empty name is not allowed
    @Test
    void createWeaponWithEmptyName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Sword("", 25));
    }

    //Creating weapon with blank name is not allowed
    @Test
    void createWeaponWithBlankName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Sword(" ", 10));
    }

    //Creating weapon lower than level 1 is not allowed
    @Test
    void createWeaponWithLevelLowerThanOne() {
        assertThrows(IllegalArgumentException.class, () ->
                new Sword("Rusty Sword", 0));
    }

    //Creating weapon higher than level 100 is not allowed
    @Test
    void createWeaponWithLevelHigherThanOneHundred() {
        assertThrows(IllegalArgumentException.class, () ->
                new Staff("Merlin Staff", 101));
    }
}