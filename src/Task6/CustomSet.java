package Task6;


import java.util.HashMap;


public class CustomSet<T> {
    private static final Object PRESENT = new Object();
    private final HashMap<T, Object> map;

    public CustomSet() {
        this.map = new HashMap<>();
    }

    public boolean add(T element) {
        return map.put(element, PRESENT) == null;
    }

    public void remove(T element) {
        map.remove(element);
    }

    public boolean contains(T element) {
        return map.containsKey(element);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public void clear() {
        map.clear();
    }
    public String toString() {
        return map.keySet().toString().replace("[", "").replace("]", "");
    }

    public static void main(String[] args) {
        CustomSet<String> customSet = new CustomSet<>();
        customSet.add("aboba");
        customSet.add("bob");
        customSet.add("bob2");
        customSet.add("sigiroyven");
        System.out.println(customSet);
        customSet.remove("aboba");
        System.out.println(customSet);
        System.out.println(customSet.isEmpty());
        System.out.println(customSet.contains("bob"));
        System.out.println(customSet.size());
        customSet.clear();
        System.out.println(customSet);
    }
}