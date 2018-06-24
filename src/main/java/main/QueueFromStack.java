package main;

import java.util.Stack;

public class QueueFromStack<E> {
    private Stack<E> inbox = new Stack<E>();
    private Stack<E> outbox = new Stack<E>();

    public static void main(String[] args) {
        QueueFromStack<Integer> queue = new QueueFromStack();
        queue.queue(1);
        queue.queue(2);
        queue.queue(3);
        System.out.println(queue.dequeue());
    }

    public void queue(E item) {
        inbox.push(item);
    }

    public E dequeue() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
        return outbox.pop();
    }
}
