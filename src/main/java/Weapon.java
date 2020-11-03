public class Weapon {
    private final String name;
    private final int level;
    private int attack;
    private int intelligence;
    private boolean isSword = false;
    private boolean isStaff = false;

    public Weapon(String name, int level, boolean isSword) {
        if (name.isEmpty() || name.isBlank())
            throw new IllegalArgumentException("Name: empty"); //Name is not allowed to be empty or blank
        this.name = name;
        //Level sets to 1 when the amount is smaller than 1 and
        //it sets 100 when the amount is bigger than 100
        if (level < 1) {
            this.level = 1;
        } else {
            this.level = Math.min(level, 100);
        }
        if (isSword) {
            this.isSword = true;
        } else {
            isStaff = true;
        }
        setWeaponStats();
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

    public int getIntelligence() {
        return intelligence;
    }

    public boolean isSword() {
        return isSword;
    }

    public boolean isStaff() {
        return isStaff;
    }

    private void setWeaponStats() {
        if (isSword)
            attack = 10 * level;
        else if (isStaff)
            intelligence = 10 * level;
    }
}