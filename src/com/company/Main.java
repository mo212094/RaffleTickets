package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    private static String[] ticketNumArray = new String[1000];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Would you like to check a raffle ticket (press 1) or purchase one (press 2)?");
            int userAns = input.nextInt();
            if (userAns == 1) {
                checkTicket();
            } else {

                int ticket = purchaseTicketTicketNum();
                //What if the ticket location is already taken?
                try {
                    while (!ticketNumArray[ticket].isEmpty()) {
                        ticket = purchaseTicketTicketNum();
                    }
                } catch (Exception e) {
                    //This is to catch errors if the space is null
                }
                ticketNumArray[ticket] = purchaseTicketName();


            }
        }
    }

    public static void checkTicket() {
        Scanner input = new Scanner(System.in);

        System.out.println("You chose to check a raffle ticket");
        System.out.println("What is your raffle ticket number?");
        int ticketNum = input.nextInt();
        System.out.println("What is your name?");
        String userName = input.next();
        boolean valid = false;
        try {
            if (ticketNumArray[ticketNum].equals(userName)) {
                System.out.println("Your ticket is valid");
                if (primeNumber(ticketNum)) {
                    System.out.println("You won!");
                } else {
                    System.out.println("You lost");
                }
                valid = true;
            } else {
                System.out.println("Your ticket is invalid");
                valid = false;
            }

        } catch (Exception e) {
            System.out.println("That ticket is not valid");
        }
    }

    public static boolean primeNumber(int a) {

        return true;
    }

    public static String purchaseTicketName() {
        Scanner input = new Scanner(System.in);
        System.out.println("You chose to purchase a raffle ticket");
        System.out.println("What is your name?");
        String realName = input.nextLine();
        return realName;
    }

    public static int purchaseTicketTicketNum() {
        Random random = new Random();
        int realTicketNum = random.nextInt(random.nextInt(999));
        System.out.println("Your raffle ticket number is " + realTicketNum);
        return realTicketNum;
    }
}
