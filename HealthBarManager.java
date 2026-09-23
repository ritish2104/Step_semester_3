import java.util.Scanner;

class GameCharacter {
    private final int maxHealth;
    private int currentHealth;

    public GameCharacter(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public void takeDamage(int amount) {
        currentHealth -= amount;
        if (currentHealth < 0) {
            currentHealth = 0;
        }
    }

    public void heal(int amount) {
        currentHealth += amount;
        if (currentHealth > maxHealth) {
            currentHealth = maxHealth;
        }
    }

    public int getHealth() {
        return currentHealth;
    }
}

public class HealthBarManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxHealth = sc.nextInt();
        GameCharacter c = new GameCharacter(maxHealth);

        int damage1 = sc.nextInt();
        c.takeDamage(damage1);
        System.out.println("c.takeDamage(" + damage1 + ") -> health = " + c.getHealth());

        int healAmount = sc.nextInt();
        c.heal(healAmount);
        System.out.println("c.heal(" + healAmount + ") -> health = " + c.getHealth() + " (capped)");

        int damage2 = sc.nextInt();
        c.takeDamage(damage2);
        System.out.println("c.takeDamage(" + damage2 + ") -> health = " + c.getHealth() + " (floored)");

        sc.close();
    }
}