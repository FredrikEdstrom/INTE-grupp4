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
        while (player.getLevel() != 100)
            player.levelUp();
        assertEquals(100, player.getLevel());
    }

    @Test
    void setPlayerOverMaxLevelTest() {
        int counter = 0;
        Hero player = new Hero("player");
        while (counter != 101) {
            counter++;
            player.levelUp();
        }
        assertEquals(100, player.getLevel());
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
        while (slasher.getLevel() != 50)
            slasher.levelUp();
        slasher.equipWeapon(goldenSword);
        assertTrue(slasher.getWeapon().isSword());
        assertEquals(goldenSword, slasher.getWeapon());
        assertEquals(755, slasher.getAttack());
    }

    //Staff increases intelligence
    @Test
    void heroEquipStaff() {
        Hero caster = new Hero("Caster");
        Weapon goldenStaff = new Weapon("Golden Staff", 50, false);
        while (caster.getLevel() != 50)
            caster.levelUp();
        caster.equipWeapon(goldenStaff);
        assertFalse(caster.getWeapon().isSword());
        assertEquals(goldenStaff, caster.getWeapon());
        assertEquals(755, caster.getIntelligence());
    }

    @Test
    void heroUnEquipSword() {
        Hero slasher = new Hero("Slasher");
        Weapon goldenSword = new Weapon("Golden Sword", 50, true);
        while (slasher.getLevel() != 50)
            slasher.levelUp();
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
        while (caster.getLevel() != 50)
            caster.levelUp();
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
    void checkIfArmorsAreInTheRightSlot() {
        Hero slasher = new Hero("Slasher");
        while (slasher.getLevel() != 82)
            slasher.levelUp();
        Armor dragonHelm = new HeadArmor("Dragon Helm", 82, true);
        Armor dragonPlate = new BodyArmor("Dragon Plate", 82, true);
        Armor dragonGauntlets = new HandArmor("Dragon GauntLets", 82, true);
        Armor dragonLegPlate = new LegArmor("Dragon Leg Plate", 82, true);
        Armor dragonBoots = new FootArmor("Dragon Boots", 82, true);
        slasher.equipArmor(dragonHelm);
        slasher.equipArmor(dragonPlate);
        slasher.equipArmor(dragonGauntlets);
        slasher.equipArmor(dragonLegPlate);
        slasher.equipArmor(dragonBoots);

        assertEquals(dragonHelm, slasher.getHeadArmor());
        assertEquals(dragonPlate, slasher.getBodyArmor());
        assertEquals(dragonGauntlets, slasher.getHandArmor());
        assertEquals(dragonLegPlate, slasher.getLegArmor());
        assertEquals(dragonBoots, slasher.getFootArmor());
    }

    //Head armor equip  and un-equip starts
    //Helmet increases health and defense
    @Test
    void heroEquipHelmet() {
        Hero slasher = new Hero("Slasher");
        HeadArmor skullHelm = new HeadArmor("Skull Helm", 30, true);
        while (slasher.getLevel() != 30)
            slasher.levelUp();
        slasher.equipArmor(skullHelm);
        assertEquals(680, slasher.getHealth() - skullHelm.getHealth());
        assertEquals(830, slasher.getHealth());
        assertEquals(155, slasher.getDefense() - skullHelm.getDefense());
        assertEquals(245, slasher.getDefense());
    }

    //Cap increases mana and defense
    @Test
    void heroEquipCap() {
        Hero caster = new Hero("Caster");
        HeadArmor priestCap = new HeadArmor("Priest Cap", 30, false);
        while (caster.getLevel() != 30)
            caster.levelUp();
        caster.equipArmor(priestCap);
        assertEquals(priestCap, caster.getHeadArmor());
        assertEquals(830, caster.getMana());
        assertEquals(170, caster.getDefense());
    }

    @Test
    void heroUnEquipHelmet() {
        Hero slasher = new Hero("Slasher");
        HeadArmor skullHelmet = new HeadArmor("Skull Helmet", 45, true);
        while (slasher.getLevel() != 45)
            slasher.levelUp();
        slasher.equipArmor(skullHelmet);
        slasher.unEquipArmor(skullHelmet);
        assertNull(slasher.getHeadArmor());
        assertEquals(980, slasher.getHealth());
        assertEquals(230, slasher.getDefense());
    }

    @Test
    void heroUnEquipCap() {
        Hero caster = new Hero("Caster");
        HeadArmor priestCap = new HeadArmor("Priest Cap", 45, false);
        while (caster.getLevel() != 45)
            caster.levelUp();
        caster.equipArmor(priestCap);
        caster.unEquipArmor(priestCap);
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
        while (slasher.getLevel() != 72)
            slasher.levelUp();
        slasher.equipArmor(goldenPlate);
        assertEquals(goldenPlate, slasher.getBodyArmor());
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
        while (caster.getLevel() != 72)
            caster.levelUp();
        caster.equipArmor(priestRobe);
        assertEquals(priestRobe, caster.getBodyArmor());
        assertEquals(1556, caster.getHealth());
        assertEquals(2240, caster.getMana());
        assertEquals(581, caster.getIntelligence());
        assertEquals(401, caster.getDefense());
    }

    @Test
    void heroUnEquipBodyPlate() {
        Hero slasher = new Hero("Slasher");
        BodyArmor dragonPlate = new BodyArmor("Dragon Plate", 82, true);
        while (slasher.getLevel() != 82)
            slasher.levelUp();
        slasher.equipArmor(dragonPlate);
        slasher.unEquipArmor(dragonPlate);
        assertEquals(2540, slasher.getHealth() + dragonPlate.getHealth());
        assertEquals(1720, slasher.getHealth());
        assertEquals(1761, slasher.getMana() + dragonPlate.getMana());
        assertEquals(1720, slasher.getMana());
        assertEquals(661, slasher.getAttack() + dragonPlate.getAttack());
        assertEquals(415, slasher.getAttack());
        assertEquals(825, slasher.getDefense() + dragonPlate.getDefense());
        assertEquals(415, slasher.getDefense());
        assertNull(slasher.getBodyArmor());
    }

    @Test
    void heroUnEquipRobe() {
        Hero caster = new Hero("Caster");
        BodyArmor blessedRobe = new BodyArmor("Blessed Robe", 82, false);
        while (caster.getLevel() != 82)
            caster.levelUp();
        caster.equipArmor(blessedRobe);
        caster.unEquipArmor(blessedRobe);
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
        while (slasher.getLevel() != 40)
            slasher.levelUp();
        slasher.equipArmor(boneGauntlets);
        assertEquals(boneGauntlets, slasher.getHandArmor());
        assertEquals(1080, slasher.getHealth());
        assertEquals(325, slasher.getAttack());
        assertEquals(325, slasher.getDefense());
    }

    //Gloves increases mana, intelligence, and defense
    @Test
    void heroEquipGloves() {
        Hero caster = new Hero("Caster");
        HandArmor priestGloves = new HandArmor("Priest Gloves", 40, false);
        while (caster.getLevel() != 40)
            caster.levelUp();
        caster.equipArmor(priestGloves);
        assertEquals(priestGloves, caster.getHandArmor());
        assertEquals(1080, caster.getMana());
        assertEquals(325, caster.getIntelligence());
        assertEquals(225, caster.getDefense());
    }

    @Test
    void heroUnEquipGauntlets() {
        Hero slasher = new Hero("Slasher");
        HandArmor boneGauntlets = new HandArmor("Bone Gauntlets", 40, true);
        while (slasher.getLevel() != 40)
            slasher.levelUp();
        slasher.equipArmor(boneGauntlets);
        slasher.unEquipArmor(boneGauntlets);
        assertEquals(880, slasher.getHealth());
        assertEquals(205, slasher.getAttack());
        assertEquals(205, slasher.getDefense());
        assertNull(slasher.getHandArmor());
    }

    @Test
    void heroUnEquipGloves() {
        Hero slasher = new Hero("Slasher");
        HandArmor priestGloves = new HandArmor("Priest Gloves", 40, false);
        while (slasher.getLevel() != 40)
            slasher.levelUp();
        slasher.equipArmor(priestGloves);
        slasher.unEquipArmor(priestGloves);
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
        while (slasher.getLevel() != 80)
            slasher.levelUp();
        slasher.equipArmor(goldenLegPlate);
        assertEquals(goldenLegPlate, slasher.getLegArmor());
        assertEquals(2480, slasher.getHealth());
        assertEquals(1720, slasher.getMana());
        assertEquals(445, slasher.getAgility());
        assertEquals(645, slasher.getDefense());
    }

    @Test
    void heroEquipTrousers() {
        Hero caster = new Hero("Caster");
        LegArmor priestTrousers = new LegArmor("Priest Trousers", 80, false);
        while (caster.getLevel() != 80)
            caster.levelUp();
        caster.equipArmor(priestTrousers);
        assertEquals(1720, caster.getHealth());
        assertEquals(2480, caster.getMana());
        assertEquals(645, caster.getAgility());
        assertEquals(445, caster.getDefense());
    }

    @Test
    void heroUnEquipLegPlate() {
        Hero slasher = new Hero("Slasher");
        LegArmor dragonLegPlate = new LegArmor("Dragon Leg Plate", 80, true);
        while (slasher.getLevel() != 80)
            slasher.levelUp();
        slasher.equipArmor(dragonLegPlate);
        slasher.unEquipArmor(dragonLegPlate);
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
        while (caster.getLevel() != 80)
            caster.levelUp();
        caster.equipArmor(blessedTrousers);
        caster.unEquipArmor(blessedTrousers);
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
        while (slasher.getLevel() != 35)
            slasher.levelUp();
        slasher.equipArmor(boneBoots);
        assertEquals(boneBoots, slasher.getFootArmor());
        assertEquals(955, slasher.getHealth());
        assertEquals(197, slasher.getAgility());
        assertEquals(285, slasher.getDefense());
    }

    //Shoes increases mana, agility and defense
    @Test
    void heroEquipShoes() {
        Hero caster = new Hero("Caster");
        FootArmor priestShoes = new FootArmor("Priest Shoes", 35, false);
        while (caster.getLevel() != 35)
            caster.levelUp();
        caster.equipArmor(priestShoes);
        assertEquals(priestShoes, caster.getFootArmor());
        assertEquals(955, caster.getMana());
        assertEquals(285, caster.getAgility());
        assertEquals(197, caster.getDefense());
    }

    @Test
    void heroUnEquipBoots() {
        Hero slasher = new Hero("Slasher");
        FootArmor boneBoots = new FootArmor("Bone Boots", 35, true);
        while (slasher.getLevel() != 35)
            slasher.levelUp();
        slasher.equipArmor(boneBoots);
        slasher.unEquipArmor(boneBoots);
        assertEquals(780, slasher.getHealth());
        assertEquals(180, slasher.getAgility());
        assertEquals(180, slasher.getDefense());
        assertNull(slasher.getFootArmor());
    }

    @Test
    void heroUnEquipShoes() {
        Hero caster = new Hero("Caster");
        FootArmor priestShoes = new FootArmor("Priest Shoes", 35, false);
        while (caster.getLevel() != 35)
            caster.levelUp();
        caster.equipArmor(priestShoes);
        caster.unEquipArmor(priestShoes);
        assertEquals(780, caster.getMana());
        assertEquals(180, caster.getAgility());
        assertEquals(180, caster.getDefense());
        assertNull(caster.getFootArmor());
    }
    //Foot armor equip and un-equip test ends
    //Hero equip and un-equip weapon and armor end

    //Armor durability dropped by 1 for every hit
    //Armor looses its effect when durability dropped to 0
    @Test
    void heroHeadArmorDurabilityDroppedToZero() {
        CombatMechanics combat = new CombatMechanics();
        Hero slasher = new Hero("Slasher");
        Enemy noobKing = new Enemy("Noob King", 1, 10, 10, 100,
                100, 10, 10, false, false);
        Armor rustyHelmet = new HeadArmor("Rusty Helmet", 1, true);
        slasher.equipArmor(rustyHelmet);
        for (int i = 0; i < 100; i++) {
            combat.attackOrder(noobKing, slasher);
            slasher.changeArmorDurability(true);
        }
        assertEquals(0, slasher.getHeadArmor().getDurability());
        assertEquals(0, slasher.getHeadArmor().getHealth());
        assertEquals(0, slasher.getHeadArmor().getDefense());
    }

    @Test
    void heroBodyArmorDurabilityDroppedToZero() {
        CombatMechanics combat = new CombatMechanics();
        Hero slasher = new Hero("Slasher");
        Enemy noobKing = new Enemy("Noob King", 1, 10, 10, 100,
                100, 10, 10, false, false);
        Armor rustyArmor = new BodyArmor("Rusty Armor", 1, true);
        slasher.equipArmor(rustyArmor);
        for (int i = 0; i < 100; i++) {
            combat.attackOrder(noobKing, slasher);
            slasher.changeArmorDurability(true);
        }
        assertEquals(0, slasher.getBodyArmor().getDurability());
        assertEquals(0, slasher.getBodyArmor().getHealth());
        assertEquals(0, slasher.getBodyArmor().getMana());
        assertEquals(0, slasher.getBodyArmor().getDefense());
        assertEquals(0, slasher.getBodyArmor().getAttack());
    }

    @Test
    void heroHandArmorDurabilityDroppedToZero() {
        CombatMechanics combat = new CombatMechanics();
        Hero slasher = new Hero("Slasher");
        Enemy noobKing = new Enemy("Noob King", 1, 10, 10, 100,
                100, 10, 10, false, false);
        Armor rustyGauntlets = new HandArmor("Rusty Gauntlets", 1, true);
        slasher.equipArmor(rustyGauntlets);
        for (int i = 0; i < 100; i++) {
            combat.attackOrder(noobKing, slasher);
            slasher.changeArmorDurability(true);
        }
        assertEquals(0, slasher.getHandArmor().getDurability());
        assertEquals(0, slasher.getHandArmor().getHealth());
        assertEquals(0, slasher.getHandArmor().getDefense());
        assertEquals(0, slasher.getHandArmor().getAttack());
    }

    @Test
    void heroLegArmorDurabilityDroppedToZero() {
        CombatMechanics combat = new CombatMechanics();
        Hero slasher = new Hero("Slasher");
        Enemy noobKing = new Enemy("Noob King", 1, 10, 10, 100,
                100, 10, 10, false, false);
        Armor rustyLeg = new LegArmor("Rusty Leg", 1, true);
        slasher.equipArmor(rustyLeg);
        for (int i = 0; i < 100; i++) {
            combat.attackOrder(noobKing, slasher);
            slasher.changeArmorDurability(true);
        }
        assertEquals(0, slasher.getLegArmor().getDurability());
        assertEquals(0, slasher.getLegArmor().getHealth());
        assertEquals(0, slasher.getLegArmor().getMana());
        assertEquals(0, slasher.getLegArmor().getDefense());
        assertEquals(0, slasher.getLegArmor().getAgility());
    }

    @Test
    void heroFootArmorDurabilityDroppedToZero() {
        CombatMechanics combat = new CombatMechanics();
        Hero slasher = new Hero("Slasher");
        Enemy noobKing = new Enemy("Noob King", 1, 10, 10, 100,
                100, 10, 10, false, false);
        Armor rustyBoots = new FootArmor("Rusty Boots", 1, true);
        slasher.equipArmor(rustyBoots);
        for (int i = 0; i < 100; i++) {
            combat.attackOrder(noobKing, slasher);
            slasher.changeArmorDurability(true);
        }
        assertEquals(0, slasher.getFootArmor().getDurability());
        assertEquals(0, slasher.getFootArmor().getHealth());
        assertEquals(0, slasher.getFootArmor().getDefense());
        assertEquals(0, slasher.getFootArmor().getAgility());
    }

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
        Hero hero = new Hero("hero");  //hero attack is 10 by default
        IncreaseAttack inSpellbook = new IncreaseAttack(); //attackbuff is 50
        RestoreHealth notInSpellbook = new RestoreHealth();
        hero.addSpellToSpellBook(inSpellbook);
        hero.setHealth(40); //sets health down to 40 to try healing spell on hero
        hero.castBuffSpell(inSpellbook);
        hero.castHealSpell(notInSpellbook);
        assertEquals(60, hero.getAttack()); //increaseattack should be cast
        assertEquals(40, hero.getHealth()); //restorehealth should not

    }

    //Test for assuring that duplicate spells will not be memorized in the hero spellbook
    @Test
    void duplicateSpellNotAddedToSpellbook() {
        Fireball f1 = new Fireball();
        Fireball f2 = new Fireball();
        Hero hero = new Hero("hero");
        hero.addSpellToSpellBook(f1);
        hero.addSpellToSpellBook(f2);
        assertEquals(1, hero.getSpellBook().size());
    }

    @Test
    void printToString() {
        Hero player = new Hero("Player");
        assertEquals("Hero [name = Player, level = 1, attack = 10," +
                " defense = 10, health = 100, mana = 100, intelligence = 10, agility = 10," +
                " experience = 0]", player.toString());
    }

}