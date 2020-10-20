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

    //Weapon equip and un-equip test starts
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
    void highLevelHeroEquipLowLevelWeapon() {
        Hero slasher = new Hero("Slasher");
        Weapon rustySword = new Sword("Rusty Sword", 1);
        slasher.setLevel(50);
        slasher.equipWeapon(rustySword);

        assertEquals(rustySword, slasher.getWeapon());
        assertEquals(275, slasher.getAttack());
    }

    @Test
    void highLevelHeroEquipSameLevelSwordWeapon() {
        Hero slasher = new Hero("Slasher");
        Weapon goldenSword = new Sword("Golden Sword", 50);
        slasher.setLevel(50);
        slasher.equipWeapon(goldenSword);

        assertEquals(goldenSword, slasher.getWeapon());
        assertEquals(525, slasher.getAttack());
    }

    @Test
    void highLevelHeroEquipSameLevelWeapon() {
        Hero slasher = new Hero("Slasher");
        Weapon goldenStaff = new Staff("Golden Staff", 50);
        slasher.setLevel(50);
        slasher.equipWeapon(goldenStaff);

        assertEquals(goldenStaff, slasher.getWeapon());
        assertEquals(525, slasher.getIntelligence());
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
        caster.setLevel(50);
        caster.equipWeapon(goldenStaff);
        caster.unEquipWeapon();

        assertNull(caster.getWeapon());
        assertEquals(255, caster.getIntelligence());

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

    //Head armor equip  and un-equip starts
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
        assertEquals(12, caster.getDefense());
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
    void highLevelHeroEquipSameLevelHelmet() {
        Hero slasher = new Hero("Slasher");
        HeadArmor skullHelm = new Helmet("Skull Helm", 30);
        slasher.setLevel(30);
        slasher.equipHeadArmor(skullHelm);

        assertEquals(skullHelm, slasher.getHeadArmor());
        assertEquals(840, slasher.getHealth());
        assertEquals(250, slasher.getDefense());
    }

    @Test
    void highLevelHeroEquipSameLevelCap() {
        Hero caster = new Hero("Caster");
        HeadArmor priestCap = new Cap("Priest Cap", 30);
        caster.setLevel(30);
        caster.equipHeadArmor(priestCap);

        assertEquals(priestCap, caster.getHeadArmor());
        assertEquals(840, caster.getMana());
        assertEquals(187, caster.getDefense());
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
        HeadArmor skullHelmet = new Helmet("Skull Helmet", 45);
        slasher.setLevel(45);
        slasher.equipHeadArmor(skullHelmet);
        slasher.unEquipHeadArmor();

        assertNull(slasher.getHeadArmor());
        assertEquals(980, slasher.getHealth());
        assertEquals(230, slasher.getDefense());
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

    //Body armor equip and un-equip test starts
    @Test
    void lowLevelHeroEquipLowLevelBodyPlate() {
        Hero slasher = new Hero("Slasher");
        BodyPlate rustyPlate = new BodyPlate("Rusty Plate", 1);
        slasher.equipBodyArmor(rustyPlate);

        assertEquals(rustyPlate, slasher.getBodyArmor());
        assertEquals(120, slasher.getHealth());
        assertEquals(105, slasher.getMana());
        assertEquals(20, slasher.getAttack());
        assertEquals(20, slasher.getDefense());
    }

    @Test
    void lowLevelHeroEquipLowLevelRobe() {
        Hero caster = new Hero("Caster");
        Robe noviceRobe = new Robe("Novice Robe", 1);
        caster.equipBodyArmor(noviceRobe);

        assertEquals(noviceRobe, caster.getBodyArmor());
        assertEquals(105, caster.getHealth());
        assertEquals(120, caster.getMana());
        assertEquals(20, caster.getIntelligence());
        assertEquals(15, caster.getDefense());
    }

    @Test
    void highLevelHeroEquipLowLevelBodyArmor() {
        Hero slasher = new Hero("Slasher");
        BodyPlate rustyPlate = new BodyPlate("Rusty Plate", 1);
        slasher.setLevel(65);
        slasher.equipBodyArmor(rustyPlate);

        assertEquals(rustyPlate, slasher.getBodyArmor());
        assertEquals(1400, slasher.getHealth());
        assertEquals(1385, slasher.getMana());
        assertEquals(340, slasher.getAttack());
        assertEquals(340, slasher.getDefense());
    }

    @Test
    void highLevelHeroEquipSameLevelBodyPlate() {
        Hero slasher = new Hero("Slasher");
        BodyArmor goldenPlate = new BodyPlate("Golden Plate", 72);
        slasher.setLevel(72);
        slasher.equipBodyArmor(goldenPlate);

        assertEquals(goldenPlate, slasher.getBodyArmor());
        assertEquals(1900, slasher.getHealth());
        assertEquals(1597, slasher.getMana());
        assertEquals(591, slasher.getAttack());
        assertEquals(591, slasher.getDefense());
    }


    @Test
    void highLevelHeroEquipSameLevelRobe() {
        Hero caster = new Hero("Caster");
        BodyArmor priestRobe = new Robe("Priest Robe", 72);
        caster.setLevel(72);
        caster.equipBodyArmor(priestRobe);

        assertEquals(priestRobe, caster.getBodyArmor());
        assertEquals(1597, caster.getHealth());
        assertEquals(1900, caster.getMana());
        assertEquals(591, caster.getIntelligence());
        assertEquals(442, caster.getDefense());
    }

    @Test
    void lowLevelHeroEquipHighLevelBodyArmor() {
        Hero caster = new Hero("Caster");
        Robe merlinRobe = new Robe("Merlin Robe", 100);

        assertThrows(IllegalStateException.class, () -> caster.equipBodyArmor(merlinRobe));
    }

    @Test
    void heroUnEquipBodyPlate() {
        Hero slasher = new Hero("Slasher");
        BodyPlate dragonPlate = new BodyPlate("Dragon Plate", 82);
        slasher.setLevel(82);
        slasher.equipBodyArmor(dragonPlate);
        slasher.unEquipBodyArmor();

        assertNull(slasher.getBodyArmor());
        assertEquals(1720, slasher.getHealth());
        assertEquals(1720, slasher.getMana());
        assertEquals(415, slasher.getAttack());
        assertEquals(415, slasher.getDefense());
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

    //Body armor equip and un-equip test ends

    //Hand armor equip and un-equip test starts
    @Test
    void heroEquipHandArmorGauntlets() {
        Hero slasher = new Hero("Slasher");
        HandArmor rustyGauntlets = new Gauntlets("Rusty Gauntlets", 1);
        slasher.equipHandArmor(rustyGauntlets);

        assertEquals(rustyGauntlets, slasher.getHandArmor());
        assertEquals(110, slasher.getHealth());
        assertEquals(15, slasher.getAttack());
        assertEquals(15, slasher.getDefense());
    }

    @Test
    void heroEquipHandArmorGloves() {
        Hero caster = new Hero("Caster");
        HandArmor tornGloves = new Gloves("Torn Gloves", 1);
        caster.equipHandArmor(tornGloves);

        assertEquals(tornGloves, caster.getHandArmor());
        assertEquals(110, caster.getMana());
        assertEquals(15, caster.getIntelligence());
        assertEquals(12, caster.getDefense());
    }

    @Test
    void highLevelHeroEquipLowLevelHandArmor() {
        Hero slasher = new Hero("Slasher");
        HandArmor rustyGauntlets = new Gauntlets("Rusty Gauntlets", 1);
        slasher.setLevel(40);
        slasher.equipHandArmor(rustyGauntlets);

        assertEquals(rustyGauntlets, slasher.getHandArmor());
        assertEquals(890, slasher.getHealth());
        assertEquals(210, slasher.getAttack());
        assertEquals(210, slasher.getDefense());
    }

    @Test
    void highLevelHeroEquipSameLevelGauntlets() {
        Hero slasher = new Hero("Slasher");
        HandArmor boneGauntlets = new Gauntlets("Bone Gauntlets", 40);
        slasher.setLevel(40);
        slasher.equipHandArmor(boneGauntlets);

        assertEquals(boneGauntlets, slasher.getHandArmor());
        assertEquals(1090, slasher.getHealth());
        assertEquals(330, slasher.getAttack());
        assertEquals(330, slasher.getDefense());
    }

    @Test
    void highLevelHeroEquipSameLevelGloves() {
        Hero caster = new Hero("Caster");
        HandArmor priestGloves = new Gloves("Priest Gloves", 40);
        caster.setLevel(40);
        caster.equipHandArmor(priestGloves);

        assertEquals(priestGloves, caster.getHandArmor());
        assertEquals(1090, caster.getMana());
        assertEquals(330, caster.getIntelligence());
        assertEquals(247, caster.getDefense());
    }

    @Test
    void lowLevelHeroEquipHighLevelHandArmor() {
        Hero slasher = new Hero("Slasher");
        HandArmor boneGauntlets = new Gauntlets("Bone Gauntlets", 50);

        assertThrows(IllegalStateException.class, () -> slasher.equipHandArmor(boneGauntlets));
    }

    @Test
    void heroUnEquipHeadArmorGauntlets() {
        Hero slasher = new Hero("Slasher");
        HandArmor skullHelmet = new Gauntlets("Bone Gauntlets", 40);
        slasher.setLevel(40);
        slasher.equipHandArmor(skullHelmet);
        slasher.unEquipHandArmor();

        assertNull(slasher.getHandArmor());
        assertEquals(880, slasher.getHealth());
        assertEquals(205, slasher.getAttack());
        assertEquals(205, slasher.getDefense());
    }

    @Test
    void heroUnEquipHeadArmorGloves() {
        Hero caster = new Hero("Caster");
        HandArmor priestGloves = new Gloves("Priest Gloves", 40);
        caster.setLevel(40);
        caster.equipHandArmor(priestGloves);
        caster.unEquipHandArmor();

        assertNull(caster.getHandArmor());
        assertEquals(880, caster.getMana());
        assertEquals(205, caster.getIntelligence());
        assertEquals(205, caster.getDefense());
    }
    //Hand armor equip and un-equip test ends

    //Leg armor equip and un-equip test starts

    //Leg armor equip and un-equip test ends

    //Foot armor equip and un-equip test starts

    //Foot armor equip and un-equip test ends

    //Full armor equip test starts

    //Full armor equip test ends

    //Hero equip and un-equip weapon and armor end
}