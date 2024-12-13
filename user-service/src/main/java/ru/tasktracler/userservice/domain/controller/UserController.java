package ru.tasktracler.userservice.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tasktracler.userservice.domain.dto.UserResponse;
import ru.tasktracler.userservice.external.client.TaskService;
import ru.tasktracler.userservice.external.dto.TaskRequest;
import ru.tasktracler.userservice.external.dto.TaskResponse;
import ru.tasktracler.userservice.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final TaskService taskService;

    @Autowired
    public UserController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<UserResponse> getUser(@RequestParam(required = false) Long id,
                                                @RequestParam(required = false) String email) {
        UserResponse userResponse;
        if (id != null) {
            userResponse = userService.getUserById(id);
        } else {
            userResponse = userService.getUserByEmail(email);
        }
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PostMapping("/createTask")
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest taskRequest) {
        return taskService.createTask(taskRequest);
    }

    @GetMapping("/{id}/tasks")
    public List<TaskResponse> getTasksByUserId(@PathVariable("id") Long userId) {
        return taskService.getTasksByUserId(userId);
    }

}
