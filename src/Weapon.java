public abstract class Weapon {
    private final String name;
    private final int level;

    public Weapon(String name, int level) {
        if (name.isBlank())
            throw new IllegalArgumentException("Name: blank"); //Namn för inte vara blank
        this.name = name;
        if (level < 1 || level > 100)
            throw new IllegalArgumentException("level: " + level); //Level för inte vara lägre än 1 eller större än 100
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}