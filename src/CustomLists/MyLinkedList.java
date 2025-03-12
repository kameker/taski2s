package CustomLists;

import java.util.Iterator;

public class MyLinkedList<Integer> implements Iterable<Integer> {

    private class LinkedListsItem<Integer> {
        public Integer value;
        public LinkedListsItem<Integer> next;

        public LinkedListsItem(Integer value, LinkedListsItem<Integer> next) {
            this.value = value;
            this.next = next;
        }

        public LinkedListsItem(Integer value) {
            this.value = value;
        }

        public LinkedListsItem() {
            this(null, null);
        }
    }

    private LinkedListsItem<Integer> head = null;
    private LinkedListsItem<Integer> tail = null;
    private int count = 0;

    private void checkEmpty() throws SimpleLinkedListException {
        if (isEmpty()) {
            throw new SimpleLinkedListException("List is empty");
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Integer getFirst() throws SimpleLinkedListException {
        checkEmpty();
        return head.value;
    }

    public Integer getLast() throws SimpleLinkedListException {
        checkEmpty();
        return tail.value;
    }

    private LinkedListsItem<Integer> getItem(int index) throws SimpleLinkedListException {
        if (index < 0 || index >= count) {
            throw new SimpleLinkedListException("Incorrect index");
        }
        LinkedListsItem<Integer> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public void addFirst(Integer value) {
        head = new LinkedListsItem<>(value, head);
        if (tail == null) {
            tail = head;
        }
        count++;
    }

    public void addLast(Integer value) {
        if (tail == null) {
            head = tail = new LinkedListsItem<>(value);
        } else {
            tail = tail.next = new LinkedListsItem<>(value);
        }
        count++;
    }

    public void insert(int index, Integer value) throws SimpleLinkedListException {
        if (index < 0 || index > count) {
            throw new SimpleLinkedListException("Incorrect index");
        }
        if (index == 0) {
            addFirst(value);
        } else {
            LinkedListsItem<Integer> prev = getItem(index - 1);
            prev.next = new LinkedListsItem<>(value, prev.next);
            if (prev.next.next == null) {
                tail = prev.next;
            }
            count++;
        }
    }

    public Integer removeFirst() throws SimpleLinkedListException {
        checkEmpty();
        Integer value = getFirst();
        head = head.next;
        if (head == null) {
            tail = null;
        }
        count--;
        return value;
    }

    public Integer get(int index) throws SimpleLinkedListException {
        return getItem(index).value;
    }

    public Integer removeLast() throws SimpleLinkedListException {
        return remove(count - 1);
    }

    public Integer remove(int index) throws SimpleLinkedListException {
        if (index == 0) {
            return removeFirst();
        } else {
            LinkedListsItem<Integer> prev = getItem(index - 1);
            Integer value = prev.next.value;
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
            count--;
            return value;
        }
    }

    public void clear() {
        head = tail = null;
        count = 0;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            LinkedListsItem<Integer> curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public Integer next() {
                Integer value = curr.value;
                curr = curr.next;
                return value;
            }
        };
    }


}

