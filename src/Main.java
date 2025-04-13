public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyArrayList<>();

        System.out.println("=== TEST: MyArrayList ===");

        list.add(5);
        list.add(10);
        list.add(15);
        list.addFirst(1);
        list.addLast(20);

        System.out.println("List after adding elements:");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        System.out.println("Element at index 2: " + list.get(2));

        list.set(2, 99);
        System.out.println("After setting index 2 to 99:");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        list.removeFirst();
        list.removeLast();
        System.out.println("After removing first and last:");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Index of 99: " + list.indexOf(99));
        System.out.println("Exists 15? " + list.exists(15)); //

        list.sort();
        System.out.println("After sorting:");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("List size: " + list.size());

        list.clear();
        System.out.println("List cleared. Size now: " + list.size());
    }
}
