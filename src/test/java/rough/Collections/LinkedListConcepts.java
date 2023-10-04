package rough.Collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListConcepts {
    LinkedList<String> ll;

    public void addItemsInLinkedList() {

        ll = new LinkedList<String>();
        ll.add("DA");
        ll.add("DA1");
        ll.add("DA2");
        ll.add("DA3");
        ll.add("DA4");
        ll.add("DA5");
    }

    public void getLinkedListSize() {
        System.out.println(ll); // Printing the complete array list
        System.out.println(ll.size()); // Printing the size of arraylist
    }
    public void getAllItemsLinkedList()
    {
        for(int i=0;i<ll.size();i++)
        {
            System.out.println(ll.get(i)); // Printing the arraylist one by one index through for loop
        }
    }

    public void getAllItemsLinkedListForEach()
    {
        ll.addLast("DA6");
        for(int i=0;i<ll.size();i++)
        {
            System.out.println(ll.get(i)); // Printing the arraylist one by one index through for loop
        }
        ll.removeFirst();
    }

    public void reverseLinkedListOrder()
    {
        //Reverse the order in linkedlist//
        ll=new LinkedList<String>();
        Iterator<String> it= ll.descendingIterator();

        while (it.hasNext())
        {
            System.out.println("Reversing the order "+ it.next());
        }
    }

    public void sortLinkedListOrder()
    {
        //Sorting//
        Collections.sort(ll);
        System.out.println("-------------"+ll);
    }

    public static void main(String[] args) {
        LinkedListConcepts linkedListConcepts=new LinkedListConcepts();
        linkedListConcepts.addItemsInLinkedList();
        linkedListConcepts.getAllItemsLinkedList();
        linkedListConcepts.getAllItemsLinkedListForEach();
        linkedListConcepts.getLinkedListSize();
        linkedListConcepts.sortLinkedListOrder();
        linkedListConcepts.reverseLinkedListOrder();
    }
}
