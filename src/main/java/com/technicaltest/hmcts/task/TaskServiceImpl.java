package com.technicaltest.hmcts.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicaltest.hmcts.errorhandlers.ResourceNotFoundException;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task entity) {
       
        Task savedTask = taskRepository.save(entity);
        return savedTask;
    }

    @Override
    public Task getTaskById(Long taskId) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task does not exist with id: " + taskId));
        return task;
    }

    @Override
    public List<Task> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks;
    }

    @Override
    public Task updateTask(Task entity) {
        if (entity.getId() == null) {
            throw new ResourceNotFoundException("Task id has to be present for update");
        }

        Task updatedTask = taskRepository.save(entity);
        return updatedTask;
    }

    @Override
    public void deleteTask(Long taskId) {
         taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task does not exist with id: " + taskId));

        taskRepository.deleteById(taskId);
    }

}
