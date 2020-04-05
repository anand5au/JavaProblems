package problems;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {
    int front=0, size=0, capacity;
    int[] array;
    ReentrantLock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while(size == capacity) {
                notFull.await();
            }
            array[(front + size)%capacity] = element;
            size++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while(size == 0) {
                notEmpty.await();
            }
            int frontVal = array[front++];
            front %= capacity;
            size--;
            notFull.signal();
            return frontVal;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        return size;
    }
}