package rough.Collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapConcepts {
    LinkedHashMap<String, String> linkedHashMap;

    public void addKeyValueToLinkedHashMap() {
        //Understanding LinkedHashMap and its iteration//

        linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put("Kushal", "Sethi");
        linkedHashMap.put("Reena", "Kumari");
        linkedHashMap.put("Disha", "Sethi");
        linkedHashMap.put("Rina", "Sethi");
        linkedHashMap.put("Komal", "Sethi");
    }

    public void readItemsFromLinkedHashmapForEach()
    {
        Set<String> keys=linkedHashMap.keySet();
        Set<Map.Entry<String, String>> keysEntrySet=linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> it=keysEntrySet.iterator();
        for(String k: keys)
        {
            System.out.println(k+" "+linkedHashMap.get(k));
        }
        Set entrySet=linkedHashMap.entrySet();

        while (it.hasNext())
        {
            System.out.println(it.next());
        }

        Iterator<Map.Entry<String, String>> it1=linkedHashMap.entrySet().iterator();  // via entry set
        while(it1.hasNext())
        {
            Map.Entry<String, String> entry=it1.next();
            System.out.println("First Name is "+entry.getKey()+" and Last Name is "+entry.getValue());
        }
    }

    public static void main(String[] args)
    {
        LinkedHashMapConcepts linkedHashMapConcepts=new LinkedHashMapConcepts();
        linkedHashMapConcepts.addKeyValueToLinkedHashMap();
        linkedHashMapConcepts.readItemsFromLinkedHashmapForEach();
    }
}
