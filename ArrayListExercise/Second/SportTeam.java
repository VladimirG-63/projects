package ArrayListExercise.Second;

import java.util.ArrayList;
import java.util.Scanner;





public class SportTeam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.print("Сколько игроков вы хотите добавить?: ");
            number = scanner.nextInt();
            scanner.nextLine();
            if (number <= 0) {
                System.out.println("Количество игроков не может быть отрицательным числом или равно нулю");
            }
        }
        while (number < 0);

        ArrayList<Gamer> list = new ArrayList<>();


        for (int i = 0; i < number; i++) {

            String name = "";
            do {
                System.out.print("Введите имя игрока " + (i + 1) + ": ");
                name = scanner.nextLine().trim();

                if (name.isEmpty()) {
                    System.out.println("Имя игрока не может быть пустым");
                } else if (name.matches(".*[0-9].*")) {
                    System.out.println("Имя не должно содержать цифры");
                }
            } while (name.isEmpty() || name.matches(".*[0-9].*"));


            int numberOfGamer = 0;
            do {
                System.out.print("Введите номер игрока " + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    numberOfGamer = scanner.nextInt();
                    scanner.nextLine();
                    if (numberOfGamer < 0) {
                        System.out.println("Номер игрока не может быть отрицательным");
                    }
                } else {
                    System.out.println("Нужно ввести число");
                    scanner.nextLine();
                    numberOfGamer = 0;
                }
            }
            while (numberOfGamer <= 0);

            Gamer gamer = new Gamer(name, numberOfGamer);
            list.add(gamer);

        }

        System.out.println("Состав команды::");
        int total = 0;
        int counter = 1;

        for (Gamer g : list) {
            System.out.println(counter + ". " + g.getName() + " (№" + g.getNumberOfGamer() + ")");
            total = list.size();
            counter++;
        }

        System.out.println("Всего игроков: " + total);


        System.out.println("Выберите действие: ");
        System.out.println("1 - Удалить игрока по индексу");
        System.out.println("2 - Найти игрока по номеру");
        System.out.println("3 - Выход");





        Action ac = new Action();
        ActionT choiceYourAction = null;

        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();

            if (choice == 1) {
                choiceYourAction = ActionT.DeleteByIndex;

            } else if (choice == 2) {
                choiceYourAction = ActionT.FindByIndex;
            } else if (choice == 3) {
                choiceYourAction = ActionT.Exit;
            } else {
                System.out.println("Неверный выбор");
            }
        }

        ac.makeAction(list, choiceYourAction);
    }
}
