package Task2;

import CustomLists.MyLinkedList;
import CustomLists.SimpleLinkedListException;

public class MergeSort {
    public static MyLinkedList<Integer> sliceMyLinkedList(MyLinkedList<Integer> list, int start, int end) throws SimpleLinkedListException {
        MyLinkedList<Integer> result = new MyLinkedList<>();
        for (int i = start; i < end; i++) {
            result.addLast(list.get(i));
        }
        return result;
    }
    public static MyLinkedList<Integer> mergeSort(MyLinkedList<Integer> list) throws SimpleLinkedListException {
        if (list.size() <= 1){
            return list;
        }
        int mid = list.size() / 2;
        MyLinkedList<Integer> left = mergeSort(sliceMyLinkedList(list,0,mid));
        MyLinkedList<Integer> right = mergeSort(sliceMyLinkedList(list,mid,list.size()));
        return mergeLists(left,right);

    }
    public static MyLinkedList<Integer> mergeLists(MyLinkedList<Integer> left,MyLinkedList<Integer> right) throws SimpleLinkedListException {
        MyLinkedList<Integer> merged = new MyLinkedList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                merged.addLast(left.get(i));
                i += 1;
            }else{
                merged.addLast(right.get(j));
                j += 1;
            }
        }
        while (i < left.size()) {
            merged.addLast(left.get(i));
            i++;
        }
        while (j < right.size()) {
            merged.addLast(right.get(j));
            j++;
        }
        return merged;

    }
    public static void main(String[] args) throws SimpleLinkedListException {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(1);
        list.addFirst(3);
        list.addFirst(2);
        MyLinkedList<Integer> list2 = mergeSort(list);
        for (int i = 0 ; i < list2.size() ; i++) {
            System.out.println(list2.get(i));
        }

    }
}
