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
        if (level < weapon.getLevel()) {
            throw new IllegalStateException("Hero level: " + level + " Item level: " + weapon.getLevel());
        } else {
            this.weapon = weapon;
            if (weapon instanceof Sword)
                setAttack(getAttack() + ((Sword) weapon).getAttack());
            else
                setIntelligence(getIntelligence() + ((Staff) weapon).getIntelligence());
        }
    }

    public void unEquipWeapon() {
        if (weapon instanceof Sword)
            setAttack(getAttack() - ((Sword) weapon).getAttack());
        else
            setIntelligence(getIntelligence() - ((Staff) weapon).getIntelligence());
        weapon = null;
    }

    public void equipHeadArmor(HeadArmor headArmor) {
        if (level < headArmor.getLevel()) {
            throw new IllegalStateException("Hero level: " + level + " Item level: " + headArmor.getLevel());
        } else {
            this.headArmor = headArmor;
            setDefense(getDefense() + headArmor.getDefense());
            if (headArmor instanceof Helmet)
                setHealth(getHealth() + ((Helmet) headArmor).getHealth());
            else
                setMana(getMana() + ((Cap) headArmor).getMana());
        }
    }

    public void unEquipHeadArmor() {
        if (headArmor instanceof Helmet)
            setHealth(getHealth() - ((Helmet) headArmor).getHealth());
        else
            setMana(getMana() - ((Cap) headArmor).getMana());
        setDefense(getDefense() - headArmor.getDefense());
        headArmor = null;
    }

    public void equipBodyArmor(BodyArmor bodyArmor) {
        if (level < bodyArmor.getLevel()) {
            throw new IllegalStateException("Hero level: " + level + " Item level: " + bodyArmor.getLevel());
        } else {
            this.bodyArmor = bodyArmor;
            setHealth(getHealth() + bodyArmor.getHealth());
            setMana(getMana() + bodyArmor.getMana());
            setDefense(getDefense() + bodyArmor.getDefense());
            if (bodyArmor instanceof BodyPlate)
                setAttack(getAttack() + ((BodyPlate) bodyArmor).getAttack());
            else
                setIntelligence(getIntelligence() + ((Robe) bodyArmor).getIntelligence());
        }
    }

    public void unEquipBodyArmor() {
        if (bodyArmor instanceof BodyPlate)
            setAttack(getAttack() - ((BodyPlate) bodyArmor).getAttack());
        else
            setIntelligence(getIntelligence() - ((Robe) bodyArmor).getIntelligence());
        setHealth(getHealth() - bodyArmor.getHealth());
        setMana(getMana() - bodyArmor.getMana());
        setDefense(getDefense() - bodyArmor.getDefense());
        bodyArmor = null;
    }

    public void equipHandArmor(HandArmor handArmor) {
        if (level < handArmor.getLevel()) {
            throw new IllegalStateException("Hero level: " + level + " Item level: " + handArmor.getLevel());
        } else {
            this.handArmor = handArmor;
            setDefense(getDefense() + handArmor.getDefense());
            if (handArmor instanceof Gauntlets) {
                setHealth(getHealth() + ((Gauntlets) handArmor).getHealth());
                setAttack(getAttack() + ((Gauntlets) handArmor).getAttack());
            } else {
                setMana(getMana() + ((Gloves) handArmor).getMana());
                setIntelligence(getIntelligence() + ((Gloves) handArmor).getIntelligence());
            }
        }
    }

    public void unEquipHandArmor() {
        if (handArmor instanceof Gauntlets) {
            setHealth(getHealth() - ((Gauntlets) handArmor).getHealth());
            setAttack(getAttack() - ((Gauntlets) handArmor).getAttack());
        } else {
            setMana(getMana() - ((Gloves) handArmor).getMana());
            setIntelligence(getIntelligence() - ((Gloves) handArmor).getIntelligence());
        }
        setDefense(getDefense() - handArmor.getDefense());
        handArmor = null;
    }

    public void equipLegArmor(LegArmor legArmor) {
        if (level < legArmor.getLevel()) {
            throw new IllegalStateException("Hero level: " + level + " Item level: " + legArmor.getLevel());
        } else {
            this.legArmor = legArmor;
            setHealth(getHealth() + legArmor.getHealth());
            setMana(getMana() + legArmor.getMana());
            setAgility(getAgility() + legArmor.getAgility());
            setDefense(getDefense() + legArmor.getDefense());
        }
    }

    public void unEquipLegArmor() {
        setHealth(getHealth() - legArmor.getHealth());
        setMana(getMana() - legArmor.getMana());
        setAgility(getAgility() - legArmor.getAgility());
        setDefense(getDefense() - legArmor.getDefense());
        legArmor = null;
    }

    public void equipFootArmor(FootArmor footArmor) {
        if (level < footArmor.getLevel()) {
            throw new IllegalStateException("Hero level: " + level + " Item level: " + footArmor.getLevel());
        } else {
            this.footArmor = footArmor;
            setDefense(getDefense() + footArmor.getDefense());
            setAgility(getAgility() + footArmor.getAgility());
            if (footArmor instanceof Boots)
                setHealth(getHealth() + ((Boots) footArmor).getHealth());
            else
                setMana(getMana() + ((Shoes)footArmor).getMana());
        }
    }

    public void unEquipFootArmor() {
        if (footArmor instanceof Boots)
            setHealth(getHealth() - ((Boots) footArmor).getHealth());
        else
            setMana(getMana() - ((Shoes)footArmor).getMana());
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