import ru.vsu.cs.util.ArrayUtils;

import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length < 1 || args.length > 3) throw new Exception("Enter arguments in this order:" +
                "1)con or win" + "2)input file name" + "3)output file name");//in this order перевод: в такой последовательности
        if (args[0].equals("con")) {
            consoleStart(args);
        } else {
            if (args[0].equals("win")) {
                winStart(args);
            } else {
                throw new Exception("First argument wrong");
            }
        }

    }

    static void winStart(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new FrameMain(args).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    static void consoleStart(String[] args) throws Exception {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        Arguments arguments = new Arguments(args);
        int[] arrOfValues = arguments.arrFromConsoleOrFile();

        convertArrToLinkedList(arrOfValues, list);

        System.out.println("------------");
        System.out.println("Size old linkedList:  " + list.size());
        printLinkedList(list);
        System.out.println("\n" + "------------");

        MyLinkedList<Integer> mixedList = MixLinkedList.mixedListOfIntegerV2(list);

        System.out.println("Size mixed linkedList:  " + mixedList.size());
        System.out.println("Mixed linkedList: ");
        printLinkedList(mixedList);
        System.out.println("\n" + "------------");

        arguments.writeLinkedListToFile(mixedList);
    }

    static void convertArrToLinkedList(int[] arr, MyLinkedList list) {
        for (int i = 0; i < arr.length; i++) {
            list.addFirst(arr[i]);
        }
    }

    static void printLinkedList(MyLinkedList list) {
        for (Object v : list) {
            System.out.print(v + ",  ");
        }
    }
}
