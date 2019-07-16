package ru.aoklimov.organization;

public class Task <O extends User, Q extends  User> {

    private O owner;
    private Q qa;
    private String task;

    public Task(O owner, Q qa, String task) {
        this.owner = owner;
        this.qa = qa;
        this.task = task;
    }

    public O getOwner() {
        return owner;
    }

    public void setOwner(O owner) {
        this.owner = owner;
    }

    public Q getQa() {
        return qa;
    }

    public void setQa(Q qa) {
        this.qa = qa;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
