package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks,
                    Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getTasks(String name) {
        if (name == null) {
            return new HashSet<>();
        }

        switch (name.toLowerCase()) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "unassigned":
                return unassignedTasks;
            case "all":
                Set<Task> all = new HashSet<>();
                all.addAll(annsTasks);
                all.addAll(bobsTasks);
                all.addAll(carolsTasks);
                all.addAll(unassignedTasks);
                return all;
            default:
                return new HashSet<>();
        }
    }

    public Set<Task> getUnion(Set<Task> first, Set<Task> second) {
        Set<Task> union = new HashSet<>(first);
        union.addAll(second);
        return union;
    }

    public Set<Task> getIntersection(Set<Task> first, Set<Task> second) {
        Set<Task> intersection = new HashSet<>(first);
        intersection.retainAll(second);
        return intersection;
    }

    public Set<Task> getDifferences(Set<Task> first, Set<Task> second) {
        Set<Task> differences = new HashSet<>(first);
        differences.removeAll(second);
        return differences;
    }
}
