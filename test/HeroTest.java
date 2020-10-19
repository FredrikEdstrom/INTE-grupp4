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

    //Hero equip and un-equip weapon and armor test start:

    //Weapon equip and un-equip test start:
    @Test
    void heroEquipSwordWeapon() {
        Hero slasher = new Hero("Slasher");
        Weapon rustySword = new Sword("Rusty Sword", 1);
        slasher.equipWeapon(rustySword);

        assertEquals(30, slasher.getAttack());
    }

    @Test
    void heroEquipStaffWeapon() {
        Hero caster = new Hero("Caster");
        Weapon woodenStaff = new Staff("Wooden Staff", 1);
        caster.equipWeapon(woodenStaff);

        assertEquals(30, caster.getIntelligence());
    }

    @Test
    void highLevelHeroEquipSameLevelWeapon() {
        Hero slasher = new Hero("Slasher");
        Weapon goldenSword = new Sword("Golden Sword", 50);
        slasher.setLevel(50);
        slasher.equipWeapon(goldenSword);

        assertEquals(525, slasher.getAttack());
    }

    @Test
    void highLevelHeroEquipLowLevelWeapon() {
        Hero slasher = new Hero("Slasher");
        Weapon rustySword = new Sword("Rusty Sword", 1);
        slasher.setLevel(50);
        slasher.equipWeapon(rustySword);

        assertEquals(275, slasher.getAttack());
    }

    @Test
    void lowLevelHeroEquipHighLevelWeapon() {
        Hero caster = new Hero("Caster");
        Weapon goldenStaff = new Staff("Golden Staff", 50);

        assertThrows(IllegalStateException.class, () -> caster.equipWeapon(goldenStaff));
    }

    @Test
    void lowLevelHeroUnEquipLowLevelWeapon() {
        Hero slasher = new Hero("Slasher");
        Weapon rustySword = new Sword("Rusty Sword", 1);
        slasher.equipWeapon(rustySword);
        slasher.unEquipWeapon();

        assertEquals(10, slasher.getAttack());
    }

    @Test
    void highLevelHeroUnEquipHighLevelWeapon() {
        Hero caster = new Hero("Caster");
        Weapon goldenStaff = new Staff("Golden Staff", 50);
        caster.setLevel(60);
        caster.equipWeapon(goldenStaff);
        caster.unEquipWeapon();

        assertEquals(305, caster.getIntelligence());

    }

    //Weapon equip and un-equip test ends

    //Head armor equip  and un-equip start:
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
    void highLevelHeroEquipLowLevelHeadArmor() {
        Hero slasher = new Hero("Slasher");
        HeadArmor rustyHelmet = new Helmet("Rusty Helmet", 1);
        slasher.setLevel(30);
        slasher.equipHeadArmor(rustyHelmet);

        assertEquals(690, slasher.getHealth());
        assertEquals(160, slasher.getDefense());
    }

    @Test
    void highLevelHeroEquipSameLevelHeadArmor() {
        Hero caster = new Hero("Caster");
        HeadArmor priestCap = new Cap("Priest Cap", 30);
        caster.setLevel(30);
        caster.equipHeadArmor(priestCap);

        assertEquals(840, caster.getMana());
        assertEquals(250, caster.getDefense());
    }

    @Test
    void lowLevelHeroEquipHighLevelHeadArmor() {
        Hero slasher = new Hero("Slasher");
        HeadArmor skullHelm = new Helmet("Skull Helmet", 50);

        assertThrows(IllegalStateException.class, () -> slasher.equipHeadArmor(skullHelm));
    }

    @Test
    void unEquipHeadArmorHelmet() {
        Hero slasher = new Hero("Slasher");
        HeadArmor skullHelmet = new Helmet("Skull Helmet", 25);
        slasher.setLevel(25);
        slasher.equipHeadArmor(skullHelmet);
        slasher.unEquipHeadArmor();

        assertEquals(580, slasher.getHealth());
        assertEquals(130, slasher.getDefense());
    }
    //Head armor equip un-equip ends

    //Body armor equip

    //Hero equip and un-equip weapon and armor end
}