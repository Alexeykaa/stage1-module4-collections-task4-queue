package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {

    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        Queue<Integer> currentQueue = new LinkedList<>(firstQueue);
        Queue<Integer> nextQueue = new LinkedList<>(secondQueue);

        addTwoCards(result, currentQueue);
        addTwoCards(result, nextQueue);
        while (!currentQueue.isEmpty()) {
            currentQueue.add(result.pollLast());
            addTwoCards(result, currentQueue);

            // swap players
            Queue<Integer> temp = currentQueue;
            currentQueue = nextQueue;
            nextQueue = temp;
        }
        return result;
    }

    private void addTwoCards(ArrayDeque<Integer> result, Queue<Integer> queue) {
        result.add(queue.poll());
        result.add(queue.poll());
    }
}
