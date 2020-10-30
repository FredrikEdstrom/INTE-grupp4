public abstract class LegArmor {
    private final String name;
    private final int level;

    public LegArmor(String name, int level) {
        if (name.isEmpty() || name.isBlank())
            throw new IllegalArgumentException("Name: empty"); //Namn får inte vara blank eller tom
        this.name = name;
        if (level < 1 || level > 100)
            throw new IllegalArgumentException("Level: " + level); //Level får inte vara lägre än 1 eller högre än 100
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public abstract int getHealth();

    public abstract int getMana();

    public abstract int getAgility();

    public abstract int getDefense();
}
