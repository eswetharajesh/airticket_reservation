/*Write a program to assign passengers seats in an airplane. Assume a small
airplane with seat numberings as follows:

1 A B C D
2 A B C D
3 A B C D
4 A B C D
5 A B C D
6 A B C D
7 A B C D

The program should display the seat pattern, with an 'X' marking the seats
already assigned. For example, after seats 1A, 2B, and 4C are taken, the
display should look like the following:

1 X B C D
2 A X C D
3 A B C D
4 A B X D
5 A B C D
6 A B C D
7 A B C D

After displaying the seats available, the program should prompt for the seat
desired, the user can type in a seat, and then the display of available seats
should be updated. This continues until all seats are filled or until the user
signals that the program should end. If the user types in a seat that is
already assigned, the program should say that that seat is occupied and ask
for another choice.

 */


import java.util.Scanner;

public class AeroplaneSeating {
    static char[][] seat = new char[8][4];

    public static void seatingArrangement() {

        String[] bookedSeats = new String[]{"6A", "2B", "7C"};
        for (int i = 1; i < 8; i++) {
            seat[i][0] = 'A';
            seat[i][1] = 'B';
            seat[i][2] = 'C';
            seat[i][3] = 'D';
        }

        System.out.println("Initial plane Tickets Before Booking");
        printSeats();


        for (int i = 0; i < bookedSeats.length; i++) {

            assignedSeats(bookedSeats[i]);
        }

        System.out.println("Available Tickets");
        printSeats();

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("enter a seat number :");
            String inputSeat = scanner.nextLine();
            if (inputSeat.equals("0")) {
                break;
            }
            assignedSeats(inputSeat);
            printSeats();
        } while (isFilledSeats() < 28);

    }

    public static void assignedSeats(String bookedSeats) {
        int row = bookedSeats.charAt(0) - '0';
        int column = bookedSeats.charAt(1) - 'A';
        if (seat[row][column] == 'X') {
            System.out.println("This Seat is already Booked. Please select another Seat.");
        } else {
            seat[row][column] = 'X';
        }

    }

    public static void printSeats() {
        for (int i = 1; i < 8; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 4; j++) {
                System.out.print(seat[i][j] + " ");
            }
            System.out.println("");
        }
    }


    public static int isFilledSeats() {
        int count = 0;
        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if (seat[i][j] == 'X') {
                    count++;
                }
            }
        }
        return count;

    }
}