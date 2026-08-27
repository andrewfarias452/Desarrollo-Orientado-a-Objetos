public class Enderman extends Character {
    private int teleportDistance;

    public Enderman(String name, int health, int mana, int hit, int teleportDistance) {
        super(name, health, mana, hit);
        this.teleportDistance = teleportDistance;
    }

    public int getTeleportDistance() {
        return teleportDistance;
    }

    public void setTeleportDistance(int teleportDistance) {
        this.teleportDistance = teleportDistance;
    }

    @Override
    public void displayStats() {
        super.displayStats();
        System.out.println("Teleport Distance: " + this.teleportDistance);
    }
}