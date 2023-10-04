package rough.Collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayListConcepts {
    ArrayList<String> ar;
    ArrayList<Integer> intArray;
    ArrayList<Integer> cloneList;
    ArrayList<String> cloneListString;
    ArrayList<String> arnew;
    int[] primes = {2, 3, 5, 7, 11, 13, 17};
    List<String> arnewsync;
    List<String> arnewsynclink;
    ArrayList<String> mynewlist;

    public void addItemsInArrayList() {
        ar = new ArrayList<>(20);
        ar.add("DA");
        ar.add("DA1");
        ar.add("DA2");
        ar.add("DA3");
        ar.add("DA4");
        ar.add("DA5");
    }

    public void readItemsFromArrayListForLoop() {
        System.out.println("Printing via For Loop");
        // Printing the complete array list
        System.out.println(ar);

        for (int i = 0; i < ar.size(); i++) {
            // Printing the arraylist one by one index through for loop
            System.out.println(ar.get(i));
        }
    }

    public void readItemsFromArrayListForEach() {
        for (String dr : ar) {
            // Printing the array list through for each loop
            System.out.println(dr);
        }
    }

    public void readItemsFromArrayListLamda() {
        ar.stream().forEach(value -> System.out.println(value));
        // printing the arraylist through the lamda function
        ar.stream().forEach(System.out::println);
    }

    public void readItemsFromArrayListIterator() {
        // iterator function of the arraylist to iterate the data as per index
        Iterator<String> it = ar.iterator();

        while (it.hasNext()) {
            // printing the arraylist data through the while loop
            System.out.println(it.next());
        }
    }

    public void InitializeArrayListConstructor() {
        // Initializing the arraylist constructor by adding a list of integers
        intArray = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(intArray); // Printing the arraylist
    }

    public void cloneArrayList() {
        cloneList = (ArrayList<Integer>) intArray.clone(); // Cloning the arraylist

        System.out.println(cloneList); // printing the cloned arraylist
    }
    public void mergeArrayList() {
        cloneListString = new ArrayList<String>(Arrays.asList("Kushal", "Rohan", "Amit", "Ankush"));

        ar.addAll(cloneListString); // Merging the array list with the cloned arraylist

        System.out.println(ar); // Printing the arraylist after merge
    }
    public void cloneArrayListFromIndex() {
        System.out.println(ar);
        /*ar.addAll(1, cloneListString); // Merging the arraylist from the index 1
        System.out.println(ar); // printing the arraylist after the merge from the index 1*/
    }
    public void checkArrayListHasDuplicates() {
        //Checking from the arraylist if it contains '1' how many times: Duplicate 1
        intArray.retainAll(Collections.singleton(1));
        System.out.println(intArray);
    }

    public void checkArrayListContainsString() {
        // checking if the array contains the value Kushal
        System.out.println(ar.contains("Kushal"));
    }

    public void checkArrayListLastIndexOfString() {
        System.out.println("Index where Kushal is present as a last value is : " + ar.lastIndexOf("Kushal"));
    }

    public void checkArrayListFirstIndexOfString() {
        //Checking the first index in arraylist where Kushal is present
        System.out.println(ar.indexOf("Kushal") > 0);
    }

    public void conditionalArrayListItemRemoval() {
        // removing the even numbers from the arraylist
        intArray.removeIf(num -> num % 2 != 0);
        // removing the odd numbers from the arraylist
        intArray.removeIf(num -> num % 2 == 0);
    }

    public void arrayToArrayListWithInstream() {
        ArrayList<Integer> list = IntStream.of(primes)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(list);
    }

    public void arrayListToArray() {
        //arraylist to array
        arnew = new ArrayList<String>(20);
        arnew.add("DA");
        arnew.add("DA1");
        arnew.add("DA2");
        arnew.add("DA3");
        arnew.add("DA4");
        arnew.add("DA5");

        Object obj[] = arnew.toArray();
        for (Object o : obj) {
            System.out.println(o);
            System.out.println(Arrays.toString(obj));
            System.out.println(Arrays.stream(obj).toArray());
        }
    }

    public void synchronizedArrayList() {
        // Synchronized arraylist
        arnewsync = Collections.synchronizedList(new ArrayList<String>());
        arnewsync.add("sync1");
        arnewsync.add("sync2");
        arnewsync.add("sync3");
        arnewsync.add("sync4");
        arnewsync.add("sync4");
        arnewsync.add("sync5");
        arnewsync.add("sync6");
        arnewsync.add("sync6");
        arnewsync.add("sync6");

        synchronized (arnewsync) {
            Iterator<String> itrsync = arnewsync.iterator();
            while (itrsync.hasNext()) {
                System.out.println(itrsync.next());
            }
        }
    }

    public void syncronizedArrayListWithCopyOnWrite() {
        // Another way of synchronized list
        CopyOnWriteArrayList<String> syncArrayList = new CopyOnWriteArrayList<String>();
        syncArrayList.addAll(arnewsync);
        System.out.println(syncArrayList.toString());
    }

    public void removeDuplicateFromArrayList() {
        //removing the duplicate value from the arraylist, LinkedHashSet removes the dupliclate values
        arnewsynclink = Collections.synchronizedList(new ArrayList<String>());
        arnewsynclink.add("sync1");
        arnewsynclink.add("sync2");
        arnewsynclink.add("sync3");
        arnewsynclink.add("sync4");
        arnewsynclink.add("sync4");
        arnewsynclink.add("sync5");
        arnewsynclink.add("sync6");
        arnewsynclink.add("sync6");
        arnewsynclink.add("sync6");
        LinkedHashSet<String> hashsetlinked = new LinkedHashSet<String>(arnewsynclink);
        System.out.println(hashsetlinked);
    }

    public void removeDuplicateFromArrayListDistinct()
    {
        mynewlist= new ArrayList<>(Arrays.asList("Roger","Binny","Tax","Enjoy","Hormone","Hormone"));
        // Creating a sublist
        ArrayList<String> subsetList=new ArrayList<String>(mynewlist.subList(0,5));
        List<String> nondup=subsetList.stream().distinct().collect(Collectors.toList());
        System.out.println(nondup);
    }

    public void compareArrayLists()
    {
        // Compare arraylist in java

        mynewlist= new ArrayList<>(Arrays.asList("Roger","Binny","Tax","Enjoy","Hormone","Hormone"));
        ArrayList<String> subsetListcomp=new ArrayList<String>(mynewlist.subList(0,6)); // Creating a sublist

        // Sorting the list
        Collections.sort(mynewlist);
        Collections.sort(subsetListcomp);

        System.out.println(mynewlist.equals(subsetListcomp));

        // removing the common data
        mynewlist.removeAll(subsetListcomp);
        System.out.println(mynewlist);
    }
    public void deleteItemsFromArrayList() {

        // Removing the data from arraylist of index 1
        ar.remove(1);
        // Clearing the data from the complete arraylist
        ar.clear();
    }

    public void getArrayListSize() {
        // Printing the size of arraylist
        System.out.println(ar.size());
    }

    public static void main(String[] args) {

        ArrayListConcepts arrayListConcepts = new ArrayListConcepts();
        arrayListConcepts.addItemsInArrayList(); // Adds items into arraylist
        arrayListConcepts.readItemsFromArrayListForLoop(); //
        arrayListConcepts.readItemsFromArrayListForEach();
        arrayListConcepts.readItemsFromArrayListLamda();
        arrayListConcepts.readItemsFromArrayListIterator();
        arrayListConcepts.InitializeArrayListConstructor();
        arrayListConcepts.cloneArrayList();
        arrayListConcepts.cloneArrayListFromIndex();
        arrayListConcepts.mergeArrayList();
        arrayListConcepts.checkArrayListContainsString();
        arrayListConcepts.checkArrayListLastIndexOfString();
        arrayListConcepts.checkArrayListFirstIndexOfString();
        arrayListConcepts.getArrayListSize();
        arrayListConcepts.checkArrayListHasDuplicates();
        arrayListConcepts.arrayToArrayListWithInstream();
        arrayListConcepts.arrayListToArray();
        arrayListConcepts.synchronizedArrayList();
        arrayListConcepts.syncronizedArrayListWithCopyOnWrite();
        arrayListConcepts.removeDuplicateFromArrayListDistinct();
        arrayListConcepts.compareArrayLists();
        arrayListConcepts.conditionalArrayListItemRemoval();
        arrayListConcepts.deleteItemsFromArrayList();
    }
}
