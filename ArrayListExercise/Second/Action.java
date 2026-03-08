package ArrayListExercise.Second;

import java.util.ArrayList;
import java.util.Scanner;

public class Action {

    void makeAction(ArrayList<Gamer> list, ActionT yourChoice) {
        Scanner scanner = new Scanner(System.in);

        if (yourChoice == ActionT.DeleteByIndex) {
            boolean isDeleted = false;
            do {
                System.out.print("Введите индекс игрока для удаления: ");
                if (scanner.hasNextInt()) {
                    int index = scanner.nextInt();

                    if (index >= 1 && index <= list.size()) {
                        Gamer removedGamer = list.remove(index);
                        System.out.println("Игрок " + removedGamer.getName() + " успешно удален.");
                        isDeleted = true;
                    } else {
                        System.out.println("Игрока с таким индексом в списке нет.");
                    }
                } else {
                    System.out.println("Нужно ввести число");
                    scanner.nextLine();
                }
            } while (!isDeleted);

        }
        if (yourChoice == ActionT.FindByIndex) {
            boolean isFind = false;
            do {
                System.out.print("Введите номер игрока для поиска: ");
                if (scanner.hasNextInt()) {
                    int findNumber = scanner.nextInt();

                    for (Gamer gamer : list) {
                        if (gamer.getNumberOfGamer() == findNumber) {
                            System.out.println("Игрок с номером " + findNumber + ": " + gamer.getName());
                            isFind = true;
                            break;
                        }
                    }

                    if (!isFind) {
                        System.out.println("Игрока с таким номером в списке нет.");
                    }
                } else {
                    System.out.println("Нужно ввести число");
                    scanner.nextLine();
                }
            } while (!isFind);

        }

        if (yourChoice == ActionT.Exit) {
            System.out.println("Завершение работы");
        }

    }
}