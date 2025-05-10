package edu.kh.todo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.mapper.TodoMapper;

@SpringBootTest
class TodoListApplicationTests {

	@Test
	void contextLoads() {
	}

    @Autowired
    private TodoMapper mapper;

    @Test
    public void testSelectAll() {
        List<Todo> todoList = mapper.selectAll();
        
        for (Todo todo : todoList) {
            System.out.println(todo);
        }
    }

}
