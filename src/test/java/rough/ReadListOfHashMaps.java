package rough;

import java.util.*;

public class ReadListOfHashMaps {
    List<HashMap<Object, Object>> hashMapList;
    HashMap<Object, Object> hashMap;
    HashMap<Object, Object> hashMap1;
    HashMap<Object, Object> hashMap2;
    HashMap<Object, Object> mergedHashMap = new HashMap<Object, Object>();
    Map.Entry<Object, Object> entry;

    Object keyToBeDeleted;

    public void addKeyValueToHashMap() {
        hashMap = new HashMap<Object, Object>();
        hashMap.put("India", "New Delhi");
        hashMap.put("UK", "London");
        hashMap.put("China", "Beijing");
        hashMap.put("France", "Paris");
        hashMap.put("Japan", "Tokyo");
        hashMap.put("US", "Washington DC");
        hashMap.put("Pakistan", "Karachi");

        hashMap1 = new HashMap<Object, Object>();
        hashMap1.put("India", "Narendra Modi");
        hashMap1.put("UK", "Rishi Sunak");
        hashMap1.put("China", "Xing Ping");
        hashMap1.put("France", "Macroni");
        hashMap1.put("Japan", "Shen Abe");
        hashMap1.put("US", "Trump");
        hashMap1.put("Pakistan", "Imran Khan");

        hashMap2 = new HashMap<Object, Object>();
        hashMap2.put("India", "New Delhi");
        hashMap2.put("UK", "London");
        hashMap2.put("China", "Beijing");
        hashMap2.put("France", "Paris");
        hashMap2.put("Japan", "Tokyo");
        hashMap2.put("US", "Washington DC");
        hashMap2.put("Pakistan", "Karachi");
        hashMap2.put("Bangladesh", "Dhaka");
    }

    public void readListOfHashMap() {
        hashMapList = new ArrayList<HashMap<Object, Object>>();
        hashMapList.add(hashMap);
        hashMapList.add(hashMap1);
        hashMapList.add(hashMap2);


       /* for(int i=0;i<hashMapList.size();i++)
        {
            HashMap<Object, Object> myHash = hashMapList.get(i);
            System.out.println(myHash);
            Iterator<Object> it = myHash.keySet().iterator();

            while(it.hasNext())
            {
                Object key=it.next();
                System.out.println(key);
                Object value=myHash.get(key);
                System.out.println(value);
                System.out.println("------------------------------------------------------------");
            }
        }*/

        /*for(int i=0;i<hashMapList.size();i++)
        {
            HashMap<Object, Object> myHash = hashMapList.get(i);
            Iterator<Map.Entry<Object, Object>> it1 = hashMap.entrySet().iterator();  // via entry set
            while (it1.hasNext())
            {
                Map.Entry<Object, Object> entry = it1.next();
                Object key=entry.getKey();
                System.out.println(entry.getKey());
                Object value=entry.getValue();
                System.out.println(entry.getValue());
                System.out.println("------------------------------------------------------------");
            }
        }*/

        for (int i = 0; i < hashMapList.size(); i++) {
            HashMap<Object, Object> myHash = hashMapList.get(i);
            Iterator<Map.Entry<Object, Object>> it1 = myHash.entrySet().iterator();  // via entry set
            while (it1.hasNext()) {
                entry = it1.next();
                Object key = entry.getKey();
                System.out.println(entry.getKey());
                Object value = entry.getValue();
                System.out.println(entry.getValue());
                System.out.println("------------------------------------------------------------");
                mergedHashMap.put(key, value);
            }
        }

        System.out.println(mergedHashMap);
    }

    public void removeDuplicatesfromHashMap() {

        HashMap<Object, Object> myHash = hashMapList.get(0);

        //removing duplicates
        for (Object key : mergedHashMap.keySet()) {
            if (myHash.containsKey(key)) {

            }
            else
            {

                keyToBeDeleted=key;
                System.out.println(keyToBeDeleted);
            }
        }
        mergedHashMap.remove(keyToBeDeleted);
        System.out.println(mergedHashMap);
    }

    public void keepDuplicatesfromHashMap() {

        HashMap<Object, Object> myHash = hashMapList.get(0);

        //removing duplicates
        for (Object key : myHash.keySet()) {
            if (mergedHashMap.containsKey(key)&&myHash.containsKey(key))
            {
                if (myHash.containsKey(key)) {
                    mergedHashMap.remove(key);
                }
            }
            else
            {
                mergedHashMap.remove(key);
            }
        }
        System.out.println(mergedHashMap);
    }




    public static void main(String[] args) {
        ReadListOfHashMaps readListOfHashMaps=new ReadListOfHashMaps();
        readListOfHashMaps.addKeyValueToHashMap();
        readListOfHashMaps.readListOfHashMap();
        readListOfHashMaps.removeDuplicatesfromHashMap();
        //readListOfHashMaps.keepDuplicatesfromHashMap();
    }


}
