package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskMapperTestSuite {
    @Autowired
    private TaskMapper taskMapper;

    @Test
    void mapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "test_title", "test_content");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertAll(
                () -> assertEquals(1L, task.getId()),
                () -> assertEquals("test_title", task.getTitle()),
                () -> assertEquals("test_content", task.getContent())
        );
    }

    @Test
    void mapToTaskDto() {
        //Given
        Task task = new Task(1L, "test_title", "test_content");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertAll(
                () -> assertEquals(1L, taskDto.getId()),
                () -> assertEquals("test_title", taskDto.getTitle()),
                () -> assertEquals("test_content", taskDto.getContent())
        );
    }

    @Test
    void mapToTaskDtoList() {
        //Given
        Task task1 = new Task(1L, "test_title1", "test_content1");
        Task task2 = new Task(2L, "test_title2", "test_content2");
        Task task3 = new Task(3L, "test_title3", "test_content3");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);

        //When
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertAll(
                () -> assertEquals(3, taskDtos.size()),
                () -> assertEquals("test_title1", taskDtos.get(0).getTitle()),
                () -> assertEquals("test_content2", taskDtos.get(1).getContent()),
                () -> assertEquals(3L, taskDtos.get(2).getId())
        );
    }

        @Test
        void mapToTaskDtoListEmpty() {
            //Given
            List<Task> taskList = new ArrayList<>();

            //When
            List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(taskList);

            //Then
            assertAll(
                    () -> assertNotNull(taskDtos),
                    () -> assertEquals(0, taskDtos.size())
            );
    }
}