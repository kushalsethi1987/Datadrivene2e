package rough.Collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapConcepts {
    HashMap<Object, Object> hashMap;
    HashMap<Object, Object> hashMap1;
    HashMap<Object, Object> hashMap2;
    HashSet<Object> hashSet;

    public void addKeyValueToHashMap() {
        hashMap = new HashMap<Object, Object>();
        hashMap.put("India", "New Delhi");
        hashMap.put("UK", "London");
        hashMap.put("China", "Beijing");
        hashMap.put("France", "Paris");
        hashMap.put("Japan", "Tokyo");
        hashMap.put(null, 1);
        hashMap.put("Pakistan", null);

        hashMap1 = new HashMap<Object, Object>();
        hashMap1.put("India", "New Delhi");
        hashMap1.put("UK", "London");
        hashMap1.put("China", "Beijing");
        hashMap1.put("France", "Paris");
        hashMap1.put("Japan", "Tokyo");
        hashMap1.put(null, 1);
        hashMap1.put("Pakistan", null);

        hashMap2 = new HashMap<Object, Object>();
        hashMap2.put("India", "New Delhi");
        hashMap2.put("UK", "London");
        hashMap2.put("China", "Beijing");
        hashMap2.put("France", "Paris");
        hashMap2.put("Japan", "Tokyo");
        hashMap2.put(null, 1);
        hashMap2.put("Pakistan", null);
        hashMap2.put("Bangladesh", "null");
    }

    public void readItemsFromHashmapIterator() {
        //Iterating the Hashmap via iterator//
        Iterator<Object> it = hashMap.keySet().iterator(); // Via keyset
        while (it.hasNext()) {
            System.out.println(hashMap.get(it.next()));
        }
        Iterator<Map.Entry<Object, Object>> it1 = hashMap.entrySet().iterator();  // via entry set
        while (it1.hasNext()) {
            Map.Entry<Object, Object> entry = it1.next();
            System.out.println("Country is " + entry.getKey() + " and Capital is " + entry.getValue());
        }
    }

    public void readItemsFromHashMapLamda() {
        //Iterating the Hashmap via lamda//

        hashMap.forEach((k, v) -> System.out.println("Country is " + k + " and Capital is " + v));
    }

    public void hashMapCompareKeyValue() {
        System.out.println(hashMap1.equals(hashMap2));
        System.out.println(hashMap.equals(hashMap1));
    }

    public void hashMapCompareKeyOnly() {
        // Comparing on the basis of key only//
        System.out.println(hashMap1.keySet().equals(hashMap2.keySet()));
        System.out.println(hashMap.keySet().equals(hashMap1.keySet()));
    }

    public void hashMapCompareValueOnlyByArrayList() {
        // compare via values/
        //Using arraylist
        System.out.println(new ArrayList<>(hashMap.values()).equals(new ArrayList<>(hashMap1.values())));
    }

    public void hashMapCompareValueOnlyByHashSet() {
        //Using HashSet
        System.out.println(new HashSet<>(hashMap.values()).equals(new HashSet<>(hashMap1.values())));
    }

    public void hashMapsExtraKeys() {
        // find out the extra keys//
        hashSet = new HashSet<Object>(hashMap1.keySet());
        hashSet.addAll(hashMap2.keySet());
        hashSet.removeAll(hashMap1.keySet());
        System.out.println(hashSet);
    }

    public void synchronizedHashMap() {
        Map<Object, Object> syncHashMap = Collections.synchronizedMap(hashMap2);
        System.out.println(syncHashMap);
    }

    public void concurrentHashMap() {
        // Concurrent Hashmap//
        // Segment wise thread safe
        // Does not allow null values
        // can read from the segment by multiple threads but multiple threads cannot write on the same segment

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();
    }

    public void hashMapToArrayList() {
        Iterator<Object> it = hashMap2.keySet().iterator(); // Via keyset
        Iterator<Map.Entry<Object, Object>> it1 = hashMap2.entrySet().iterator(); // Via EntrySet
        while (it.hasNext()) {
            System.out.println(hashMap2.get(it.next()));
        }
        while (it1.hasNext()) {
            Map.Entry entry = it1.next();
            System.out.println("Country is " + entry.getKey() + " and Capital is " + entry.getValue());
        }
        List<Object> arrayList = new ArrayList<Object>(hashMap2.keySet());
        List<Object> arrayListValues = new ArrayList<Object>(hashMap2.values());

        for (Object obj : arrayList) {
            System.out.println(obj);
        }

        for (Object obj : arrayListValues) {
            System.out.println(obj);
        }

        for (int i = 0; i < arrayListValues.size(); i++) {
            System.out.println("Country: " + arrayList.get(i) + "            Capital: " + arrayListValues.get(i));

        }
    }

    public void readListOfHashMaps()
    {
        List<HashMap<Object,Object>> hashMapList=new ArrayList<HashMap<Object,Object>>();
        hashMapList.add(hashMap);
        hashMapList.add(hashMap1);
        hashMapList.add(hashMap2);

        hashMapList.get(0);

    }

        public static void main(String[]args)
        {
            HashMapConcepts hashMapConcepts = new HashMapConcepts();
            hashMapConcepts.addKeyValueToHashMap();
            hashMapConcepts.readItemsFromHashmapIterator();
            hashMapConcepts.readItemsFromHashMapLamda();
            hashMapConcepts.hashMapCompareKeyValue();
            hashMapConcepts.hashMapCompareKeyOnly();
            hashMapConcepts.hashMapCompareValueOnlyByArrayList();
            hashMapConcepts.hashMapCompareValueOnlyByHashSet();
            hashMapConcepts.hashMapsExtraKeys();
            hashMapConcepts.synchronizedHashMap();
            hashMapConcepts.concurrentHashMap();
            hashMapConcepts.hashMapToArrayList();

        }

    }
