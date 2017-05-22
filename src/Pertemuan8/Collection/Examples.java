package Pertemuan8.Collection;

import javax.swing.*;
import java.util.*;

public class Examples {

    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        LinkedList<Integer> linkedList = new LinkedList<>();
//
//        Scanner scanner = new Scanner(System.in);
//        int input;
//        while((input = scanner.nextInt()) != 0)
//            linkedList.add(input);
//
//        for(Integer i : linkedList)
//            System.out.println(i);
//        HashMap<String, String> hashMap = new HashMap<>();
//        Scanner scanner = new Scanner(System.in);
//        String kunci, nilai;
//        do {
//            System.out.print("Kunci : ");
//            kunci = scanner.nextLine();
//            System.out.print("Nilai : ");
//            nilai = scanner.nextLine();
//            hashMap.put(kunci, nilai);
//        } while(! nilai.equals("STOP"));
//
//        Iterator iterator = hashMap.entrySet().iterator();
//        while(iterator.hasNext()) {
//            Map.Entry entry = (Map.Entry) iterator.next();
//            System.out.println(entry.getKey() + " => " +
//                entry.getValue());
//        }

        Vector<Integer> list = new Vector<>();
        Scanner scanner = new Scanner(System.in);

        int val;
        while((val = scanner.nextInt()) > 0)
            list.add(val);

        for(Integer i : list)
            System.out.println(i);
        for(Integer i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
