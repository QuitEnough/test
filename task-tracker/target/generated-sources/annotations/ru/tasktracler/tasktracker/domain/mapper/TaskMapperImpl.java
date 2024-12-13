package ru.tasktracler.tasktracker.domain.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.tasktracler.tasktracker.domain.dto.TaskRequest;
import ru.tasktracler.tasktracker.domain.dto.TaskResponse;
import ru.tasktracler.tasktracker.domain.entity.Task;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-12T18:22:27+0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskResponse toTaskResponse(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskResponse.TaskResponseBuilder taskResponse = TaskResponse.builder();

        taskResponse.taskId( task.getId() );
        taskResponse.title( task.getTitle() );
        taskResponse.description( task.getDescription() );
        taskResponse.status( task.getStatus() );
        taskResponse.expirationDate( task.getExpirationDate() );
        taskResponse.userId( task.getUserId() );

        return taskResponse.build();
    }

    @Override
    public TaskRequest toTaskRequest(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskRequest.TaskRequestBuilder taskRequest = TaskRequest.builder();

        taskRequest.taskId( task.getId() );
        taskRequest.title( task.getTitle() );
        taskRequest.description( task.getDescription() );
        taskRequest.status( task.getStatus() );
        taskRequest.expirationDate( task.getExpirationDate() );
        taskRequest.userId( task.getUserId() );

        return taskRequest.build();
    }

    @Override
    public Task toTask(TaskRequest taskRequest) {
        if ( taskRequest == null ) {
            return null;
        }

        Task.TaskBuilder task = Task.builder();

        task.title( taskRequest.getTitle() );
        task.description( taskRequest.getDescription() );
        task.status( taskRequest.getStatus() );
        task.expirationDate( taskRequest.getExpirationDate() );
        task.userId( taskRequest.getUserId() );

        return task.build();
    }
}
