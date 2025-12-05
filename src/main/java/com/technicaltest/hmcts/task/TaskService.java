package com.technicaltest.hmcts.task;

import java.util.List;

public interface TaskService {

    Task createTask(Task entity);

    Task getTaskById(Long taskId);

    List<Task> getTasks();

    Task updateTask(Task entity);

    void deleteTask(Long taskId);
    

}
