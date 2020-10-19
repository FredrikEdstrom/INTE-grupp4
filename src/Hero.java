public class Hero {

    private final String name;
    private int level = 1;
    private int attack = 10;
    private int defense = 10;
    private int health = 100;
    private int mana = 100;
    private int intelligence = 10;
    private int experience = 0;

    private Weapon weapon;
    private HeadArmor headArmor;
    private BodyArmor bodyArmor;
    private HandArmor handArmor;
    private LegArmor legArmor;
    private FootArmor footArmor;

    public Hero (String name) {
        if(name.isEmpty() || name.isBlank())
            throw new IllegalArgumentException("Name: empty"); //Namn får inte vara tom eller blank
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getExperience() {
        return experience;
    }

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

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void levelUp( ) {
        this.level++;
        //Osäkert om hur mycket ska attributer öka för varje level up
        //Om de ökar kvadratisk så bli de för stor
        health += 20;
        mana += 20;
        attack += 5;
        defense += 5;
        intelligence += 5;
    }

    //Setter metod för level som används för testning
    protected void setLevel(int level) {
        while (this.level != level)
            levelUp();
    }

    //Equip weapon och armor metoder start:
    //Low level hero får inte equipa high level item
    public void equipWeapon(Weapon weapon) {
        if(weapon.getLevel() > level) {
            throw new IllegalStateException("Hero level: " + level + " Item level: " + weapon.getLevel());
        } else {
            this.weapon = weapon;
            if(weapon instanceof Sword) {
                attack += ((Sword) weapon).getAttack();
            } else {
                intelligence += ((Staff) weapon).getIntelligence();
            }
        }
    }

    public void unEquipWeapon() {
        if(weapon instanceof Sword)
            attack -= ((Sword) weapon).getAttack();
        else
            intelligence -= ((Staff) weapon).getIntelligence();
        weapon = null;
    }

    public void equipHeadArmor(HeadArmor headArmor) {
        if(headArmor.getLevel() > level) {
            throw new IllegalStateException("Hero level: " + level + " Item level: " + headArmor.getLevel());
        } else {
            this.headArmor = headArmor;
            if(headArmor instanceof Helmet) {
                health += ((Helmet) headArmor).getHealth();
                defense += ((Helmet) headArmor).getDefense();
            } else {
                mana += ((Cap) headArmor).getMana();
                defense += ((Cap) headArmor).getDefense();
            }
        }
    }
    //Equip weapon och armor metoder end
}
