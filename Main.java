import java.util.Iterator;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        LinkedArrayList<String> list = new LinkedArrayList<>();

        ListIterator<String> iterator = list.listIterator();

        System.out.println("Add to LinkedArrayList : ");

        System.out.println("The number of node before add operation (each node has 5 element capacity) : " +  list.getCurrentSizeList());

        System.out.println("5 added");
        list.add("5");
        System.out.println("6 added");
        list.add("6");
        System.out.println("7 added");
        list.add("7");
        System.out.println("8 added");
        list.add("8");
        System.out.println("9 added");
        list.add("9");
        System.out.println("10 added");
        list.add("10");
        System.out.println("11 added");
        list.add("11");
        System.out.println("12 added");
        list.add("12");
        System.out.println("13 added");
        list.add("13");
        System.out.println("14 added");
        list.add("14");
        System.out.println("15 added");
        list.add("15");
        System.out.println("16 added");
        list.add("16");
        System.out.println("17 added");
        list.add("17");

        System.out.print("LIST : ");
        //Prints LinkedArrayList using my custom iterator class.
        while(iterator.hasNext()){
            iterator.next();
        }

        System.out.println();
        System.out.println("The number of node after add operation : " +  list.getCurrentSizeList());
        System.out.println();

        iterator = list.listIterator();
        System.out.println("List before remove operations");
        System.out.println("LIST :");
        while(iterator.hasNext()){
            iterator.next();
        }
        System.out.println();

        System.out.println("Deleted Index of 2.");
        list.remove(2);
        iterator = list.listIterator();

        System.out.println("LIST :");
        while(iterator.hasNext()){
            iterator.next();
        }
        System.out.println();
        System.out.println("Deleted Index of 7.");
        list.remove(7);
        iterator = list.listIterator();

        System.out.println("LIST :");
        while(iterator.hasNext()){
            iterator.next();
        }
        System.out.println();
        System.out.println("Deleted Index of 4.");
        list.remove(4);
        iterator = list.listIterator();

        System.out.println("LIST :");
        while(iterator.hasNext()){
            iterator.next();
        }
        System.out.println();
        System.out.println("Deleted Index of 5.");
        list.remove(5);
        iterator = list.listIterator();

        System.out.println("Remove operations completed");
        System.out.println();
        System.out.println("LIST :");
        iterator = list.listIterator();
        while(iterator.hasNext()){
            iterator.next();
        }
        System.out.println();

        System.out.println("Change 5. index element with 455 :");

        list.set(5,"455");
        System.out.println();

        iterator = list.listIterator();
        while(iterator.hasNext()){
            iterator.next();
        }
        System.out.println();


        iterator = list.listIterator();
        iterator.add("25");

        iterator = list.listIterator();
        while(iterator.hasNext()){
            iterator.next();
        }
        System.out.println();



    }

}
