package GameAboutMonster;

class GameChracter {
    private String name;
    private int health;
    private int maxHealth;

    public GameChracter(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        if (health > 0) {
            health -= damage;
        } else {
            health = 0;
        }

    }

    public void heal(int count) {
        health += count;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }
}