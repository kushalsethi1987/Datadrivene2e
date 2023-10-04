package rough.Collections;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapConcepts {

    TreeMap<String,String> myTreeMap;

    public void addKeyValueInTreeMap()
    {
        myTreeMap=new TreeMap<String,String>();
        myTreeMap.put("Key","Value");
        myTreeMap.put("Ketan","Mirg");
        myTreeMap.put("Duplicate","Value");
        myTreeMap.put("Samosa","Chicken");
    }

    public void getTreeMapKeyValueThruIterator()
    {
        Iterator<Map.Entry<String, String>> mySet=myTreeMap.entrySet().iterator();
        while(mySet.hasNext())
        {
            Map.Entry<String, String> entry=mySet.next();
            System.out.println("Key Name is "+entry.getKey()+" and Value is "+entry.getValue());
        }

    }
    public void getTreeMapKeyValueThruForEach()
    {
        for(String s:myTreeMap.keySet())
        {
            System.out.println(s +" "+myTreeMap.get(s));
        }

    }

    public static void main(String[] args) {
        TreeMapConcepts treeMapConcepts=new TreeMapConcepts();
        treeMapConcepts.addKeyValueInTreeMap();
        treeMapConcepts.getTreeMapKeyValueThruIterator();
        treeMapConcepts.getTreeMapKeyValueThruForEach();
    }
}
