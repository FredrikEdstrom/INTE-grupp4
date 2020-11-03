import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void playerLevelUpTest() {
        Hero player = new Hero("player");
        player.levelUp();
    }

    @Test
    void setPlayerExperience() {
        Hero player = new Hero("player");
        player.setExperience(100);
        assertEquals(100, player.getExperience());
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
    void setExperienceTest() {
        Hero hero = new Hero("hero");
        hero.setExperience(100);
        assertEquals(100, hero.getExperience());
    }


    @Test
    void createHeroWithEmptyName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Enemy("", 50, 100, 100, 100, 100, 100, 100, false, false));
        assertThrows(IllegalArgumentException.class,
                () -> new Hero(""));
    }

    @Test
    void createHeroWithBlankName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Enemy("", 50, 100, 100, 100, 100, 100, 100, false, false));
        assertThrows(IllegalArgumentException.class,
                () -> new Hero("   "));
    }

    //Hero equip and un-equip weapon and armor test start:

    //Weapon equip and un-equip test starts
    @Test
    void lowLevelHeroEquipHighLevelWeapon() {
        Hero caster = new Hero("Caster");
        Weapon goldenStaff = new Weapon("Golden Staff", 50, false);

        assertEquals(1, caster.getLevel());
        assertEquals(50, goldenStaff.getLevel());
        assertThrows(IllegalStateException.class, () -> caster.equipWeapon(goldenStaff));
    }

    //Sword increases attack
    @Test
    void heroEquipSword() {
        Hero slasher = new Hero("Slasher");
        Weapon goldenSword = new Weapon("Golden Sword", 50, true);
        slasher.setLevel(50);
        slasher.equipWeapon(goldenSword);

        assertTrue(goldenSword.isSword());
        assertFalse(goldenSword.isStaff());
        assertEquals(goldenSword, slasher.getWeapon());
        assertEquals(755, slasher.getAttack());
    }

    //Staff increases intelligence
    @Test
    void heroEquipStaff() {
        Hero caster = new Hero("Caster");
        Weapon goldenStaff = new Weapon("Golden Staff", 50, false);
        caster.setLevel(50);
        caster.equipWeapon(goldenStaff);

        assertTrue(goldenStaff.isStaff());
        assertFalse(goldenStaff.isSword());
        assertEquals(goldenStaff, caster.getWeapon());
        assertEquals(755, caster.getIntelligence());
    }

    @Test
    void heroUnEquipSword() {
        Hero slasher = new Hero("Slasher");
        Weapon goldenSword = new Weapon("Golden Sword", 50, true);
        slasher.setLevel(50);
        slasher.equipWeapon(goldenSword);
        slasher.unEquipWeapon();

        assertTrue(goldenSword.isSword());
        assertEquals(255, slasher.getAttack());
        assertNull(slasher.getWeapon());
    }

    @Test
    void heroUnEquipStaff() {
        Hero caster = new Hero("Caster");
        Weapon goldenStaff = new Weapon("Golden Staff", 50, false);
        caster.setLevel(50);
        caster.equipWeapon(goldenStaff);
        caster.unEquipWeapon();

        assertFalse(goldenStaff.isSword());
        assertEquals(255, caster.getIntelligence());
        assertNull(caster.getWeapon());
    }
    //Weapon equip and un-equip test ends

    @Test
    void lowLevelHeroEquipHighLevelArmor() {
        Hero caster = new Hero("Caster");
        Armor merlinRobe = new BodyArmor("Merlin Robe", 100, false);

        assertEquals(1, caster.getLevel());
        assertEquals(100, merlinRobe.getLevel());
        assertThrows(IllegalStateException.class, () -> caster.equipArmor(merlinRobe));
    }

    @Test
    void checkIfArmorIsInTheRightSlot() {
        Hero slasher = new Hero("Slasher");
        BodyArmor dragonPlate = new BodyArmor("Dragon Plate", 82, true);
        slasher.setLevel(82);
        slasher.equipArmor(dragonPlate);

        assertEquals(dragonPlate, slasher.getBodyArmor());
        assertNull(slasher.getHeadArmor());
        assertNull(slasher.getHandArmor());
        assertNull(slasher.getLegArmor());
        assertNull(slasher.getFootArmor());
    }

    //Head armor equip  and un-equip starts
    //Helmet increases health and defense
    @Test
    void heroEquipHelmet() {
        Hero slasher = new Hero("Slasher");
        HeadArmor skullHelm = new HeadArmor("Skull Helm", 30, true);
        slasher.setLevel(30);
        slasher.equipArmor(skullHelm);

        assertTrue(skullHelm.isHelmet());
        assertFalse(skullHelm.isCap());
        assertEquals(830, slasher.getHealth());
        assertEquals(245, slasher.getDefense());
    }

    //Cap increases mana and defense
    @Test
    void heroEquipCap() {
        Hero caster = new Hero("Caster");
        HeadArmor priestCap = new HeadArmor("Priest Cap", 30, false);
        caster.setLevel(30);
        caster.equipArmor(priestCap);

        assertTrue(priestCap.isCap());
        assertFalse(priestCap.isHelmet());
        assertEquals(830, caster.getMana());
        assertEquals(170, caster.getDefense());
    }

    @Test
    void heroUnEquipHelmet() {
        Hero slasher = new Hero("Slasher");
        HeadArmor skullHelmet = new HeadArmor("Skull Helmet", 45, true);
        slasher.setLevel(45);
        slasher.equipArmor(skullHelmet);
        slasher.unEquipHeadArmor();

        assertTrue(skullHelmet.isHelmet());
        assertNull(slasher.getHeadArmor());
        assertEquals(980, slasher.getHealth());
        assertEquals(230, slasher.getDefense());
    }

    @Test
    void heroUnEquipCap() {
        Hero caster = new Hero("Caster");
        HeadArmor priestCap = new HeadArmor("Priest Cap", 45, false);
        caster.setLevel(45);
        caster.equipArmor(priestCap);
        caster.unEquipHeadArmor();

        assertFalse(priestCap.isHelmet());
        assertNull(caster.getHeadArmor());
        assertEquals(980, caster.getMana());
        assertEquals(230, caster.getDefense());
    }
    //Head armor equip un-equip ends

    //Body armor equip and un-equip test starts
    //Body plate increases health, mana, attack, and defense
    @Test
    void heroEquipBodyPlate() {
        Hero slasher = new Hero("Slasher");
        BodyArmor goldenPlate = new BodyArmor("Golden Plate", 72, true);
        slasher.setLevel(72);
        slasher.equipArmor(goldenPlate);

        assertTrue(goldenPlate.isPlate());
        assertFalse(goldenPlate.isRobe());
        assertEquals(2240, slasher.getHealth());
        assertEquals(1556, slasher.getMana());
        assertEquals(581, slasher.getAttack());
        assertEquals(725, slasher.getDefense());
    }

    //Robe increases health, mana, intelligence, and defense
    @Test
    void heroEquipRobe() {
        Hero caster = new Hero("Caster");
        BodyArmor priestRobe = new BodyArmor("Priest Robe", 72, false);
        caster.setLevel(72);
        caster.equipArmor(priestRobe);

        assertTrue(priestRobe.isRobe());
        assertFalse(priestRobe.isPlate());
        assertEquals(1556, caster.getHealth());
        assertEquals(2240, caster.getMana());
        assertEquals(581, caster.getIntelligence());
        assertEquals(401, caster.getDefense());
    }

    @Test
    void heroUnEquipBodyPlate() {
        Hero slasher = new Hero("Slasher");
        BodyArmor dragonPlate = new BodyArmor("Dragon Plate", 82, true);
        slasher.setLevel(82);
        slasher.equipArmor(dragonPlate);
        slasher.unEquipBodyArmor();

        assertTrue(dragonPlate.isPlate());
        assertEquals(1720, slasher.getHealth());
        assertEquals(1720, slasher.getMana());
        assertEquals(415, slasher.getAttack());
        assertEquals(415, slasher.getDefense());
        assertNull(slasher.getBodyArmor());
    }

    @Test
    void heroUnEquipRobe() {
        Hero caster = new Hero("Caster");
        BodyArmor blessedRobe = new BodyArmor("Blessed Robe", 82, false);
        caster.setLevel(82);
        caster.equipArmor(blessedRobe);
        caster.unEquipBodyArmor();

        assertFalse(blessedRobe.isPlate());
        assertEquals(1720, caster.getHealth());
        assertEquals(1720, caster.getMana());
        assertEquals(415, caster.getIntelligence());
        assertEquals(415, caster.getDefense());
        assertNull(caster.getBodyArmor());

    }
    //Body armor equip and un-equip test ends

    //Hand armor equip and un-equip test starts
    //Gauntlets increases health, attack, and defense
    @Test
    void heroEquipGauntlets() {
        Hero slasher = new Hero("Slasher");
        HandArmor boneGauntlets = new HandArmor("Bone Gauntlets", 40, true);
        slasher.setLevel(40);
        slasher.equipArmor(boneGauntlets);

        assertTrue(boneGauntlets.isGauntlets());
        assertFalse(boneGauntlets.isGloves());
        assertEquals(1080, slasher.getHealth());
        assertEquals(325, slasher.getAttack());
        assertEquals(325, slasher.getDefense());
    }

    //Gloves increases mana, intelligence, and defense
    @Test
    void heroEquipGloves() {
        Hero caster = new Hero("Caster");
        HandArmor priestGloves = new HandArmor("Priest Gloves", 40, false);
        caster.setLevel(40);
        caster.equipArmor(priestGloves);

        assertTrue(priestGloves.isGloves());
        assertFalse(priestGloves.isGauntlets());
        assertEquals(1080, caster.getMana());
        assertEquals(325, caster.getIntelligence());
        assertEquals(225, caster.getDefense());
    }

    @Test
    void heroUnEquipGauntlets() {
        Hero slasher = new Hero("Slasher");
        HandArmor boneGauntlets = new HandArmor("Bone Gauntlets", 40, true);
        slasher.setLevel(40);
        slasher.equipArmor(boneGauntlets);
        slasher.unEquipHandArmor();

        assertTrue(boneGauntlets.isGauntlets());
        assertEquals(880, slasher.getHealth());
        assertEquals(205, slasher.getAttack());
        assertEquals(205, slasher.getDefense());
        assertNull(slasher.getHandArmor());
    }

    @Test
    void heroUnEquipGloves() {
        Hero slasher = new Hero("Slasher");
        HandArmor priestGloves = new HandArmor("Priest Gloves", 40, false);
        slasher.setLevel(40);
        slasher.equipArmor(priestGloves);
        slasher.unEquipHandArmor();

        assertFalse(priestGloves.isGauntlets());
        assertEquals(880, slasher.getMana());
        assertEquals(205, slasher.getIntelligence());
        assertEquals(205, slasher.getDefense());
        assertNull(slasher.getHandArmor());
    }
    //Hand armor equip and un-equip test ends

    //Leg armor equip and un-equip test starts
    @Test
    void heroEquipLegPlate() {
        Hero slasher = new Hero("Slasher");
        LegArmor goldenLegPlate = new LegArmor("Golden Leg Plate", 80, true);
        slasher.setLevel(80);
        slasher.equipArmor(goldenLegPlate);

        assertTrue(goldenLegPlate.isPlate());
        assertFalse(goldenLegPlate.isTrousers());
        assertEquals(2480, slasher.getHealth());
        assertEquals(1720, slasher.getMana());
        assertEquals(445, slasher.getAgility());
        assertEquals(645, slasher.getDefense());
    }

    @Test
    void heroEquipTrousers() {
        Hero caster = new Hero("Caster");
        LegArmor priestTrousers = new LegArmor("Priest Trousers", 80, false);
        caster.setLevel(80);
        caster.equipArmor(priestTrousers);

        assertTrue(priestTrousers.isTrousers());
        assertFalse(priestTrousers.isPlate());
        assertEquals(1720, caster.getHealth());
        assertEquals(2480, caster.getMana());
        assertEquals(645, caster.getAgility());
        assertEquals(445, caster.getDefense());
    }

    @Test
    void heroUnEquipLegPlate() {
        Hero slasher = new Hero("Slasher");
        LegArmor dragonLegPlate = new LegArmor("Dragon Leg Plate", 80, true);
        slasher.setLevel(80);
        slasher.equipArmor(dragonLegPlate);
        slasher.unEquipLegArmor();

        assertTrue(dragonLegPlate.isPlate());
        assertEquals(1680, slasher.getHealth());
        assertEquals(1680, slasher.getMana());
        assertEquals(405, slasher.getAgility());
        assertEquals(405, slasher.getDefense());
        assertNull(slasher.getLegArmor());
    }

    @Test
    void heroUnEquipTrousers() {
        Hero caster = new Hero("Caster");
        LegArmor blessedTrousers = new LegArmor("Blessed Trousers", 80, false);
        caster.setLevel(80);
        caster.equipArmor(blessedTrousers);
        caster.unEquipLegArmor();

        assertFalse(blessedTrousers.isPlate());
        assertEquals(1680, caster.getHealth());
        assertEquals(1680, caster.getMana());
        assertEquals(405, caster.getAgility());
        assertEquals(405, caster.getDefense());
        assertNull(caster.getLegArmor());
    }
    //Leg armor equip and un-equip test ends

    //Foot armor equip and un-equip test starts
    //Boots increases health, agility and defense
    @Test
    void heroEquipBoots() {
        Hero slasher = new Hero("Slasher");
        FootArmor boneBoots = new FootArmor("Bone Boots", 35, true);
        slasher.setLevel(35);
        slasher.equipArmor(boneBoots);

        assertTrue(boneBoots.isBoots());
        assertFalse(boneBoots.isShoes());
        assertEquals(955, slasher.getHealth());
        assertEquals(197, slasher.getAgility());
        assertEquals(285, slasher.getDefense());
    }

    //Shoes increases mana, agility and defense
    @Test
    void heroEquipShoes() {
        Hero caster = new Hero("Caster");
        FootArmor priestShoes = new FootArmor("Priest Shoes", 35, false);
        caster.setLevel(35);
        caster.equipArmor(priestShoes);

        assertTrue(priestShoes.isShoes());
        assertFalse(priestShoes.isBoots());
        assertEquals(955, caster.getMana());
        assertEquals(285, caster.getAgility());
        assertEquals(197, caster.getDefense());
    }

    @Test
    void heroUnEquipBoots() {
        Hero slasher = new Hero("Slasher");
        FootArmor boneBoots = new FootArmor("Bone Boots", 35, true);
        slasher.setLevel(35);
        slasher.equipArmor(boneBoots);
        slasher.unEquipFootArmor();

        assertTrue(boneBoots.isBoots());
        assertEquals(780, slasher.getHealth());
        assertEquals(180, slasher.getAgility());
        assertEquals(180, slasher.getDefense());
        assertNull(slasher.getFootArmor());
    }

    @Test
    void heroUnEquipShoes() {
        Hero caster = new Hero("Caster");
        FootArmor priestShoes = new FootArmor("Priest Shoes", 35, false);
        caster.setLevel(35);
        caster.equipArmor(priestShoes);
        caster.unEquipFootArmor();

        assertFalse(priestShoes.isBoots());
        assertEquals(780, caster.getMana());
        assertEquals(180, caster.getAgility());
        assertEquals(180, caster.getDefense());
        assertNull(caster.getFootArmor());
    }
    //Foot armor equip and un-equip test ends
    //Hero equip and un-equip weapon and armor end

    @Test
    void addSpellToSpellBook() {
        Hero hero = new Hero("Hero");
        Fireball fireball = new Fireball();
        hero.addSpellToSpellBook(fireball);
        assertTrue(hero.getSpellBook().contains(fireball));
    }

    //Test for making sure only spells memorized in the hero spellbook will be
    //cast.
    @Test
    void onlyCastSpellsMemorizedInSpellbook() {
        Hero hero = new Hero("hero");
        IncreaseAttack increaseAttack = new IncreaseAttack();
        RestoreHealth restoreHealth = new RestoreHealth();
        hero.addSpellToSpellBook(increaseAttack);
        hero.setHealth(60);
        hero.castBuffSpell(increaseAttack);
        hero.castHealSpell(restoreHealth);
        assertEquals(60, hero.getAttack());
        assertEquals(60, hero.getHealth());

    }

    @Test
    void printToString() {
        Hero player = new Hero("Player");
        assertEquals("Hero [name = Player, level = 1, attack = 10," +
                " defense = 10, health = 100, mana = 100, intelligence = 10, agility = 10," +
                " experience = 0]", player.toString());
    }

}