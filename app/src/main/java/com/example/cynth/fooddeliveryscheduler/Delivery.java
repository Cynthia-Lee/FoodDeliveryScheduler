package com.example.cynth.fooddeliveryscheduler;

/**
 * Created by cynth on 2/19/2018.
 */

/**
 * This class contains the source, destination, and instruction for a delivery.
 *
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
public class Delivery {
    // contains the source, destination, and instruction for a delivery
    private String source;
    private String dest;
    private String instruction;

    /**
     * This constructor creates a new Delivery object. It does not take any information in, making it's variables null.
     */
    public Delivery() {
        source = null;
        dest = null;
        instruction = null;
    }

    /**
     * This constructor creates a new Delivery object with information it is given.
     * @param s
     * The source of the delivery
     * @param d
     * The destination of the delivery
     * @param i
     * The special instructions of the delivery
     */
    public Delivery(String s, String d, String i) {
        source = s;
        dest = d;
        instruction = i;
    }

    // getters and setters
    public String getSource() {
        return source;
    }

    public String getDest() {
        return dest;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setSource(String s) {
        source = s;
    }

    public void setDest(String d) {
        dest = d;
    }

    public void setInstruction(String i) {
        instruction = i;
    }

    /**
     * A method that returns the printable representation of the Delivery.
     * @return
     * A String of the delivery's destination, source and instruction
     */
    public String toString() {
        return "To: " + dest + " | From: " + source + "\nInstruction: " + instruction;
    }
}
