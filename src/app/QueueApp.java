package app;

import model.Task;
import service.TaskQueueService;

import java.util.Scanner;

public class QueueApp {
     public static void main (String[] args){
         Scanner scanner = new Scanner(System.in);
         TaskQueueService taskQueueService = new TaskQueueService();
         int input;
         do{
             System.out.println("Enter a number 1-4");
             System.out.println("1 = add a task");
             System.out.println("2 = list all tasks");
             System.out.println("3 = remove and display next task");
             System.out.println("4 = exit");
             input = scanner.next().charAt(0);

             if (input == '1'){
                 System.out.println("Enter an ID: ");
                 int id = scanner.nextInt();
                 System.out.println("Enter a description:");
                 scanner.nextLine();
                 String description = scanner.nextLine();
                 taskQueueService.enqueue(new Task(id, description));
             }
             else if (input == '2'){
                 System.out.println(taskQueueService.listTasks());
             }
             else if (input == '3'){
                Task task = taskQueueService.dequeue();
                if (task == null){
                    System.out.println("No task available");
                }
                else{
                    System.out.println("Next task: " + task);
                }

             }
             else if (input != '4'){
                System.out.println("Invalid input. Enter 1, 2, 3, or 4");
             }



         }while (input != '4');
     }
}
