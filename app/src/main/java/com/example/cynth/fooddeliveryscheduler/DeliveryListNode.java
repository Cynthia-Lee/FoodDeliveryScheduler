package com.example.cynth.fooddeliveryscheduler;

/**
 * Created by cynth on 2/19/2018.
 */

/**
 * This class wraps a Delivery object to allow it to be inserted into a doubly linked-list data structure.
 *
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
public class DeliveryListNode {
    // wraps a Delivery object to allow it to be inserted into a doubly linked-list
    // data structure
    // The Delivery object reference should be contained in a field called data and
    // there should be two DeliveryListNode references serving as ‘links’ to the
    // previous and next DeliveryListNodes in the list.
    private Delivery data;
    private DeliveryListNode next;
    private DeliveryListNode prev;

    /**
     * This constructor creates a DeliveryListNode that holds a Delivery.
     * <dt><b>Preconditions:</b><dd>
     * initData is not null
     * <dt><b>Postconditions:</b><dd>
     * This DeliveryListNode has been initialized to wrap the indicated Delivery, and prev and next have been set to null.
     * @param initData
     * A Delivery to be wrapped by a DeliveryListNode
     * @throws IllegalArgumentException
     * If the Delivery is null
     */
    public DeliveryListNode(Delivery initData) throws IllegalArgumentException { // default constructor
        if (initData == null) {
            throw new IllegalArgumentException();
        } else {
            data = initData;
            next = null;
            prev = null;
        }
    }

    // getters and setters
    public Delivery getData() {
        return data;
    }

    public DeliveryListNode getNext() {
        return next;
    }

    public DeliveryListNode getPrev() {
        return prev;
    }

    public void setData(Delivery d) {
        data = d;
    }

    public void setNext(DeliveryListNode dln) {
        next = dln;
    }

    public void setPrev(DeliveryListNode dln) {
        prev = dln;
    }

}

