import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void createHeroWithEmptyName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Hero(""));
    }

    @Test
    void createHeroWithBlankName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Hero("   "));
    }

    //Hero equip and un-equip weapon and armor start:

    //Weapon equip test start:
    @Test
    void heroEquipSwordWeapon() {
        Hero slasher = new Hero("Slasher");
        Weapon rustySword = new Sword("Rusty Sword", 1);
        slasher.equipWeapon(rustySword);

        assertEquals(20, slasher.getAttack());
    }

    @Test
    void heroEquipStaffWeapon() {
        Hero caster = new Hero("Caster");
        Weapon woodenStaff = new Staff("Wooden Staff", 1);
        caster.equipWeapon(woodenStaff);

        assertEquals(20, caster.getIntelligence());
    }

    @Test
    void highLevelHeroEquipSameLevelWeapon() {
        Hero slasher = new Hero("Slasher");
        Weapon goldenSword = new Sword("Golden Sword", 50);
        slasher.setLevel(50);
        slasher.equipWeapon(goldenSword);

        assertEquals(365, slasher.getAttack());
    }

    @Test
    void highLevelHeroEquipLowLevelWeapon() {
        Hero slasher = new Hero("Slasher");
        Weapon rustySword = new Sword("Rusty Sword", 1);
        slasher.setLevel(50);
        slasher.equipWeapon(rustySword);

        assertEquals(265, slasher.getAttack());
    }

    @Test
    void lowLevelHeroEquipHighLevelWeapon() {
        Hero caster = new Hero("Caster");
        Weapon goldenStaff = new Staff("Golden Staff", 50);

        assertThrows(IllegalStateException.class, () -> caster.equipWeapon(goldenStaff));
    }
    //Weapon equip test ends

    //Head armor equip start:
    @Test
    void heroEquipHeadArmorHelmet() {
        Hero slasher = new Hero("Slasher");
        HeadArmor rustyHelmet = new Helmet("Rusty Helmet", 1);
        slasher.equipHeadArmor(rustyHelmet);

        assertEquals(110, slasher.getHealth());
        assertEquals(15, slasher.getDefense());
    }

    @Test
    void heroEquipHeadArmorCap() {
        Hero caster = new Hero("Caster");
        HeadArmor tornCap = new Cap("Torn Cap", 1);
        caster.equipHeadArmor(tornCap);

        assertEquals(110, caster.getMana());
        assertEquals(15, caster.getDefense());
    }

    @Test
    void HighLevelHeroEquipLowLevelHeadArmor() {
        Hero slasher = new Hero("Slasher");
        HeadArmor rustyHelmet = new Helmet("Rusty Helmet", 1);
        slasher.setLevel(30);
        slasher.equipHeadArmor(rustyHelmet);

        assertEquals(690, slasher.getHealth());
        assertEquals(160, slasher.getDefense());
    }

    @Test
    void HighLevelHeroEquipSameLevelHeadArmor() {
        Hero caster = new Hero("Caster");
        HeadArmor priestCap = new Cap("Priest Cap", 30);
        caster.setLevel(30);
        caster.equipHeadArmor(priestCap);

        assertEquals(750, caster.getMana());
        assertEquals(220, caster.getDefense());
    }

    @Test
    void lowLevelHeroEquipHighLevelHeadArmor() {
        Hero slasher = new Hero("Slasher");
        HeadArmor skullHelm = new Helmet("Skull Helmet", 50);

        assertThrows(IllegalStateException.class, () -> slasher.equipHeadArmor(skullHelm));
    }
    //Head armor equip ends

    //Hero equip and un-equip weapon and armor end
}