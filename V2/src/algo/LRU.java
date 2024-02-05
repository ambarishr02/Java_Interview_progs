package algo;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class LRU {

    Deque<Integer> qDeque = null;
    int CACHE_SIZE = 3;
    Set<Integer> set = null;

    public LRU(int size) {
        this.CACHE_SIZE = size;
        qDeque = new LinkedList<>();
        set = new HashSet<>();
    }

    int refer(Integer v) {
      if (!set.contains(v)) {
            if (qDeque.size() >= this.CACHE_SIZE) {
                int poll = qDeque.removeLast();
                set.remove(poll);
            }
        } else {
            qDeque.remove(v);

        }
        qDeque.push(v);
        set.add(v);
        return 0;
    }

    public void display() {
        Iterator<Integer> itr = qDeque.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public static void main(String[] args) {
        LRU cache = new LRU(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);
        cache.refer(2);
        cache.refer(2);
        cache.refer(1);
        cache.display();
    }
}
