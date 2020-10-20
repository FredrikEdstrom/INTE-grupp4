public abstract class FootArmor {
    private final String name;
    private final int level;

    public FootArmor(String name, int level) {
        if (name.isEmpty() || name.isBlank())
            throw new IllegalArgumentException("Name: empty"); //Namn får inte vara blank eller tom
        this.name = name;
        if(level < 1 || level > 100)
            throw new IllegalArgumentException("Level: " + level); //Level får inte vara lägre än 1 eller högre än 100
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

}
