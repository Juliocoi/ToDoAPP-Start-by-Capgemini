package model;

import java.util.Date;

public class Task {

    private int id;
    private int idProject;
    private String name;
    private String Description;
    private boolean isCompleted;
    private String notes;
    private Date deadLine;
    private Date createdAt;
    private Date updatedAt;

    public Task(int id, int idProject, String name, String Description, boolean isCompleted, String notes, Date deadLine, Date createdAt, Date updatedAt) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.Description = Description;
        this.isCompleted = isCompleted;
        this.notes = notes;
        this.deadLine = deadLine;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", Description=" + Description + ", isCompleted=" + isCompleted + ", notes=" + notes + ", deadLine=" + deadLine + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }

}
