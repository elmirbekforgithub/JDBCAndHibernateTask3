package peaksoft;

import peaksoft.colors.Colors;
import peaksoft.model.User;
import peaksoft.service.UserServiceImpl;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    static Scanner in = new Scanner(System.in);
    static Scanner word = new Scanner(System.in);
    static UserServiceImpl userService = new UserServiceImpl();
    static Colors colors = new Colors();

    public static void main(String[] args) {
//        while (true) {
//            System.out.print("create table users -> 1\ndrop table users -> 2\nsave users -> 3\nremove users -> 4\nget all users -> 5\nclean table users -> 6\nstop -> 7\nwrite here: ");
//            int index = in.nextInt();
//            if (index == 1) {
//                userService.createUsersTable();
//                System.out.println(colors.JASHYL + "created table users" + colors.JASHYL);
//            } else if (index == 2) {
//                userService.dropUsersTable();
//                System.out.println(colors.JASHYL + " was drop table users" + colors.JASHYL);
//            } else if (index == 3) {
//                System.out.print(colors.KOK + "enter name: ");
//                String name = word.next();
//                System.out.print("enter surname:");
//                String last_name = word.next();
//                System.out.print("enter age: ");
//                byte age = in.nextByte();
//                userService.saveUser(name, last_name, age);
//                System.out.println(colors.SARY + "user saved");
//            } else if (index == 4) {
//                System.out.print(colors.KYZYL + "enter id user: ");
//                int id = in.nextInt();
//                userService.removeUserById(id);
//                System.out.println("user deleted");
//            } else if (index == 5) {
//                System.out.println(userService.getAllUsers());
//            } else if (index == 6) {
//                userService.cleanUsersTable();
//                System.out.println("cleaned table users");
//            }else if (index==7){
//                System.out.println("stop");
//                break;
//            }
//        }

    }
}
