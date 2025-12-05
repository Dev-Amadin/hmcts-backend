package com.technicaltest.hmcts.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/hmcts/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
    Creates a new task.
    @param entity the new Task object
    @return the created task
    */
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task entity) {
        Task savedTask = taskService.createTask(entity);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

  
    /**
     * Returns Task by its id
     * @param taskId the id of the task to get
     * @return Task with the given id
     */
    @GetMapping("{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long taskId) {
        Task task = taskService.getTaskById(taskId);
        return ResponseEntity.ok(task);
    }

     /**
     * Return all tasks
     * @return list of Task objects
     */
    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {

        List<Task> tasks = taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    /**
     * Update task
     * @param entity the Task to be updated
     * @return updated Task
     */
    @PutMapping
    public ResponseEntity<Task> updateTask(@RequestBody Task entity) {
        Task updatedTask = taskService.updateTask(entity);
        return ResponseEntity.ok(updatedTask);
    }

    /**
     * Delete task by its id
     * @param taskId the id of the Task to be deleted
     * @return success message
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable("id") Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task deleted successfully!");
    }

}
