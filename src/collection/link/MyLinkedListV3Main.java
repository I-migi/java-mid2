package collection.link;

public class MyLinkedListV3Main {
    public static void main(String[] args) {
        MyLinkedListV3<String> stringlist = new MyLinkedListV3<>();

        stringlist.add("a");
        stringlist.add("b");
        stringlist.add("c");
        String string = stringlist.get(0);
        System.out.println("string = " + string);

        MyLinkedListV3<Integer> integerlist = new MyLinkedListV3<>();
        integerlist.add(1);
        integerlist.add(2);
        integerlist.add(3);
        Integer integer = integerlist.get(0);
        System.out.println("integer = " + integer);
    }
}
