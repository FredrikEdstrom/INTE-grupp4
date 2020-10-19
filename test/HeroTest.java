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

    @Test
    void heroUnEquipWeapon() {
        Hero slasher = new Hero("Slasher");
        Weapon goldenSword = new Sword("Golden Sword", 50);
        slasher.setLevel(50);
        slasher.equipWeapon(goldenSword);
        slasher.unEquipWeapon();

        assertEquals(255, slasher.getAttack());
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
    void heroUnEquipHeadArmorHelmet() {
        Hero slasher = new Hero("Slasher");
        HeadArmor skullHelmet = new Helmet("Skull Helmet", 25);
        slasher.setLevel(25);
        slasher.equipHeadArmor(skullHelmet);
        slasher.unEquipHeadArmor();

        assertEquals(580, slasher.getHealth());
        assertEquals(130, slasher.getDefense());
    }

    @Test
    void heroUnEquipHeadArmorCap() {
        Hero caster = new Hero ("Caster");
        HeadArmor priestHelm = new Cap("Priest Helm", 45);
        caster.setLevel(45);
        caster.equipHeadArmor(priestHelm);
        caster.unEquipHeadArmor();

        assertEquals(980, caster.getMana());
        assertEquals(230, caster.getDefense());
    }
    //Head armor equip un-equip ends

    //Body armor equip
    @Test
    void lowLevelHeroEquipLowLevelBodyArmor() {
        Hero slasher = new Hero ("Slasher");
        BodyArmor rustyPlate = new BodyArmor("Rusty Plate", 1);
        slasher.equipBodyArmor(rustyPlate);

        assertEquals(120, slasher.getHealth());
        assertEquals(120, slasher.getMana());
        assertEquals(20, slasher.getDefense());
    }

    @Test
    void highLevelHeroEquipSameLevelBodyArmor() {
        Hero caster = new Hero ("Caster");
        BodyArmor priestRobe = new BodyArmor("Priest Robe", 55);
        caster.setLevel(55);
        caster.equipBodyArmor(priestRobe);

        assertEquals(1475, caster.getHealth());
        assertEquals(1475, caster.getMana());
        assertEquals(455, caster.getDefense());
    }

    @Test
    void highLevelHeroEquipLowLevelBodyArmor() {
        Hero slasher = new Hero ("Slasher");
        BodyArmor rustyPlate = new BodyArmor("Rusty Plate", 1);
        slasher.setLevel(65);
        slasher.equipBodyArmor(rustyPlate);

        assertEquals(1400, slasher.getHealth());
        assertEquals(1400, slasher.getMana());
        assertEquals(340, slasher.getDefense());
    }

    @Test
    void lowLevelHeroEquipHighLevelBodyArmor() {
        Hero caster = new Hero("Caster");
        BodyArmor merlinRobe = new BodyArmor("Merlin Robe", 100);

        assertThrows(IllegalStateException.class,() -> caster.equipBodyArmor(merlinRobe));
    }

    @Test
    void heroUnEquipBodyArmor() {
        Hero slasher = new Hero ("Slasher");
        BodyArmor dragonPlate = new BodyArmor("Dragon Plate", 90);
        slasher.setLevel(90);
        slasher.equipBodyArmor(dragonPlate);
        slasher.unEquipBodyArmor();

        assertEquals(1880, slasher.getHealth());
        assertEquals(1880, slasher.getMana());
        assertEquals(455, slasher.getDefense());
    }
    //Body armor equip and un-equip test ends

    //Hero equip and un-equip weapon and armor end
}