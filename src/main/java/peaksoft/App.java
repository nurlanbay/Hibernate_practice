package peaksoft;

import org.hibernate.Session;
import peaksoft.entity.Workers;
import peaksoft.service.WorkersService;
import peaksoft.service.WorkersServiceImpl;
import peaksoft.util.HibernateUtil;

import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    static WorkersService dao = new WorkersServiceImpl();
    static Scanner scanner = new Scanner(System.in);
    static Scanner foreStr = new Scanner(System.in);
    static Scanner fore = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            cansol();
            int number = scanner.nextInt();
            try {
                if (number < 0 || number > 5) {
                    throw new Exception();
                }
                switch (number) {
                    case 1 -> dao.createTable();

                    case 2 -> dao.getAllWorkers().forEach(System.out::println);

                    case 3 -> {
                        dao.updateAllWorkers();
                    }
                    case 4 -> dao.deleteAllWorkers().forEach(System.out::println);

                    case 5 -> {
                        System.out.println("write name");
                        String name = foreStr.nextLine();
                        System.out.println("write surname");
                        String surname = foreStr.nextLine();
                        System.out.println("write age");
                        byte age = (byte) fore.nextInt();
                        dao.saveWorkers(name, surname, age);
                    }
                    case 6 ->{
                        dao.deleteAllWorkers().forEach(System.out::println);
                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void cansol() {
        System.out.println("prent 1 > create table");
        System.out.println("prent 2 > get All Aza age big from 20");
        System.out.println("prent 3 > update all Aza age to 18");
        System.out.println("prent 4 > delete all Aza with age big from 20");
        System.out.println("prent 5 > save workers to database");
        System.out.println("prent 6 > get all Remainder Workers");
    }
}