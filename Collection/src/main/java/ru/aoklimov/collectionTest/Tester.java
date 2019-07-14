package ru.aoklimov.collectionTest;

import java.util.*;

public class Tester {
    private static final Integer TEST_AMOUNT = 1000000;

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Integer deleting = new Random().nextInt(TEST_AMOUNT);

        testCollection(hashSet, TEST_AMOUNT, deleting);
        testMap(hashMap, TEST_AMOUNT, deleting);

        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        testCollection(linkedList, TEST_AMOUNT, deleting);
        testCollection(arrayList, TEST_AMOUNT, deleting);
        testCollection(treeSet, TEST_AMOUNT, deleting);
    }

    private static void testCollection(Collection<Integer> collection, Integer amount, Integer deletingNumber) {

        Long startAdding = System.currentTimeMillis();
        for (int counter = 0; counter < amount; counter++) {
            collection.add(counter);
        }
        Long endAdding = System.currentTimeMillis();
        Long startDeleting = System.currentTimeMillis();
        collection.remove(deletingNumber);
        Long endDeleting = System.currentTimeMillis();

        System.out.println("Collection: " + collection.getClass().getName() + "\n" +
                "Adding: " + (endAdding - startAdding) + " ms\n" +
                "Deleting: " + (endDeleting - startDeleting) + " ms\n");
    }

    private static void testMap(Map<Integer, Integer> map, Integer amount, Integer deletingNumber) {

        Long startAdding = System.currentTimeMillis();
        for (int counter = 0; counter < amount; counter++) {
            map.put(counter, counter);
        }
        Long endAdding = System.currentTimeMillis();
        Long startDeleting = System.currentTimeMillis();
        map.remove(deletingNumber);
        Long endDeleting = System.currentTimeMillis();

        System.out.println("Map: " + map.getClass().getName() + "\n" +
                "Adding: " + (endAdding - startAdding) + " ms\n" +
                "Deleting: " + (endDeleting - startDeleting) + " ms\n");
    }

}
