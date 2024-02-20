package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hashtable {

    private int size = 7;
    private Node[] dataMap;

    public class Node {
        private String key;
        private int value;
        private Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public Hashtable(int size) {
        dataMap = new Node[size];
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("  {" + temp.key + "=" + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            // to make sure to get an index in range of 0,length we get the modulus
            hash = ( hash + asciiValue * 23 ) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.key == key) return temp.value;
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList<String> keys() {
        ArrayList<String> allKeys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

    // INTERVIEW QUESTIONS
    // Check if 2 arrays has item in common (do not use nested loop)
    public static boolean itemInCommon(int [] arr1, int[] arr2) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();

        for (int i : arr1) {
            hashMap.put(i, true);
        }
        for (int j : arr2) {
            if (hashMap.get(j) != null) return true;
        }

        return false;
    }

    // Given an array of integers, find all the duplicates in the array using a hash table
    public List<Integer> findDuplicates(int[] arr) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                count = hashMap.get(arr[i]);
                hashMap.put(arr[i], count + 1);
            } else {
                hashMap.put(arr[i], 1);
            }
        }

        List<Integer> duplicates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        return duplicates;
    }


}
