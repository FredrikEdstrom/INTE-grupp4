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
    void lowLevelHeroEquipHighLevelWeapon() {
        Hero caster = new Hero("Caster");
        Weapon goldenStaff = new Staff("Golden Staff", 50);

        assertThrows(IllegalStateException.class, () -> caster.equipWeapon(goldenStaff));
    }

    @Test
    void heroEquipSword() {
        Hero slasher = new Hero("Slasher");
        Weapon goldenSword = new Sword("Golden Sword", 50);
        slasher.setLevel(50);
        slasher.equipWeapon(goldenSword);

        assertEquals(goldenSword, slasher.getWeapon());
        assertEquals(525, slasher.getAttack());
    }

    @Test
    void heroEquipStaff() {
        Hero slasher = new Hero("Slasher");
        Weapon goldenStaff = new Staff("Golden Staff", 50);
        slasher.setLevel(50);
        slasher.equipWeapon(goldenStaff);

        assertEquals(goldenStaff, slasher.getWeapon());
        assertEquals(525, slasher.getIntelligence());
    }

    @Test
    void heroUnEquipWeapon() {
        Hero caster = new Hero("Caster");
        Weapon goldenStaff = new Staff("Golden Staff", 50);
        Weapon goldenSword = new Sword("Golden Sword", 50);
        caster.setLevel(50);
        caster.equipWeapon(goldenStaff);
        caster.unEquipWeapon();
        caster.equipWeapon(goldenSword);
        caster.unEquipWeapon();

        assertNull(caster.getWeapon());
        assertEquals(255, caster.getIntelligence());
        assertEquals(255, caster.getAttack());
    }
    //Weapon equip and un-equip test ends

    //Head armor equip  and un-equip starts
    @Test
    void lowLevelHeroEquipHighLevelHeadArmor() {
        Hero slasher = new Hero("Slasher");
        HeadArmor skullHelm = new Helmet("Skull Helmet", 50);

        assertThrows(IllegalStateException.class, () -> slasher.equipHeadArmor(skullHelm));
    }

    @Test
    void heroEquipHelmet() {
        Hero slasher = new Hero("Slasher");
        HeadArmor skullHelm = new Helmet("Skull Helm", 30);
        slasher.setLevel(30);
        slasher.equipHeadArmor(skullHelm);

        assertEquals(skullHelm, slasher.getHeadArmor());
        assertEquals(840, slasher.getHealth());
        assertEquals(250, slasher.getDefense());
    }

    @Test
    void heroEquipCap() {
        Hero caster = new Hero("Caster");
        HeadArmor priestCap = new Cap("Priest Cap", 30);
        caster.setLevel(30);
        caster.equipHeadArmor(priestCap);

        assertEquals(priestCap, caster.getHeadArmor());
        assertEquals(840, caster.getMana());
        assertEquals(187, caster.getDefense());
    }

    @Test
    void heroUnEquipHeadArmor() {
        Hero slasher = new Hero("Slasher");
        HeadArmor skullHelmet = new Helmet("Skull Helmet", 45);
        HeadArmor priestHelm = new Cap("Priest Helm", 45);
        slasher.setLevel(45);
        slasher.equipHeadArmor(skullHelmet);
        slasher.unEquipHeadArmor();
        slasher.equipHeadArmor(priestHelm);
        slasher.unEquipHeadArmor();

        assertNull(slasher.getHeadArmor());
        assertEquals(980, slasher.getHealth());
        assertEquals(980, slasher.getMana());
        assertEquals(230, slasher.getDefense());
    }
    //Head armor equip un-equip ends

    //Body armor equip and un-equip test starts
    @Test
    void lowLevelHeroEquipHighLevelBodyArmor() {
        Hero caster = new Hero("Caster");
        Robe merlinRobe = new Robe("Merlin Robe", 100);

        assertThrows(IllegalStateException.class, () -> caster.equipBodyArmor(merlinRobe));
    }

    @Test
    void heroEquipBodyPlate() {
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
    void heroEquipRobe() {
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
    void heroUnEquipBodyArmor() {
        Hero slasher = new Hero("Slasher");
        BodyPlate dragonPlate = new BodyPlate("Dragon Plate", 82);
        Robe blessedRobe = new Robe("Blessed Robe", 82);
        slasher.setLevel(82);
        slasher.equipBodyArmor(dragonPlate);
        slasher.unEquipBodyArmor();
        slasher.equipBodyArmor(blessedRobe);
        slasher.unEquipBodyArmor();

        assertNull(slasher.getBodyArmor());
        assertEquals(1720, slasher.getHealth());
        assertEquals(1720, slasher.getMana());
        assertEquals(415, slasher.getAttack());
        assertEquals(415, slasher.getIntelligence());
        assertEquals(415, slasher.getDefense());
    }
    //Body armor equip and un-equip test ends

    //Hand armor equip and un-equip test starts
    @Test
    void lowLevelHeroEquipHighLevelHandArmor() {
        Hero slasher = new Hero("Slasher");
        HandArmor boneGauntlets = new Gauntlets("Bone Gauntlets", 50);

        assertThrows(IllegalStateException.class, () -> slasher.equipHandArmor(boneGauntlets));
    }

    @Test
    void heroEquipGauntlets() {
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
    void heroEquipGloves() {
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
    void heroUnEquipHandArmor() {
        Hero slasher = new Hero("Slasher");
        HandArmor skullHelmet = new Gauntlets("Bone Gauntlets", 40);
        HandArmor priestGloves = new Gloves("Priest Gloves", 40);
        slasher.setLevel(40);
        slasher.equipHandArmor(skullHelmet);
        slasher.unEquipHandArmor();
        slasher.equipHandArmor(priestGloves);
        slasher.unEquipHandArmor();

        assertNull(slasher.getHandArmor());
        assertEquals(880, slasher.getHealth());
        assertEquals(205, slasher.getAttack());
        assertEquals(205, slasher.getIntelligence());
        assertEquals(205, slasher.getDefense());
    }
    //Hand armor equip and un-equip test ends

    //Leg armor equip and un-equip test starts
    @Test
    void lowLevelHeroEquipHighLevelLegArmor() {
        Hero caster = new Hero("Caster");
        LegArmor merlinTrousers = new Trousers("Merlin Trousers", 95);

        assertThrows(IllegalStateException.class, () -> caster.equipLegArmor(merlinTrousers));
    }

    @Test
    void heroEquipLegPlate() {
        Hero slasher = new Hero("Slasher");
        LegArmor goldenLegPlate = new LegPlate("Golden Leg Plate", 80);
        slasher.setLevel(80);
        slasher.equipLegArmor(goldenLegPlate);

        assertEquals(goldenLegPlate, slasher.getLegArmor());
        assertEquals(2100, slasher.getHealth());
        assertEquals(1765, slasher.getMana());
        assertEquals(490, slasher.getAgility());
        assertEquals(655, slasher.getDefense());
    }

    @Test
    void heroEquipTrousers() {
        Hero caster = new Hero("Caster");
        LegArmor priestTrousers = new Trousers("Priest Trousers", 80);
        caster.setLevel(80);
        caster.equipLegArmor(priestTrousers);

        assertEquals(priestTrousers, caster.getLegArmor());
        assertEquals(1765, caster.getHealth());
        assertEquals(2100, caster.getMana());
        assertEquals(655, caster.getAgility());
        assertEquals(490, caster.getDefense());
    }

    @Test
    void heroUnEquipLegArmor() {
        Hero slasher = new Hero("Slasher");
        LegArmor dragonLegPlate = new LegPlate("Dragon Leg Plate", 80);
        LegArmor blessedTrousers = new Trousers("Blessed Trousers", 80);
        slasher.setLevel(80);
        slasher.equipLegArmor(dragonLegPlate);
        slasher.unEquipLegArmor();
        slasher.equipLegArmor(blessedTrousers);
        slasher.unEquipLegArmor();

        assertNull(slasher.getLegArmor());
        assertEquals(1680, slasher.getHealth());
        assertEquals(1680, slasher.getMana());
        assertEquals(405, slasher.getAgility());
        assertEquals(405, slasher.getDefense());
    }
    //Leg armor equip and un-equip test ends

    //Foot armor equip and un-equip test starts
    @Test
    void lowLevelHeroEquipHighLevelFootArmor() {
        Hero caster = new Hero("Caster");
        FootArmor priestShoes = new Shoes("Priest Shoes", 30);

        assertThrows(IllegalStateException.class, () -> caster.equipFootArmor(priestShoes));
    }

    @Test
    void heroEquipBoots() {
        Hero slasher = new Hero("Slasher");
        FootArmor boneBoots = new Boots("Bone Boots", 35);
        slasher.setLevel(35);
        slasher.equipFootArmor(boneBoots);

        assertEquals(boneBoots, slasher.getFootArmor());
        assertEquals(965, slasher.getHealth());
        assertEquals(217, slasher.getAgility());
        assertEquals(290, slasher.getDefense());
    }

    @Test
    void heroEquipShoes() {
        Hero caster = new Hero("Caster");
        FootArmor priestShoes = new Shoes("Priest Shoes", 35);
        caster.setLevel(35);
        caster.equipFootArmor(priestShoes);

        assertEquals(priestShoes, caster.getFootArmor());
        assertEquals(965, caster.getMana());
        assertEquals(290, caster.getAgility());
        assertEquals(217, caster.getDefense());
    }

    @Test
    void heroUnEquipFootArmor() {
        Hero slasher = new Hero("Slasher");
        FootArmor boneBoots = new Boots("Bone Boots", 35);
        FootArmor priestShoes = new Shoes("Priest Shoes", 35);
        slasher.setLevel(35);
        slasher.equipFootArmor(boneBoots);
        slasher.unEquipFootArmor();
        slasher.equipFootArmor(priestShoes);
        slasher.unEquipFootArmor();

        assertNull(slasher.getFootArmor());
        assertEquals(780, slasher.getHealth());
        assertEquals(780, slasher.getMana());
        assertEquals(180, slasher.getAgility());
        assertEquals(180, slasher.getDefense());
    }
    //Foot armor equip and un-equip test ends

    //Full armor equip test starts
    //Full plate armor pieces are helmet, gauntlets, body plate, leg plate, and boots
    @Test
    void heroEquipFullPlateArmorWithSword() {
        Hero slasher = new Hero("Slasher");
        Weapon dragonBlade = new Sword("Dragon Blade", 100);
        HeadArmor dragonHelm = new Helmet("Dragon Helm", 100);
        BodyArmor dragonPlate = new BodyPlate("Dragon Plate", 100);
        HandArmor dragonGauntlets = new Gauntlets("Dragon Gauntlets", 100);
        LegArmor dragonLegPlate = new LegPlate("Dragon Leg Plate", 100);
        FootArmor dragonBoots = new Boots("Dragon Boots", 100);
        slasher.setLevel(100);
        slasher.equipWeapon(dragonBlade);
        slasher.equipHeadArmor(dragonHelm);
        slasher.equipBodyArmor(dragonPlate);
        slasher.equipHandArmor(dragonGauntlets);
        slasher.equipLegArmor(dragonLegPlate);
        slasher.equipFootArmor(dragonBoots);

        assertEquals(dragonBlade, slasher.getWeapon());
        assertEquals(dragonHelm, slasher.getHeadArmor());
        assertEquals(dragonPlate, slasher.getBodyArmor());
        assertEquals(dragonGauntlets, slasher.getHandArmor());
        assertEquals(dragonLegPlate, slasher.getLegArmor());
        assertEquals(dragonBoots, slasher.getFootArmor());
        assertEquals(4650, slasher.getHealth());
        assertEquals(2290, slasher.getMana());
        assertEquals(1640, slasher.getAttack());
        assertEquals(505, slasher.getIntelligence());
        assertEquals(712, slasher.getAgility());
        assertEquals(2040, slasher.getDefense());
    }
    //Full cloth armor pieces are cap, gloves, robe, trousers, and shoes
    @Test
    void heroEquipFullClothArmorWithStaff() {
        Hero caster = new Hero("Caster");
        Weapon merlinStaff = new Staff("Merlin Staff", 100);
        HeadArmor merlinCap = new Cap("Merlin Cap", 100);
        BodyArmor merlinRobe = new Robe("Merlin Robe", 100);
        HandArmor merlinGloves = new Gloves("Merlin Gloves", 100);
        LegArmor merlinTrouser = new Trousers("Merlin Trouser", 100);
        FootArmor merlinShoes = new Shoes("Merlin Shoes", 100);
        caster.setLevel(100);
        caster.equipWeapon(merlinStaff);
        caster.equipHeadArmor(merlinCap);
        caster.equipBodyArmor(merlinRobe);
        caster.equipHandArmor(merlinGloves);
        caster.equipLegArmor(merlinTrouser);
        caster.equipFootArmor(merlinShoes);

        assertEquals(merlinStaff, caster.getWeapon());
        assertEquals(merlinCap, caster.getHeadArmor());
        assertEquals(merlinRobe, caster.getBodyArmor());
        assertEquals(merlinGloves, caster.getHandArmor());
        assertEquals(merlinTrouser, caster.getLegArmor());
        assertEquals(merlinShoes, caster.getFootArmor());
        assertEquals(2290, caster.getHealth());
        assertEquals(4650, caster.getMana());
        assertEquals(505, caster.getAttack());
        assertEquals(1640, caster.getIntelligence());
        assertEquals(1120, caster.getAgility());
        assertEquals(1021, caster.getDefense());
    }
    //Full armor equip test ends
    //Hero equip and un-equip weapon and armor end
}