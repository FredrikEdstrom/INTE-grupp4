import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void playerLevelUpTest() {
        Hero player = new Hero("player");
        player.levelUp();
        assertEquals(2, player.getLevel());
    }

    @Test
    void setPlayerMaxLevelTest() {
        Hero player = new Hero("player");
        player.setLevel(100);
        assertEquals(100, player.getLevel());
    }

    @Test
    void setPlayerOverMaxLevelTest() {
        Hero player = new Hero("player");
        player.setLevel(101);
        assertEquals(100, player.getLevel());
    }

    @Test
    void setPlayerLevelZeroTest() {
        Hero player = new Hero("player");
        player.setLevel(0);
        assertEquals(1, player.getLevel());
    }

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

    //Sword increases attack
    @Test
    void heroEquipSword() {
        Hero slasher = new Hero("Slasher");
        Weapon goldenSword = new Sword("Golden Sword", 50);
        slasher.setLevel(50);
        slasher.equipWeapon(goldenSword);

        assertEquals(goldenSword, slasher.getWeapon());
        assertEquals(525, slasher.getAttack());
    }

    //Staff increases intelligence
    @Test
    void heroEquipStaff() {
        Hero caster = new Hero("Caster");
        Weapon goldenStaff = new Staff("Golden Staff", 50);
        caster.setLevel(50);
        caster.equipWeapon(goldenStaff);

        assertEquals(goldenStaff, caster.getWeapon());
        assertEquals(525, caster.getIntelligence());
    }

    @Test
    void heroUnEquipSword() {
        Hero slasher = new Hero("Slasher");
        Weapon goldenSword = new Sword("Golden Sword", 50);
        slasher.setLevel(50);
        slasher.equipWeapon(goldenSword);
        slasher.unEquipWeapon();

        assertNull(slasher.getWeapon());
        assertEquals(255, slasher.getAttack());
    }

    @Test
    void heroUnEquipStaff() {
        Hero caster = new Hero("Caster");
        Weapon goldenStaff = new Staff("Golden Staff", 50);
        caster.setLevel(50);
        caster.equipWeapon(goldenStaff);
        caster.unEquipWeapon();

        assertNull(caster.getWeapon());
        assertEquals(255, caster.getIntelligence());
    }
    //Weapon equip and un-equip test ends

    //Head armor equip  and un-equip starts
    @Test
    void lowLevelHeroEquipHighLevelHeadArmor() {
        Hero slasher = new Hero("Slasher");
        HeadArmor skullHelm = new Helmet("Skull Helmet", 50);

        assertThrows(IllegalStateException.class, () -> slasher.equipHeadArmor(skullHelm));
    }

    //Helmet increases health and defense
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

    //Cap increases mana and defense
    @Test
    void heroEquipCap() {
        Hero caster = new Hero("Caster");
        HeadArmor priestCap = new Cap("Priest Cap", 30);
        caster.setLevel(30);
        caster.equipHeadArmor(priestCap);

        assertEquals(priestCap, caster.getHeadArmor());
        assertEquals(840, caster.getMana());
        assertEquals(172, caster.getDefense());
    }

    @Test
    void heroUnEquipHelmet() {
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
    void heroUnEquipHeadArmor() {
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
    void lowLevelHeroEquipHighLevelBodyArmor() {
        Hero caster = new Hero("Caster");
        Robe merlinRobe = new Robe("Merlin Robe", 100);

        assertThrows(IllegalStateException.class, () -> caster.equipBodyArmor(merlinRobe));
    }

    //Body plate increases health, mana, attack, and defense
    @Test
    void heroEquipBodyPlate() {
        Hero slasher = new Hero("Slasher");
        BodyArmor goldenPlate = new BodyPlate("Golden Plate", 72);
        slasher.setLevel(72);
        slasher.equipBodyArmor(goldenPlate);

        assertEquals(goldenPlate, slasher.getBodyArmor());
        assertEquals(1900, slasher.getHealth());
        assertEquals(1561, slasher.getMana());
        assertEquals(591, slasher.getAttack());
        assertEquals(591, slasher.getDefense());
    }

    //Robe increases health, mana, intelligence, and defense
    @Test
    void heroEquipRobe() {
        Hero caster = new Hero("Caster");
        BodyArmor priestRobe = new Robe("Priest Robe", 72);
        caster.setLevel(72);
        caster.equipBodyArmor(priestRobe);

        assertEquals(priestRobe, caster.getBodyArmor());
        assertEquals(1561, caster.getHealth());
        assertEquals(1900, caster.getMana());
        assertEquals(591, caster.getIntelligence());
        assertEquals(406, caster.getDefense());
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
    void lowLevelHeroEquipHighLevelHandArmor() {
        Hero slasher = new Hero("Slasher");
        HandArmor boneGauntlets = new Gauntlets("Bone Gauntlets", 50);

        assertThrows(IllegalStateException.class, () -> slasher.equipHandArmor(boneGauntlets));
    }

    //Gauntlets increases health, attack, and defense
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

    //Gloves increases mana, intelligence, and defense
    @Test
    void heroEquipGloves() {
        Hero caster = new Hero("Caster");
        HandArmor priestGloves = new Gloves("Priest Gloves", 40);
        caster.setLevel(40);
        caster.equipHandArmor(priestGloves);

        assertEquals(priestGloves, caster.getHandArmor());
        assertEquals(1090, caster.getMana());
        assertEquals(330, caster.getIntelligence());
        assertEquals(227, caster.getDefense());
    }

    @Test
    void heroUnEquipGauntlets() {
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
    void heroUnEquipGloves() {
        Hero slasher = new Hero("Slasher");
        HandArmor priestGloves = new Gloves("Priest Gloves", 40);
        slasher.setLevel(40);
        slasher.equipHandArmor(priestGloves);
        slasher.unEquipHandArmor();

        assertNull(slasher.getHandArmor());
        assertEquals(880, slasher.getMana());
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

    //Both leg plate and trousers increases health, mana, agility and defense but in a different way
    @Test
    void heroEquipLegPlate() {
        Hero slasher = new Hero("Slasher");
        LegArmor goldenLegPlate = new LegPlate("Golden Leg Plate", 80);
        slasher.setLevel(80);
        slasher.equipLegArmor(goldenLegPlate);

        assertEquals(goldenLegPlate, slasher.getLegArmor());
        assertEquals(2100, slasher.getHealth());
        assertEquals(1725, slasher.getMana());
        assertEquals(450, slasher.getAgility());
        assertEquals(655, slasher.getDefense());
    }

    @Test
    void heroEquipTrousers() {
        Hero caster = new Hero("Caster");
        LegArmor priestTrousers = new Trousers("Priest Trousers", 80);
        caster.setLevel(80);
        caster.equipLegArmor(priestTrousers);

        assertEquals(priestTrousers, caster.getLegArmor());
        assertEquals(1725, caster.getHealth());
        assertEquals(2100, caster.getMana());
        assertEquals(655, caster.getAgility());
        assertEquals(450, caster.getDefense());
    }

    @Test
    void heroUnEquipLegPlate() {
        Hero slasher = new Hero("Slasher");
        LegArmor dragonLegPlate = new LegPlate("Dragon Leg Plate", 80);
        slasher.setLevel(80);
        slasher.equipLegArmor(dragonLegPlate);
        slasher.unEquipLegArmor();

        assertNull(slasher.getLegArmor());
        assertEquals(1680, slasher.getHealth());
        assertEquals(1680, slasher.getMana());
        assertEquals(405, slasher.getAgility());
        assertEquals(405, slasher.getDefense());
    }

    @Test
    void heroUnEquipTrousers() {
        Hero caster = new Hero("Caster");
        LegArmor blessedTrousers = new Trousers("Blessed Trousers", 80);
        caster.setLevel(80);
        caster.equipLegArmor(blessedTrousers);
        caster.unEquipLegArmor();

        assertNull(caster.getLegArmor());
        assertEquals(1680, caster.getHealth());
        assertEquals(1680, caster.getMana());
        assertEquals(405, caster.getAgility());
        assertEquals(405, caster.getDefense());
    }
    //Leg armor equip and un-equip test ends

    //Foot armor equip and un-equip test starts
    @Test
    void lowLevelHeroEquipHighLevelFootArmor() {
        Hero caster = new Hero("Caster");
        FootArmor priestShoes = new Shoes("Priest Shoes", 30);

        assertThrows(IllegalStateException.class, () -> caster.equipFootArmor(priestShoes));
    }

    //Boots increases health, agility and defense
    @Test
    void heroEquipBoots() {
        Hero slasher = new Hero("Slasher");
        FootArmor boneBoots = new Boots("Bone Boots", 35);
        slasher.setLevel(35);
        slasher.equipFootArmor(boneBoots);

        assertEquals(boneBoots, slasher.getFootArmor());
        assertEquals(965, slasher.getHealth());
        assertEquals(199, slasher.getAgility());
        assertEquals(290, slasher.getDefense());
    }

    //Shoes increases mana, agility and defense
    @Test
    void heroEquipShoes() {
        Hero caster = new Hero("Caster");
        FootArmor priestShoes = new Shoes("Priest Shoes", 35);
        caster.setLevel(35);
        caster.equipFootArmor(priestShoes);

        assertEquals(priestShoes, caster.getFootArmor());
        assertEquals(965, caster.getMana());
        assertEquals(290, caster.getAgility());
        assertEquals(199, caster.getDefense());
    }

    @Test
    void heroUnEquipBoots() {
        Hero slasher = new Hero("Slasher");
        FootArmor boneBoots = new Boots("Bone Boots", 35);
        slasher.setLevel(35);
        slasher.equipFootArmor(boneBoots);
        slasher.unEquipFootArmor();

        assertNull(slasher.getFootArmor());
        assertEquals(780, slasher.getHealth());
        assertEquals(180, slasher.getAgility());
        assertEquals(180, slasher.getDefense());
    }

    @Test
    void heroUnEquipShoes() {
        Hero caster = new Hero("Caster");
        FootArmor priestShoes = new Shoes("Priest Shoes", 35);
        caster.setLevel(35);
        caster.equipFootArmor(priestShoes);
        caster.unEquipFootArmor();

        assertNull(caster.getFootArmor());
        assertEquals(780, caster.getMana());
        assertEquals(180, caster.getAgility());
        assertEquals(180, caster.getDefense());
    }
    //Foot armor equip and un-equip test ends

    //Full armor equip test starts

    //Full plate armor pieces are helmet, gauntlets, body plate, leg plate, and boots
    //Full plate armor with sword have more health, attack and defense
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
        assertEquals(2190, slasher.getMana());
        assertEquals(1640, slasher.getAttack());
        assertEquals(505, slasher.getIntelligence());
        assertEquals(612, slasher.getAgility());
        assertEquals(2040, slasher.getDefense());
    }

    //Full cloth armor pieces are cap, gloves, robe, trousers, and shoes
    //Full cloth armor with staff have more mana, intelligence and agility
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
        assertEquals(2190, caster.getHealth());
        assertEquals(4650, caster.getMana());
        assertEquals(505, caster.getAttack());
        assertEquals(1640, caster.getIntelligence());
        assertEquals(1120, caster.getAgility());
        assertEquals(771, caster.getDefense());
    }
    //Full armor equip test ends
    //Hero equip and un-equip weapon and armor end
}