import java.util.Scanner;

public class Main {
    // AQUÍ PUEDES AGREGAR TODAS LAS GROSERÍAS QUE QUIERAS BLOQUEAR
    private static final String[] BAD_WORDS = {
        "manco", "weon", "tonto", "basura", "noob", "puto", "mierda", "culiao", "imbecil"
    };

    public static void main(String[] args) {
        showMenu();
    }

    static void showMenu() {
        System.out.println("**** Welcome to minecraft ****");
        boolean flag_menu = true;
        
        Character playerCharacter = null;
        Character enemyCharacter = null; 

        try (Scanner scanner = new Scanner(System.in)) {
            while (flag_menu) {
                System.out.println("\n--- MAIN MENU ---");
                System.out.println("1- Create Character");
                System.out.println("2- View Characters");
                System.out.println("3- Delete Character");
                System.out.println("4- Create Enemy");
                System.out.println("5- Exit");
                System.out.print("Select an option: ");

                String userOption = scanner.nextLine();

                switch (userOption) {
                    case "1" -> playerCharacter = createCharacter(scanner);
                    case "2" -> viewCharacters(playerCharacter, enemyCharacter);
                    case "3" -> playerCharacter = deleteCharacter();
                    case "4" -> enemyCharacter = createEnemy(scanner);
                    case "5" -> {
                        System.out.println("Exiting...");
                        flag_menu = false;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }

    static boolean isValidName(String name) {
        String nameLower = name.toLowerCase();
        
        for (String badWord : BAD_WORDS) {
            if (nameLower.contains(badWord.toLowerCase())) {
                return false;
            }
        }
        return true;
    }


    static Character createCharacter(Scanner scanner) {
        System.out.println("\n--- Creating character ---");
        String name;
        while (true) {
            System.out.print("Enter character name: ");
            name = scanner.nextLine();
            if (isValidName(name)) {
                break;
            } else {
                System.out.println("Error: The name contains inappropriate words. Try again.");
            }
        }

        System.out.print("Enter Health Points: ");
        int health = scanner.nextInt();

        System.out.print("Enter Character Mana Points: ");
        int mana = scanner.nextInt();

        System.out.print("Enter Character Hit Points: ");
        int hit = scanner.nextInt();
        scanner.nextLine();

        Character newChar = new Character(name, health, mana, hit);
        System.out.println("Character '" + newChar.getName() + "' created successfully!");

        return newChar;
    }

    static Character createEnemy(Scanner scanner) {
        System.out.println("\n--- Creating Enemy ---");
        System.out.println("Choose enemy type:");
        System.out.println("1- Creeper");
        System.out.println("2- Enderman");
        System.out.println("3- Zombie");
        System.out.print("Select type (1-3): ");
        String typeOpt = scanner.nextLine();

        String name = "";
        System.out.print("Do you want to give it a custom name? (y/n): ");
        String customNameOpt = scanner.nextLine();
        
        if (customNameOpt.equalsIgnoreCase("y")) {
            while (true) {
                System.out.print("Enter custom enemy name: ");
                name = scanner.nextLine();
                if (isValidName(name)) {
                    break;
                } else {
                    System.out.println("Error: The name contains inappropriate words. Try again.");
                }
            }
        }

        System.out.print("Enter Enemy Health Points: ");
        int health = scanner.nextInt();
        System.out.print("Enter Enemy Mana Points: ");
        int mana = scanner.nextInt();
        System.out.print("Enter Enemy Hit Points: ");
        int hit = scanner.nextInt();
        scanner.nextLine();

        Character enemy;

        switch (typeOpt) {
            case "1" -> {
                if (name.isEmpty()) name = "Creeper";
                System.out.print("Enter Explosion Radius: ");
                int explosion = scanner.nextInt();
                scanner.nextLine();
                enemy = new Creeper(name, health, mana, hit, explosion);
            }
            case "2" -> {
                if (name.isEmpty()) name = "Enderman";
                System.out.print("Enter Teleport Distance: ");
                int teleport = scanner.nextInt();
                scanner.nextLine();
                enemy = new Enderman(name, health, mana, hit, teleport);
            }
            case "3" -> {
                if (name.isEmpty()) name = "Zombie";
                System.out.print("Enter Infection Damage: ");
                int infection = scanner.nextInt();
                scanner.nextLine();
                enemy = new Zombie(name, health, mana, hit, infection);
            }
            default -> {
                System.out.println("Invalid type. Creating a default generic enemy.");
                if (name.isEmpty()) name = "Unknown Monster";
                enemy = new Character(name, health, mana, hit);
            }
        }

        System.out.println("Enemy '" + enemy.getName() + "' created successfully!");
        return enemy;
    }

    static void viewCharacters(Character player, Character enemy) {
        System.out.println("\n--- Viewing characters ---");
        
        if (player == null && enemy == null) {
            System.out.println("No characters exist yet. Please create one first.");
            return;
        }
        
        if (player != null) {
            System.out.println("\n[ PLAYER STATS ]");
            player.displayStats();
        }

        if (enemy != null) {
            System.out.println("\n[ ENEMY STATS ]");
            enemy.displayStats();
        }
    }

    static Character deleteCharacter() {
        System.out.println("Deleting player character...");
        System.out.println("Player character has been deleted.");
        return null; 
    }
}