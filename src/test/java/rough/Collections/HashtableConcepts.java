package rough.Collections;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class HashtableConcepts {

    Hashtable<String,String> myHashTable;
    Iterator<Map.Entry<String, String>> mySet;
    public void addKeyValueInHashTable()
    {
        myHashTable=new Hashtable<String,String>();
        myHashTable.put("Key","Value");
        myHashTable.put("Ketan","Mirg");
        myHashTable.put("Duplicate","Value");
        myHashTable.put("Samosa","Chicken");
    }

    public void readyAllKeyValuesHashTableIterator()
    {
        mySet=myHashTable.entrySet().iterator();
        while(mySet.hasNext())
        {
            Map.Entry<String, String> entry=mySet.next();
            System.out.println("Key Name is "+entry.getKey()+" and Value is "+entry.getValue());
        }
    }
    public void readyAllKeyValuesHashTableForEach()
    {
        while(mySet.hasNext())
        {
            Map.Entry<String, String> entry=mySet.next();
            System.out.println("Key Name is "+entry.getKey()+" and Value is "+entry.getValue());
        }

        for(String s:myHashTable.keySet())
        {
            System.out.println(s +" "+myHashTable.get(s));
        }
    }

    public static void main(String[] args) {
        HashtableConcepts hashtableConcepts=new HashtableConcepts();

        hashtableConcepts.addKeyValueInHashTable();
        hashtableConcepts.readyAllKeyValuesHashTableForEach();
        hashtableConcepts.readyAllKeyValuesHashTableIterator();
    }
}
