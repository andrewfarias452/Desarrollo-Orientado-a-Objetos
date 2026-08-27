public class Character {
    private String name;
    private int health;
    private int hit;
    private int mana;

    public Character(String name, int health, int mana, int hit) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.hit = hit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void displayStats() {
        System.out.println("Character Name: " + this.name);
        System.out.println("Health Points: " + this.health);
        System.out.println("Mana Points: " + this.mana);
        System.out.println("Hit Points: " + this.hit);
    }
}