public class Zombie extends Character {
    private int infectionDamage;

    public Zombie(String name, int health, int mana, int hit, int infectionDamage) {
        super(name, health, mana, hit);
        this.infectionDamage = infectionDamage;
    }

    public int getInfectionDamage() {
        return infectionDamage;
    }

    public void setInfectionDamage(int infectionDamage) {
        this.infectionDamage = infectionDamage;
    }

    @Override
    public void displayStats() {
        super.displayStats();
        System.out.println("Infection Damage: " + this.infectionDamage);
    }
}