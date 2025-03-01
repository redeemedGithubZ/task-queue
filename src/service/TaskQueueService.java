package service;

import model.Task;

import java.util.LinkedList;

public class TaskQueueService {
    LinkedList<Task> queue = new LinkedList<>();

    public void enqueue(Task task) {
        queue.add(task);
    }

    public String listTasks(){
        return queue.toString();
    }

    public Task dequeue(){
        return queue.poll();
    }

}
