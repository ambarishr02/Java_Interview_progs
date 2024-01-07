import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfStream {
	static PriorityQueue minHeap = new PriorityQueue();
	static PriorityQueue maxHeap = new PriorityQueue(Collections.reverseOrder());
	static int numberOfElements = 0;

	public static void addNum(int num) {
		maxHeap.add(num);

		if (numberOfElements % 2 == 0) {
			if (minHeap.isEmpty()) {
				numberOfElements++;
				return;
			} else if ((int) maxHeap.peek() > (int) minHeap.peek()) {
				Integer maxHeapRoot = (Integer) maxHeap.poll();
				Integer minHeapRoot = (Integer) minHeap.poll();
				maxHeap.add(minHeapRoot);
				minHeap.add(maxHeapRoot);
			}
		} else {
			minHeap.add(maxHeap.poll());
		}
		
		numberOfElements++;
	}

	public static Double findMedian() {
		if (numberOfElements % 2 != 0)
			return new Double((double) maxHeap.peek());
		else
			return ((int) maxHeap.peek() + (int)minHeap.peek()) / 2.0;

	}

	public static void main(String[] args) {
		addNum(2);
		addNum(5);
		addNum(8);
		addNum(28);

		System.out.println("Median " + findMedian());
	}
}
