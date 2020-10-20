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

        assertEquals(rustySword, slasher.getWeapon());
        assertEquals(30, slasher.getAttack());
    }

    @Test
    void heroEquipStaffWeapon() {
        Hero caster = new Hero("Caster");
        Weapon woodenStaff = new Staff("Wooden Staff", 1);
        caster.equipWeapon(woodenStaff);

        assertEquals(woodenStaff, caster.getWeapon());
        assertEquals(30, caster.getIntelligence());
    }

    @Test
    void highLevelHeroEquipSameLevelWeapon() {
        Hero slasher = new Hero("Slasher");
        Weapon goldenSword = new Sword("Golden Sword", 50);
        slasher.setLevel(50);
        slasher.equipWeapon(goldenSword);

        assertEquals(goldenSword, slasher.getWeapon());
        assertEquals(525, slasher.getAttack());
    }

    @Test
    void highLevelHeroEquipLowLevelWeapon() {
        Hero slasher = new Hero("Slasher");
        Weapon rustySword = new Sword("Rusty Sword", 1);
        slasher.setLevel(50);
        slasher.equipWeapon(rustySword);

        assertEquals(rustySword, slasher.getWeapon());
        assertEquals(275, slasher.getAttack());
    }

    @Test
    void lowLevelHeroEquipHighLevelWeapon() {
        Hero caster = new Hero("Caster");
        Weapon goldenStaff = new Staff("Golden Staff", 50);

        assertThrows(IllegalStateException.class, () -> caster.equipWeapon(goldenStaff));
    }

    @Test
    void heroUnEquipWeaponStaff() {
        Hero caster = new Hero("Caster");
        Weapon goldenStaff = new Staff("Golden Staff", 50);
        caster.setLevel(60);
        caster.equipWeapon(goldenStaff);
        caster.unEquipWeapon();

        assertNull(caster.getWeapon());
        assertEquals(305, caster.getIntelligence());

    }

    @Test
    void heroUnEquipWeaponSword() {
        Hero slasher = new Hero("Slasher");
        Weapon goldenSword = new Sword("Golden Sword", 50);
        slasher.setLevel(50);
        slasher.equipWeapon(goldenSword);
        slasher.unEquipWeapon();

        assertNull(slasher.getWeapon());
        assertEquals(255, slasher.getAttack());
    }


    //Weapon equip and un-equip test ends

    //Head armor equip  and un-equip start:
    @Test
    void heroEquipHeadArmorHelmet() {
        Hero slasher = new Hero("Slasher");
        HeadArmor rustyHelmet = new Helmet("Rusty Helmet", 1);
        slasher.equipHeadArmor(rustyHelmet);

        assertEquals(rustyHelmet, slasher.getHeadArmor());
        assertEquals(110, slasher.getHealth());
        assertEquals(15, slasher.getDefense());
    }

    @Test
    void heroEquipHeadArmorCap() {
        Hero caster = new Hero("Caster");
        HeadArmor tornCap = new Cap("Torn Cap", 1);
        caster.equipHeadArmor(tornCap);

        assertEquals(tornCap, caster.getHeadArmor());
        assertEquals(110, caster.getMana());
        assertEquals(13, caster.getDefense());
    }

    @Test
    void highLevelHeroEquipLowLevelHeadArmor() {
        Hero slasher = new Hero("Slasher");
        HeadArmor rustyHelmet = new Helmet("Rusty Helmet", 1);
        slasher.setLevel(30);
        slasher.equipHeadArmor(rustyHelmet);

        assertEquals(rustyHelmet, slasher.getHeadArmor());
        assertEquals(690, slasher.getHealth());
        assertEquals(160, slasher.getDefense());
    }

    @Test
    void highLevelHeroEquipSameLevelHeadArmor() {
        Hero caster = new Hero("Caster");
        HeadArmor priestCap = new Cap("Priest Cap", 30);
        caster.setLevel(30);
        caster.equipHeadArmor(priestCap);

        assertEquals(priestCap, caster.getHeadArmor());
        assertEquals(840, caster.getMana());
        assertEquals(218, caster.getDefense());
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

        assertNull(slasher.getHeadArmor());
        assertEquals(580, slasher.getHealth());
        assertEquals(130, slasher.getDefense());
    }

    @Test
    void heroUnEquipHeadArmorCap() {
        Hero caster = new Hero("Caster");
        HeadArmor priestHelm = new Cap("Priest Helm", 45);
        caster.setLevel(45);
        caster.equipHeadArmor(priestHelm);
        caster.unEquipHeadArmor();

        assertNull(caster.getHeadArmor());
        assertEquals(980, caster.getMana());
        assertEquals(230, caster.getDefense());
    }
    //Head armor equip un-equip ends

    //Body armor equip and un-equip test start:
    @Test
    void lowLevelHeroEquipLowLevelBodyPlate() {
        Hero slasher = new Hero("Slasher");
        BodyPlate rustyPlate = new BodyPlate("Rusty Plate", 1);
        slasher.equipBodyArmor(rustyPlate);

        assertEquals(rustyPlate, slasher.getBodyArmor());
        assertEquals(120, slasher.getHealth());
        assertEquals(110, slasher.getMana());
        assertEquals(20, slasher.getAttack());
        assertEquals(20, slasher.getDefense());
    }

    @Test
    void highLevelHeroEquipSameLevelBodyPlate() {
        Hero slasher = new Hero("Slasher");
        BodyPlate goldenPlate = new BodyPlate("Golden Plate", 72);
        slasher.setLevel(72);
        slasher.equipBodyArmor(goldenPlate);

        assertEquals(goldenPlate, slasher.getBodyArmor());
        assertEquals(1900, slasher.getHealth());
        assertEquals(1674, slasher.getMana());
        assertEquals(591, slasher.getAttack());
        assertEquals(591, slasher.getDefense());
    }

    @Test
    void lowLevelHeroEquipLowLevelRobe() {
        Hero caster = new Hero("Caster");
        Robe noviceRobe = new Robe("Novice Robe", 1);
        caster.equipBodyArmor(noviceRobe);

        assertEquals(noviceRobe, caster.getBodyArmor());
        assertEquals(110, caster.getHealth());
        assertEquals(120, caster.getMana());
        assertEquals(20, caster.getIntelligence());
        assertEquals(15, caster.getDefense());
    }

    @Test
    void highLevelHeroEquipSameLevelRobe() {
        Hero caster = new Hero("Caster");
        Robe priestRobe = new Robe("Priest Robe", 55);
        caster.setLevel(55);
        caster.equipBodyArmor(priestRobe);

        assertEquals(priestRobe, caster.getBodyArmor());
        assertEquals(1300, caster.getHealth());
        assertEquals(1475, caster.getMana());
        assertEquals(455, caster.getIntelligence());
        assertEquals(395, caster.getDefense());
    }

    @Test
    void highLevelHeroEquipLowLevelBodyArmor() {
        Hero slasher = new Hero("Slasher");
        BodyPlate rustyPlate = new BodyPlate("Rusty Plate", 1);
        slasher.setLevel(65);
        slasher.equipBodyArmor(rustyPlate);

        assertEquals(rustyPlate, slasher.getBodyArmor());
        assertEquals(1400, slasher.getHealth());
        assertEquals(1390, slasher.getMana());
        assertEquals(340, slasher.getAttack());
        assertEquals(340, slasher.getDefense());
    }

    @Test
    void lowLevelHeroEquipHighLevelBodyArmor() {
        Hero caster = new Hero("Caster");
        Robe merlinRobe = new Robe("Merlin Robe", 100);

        assertThrows(IllegalStateException.class, () -> caster.equipBodyArmor(merlinRobe));
    }

    @Test
    void heroUnEquipRobe() {
        Hero caster = new Hero("Caster");
        Robe blessedRobe = new Robe("Blessed Robe", 82);
        caster.setLevel(82);
        caster.equipBodyArmor(blessedRobe);
        caster.unEquipBodyArmor();

        assertNull(caster.getBodyArmor());
        assertEquals(1720, caster.getHealth());
        assertEquals(1720, caster.getMana());
        assertEquals(415, caster.getIntelligence());
        assertEquals(415, caster.getDefense());
    }

    @Test
    void heroUnEquipBodyPlate() {
        Hero slasher = new Hero("Slasher");
        BodyPlate dragonPlate = new BodyPlate("Dragon Plate", 90);
        slasher.setLevel(90);
        slasher.equipBodyArmor(dragonPlate);
        slasher.unEquipBodyArmor();

        assertNull(slasher.getBodyArmor());
        assertEquals(1880, slasher.getHealth());
        assertEquals(1880, slasher.getMana());
        assertEquals(455, slasher.getAttack());
        assertEquals(455, slasher.getDefense());
    }
    //Body armor equip and un-equip test ends

    //Hero equip and un-equip weapon and armor end
}