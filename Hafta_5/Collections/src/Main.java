import java.util.*;

public class Main {
    public static void main(String[] args) {
        //HashSet
        HashSet<String> stringHash = new HashSet<>();
        stringHash.add("Foo");
        stringHash.add("Bar");
        stringHash.add("Baz");
        stringHash.add(null);

        stringHash.forEach(System.out::println);
        System.out.println("I am a HashSet and here is my output: ");
        System.out.println("---------");
        stringHash.remove("Baz");
        stringHash.forEach(System.out::println);
        System.out.println("---------");

        System.out.println(stringHash.size());
        System.out.println(stringHash.contains("Baz"));
        System.out.println("---------");

        //Iterator Object
        Iterator<String> itrForStrHash = stringHash.iterator();
        while (itrForStrHash.hasNext()){
            System.out.println("I am an iterator and I am iterating over the HashSet: " + itrForStrHash.next());
        }

        //LinkedHashSet
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(10);
        linkedHashSet.add(20);
        linkedHashSet.add(30);
        System.out.println("---------");
        System.out.println("I am a Linked HashSet and here are my values:");
        linkedHashSet.forEach(System.out::println);
        System.out.println("---------");

        //TreeSet with primitives
        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        integerTreeSet.add(42);
        integerTreeSet.add(314);
        integerTreeSet.add(23);
        integerTreeSet.add(212);
        integerTreeSet.add(17);
        System.out.println("---------");
        System.out.println("I am a TreeSet and I ordered my elements. Here is the output:");
        integerTreeSet.forEach(System.out::println);
        System.out.println("---------");
        System.out.println("I am a TreeSet and I ordered my Student elements by their marks. I implemented a custom comparator." +
                " Here is the output:");
        TreeSet<Student> treeSetStudent = new TreeSet<>();
        treeSetStudent.add(new Student("John Doe", 100));
        treeSetStudent.add(new Student("Mary Sue", 42));
        treeSetStudent.add(new Student("Joseph Jacob", 85));
        treeSetStudent.add(new Student("Donald Draper", 0));
        treeSetStudent.add(new Student("Walter White", 250));

        treeSetStudent.forEach(student -> {System.out.println(student.getMarks());});

        //ArrayList
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Foo");
        stringArrayList.add("Bar");
        stringArrayList.add("Baz");
        stringArrayList.add("Buzz");
        stringArrayList.add("FizzBuzz");
        System.out.println("---------");
        System.out.println("I am an ArrayList.");
        System.out.println("As an ArrayList, I am blazingly fast at fetching a data from a given index. " +
                "My time complexity is O(1), constant time. But my cousin LinkedList is better at adding elements. " +
                "Because of pointers. Isn't computers amazing?");
        System.out.println(stringArrayList);
        System.out.println("My size is: " + stringArrayList.size());
        System.out.println("My element Bar is in index: " + stringArrayList.indexOf("Bar"));
        System.out.println("I am changing my element in index 1 with FooBar: ");
        stringArrayList.set(1, "FooBar");
        System.out.println(stringArrayList);
        System.out.println("I am adding element Fizz to index 1 and shifting all the values right: ");
        stringArrayList.add(1, "Fizz");
        System.out.println(stringArrayList);
        System.out.println("---------");
        System.out.println("I am a new ArrayList but I contain all the elements from the first one!");
        ArrayList<String> newStringArrayList = new ArrayList<>(stringArrayList);
        System.out.println(newStringArrayList);
        System.out.println("I am a new ArrayList and I contain the elements of the first list " +
                "but only from indexes 0 to 2! Don't forget the last parameter of the subList method is not inclusive!");
        ArrayList<String> newStringArrayList2 = new ArrayList<>(stringArrayList.subList(0,3));
        System.out.println(newStringArrayList2);
        Object[] arrayListToArray = stringArrayList.toArray();
        System.out.println("I am an array created from the ArrayList!");
        for (Object str: arrayListToArray) {
            System.out.println(str);
        }

        //LinkedList
        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("Foo");
        stringLinkedList.add("Bar");
        stringLinkedList.add("Baz");
        stringLinkedList.add("Fizz");
        System.out.println("---------");
        System.out.println("I am a LinkedList! I have pointers! I am faster at changing the elements of the list. " +
                "My time complexity is O(1), constant time. But I am slower at fetching data from a given " +
                "index then an ArrayList.");
        System.out.println(stringLinkedList);

        //Vectors
        Vector<String> stringVector = new Vector<>();
        stringVector.add("Foo");
        stringVector.add("Bar");
        stringVector.add("Baz");
        stringVector.add("Fizz");
        System.out.println("---------");
        System.out.println("I am a Vector! I am a bit old school, but I still have uses! Please don't forget me...");
        System.out.println(stringVector);
        //Queue
        Queue<String> stringQueue = new LinkedList<>();
        stringQueue.offer("Foo");
        stringQueue.offer("Bar");
        stringQueue.offer("Baz");
        stringQueue.offer("Fizz");
        System.out.println("---------");
        System.out.println("I am a LinkedList that implements queue! Remember First In First Out!");
        System.out.println(stringQueue);
        System.out.println("Let's poll (remove) the first 2 elements that entered the queue:");
        stringQueue.poll();
        stringQueue.poll();
        System.out.println(stringQueue);

        //Priority Queue
        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        stringPriorityQueue.add("Foo");
        stringPriorityQueue.add("Bar");
        stringPriorityQueue.add("Baz");
        System.out.println("---------");
        while (!stringPriorityQueue.isEmpty()) {
            System.out.println(stringPriorityQueue.poll());
        }

        //HashMap

        Map<String, Integer> workerID = new HashMap<>();
        workerID.put("Donald Draper" , 1);
        workerID.put("Walter White" , 2);
        workerID.put("Roger Sterling" , 3);
        workerID.put("Raylan Givens" , 4);
        workerID.put("Steve Smith" , 5);
        System.out.println("---------");
        System.out.println("I am a HashMap! I have key - value pairs. You'll learn to love me.");
        for (String worker: workerID.keySet()) {
            System.out.println("(key) Worker name: " + worker + " | (value) ID: " + workerID.get(worker));
        }

        //Linked HashMap
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Conan O Brien", 42);
        linkedHashMap.put("Norm Macdonald", 69);
        linkedHashMap.put("Louis CK", 31);
        linkedHashMap.put("Bill Burr", 420);
        System.out.println("---------");
        System.out.println("I am a Linked HashMap! I will preserve the entrance order that you give me.");
        for (String str: linkedHashMap.keySet()){
            System.out.println(str + " " + linkedHashMap.get(str));
        }

        //TreeMap
        TreeMap<String, Integer> workerProfit = new TreeMap<>();
        workerProfit.put("Adam Kovic", 69420);
        workerProfit.put("James Willems", 265144);
        workerProfit.put("Bruce Greene", 564654);
        workerProfit.put("Norm Macdonald", 1);
        workerProfit.put("Lawrance Sonntag", 3213213);
        System.out.println("---------");
        System.out.println("I am a TreeMap! I sort the keys if I can! Don't forget, you can give me a custom Comparator!");
        for (String worker: workerProfit.keySet()){
            System.out.println(worker + " " + workerProfit.get(worker));
        }






    }
}