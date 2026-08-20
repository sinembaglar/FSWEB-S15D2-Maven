package org.example;

import org.example.entity.Priority;
import org.example.entity.Status;
import org.example.entity.StringSet;
import org.example.entity.Task;
import org.example.entity.TaskData;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Task listTask = new Task("Java Collections", "Write List Interface", "Ann", Status.IN_QUEUE, Priority.LOW);
        Task setTask = new Task("Java Collections", "Write Set Interface", "Ann", Status.ASSIGNED, Priority.MED);
        Task mapTask = new Task("Java Collections", "Write Map Interface", "Bob", Status.IN_QUEUE, Priority.HIGH);
        Task docTask = new Task("Java Collections", "Write Documentation", "Carol", Status.IN_PROGRESS, Priority.LOW);

        Set<Task> annsTasks = new HashSet<>();
        annsTasks.add(listTask);
        annsTasks.add(setTask);

        Set<Task> bobsTasks = new HashSet<>();
        bobsTasks.add(mapTask);
        bobsTasks.add(setTask);

        Set<Task> carolsTasks = new HashSet<>();
        carolsTasks.add(docTask);

        Set<Task> unassignedTasks = new HashSet<>();

        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, unassignedTasks);

        System.out.println("Ann'in tasklari: " + taskData.getTasks("ann").size());
        System.out.println("Tum tasklar: " + taskData.getTasks("all").size());
        System.out.println("Atanmamis tasklar: " + taskData.getTasks("unassigned").size());

        Set<Task> birdenFazlaKisiye = taskData.getIntersection(annsTasks, bobsTasks);
        System.out.println("Hem Ann hem Bob'da olan tasklar: " + birdenFazlaKisiye);

        Set<Task> sadeceAnn = taskData.getDifferences(annsTasks, bobsTasks);
        System.out.println("Sadece Ann'de olan tasklar: " + sadeceAnn);

        System.out.println("Unique kelime sayisi: " + StringSet.findUniqueWords().size());
    }
}
