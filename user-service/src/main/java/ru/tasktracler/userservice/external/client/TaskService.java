package ru.tasktracler.userservice.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tasktracler.userservice.external.dto.TaskRequest;
import ru.tasktracler.userservice.external.dto.TaskResponse;

import java.util.List;

@FeignClient("TASK-SERVICE/tasks")
public interface TaskService {

    @GetMapping("/byUser")
    List<TaskResponse> getTasksByUserId(@RequestParam("id") Long userId);

    @PostMapping
    ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest taskRequest);

}
