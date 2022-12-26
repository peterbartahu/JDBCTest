package GrocerySQL;

import java.util.Scanner;

public class Program {
    public static void main(final String[] args) {
        run();
    }

    public static void run() {
        final Scanner scanner = new Scanner(System.in);
        final GroceryDao dao = new GroceryDao();
        boolean flag = true;
        System.out.println("Üdvözlöm! Kérem válasszon a menüből");
        showMenu();
        while (flag) {
            System.out.print("Menüpont: ");
            final String prompt = scanner.nextLine();
            switch (prompt) {
                case "1":
                    dao.selectValue();
                    break;
                case "2":
                    System.out.println("Kérem írja be, hogy mit szeretne a listához adni: ");
                    final String addItem = scanner.nextLine();
                    dao.insertValue(addItem);
                    break;
                case "3":
                    System.out.println("Kérem írja be, hogy mit szeretne megváltoztatni és mire a listában: ");
                    final String oldItem = scanner.nextLine();
                    final String newItem = scanner.nextLine();
                    dao.updateValue(oldItem, newItem);
                    break;
                case "4":
                    System.out.println("Kérem írja be, hogy mit szeretne törölni a listából: ");
                    final String deleteItem = scanner.nextLine();
                    dao.deleteValue(deleteItem);
                    break;
                case "5":
                    flag = false;
                    break;
            }
        }
    }

    public static void showMenu() {
        System.out.println(
            "1. - Bevásárló lista ellenőrzése\n" +
                "2. - Bevásárló lista módosítása : bővítés\n" +
                "3. - Bevásárló lista módosítása : Szerkesztés\n" +
                "4. - Bevásárló lista módosítása : Törlés\n" +
                "5. - Kilépés"
        );
    }
}
