package com.technicaltest.hmcts.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaskServiceImplTest {

    @Autowired
    private TaskService taskService;

    @Test
    void testCreateTask() {
        Task task = new Task();
        task.setTitle("My Task");
        task.setDescription("Test description");
        task.setStatus("CREATED");

        Task saved = taskService.createTask(task);

        assertNotNull(saved.getId());
        assertEquals("My Task", saved.getTitle());
    }

    @Test
    void testGetTaskById() {
        Task task = new Task();
        task.setTitle("Get Task");
        Task saved = taskService.createTask(task);

        Task found = taskService.getTaskById(saved.getId());

        assertEquals(saved.getId(), found.getId());
    }

    @Test
    void testUpdateTask() {
        Task task = new Task();
        task.setTitle("Before update");
        Task saved = taskService.createTask(task);

        saved.setTitle("After update");
        Task updated = taskService.updateTask(saved);

        assertEquals("After update", updated.getTitle());
    }

    @Test
    void testDeleteTask() {
        Task task = new Task();
        task.setTitle("Delete me");
        Task saved = taskService.createTask(task);

        taskService.deleteTask(saved.getId());

        assertThrows(RuntimeException.class, () -> {
            taskService.getTaskById(saved.getId());
        });
    }

}
