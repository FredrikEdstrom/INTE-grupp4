import java.util.HashSet;
import java.util.Set;

public class Hero extends Character {

    private Weapon weapon;
    private HeadArmor headArmor;
    private BodyArmor bodyArmor;
    private HandArmor handArmor;
    private LegArmor legArmor;
    private FootArmor footArmor;
    private Set<Spell> spellBook = new HashSet<Spell>();

    public Hero(String name) {
        super(name);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public HeadArmor getHeadArmor() {
        return headArmor;
    }

    public BodyArmor getBodyArmor() {
        return bodyArmor;
    }

    public HandArmor getHandArmor() {
        return handArmor;
    }

    public LegArmor getLegArmor() {
        return legArmor;
    }

    public FootArmor getFootArmor() {
        return footArmor;
    }

    public Set<Spell> getSpellBook() {
        return spellBook;
    }

    //Equip weapon och armor metoder start:
    //Low level hero får inte equipa high level item
    public void equipWeapon(Weapon weapon) {
        if (getLevel() < weapon.getLevel()) {
            throw new IllegalStateException("Hero level: " + getLevel()
                    + " Item level: " + weapon.getLevel());
        } else {
            if (weapon.isSword())
                setAttack(getAttack() + weapon.getAttack());
            else
                setIntelligence(getIntelligence() + weapon.getIntelligence());
            this.weapon = weapon;
        }
    }

    public void unEquipWeapon() {
        if (weapon.isSword())
            setAttack(getAttack() - weapon.getAttack());
        else
            setIntelligence(getIntelligence() - weapon.getIntelligence());
        weapon = null;
    }

    public void equipArmor(Armor armor) {
        if (getLevel() < armor.getLevel()) {
            throw new IllegalStateException("Hero level: " + getLevel()
                    + " Item level: " + armor.getLevel());
        } else {
            if (armor instanceof HeadArmor)
                headArmor = (HeadArmor) armor;
            if (armor instanceof BodyArmor)
                bodyArmor = (BodyArmor) armor;
            if (armor instanceof HandArmor)
                handArmor = (HandArmor) armor;
            if (armor instanceof LegArmor)
                legArmor = (LegArmor) armor;
            if (armor instanceof FootArmor)
                footArmor = (FootArmor) armor;
            setHealth(getHealth() + armor.getHealth());
            setMana(getMana() + armor.getMana());
            setDefense(getDefense() + armor.getDefense());
            setAttack(getAttack() + armor.getAttack());
            setIntelligence(getIntelligence() + armor.getIntelligence());
            setAgility(getAgility() + armor.getAgility());
        }
    }

    public void unEquipArmor(Armor armor) {
        if (armor == headArmor || armor == bodyArmor || armor == handArmor
                || armor == legArmor || armor == footArmor) {
            setHealth(getHealth() - armor.getHealth());
            setMana(getMana() - armor.getMana());
            setDefense(getDefense() - armor.getDefense());
            setAttack(getAttack() - armor.getAttack());
            setIntelligence(getIntelligence() - armor.getIntelligence());
            setAgility(getAgility() - armor.getAgility());
        }
        if (armor == headArmor)
            headArmor = null;
        if (armor == bodyArmor)
            bodyArmor = null;
        if (armor == handArmor)
            handArmor = null;
        if (armor == legArmor)
            legArmor = null;
        if (armor == footArmor)
            footArmor = null;
    }
    //Equip weapon och armor metoder end

    //Armors durability drops for every hit, when it dropped to 0
    //all armor stats become 0 and un-equip it automatically
    public void changeArmorDurability(boolean hit) {
        if(hit) {
            if(headArmor != null) {
                headArmor.setDurability();
                if(headArmor.getDurability() == 0)
                    unEquipArmor(headArmor);
            }
            if(bodyArmor != null) {
                bodyArmor.setDurability();
                if(bodyArmor.getDurability() == 0)
                    unEquipArmor(bodyArmor);
            }
            if(handArmor != null) {
                handArmor.setDurability();
                if(handArmor.getDurability() == 0)
                    unEquipArmor(handArmor);
            }
            if(legArmor != null) {
                legArmor.setDurability();
                if(legArmor.getDurability() == 0)
                    unEquipArmor(legArmor);
            }
            if(footArmor != null) {
                footArmor.setDurability();
                if(footArmor.getDurability() == 0)
                    unEquipArmor(footArmor);
            }
        }
    }

    //Method for adding a previously unknown spell to the hero spellbook
    public void addSpellToSpellBook(Spell spell) {
        spellBook.add(spell);
    }

    //Method for casting a supplied buffspell, currently only making use of IncreaseAttack
    public void castBuffSpell(BuffSpell spell) {
        if (spellBook.contains(spell)) {
            switch (spell.getName()) {
                case "Increase Attack":
                    int newAttack = getAttack() + spell.getBuffValue();
                    setAttack(newAttack);
                    break;
            }
        }
    }

    //Method for casting a supplied healing spell, avoiding overhealing above hero default max-health
    public void castHealSpell(HealSpell spell) {
        if (spellBook.contains(spell)) {
            int newHealth = getHealth() + spell.getModifiedHealValue(getIntelligence());
            if (newHealth > 100)
                newHealth = 100;
            setHealth(newHealth);
        }
    }

    @Override
    public String toString() {
        return "Hero [name = " + getName() + ", level = " + getLevel() + ", " +
                "attack = " + getAttack() + ", defense = " + getDefense() + ", health = "
                + getHealth() + ", mana = " + getMana() + ", " + "intelligence = " +
                getIntelligence() + ", agility = " + getAgility()
                + ", experience = " + getExperience() + "]";
    }
}