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
        Workers workers1 = new Workers("Аза", "Атаяров", 23);
        Workers workers2 = new Workers("Аза", "Курбанов", 21);
        Workers workers3 = new Workers("Аза", "Маматкадыров", 25);
        Workers workers4 = new Workers("Nurlan", "Atayarov", 18);
        Workers workers5 = new Workers("Kutubek", "Gaparov", 17);
        Workers workers6 = new Workers("Aijan", "serieva", 19);
        while (true) {
            cansol();
            int number = scanner.nextInt();
            try {
                if (number < 0 || number > 4) {
                    throw new Exception();
                }
                switch (number) {
                    case 1 ->   dao.getAllWorkers ().forEach(System.out::println);


                    case 2 -> {
                          dao.updateAllWorkers();
                    }
                    case 3 -> dao.deleteAllWorkers().forEach(System.out::println);

                    case 4 ->{
                        System.out.println("write name");
                        String name = foreStr.nextLine();
                        System.out.println("write surname");
                        String surname = foreStr.nextLine();
                        System.out.println("write age");
                        byte age = (byte) fore.nextInt();
                        dao.saveWorkers(name,surname,age);
                    }
                }


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void cansol() {
        System.out.println("prent 1 > get All Aza age big from 20");
        System.out.println("prent 2 > update all Aza age to 18");
        System.out.println("prent 3 > delete all Aza with age big from 20");
        System.out.println("prent 4 > save workers to database");
    }
}