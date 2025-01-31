package map;

import collect.StudentMarks;

import java.util.*;

public class MapInterfaceDemo {
    public static void main(String[] args) {
        TreeMapDemo hashMap = new TreeMapDemo();
        Thread t1 = new Thread(hashMap);
        t1.start();
    }
    private static class HashMapDemo implements Runnable {

        @Override
        public void run() {
            Map<String, Long> phoneDirectory = new HashMap<>();

            // Populating maps
            phoneDirectory.put("Niladri", 8637288180L);
            phoneDirectory.put("Prapti", 9163919736L);
            phoneDirectory.put("Baba", 9437647514L);

            // Get phonenumber from key
            System.out.println("Phone number for Niladri is: " + phoneDirectory.get("Niladri"));

            // Get directory size
            System.out.println("Number of entries in phone directory: "+phoneDirectory.size());

            // Check if a name exists
            System.out.println("Maa exists: " + phoneDirectory.containsKey("Maa"));

            // Create new Map from existing map
            Map<String, Long> pHDir = new HashMap<>(phoneDirectory);

            // Clearing a map
            phoneDirectory.clear();

            System.out.println("phoneDirectory Size: " + phoneDirectory.size() + "\nphDir size: " + pHDir.size() );

            Map<String, Students> studentReport = new HashMap<>();

            studentReport.put("Niladri", new Students(80, 90));
            studentReport.put("Raj", new Students(70, 22));
            studentReport.put("Prapti", new Students(85, 100));
            studentReport.put("Rohit", new Students(50, 70));
            studentReport.put("Ranjan", new Students(36, 60));
            studentReport.put("Tom", new Students(36, 60));

            // Prevent throwing exception when key does not exist
            System.out.println("Riddhi exixts: " + studentReport.getOrDefault("Riddhi", null));

            /*
                Using maps to store adjacency list in graphs
                Adjacency list -> for a given node, list of all the nodes to which it is connected to
             */

            /*
                Converting map entries to set of mapEntries
             */
            Set<Map.Entry<String, Students>> studentSet = studentReport.entrySet();

            System.out.println(studentSet);

        }
    }

    private static class TreeMapDemo implements Runnable {

        @Override
        public void run() {
            NavigableMap<Integer, String> tmap = new TreeMap<>((o1, o2) -> o2 - o1);

            tmap.put(1, "Niladri");
            tmap.put(2, "Prapti");
            tmap.put(9, "Riddhi");
            tmap.put(5, "Sushmita");

            // traversing
            for (Map.Entry<Integer, String> entry : tmap.entrySet()) {
                System.out.println(entry);
            }
        }
    }
}
