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
        }
        this.weapon = weapon;
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

    public void unEquipHeadArmor() {
        if (headArmor.isHelmet())
            setHealth(getHealth() - headArmor.getHealth());
        else
            setMana(getMana() - headArmor.getMana());
        setDefense(getDefense() - headArmor.getDefense());
        headArmor = null;
    }

    public void unEquipBodyArmor() {
        if (bodyArmor.isPlate())
            setAttack(getAttack() - bodyArmor.getAttack());
        else
            setIntelligence(getIntelligence() - bodyArmor.getIntelligence());
        setHealth(getHealth() - bodyArmor.getHealth());
        setMana(getMana() - bodyArmor.getMana());
        setDefense(getDefense() - bodyArmor.getDefense());
        bodyArmor = null;
    }

    public void unEquipHandArmor() {
        if (handArmor.isGauntlets()) {
            setHealth(getHealth() - handArmor.getHealth());
            setAttack(getAttack() - handArmor.getAttack());
        } else {
            setMana(getMana() - handArmor.getMana());
            setIntelligence(getIntelligence() - handArmor.getIntelligence());
        }
        setDefense(getDefense() - handArmor.getDefense());
        handArmor = null;
    }

    public void unEquipLegArmor() {
        setHealth(getHealth() - legArmor.getHealth());
        setMana(getMana() - legArmor.getMana());
        setAgility(getAgility() - legArmor.getAgility());
        setDefense(getDefense() - legArmor.getDefense());
        legArmor = null;
    }

    public void unEquipFootArmor() {
        if (footArmor.isBoots())
            setHealth(getHealth() - footArmor.getHealth());
        else
            setMana(getMana() - footArmor.getMana());
        setDefense(getDefense() - footArmor.getDefense());
        setAgility(getAgility() - footArmor.getAgility());
        footArmor = null;
    }
    //Equip weapon och armor metoder end

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