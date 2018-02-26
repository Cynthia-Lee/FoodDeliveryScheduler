package com.example.cynth.fooddeliveryscheduler;

/**
 * Created by cynth on 2/19/2018.
 */

/**
 * This class implements a double linked-list data structure.
 * It maintains Deliveries by chaining a list of DeliveryListNodes between a head and tail reference.
 *
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
public class DeliveryList {
    // double linked list
    // maintain a list of deliveries by chaining a series of DeliveryListNodes
    // between hail and tail reference
    private DeliveryListNode head;
    private DeliveryListNode tail;
    private DeliveryListNode cursor;
    private int count = 0;

    /**
     * Default constructor which initializes this object to an empty list of Deliveries.
     * <dt><b>Postconditions:</b><dd>
     * This DeliveryList has been initialized with head, tail, and cursor all set to null.
     */
    public DeliveryList() { // default constructor
        head = null;
        tail = null;
        cursor = null;
    }

    /**
     * This method returns the total number of Deliveries in the list. O(1)
     * @return
     * Number of deliveries in the list as an integer
     */
    public int numDeliveries() {
        return count;
    }

    /**
     * This method gets the reference to the Delivery wrapped by the DeliveryListNode currently referenced by cursor.
     * @return
     * The reference by the Delivery wrapped by the DeliveryListNode currently referenced by cursor.
     * If the cursor is null, then it returns null.
     */
    public Delivery getCursor() { // if the cursor is null, then the method should return null as well
        if (cursor == null) { // cursor does not reference a Delivery
            return null;
        }
        return cursor.getData();
    }

    /**
     * This method returns cursor to the start of the list.
     * <dt><b>Postconditions:</b><dd>
     * If head is not null, the cursor now references the first DeliveryNode in the list.
     * If the head is null, the cursor is set to null as well. (there are no Deliveries in the list)
     */
    public void resetCursorToHead() {
        if (head == null) {
            cursor = null; // no Deliveries in the list
        } else {
            cursor = head;
        }
    }

    /**
     * This method returns cursor to the end of the list.
     * <dt><b>Postconditions:</b><dd>
     * If tail is not null, the cursor now references the last DeliveryNode in the list.
     * If tail head is null, the cursor is set to null as well.
     */
    public void resetCursorToTail() {
        if (tail == null) {
            cursor = null; // no Deliveries in the list
        } else {
            cursor = tail;
        }
    }

    /**
     * This method moves the cursor to select the next DeliveryListNode in the list.
     * @throws EndOfListException
     * If the cursor is at the tail of the list (this includes the case where cursor and tail are both null)
     */
    public void cursorForward() throws EndOfListException {
        if (cursor == tail) { // if cursor at tail (includes if cursor and tail both null)
            throw new EndOfListException();
        } else {
            cursor = cursor.getNext();
        }
    }

    /**
     * This method moves the cursor to select the previous DeliveryListNode in the list.
     * @throws EndOfListException
     * If the cursor is at the head of the list (this includes the case where cursor and head are both null)
     */
    public void cursorBackward() throws EndOfListException {
        if ( cursor == head ) {
            throw new EndOfListException();
        } else {
            cursor = cursor.getPrev();
        }
    }

    /**
     * This method inserts the indicated Delivery after the cursor.
     * <dt><b>Preconditions:</b><dd>
     * newDelivery is not null
     * <dt><b>Postconditions:</b><dd>
     * newDelivery has been wrapped in a new DeliveryListNode object.
     * If cursor was previously not null, the newly created DeliveryListNode has been inserted into the list after the cursor.
     * If cursor was previously null, the newly created DeliveryListNode has been set as the new head of the list (as well as the tail).
     * The cursor remains unchanged.
     * @param newDelivery
     * Delivery to be inserted after the cursor
     * @throws IllegalArgumentException
     * If newDelivery is null
     */
    public void insertAfterCursor(Delivery newDelivery) throws IllegalArgumentException {
        // inserts the indicated delivery after the cursor
        if (newDelivery != null) {
            // newDelivery has been wrapped in a new DeliveryListNode object.
            DeliveryListNode insertDelivery = new DeliveryListNode(newDelivery);
            if (cursor != null) { // not tail
                // add delivery after the cursor (doubled link list)
                if (cursor != tail) {
                    insertDelivery.setNext(cursor.getNext());
                    insertDelivery.setPrev(cursor);
                    cursor.setNext(insertDelivery);
                    insertDelivery.getNext().setPrev(insertDelivery);
                } else if (cursor == tail) {
                    tail.setNext(insertDelivery);
                    insertDelivery.setPrev(tail);
                    tail = insertDelivery;
                }
            } else {
                head = insertDelivery;
                tail = insertDelivery;
                cursor = insertDelivery;
            }
            count++;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Inserts the indicated Delivery after the tail of the list.
     * <dt><b>Preconditions:</b><dd>
     * newDelivery is not null
     * <dt><b>Postconditions:</b><dd>
     * newDelivery has been wrapped in a new DeliveryListNode object.
     * If tail was previously not null, the newly created DeliveryListNode has been inserted into the list after the tail.
     * If tail was previously null, the newly created DeliveryListNode has been set as the new head of the list (as well as the tail and the cursor).
     * The tail now references the newly created DeliveryListNode.
     * @param newDelivery
     * Delivery to be added to the end of the list
     * @throws IllegalArgumentException
     * If newDelivery is null
     */
    public void appendToTail(Delivery newDelivery) throws IllegalArgumentException{
        // inserts after the tail of the list
        if (newDelivery != null) {
            DeliveryListNode addDelivery = new DeliveryListNode(newDelivery);
            if (tail != null) { // add after tail
                tail.setNext(addDelivery);
                addDelivery.setPrev(tail);
                tail = addDelivery;
            } else {
                head = addDelivery;
                tail = addDelivery;
                cursor = addDelivery;
            }
            count++;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This method removes the DeliveryListNode referenced by cursor and returns the Delivery inside.
     * <dt><b>Preconditions:</b><dd>
     * Cursor is not null
     * <dt><b>Postconditions:</b><dd>
     * The DeliveryListNode referenced by cursor has been removed from the list.
     * All other DeliveryListNodes in the list exist in the same Delivery as before.
     * The cursor now references the next DeliveryListNode (or the tail, if the cursor previously referenced the tail of the list).
     * @return
     * Delivery from the DeliveryListNode that was removed
     * @throws EndOfListException
     * If cursor is null
     */
    public Delivery removeCursor() throws EndOfListException{
        // removes node referenced by cursor, returns the Delivery inside
        if (cursor != null) { // not head or tail
            Delivery removed = cursor.getData();
            if (cursor != head && cursor != tail) {
                cursor.getPrev().setNext(cursor.getNext());
                cursor.getNext().setPrev(cursor.getPrev());
                cursor = cursor.getNext();
            } else if (cursor == head && cursor == tail) {
                head = null;
                tail = null;
                cursor = null;
            } else if (cursor == head) { // head, remove at head
                head = cursor.getNext();
                cursor = head;
            } else if(cursor == tail) { // tail, remove at tail
                tail = cursor.getPrev();
                cursor = tail;
            }
            count--;
            return removed;
        } else {
            throw new EndOfListException();
        }
    }

    /**
     * This method returns a String of the DeliveryList, printing each of its Deliveries in order
     * @return
     * A String representing the Deliveries in the DeliveryList
     */
    public String toString() {
        DeliveryListNode nodePtr = head;
        String s = "----------------------------------------------------------\n";
        for (int i = 1; i<=count; i++) {
            // cursor printed above the node it is referencing
            if (cursor == nodePtr) { // ->
                s = s + "->\n";
            } else { // ~
                s = s + "~\n";
            }
            s = s + (nodePtr.getData()).toString() + "\n";
            nodePtr = nodePtr.getNext();
        }
        s = s + "----------------------------------------------------------\n";
        return s;
    }
}

