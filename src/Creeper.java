public class Creeper extends Character {
    private int explosionRadius;

    public Creeper(String name, int health, int mana, int hit, int explosionRadius) {
        super(name, health, mana, hit); 
        this.explosionRadius = explosionRadius;
    }

    public int getExplosionRadius() {
        return explosionRadius;
    }

    public void setExplosionRadius(int explosionRadius) {
        this.explosionRadius = explosionRadius;
    }

    @Override
    public void displayStats() {
        super.displayStats();
        System.out.println("Explosion Radius: " + this.explosionRadius);
    }
}