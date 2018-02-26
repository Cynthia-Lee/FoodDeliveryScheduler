package com.example.cynth.fooddeliveryscheduler;

/**
 * Created by cynth on 2/19/2018.
 */

/**
 * This class creates two instances of the DeliveryList class and provides an interface for a user to manipulate the list.
 *
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
import java.util.Scanner;

public class DeliveryDriver {
    // two instances of the DeliveryList class
    private static DeliveryList billy = new DeliveryList();
    private static DeliveryList mike = new DeliveryList();

    /**
     * The main method that runs a menu driven application which first creates two empty DeliveryLists and then prompts the
     * user for a menu command selecting the operation. The required information is then requested from the user based on
     * the selected operation.
     */
    public static void main(String[] args) {
        String option;
        DeliveryList current = billy;
        Delivery tempDel = null;
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Delinquent Dollar Delivery Scheduler.");
        System.out.println();
        do {
            System.out.println("Menu:");
            System.out.println("     A) Add a Delivery After Cursor");
            System.out.println("     R) Remove Delivery At Cursor");
            System.out.println("     X) Cut Cursor");
            System.out.println("     V) Paste After Cursor");
            System.out.println("     H) Cursor to Head");
            System.out.println("     T) Cursor to Tail");
            System.out.println("     F) Cursor Forward");
            System.out.println("     B) Cursor Backward");
            System.out.println("     S) Switch Delivery Lists");
            System.out.println("     P) Print current List");
            System.out.println("     Q) Quit");

            System.out.print("Please select an option: ");
            option = input.nextLine();
            if (option.equalsIgnoreCase("A")) {
                System.out.print("Please enter a source: ");
                String s = input.nextLine();
                System.out.print("Please enter a destination: ");
                String d = input.nextLine();
                System.out.print("Please enter any special instructions: ");
                String i = input.nextLine();
                try {
                    Delivery newDelivery = new Delivery(s,d,i);
                    current.insertAfterCursor(newDelivery);
                    System.out.println();
                    System.out.println("Order Inserted.");
                    System.out.println();
                } catch (IllegalArgumentException ex) {
                    System.out.println();
                    System.out.println("Invalid order entered. Cannot add.");
                    System.out.println();
                }
            } else if (option.equalsIgnoreCase("R")) {
                try {
                    System.out.println();
                    System.out.println("Delivery to " + current.removeCursor().getDest() + " removed.");
                    System.out.println();
                } catch (EndOfListException ex) {
                    System.out.println("Invalid order at cursor. Cannot remove.");
                    System.out.println();
                }
            } else if (option.equalsIgnoreCase("X")) {
                try {
                    tempDel = current.removeCursor();
                    System.out.println();
                    System.out.println("Cursor is cut.");
                    System.out.println();
                } catch (EndOfListException ex) {
                    System.out.println();
                    System.out.println("Invalid order at cursor. Cannot remove order from the place to be cut.");
                    System.out.println();
                } catch (IllegalArgumentException ex) {
                    System.out.println();
                    System.out.println("Invalid order at cursor. Cannot cut.");
                    System.out.println();
                }
            } else if (option.equalsIgnoreCase("V")) {
                try {
                    current.insertAfterCursor(tempDel);
                    tempDel = null;
                    System.out.println();
                    System.out.println("Delivery pasted successfully.");
                    System.out.println();
                } catch (IllegalArgumentException ex) {
                    System.out.println();
                    System.out.println("No order could be pasted. Cannot paste order.");
                    System.out.println();
                }
            } else if (option.equalsIgnoreCase("H")) {
                System.out.println();
                current.resetCursorToHead();
                System.out.println("Cursor is at head.");
                System.out.println();
            } else if (option.equalsIgnoreCase("T")) {
                current.resetCursorToTail();
                System.out.println();
                System.out.println("Cursor is at tail.");
                System.out.println();
            } else if (option.equalsIgnoreCase("F")) {
                try {
                    current.cursorForward();
                    System.out.println();
                    System.out.println("Cursor moved forward.");
                    System.out.println();
                } catch (EndOfListException ex) {
                    System.out.println();
                    System.out.println("Cursor already at the end of the list. Cannot move cursor forward.");
                    System.out.println();
                }
            } else if (option.equalsIgnoreCase("B")) {
                try {
                    current.cursorBackward();
                    System.out.println();
                    System.out.println("Cursor moved backwards.");
                    System.out.println();
                } catch (EndOfListException ex) {
                    System.out.println();
                    System.out.println("Cursor is at the head and has nothing behind it. Cannot move cursor backwards.");
                    System.out.println();
                }
            } else if (option.equalsIgnoreCase("S")) {
                if (current == billy) { // switch to mike
                    current = mike;
                    System.out.println();
                    System.out.println("Money Mike's List Selected.");
                } else if (current == mike) { // switch to billy
                    current = billy;
                    System.out.println();
                    System.out.println("Biz Billy's List Selected.");
                }
                System.out.println();
            } else if (option.equalsIgnoreCase("P")) {
                if (current == billy) {
                    System.out.println();
                    System.out.println("Biz Billy's Deliveries:");
                } else if (current == mike) {
                    System.out.println();
                    System.out.println("Money Mike's Deliveries:");
                }
                System.out.println(current.toString());
            } else if (!option.equalsIgnoreCase("Q")) { // any other letters or numbers (invalid)
                System.out.println();
                System.out.println("Please enter a valid option!");
            }
        } while (!option.equalsIgnoreCase("Q"));
        // option was Q
        System.out.println("Next time, try UPS!");
    }
}

