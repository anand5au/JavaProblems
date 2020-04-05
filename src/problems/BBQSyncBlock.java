package problems;

public class BBQSyncBlock {
    int front, size, capacity;
    int[] array;
    Object lock;

    public BBQSyncBlock(int capacity) {
        front = 0;
        size = 0;
        this.capacity = capacity;
        array = new int[capacity];
        lock = new Object();
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized(lock) {
            while(size == capacity){
                lock.wait();
            }
            array[(front + size)%capacity] = element;
            size++;
            lock.notifyAll();
        }
    }

    public int dequeue() throws InterruptedException {
        synchronized(lock) {
            while(size == 0) {
                lock.wait();
            }
            int frontVal = array[front++];
            front %= capacity;
            size--;
            lock.notifyAll();
            return frontVal;
        }
    }

    public int size() {
        return size;
    }
}
