import java.util.HashSet;
import java.util.Set;

public class Hero extends Character {

    private Set<Spell> spellBook = new HashSet<Spell>();

    public Hero(String name) {
        super(name);
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
            if(weapon.isSword())
                setAttack(getAttack() + weapon.getAttack());
            else
                setIntelligence(getIntelligence() + weapon.getIntelligence());
            setWeapon(weapon);
        }
    }

    public void unEquipWeapon() {
        if(getWeapon().isSword())
            setAttack(getAttack() - getWeapon().getAttack());
        else
            setIntelligence(getIntelligence() - getWeapon().getIntelligence());
        setWeapon(null);
    }

    public void equipArmor(Armor armor) {
        if (getLevel() < armor.getLevel()) {
            throw new IllegalStateException("Hero level: " + getLevel()
                    + " Item level: " + armor.getLevel());
        } else {
            if (armor instanceof HeadArmor)
                setHeadArmor((HeadArmor) armor);
            if (armor instanceof BodyArmor)
                setBodyArmor((BodyArmor) armor);
            if (armor instanceof HandArmor)
                setHandArmor((HandArmor) armor);
            if (armor instanceof LegArmor)
                setLegArmor((LegArmor) armor);
            if (armor instanceof FootArmor)
                setFootArmor((FootArmor) armor);
            setHealth(getHealth() + armor.getHealth());
            setMana(getMana() + armor.getMana());
            setDefense(getDefense() + armor.getDefense());
            setAttack(getAttack() + armor.getAttack());
            setIntelligence(getIntelligence() + armor.getIntelligence());
            setAgility(getAgility() + armor.getAgility());
        }
    }

    public void unEquipArmor(Armor armor) {
        setHealth(getHealth() - armor.getHealth());
        setMana(getMana() - armor.getMana());
        setDefense(getDefense() - armor.getDefense());
        setAttack(getAttack() - armor.getAttack());
        setIntelligence(getIntelligence() - armor.getIntelligence());
        setAgility(getAgility() - armor.getAgility());
        if (armor == getHeadArmor())
            setHeadArmor(null);
        if (armor == getBodyArmor())
            setBodyArmor(null);
        if (armor == getHandArmor())
            setHandArmor(null);
        if (armor == getLegArmor())
            setLegArmor(null);
        if (armor == getFootArmor())
            setFootArmor(null);
    }

    //Equip weapon och armor metoder end

    //Armors durability drops by 1 for every hit, when it dropped to 0 and
    //then all armor stats become 0
    public void changeArmorDurability(boolean hit) {
        if (hit) {
            if (getHeadArmor() != null)
                getHeadArmor().setDurability();
            if (getHeadArmor() != null && getHeadArmor().getDurability() <= 0)
                changeArmorEffects(getHeadArmor());
            if (getBodyArmor() != null)
                getBodyArmor().setDurability();
            if (getBodyArmor() != null && getBodyArmor().getDurability() <= 0)
                changeArmorEffects(getBodyArmor());
            if (getLegArmor() != null)
                getLegArmor().setDurability();
            if (getLegArmor() != null && getLegArmor().getDurability() <= 0)
                changeArmorEffects(getLegArmor());
            if (getHandArmor() != null)
                getHandArmor().setDurability();
            if (getHandArmor() != null && getHandArmor().getDurability() <= 0)
                changeArmorEffects(getHandArmor());
            if (getFootArmor() != null)
                getFootArmor().setDurability();
            if (getFootArmor() != null && getFootArmor().getDurability() <= 0)
                changeArmorEffects(getFootArmor());
        }
    }

    public void changeArmorEffects(Armor armor) {
        setHealth(getHealth() - armor.getHealth());
        setMana(getMana() - armor.getMana());
        setDefense(getDefense() - armor.getDefense());
        setAttack(getAttack() - armor.getAttack());
        setIntelligence(getIntelligence() - armor.getIntelligence());
        setAgility(getAgility() - armor.getAgility());
        armor.durabilityZeroStatsToZero();
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