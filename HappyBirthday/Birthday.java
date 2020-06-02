// Author: Nabiha Bashir
// Birthday Class

import java.util.Scanner;

public class Birthday {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name;
        String reply;
        int age;
        int birthYear;
        char thisYear;

        System.out.print("What is your name?");
        name = in.next();
        System.out.print("How old are you " + name + "?");
        age = in.nextInt();
        System.out.print(name+", have you had your birthday yet this year? (y/n)");
        reply = in.next();
        thisYear = reply.charAt(0);

        if (thisYear == 'y' || thisYear == 'Y')
            birthYear = 2019 - age;
        else
            birthYear = 2019 - age - 1;

        System.out.println("I guess that ypu were born in " + birthYear);

    }
}
