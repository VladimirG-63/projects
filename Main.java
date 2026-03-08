package ArrayListExercise.First;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.print("Введите количество заказов: ");
            number = scanner.nextInt();
            scanner.nextLine();
            if (number <= 0) {
                System.out.println("Заказ не может быть отрицательным числом или равен нулю");
            }
        }
        while (number <= 0);


        ArrayList<Dish> orders = new ArrayList<>();

        for (int i = 0; i < number; i++) {

            String name = "";
            do {
                System.out.print("Введите название блюда " + (i + 1) + ": ");
                name = scanner.nextLine().trim();

                if (name.isEmpty()) {
                    System.out.println("Название блюда не может быть пустым");
                }
                else if (name.matches(".*[0-9].*")) {
                    System.out.println("Название блюда не должно содержать цифры");
                }
            } while (name.isEmpty() || name.matches(".*[0-9].*"));


            int price = 0;
            do {
                System.out.print("Введите цену блюда " + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    price = scanner.nextInt();
                    scanner.nextLine();
                    if (price < 0) {
                        System.out.println("Цена не может быть отрицательной");
                    }
                } else {
                    System.out.println("Нужно ввести число");
                    scanner.nextLine();
                    price = 0;
                }
            }
            while (price <= 0);

            Dish newDish = new Dish(name, price);
            orders.add(newDish);

        }


        System.out.println("Список заказанных блюд:");
        int total = 0;
        int counter = 1;

        for (Dish dish : orders) {
            System.out.println(counter + ". " + dish.getName() + " - " + dish.getPrice());
            total += dish.getPrice();
            counter++;
        }

        System.out.println("Общая стоимость заказов: " + total);
    }
}