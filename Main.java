import java.util.Random;
import java.util.Scanner;

enum ActionType {
    Atack,
    Heal,
    Skip
}

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

class Game {
    private GameChracter Gamer;
    private GameChracter Monster;
    private Scanner scanner;
    private Random random;

    public Game() {
        this.Gamer = new GameChracter("Artur", 100);
        this.Monster = new GameChracter("Monster", 100);
        scanner = new Scanner(System.in);
        random = new Random();
    }

    private void executeAction(GameChracter Gamer, GameChracter Monster, ActionType playerAction) {
        if (playerAction == ActionType.Atack) {
            System.out.println(Gamer.getName() + " Атакует и наносит 25 урона");
            Monster.takeDamage(25);
        } else if (playerAction == ActionType.Heal) {
            System.out.println(Gamer.getName() + " Восстанавливает здоровье на 25 единиц");
            Gamer.heal(25);
        } else if (playerAction == ActionType.Skip) {
            System.out.println(Gamer.getName() + " Пропускает ход");
        } else {
            System.out.println("Неверный выбор");
        }
    }

    private void MonsterAction(GameChracter Gamer, GameChracter Monster, ActionType monsterAction) {
        if (monsterAction == ActionType.Atack) {
            System.out.println(Monster.getName() + " Атакует и наносит 25 урона");
            Gamer.takeDamage(25);

        } else if (monsterAction == ActionType.Heal) {
            System.out.println(Monster.getName() + " Восстанавливает здоровье на 25 единиц");
            Monster.heal(25);
        } else if (monsterAction == ActionType.Skip) {
            System.out.println(Monster.getName() + " Пропускает ход");
        } else {
            System.out.println("Неверный выбор");
        }
    }


    public void start() {
        System.out.println("Начало");
        ActionType playerAction = null;
        ActionType monsterAction = null;
        while (Gamer.isAlive() && Monster.isAlive()) {
            System.out.println("Выберите действие: ");
            System.out.println("1. Атака ");
            System.out.println("2. Лечение ");
            System.out.println("3. Пропуск хода ");
            System.out.println("Введите номер действия: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                playerAction = ActionType.Atack;
            } else if (choice == 2) {
                playerAction = ActionType.Heal;
            } else if (choice == 3) {
                playerAction = ActionType.Skip;
            } else {
                System.out.println("Неверный выбор");
            }
            executeAction(Gamer, Monster, playerAction);

            int choice2 = random.nextInt(3) + 1;
            if (Monster.isAlive()) {
                if (choice2 == 1) {
                    monsterAction = ActionType.Atack;
                } else if (choice2 == 2) {
                    monsterAction = ActionType.Heal;
                } else {
                    monsterAction = ActionType.Skip;
                }
                MonsterAction(Gamer, Monster, monsterAction);
            }

            System.out.println("Здоровье игрока: " + Gamer.getHealth());
            System.out.println("Здоровье монстра: " + Monster.getHealth());

            if (!Gamer.isAlive()) {
                System.out.println(Gamer.getName() + " проиграл");
            } else if (!Monster.isAlive()) {
                System.out.println(Gamer.getName() + " выиграл");
            } else {
                System.out.println("Продолжаем игру");
            }

        }

    }
}

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}