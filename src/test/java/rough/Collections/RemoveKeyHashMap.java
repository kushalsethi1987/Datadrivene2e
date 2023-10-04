package rough.Collections;

import java.util.HashMap;
import java.util.Map;

public class RemoveKeyHashMap {

    public static void main(String[] args) {

        Map<Integer, String> hm1 = new HashMap<Integer, String>();
        Map<Integer, String> hm2 = new HashMap<Integer, String>();

        hm1.put(11, "Wed Feb 23 12:56:24 IST 2022");
        hm1.put(12, "Wed Feb 23 12:56:48 IST 2022");
        hm1.put(13, "Wed Feb 23 12:56:45 IST 2022");
        hm1.put(14, "Wed Feb 23 12:56:51 IST 2022");
        hm1.put(15, "Wed Feb 23 12:56:50 IST 2022");

        hm2.put(11, "Wed Feb 23 12:56:24 IST 2022");
        hm2.put(12, "Wed Feb 23 12:56:48 IST 2022");
        hm2.put(13, "Wed Feb 23 12:56:45 IST 2022");
        hm2.put(17, "Wed Feb 23 12:56:37 IST 2022");
        hm2.put(18, "Wed Feb 23 12:56:28 IST 2022");

        //removing duplicates
        for (Integer key : hm1.keySet())
        {
            if (hm2.containsKey(key))
            {
                if (hm1.get(key).equals(hm2.get(key)))
                {
                    hm2.remove(key);
                }
            }
        }

        // show content of hm2
        System.out.println(hm2);


    }

}
