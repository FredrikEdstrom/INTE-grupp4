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

    public Set<Spell> getSpellBook(){ return spellBook; }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setAgility(int agility) { this.agility = agility; }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void levelUp() {
        this.level++;
        health += 20;
        mana += 20;
        attack += 5;
        defense += 5;
        intelligence += 5;
        agility += 5;
    }

    //Equip weapon och armor metoder start:
    //Low level hero får inte equipa high level item
    public void equipWeapon(Weapon weapon) {
        if (level < weapon.getLevel()) {
            throw new IllegalStateException("Hero level: " + level + " Item level: " + weapon.getLevel());
        } else {
            this.weapon = weapon;
            if (weapon instanceof Sword)
                attack += ((Sword) weapon).getAttack();
            else
                intelligence += ((Staff) weapon).getIntelligence();
        }
    }

    public void unEquipWeapon() {
        if (weapon instanceof Sword)
            attack -= ((Sword) weapon).getAttack();
        else
            intelligence -= ((Staff) weapon).getIntelligence();
        weapon = null;
    }

    public void equipHeadArmor(HeadArmor headArmor) {
        if (level < headArmor.getLevel()) {
            throw new IllegalStateException("Hero level: " + level + " Item level: " + headArmor.getLevel());
        } else {
            this.headArmor = headArmor;
            defense += headArmor.getDefense();
            if (headArmor instanceof Helmet)
                health += ((Helmet) headArmor).getHealth();
            else
                mana += ((Cap) headArmor).getMana();
        }
    }

    public void unEquipHeadArmor() {
        if (headArmor instanceof Helmet)
            health -= ((Helmet) headArmor).getHealth();
        else
            mana -= ((Cap) headArmor).getMana();
        defense -= headArmor.getDefense();
        headArmor = null;
    }

    public void equipBodyArmor(BodyArmor bodyArmor) {
        if (level < bodyArmor.getLevel()) {
            throw new IllegalStateException("Hero level: " + level + " Item level: " + bodyArmor.getLevel());
        } else {
            this.bodyArmor = bodyArmor;
            health += bodyArmor.getHealth();
            mana += bodyArmor.getMana();
            defense += bodyArmor.getDefense();
            if (bodyArmor instanceof BodyPlate)
                attack += ((BodyPlate) bodyArmor).getAttack();
            else
                intelligence += ((Robe) bodyArmor).getIntelligence();
        }
    }

    public void unEquipBodyArmor() {
        if (bodyArmor instanceof BodyPlate)
            attack -= ((BodyPlate) bodyArmor).getAttack();
        else
            intelligence -= ((Robe) bodyArmor).getIntelligence();
        health -= bodyArmor.getHealth();
        mana -= bodyArmor.getMana();
        defense -= bodyArmor.getDefense();
        bodyArmor = null;
    }

    public void equipHandArmor(HandArmor handArmor) {
        if (level < handArmor.getLevel()) {
            throw new IllegalStateException("Hero level: " + level + " Item level: " + handArmor.getLevel());
        } else {
            this.handArmor = handArmor;
            defense += handArmor.getDefense();
            if (handArmor instanceof Gauntlets) {
                health += ((Gauntlets) handArmor).getHealth();
                attack += ((Gauntlets) handArmor).getAttack();
            } else {
                mana += ((Gloves) handArmor).getMana();
                intelligence += ((Gloves) handArmor).getIntelligence();
            }
        }
    }

    public void unEquipHandArmor() {
        if (handArmor instanceof Gauntlets) {
            health -= ((Gauntlets) handArmor).getHealth();
            attack -= ((Gauntlets) handArmor).getAttack();
        } else {
            mana -= ((Gloves) handArmor).getMana();
            intelligence -= ((Gloves) handArmor).getIntelligence();
        }
        defense -= handArmor.getDefense();
        handArmor = null;
    }

    public void equipLegArmor(LegArmor legArmor) {
        if (level < legArmor.getLevel()) {
            throw new IllegalStateException("Hero level: " + level + " Item level: " + legArmor.getLevel());
        } else {
            this.legArmor = legArmor;
            health += legArmor.getHealth();
            mana += legArmor.getMana();
            agility += legArmor.getAgility();
            defense += legArmor.getDefense();
        }
    }

    public void unEquipLegArmor() {
        health -= legArmor.getHealth();
        mana -= legArmor.getMana();
        agility -= legArmor.getAgility();
        defense -= legArmor.getDefense();
        legArmor = null;
    }

    public void equipFootArmor(FootArmor footArmor) {
        if (level < footArmor.getLevel()) {
            throw new IllegalStateException("Hero level: " + level + " Item level: " + footArmor.getLevel());
        } else {
            this.footArmor = footArmor;
            defense += footArmor.getDefense();
            agility += footArmor.getAgility();
            if (footArmor instanceof Boots)
                health += ((Boots) footArmor).getHealth();
            else
                mana += ((Shoes) footArmor).getMana();
        }
    }

    public void unEquipFootArmor() {
        if (footArmor instanceof Boots)
            health -= ((Boots) footArmor).getHealth();
        else
            mana -= ((Shoes) footArmor).getMana();
        defense -= footArmor.getDefense();
        agility -= footArmor.getAgility();
        footArmor = null;
    }
    //Equip weapon och armor metoder end

    public void addSpellToSpellBook(Spell spell){
        spellBook.add(spell);
    }

    public void castBuffSpell(BuffSpell spell) {
        switch (spell.getName()) {
            case "AttackUp":
                int newAttack = getAttack() + spell.getBuffValue();
                setAttack(newAttack);
                break;
            case "DefenseUp":
                int newDefense = getDefense() + spell.getBuffValue();
                setDefense(newDefense);
                break;
            case "IntelligenceUp":
                int newIntelligence = getIntelligence() + spell.getBuffValue();
                setIntelligence(newIntelligence);
                break;
        }
    }

    public void castHealSpell(HealSpell spell) {
        int newHealth = getHealth() + spell.getHealValue();
        if (newHealth > 100)
            newHealth = 100;
        setHealth(newHealth);
    }

    @Override
    public String toString() {
        return "Hero [name =" + this.getName() + ", level =" + this.getLevel() + ", " +
                "attack =" + this.getAttack() + ", defense =" + this.getDefense() + ", health ="
                + this.getHealth() + ", mana=" + this.getMana() + ", " + "intelligence=" +
                this.getIntelligence() + ", agility =" + this.getAgility()
                + ", experience=" + this.getExperience() + "]";
    }
}
