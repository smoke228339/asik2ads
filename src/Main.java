public class Main {
    public static void main(String[] args) {
        System.out.println("MyArrayList:");

        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(5);
        list.add(30);
        list.add(20);

        System.out.println("Элементы после добавления:");
        for (Integer item : list) {
            System.out.print(item + " ");
        }
        System.out.println();

        System.out.println("Sorted:");
        for (Integer item : list) {
            System.out.print(item + " ");
        }
        System.out.println();

        list.remove(1);
        System.out.println("Элементы после удаления второго элемента:");
        for (Integer item : list) {
            System.out.print(item + " ");
        }
        System.out.println();

        System.out.println("sizeoflist" + list.size());

        // Тест для MyStack
        System.out.println("\nMyStack:");

        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Элементы в стеке:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
