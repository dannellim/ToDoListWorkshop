import java.io.Console;
import java.util.Collection;

import org.junit.*;
import org.junit.Test;
import junit.framework.*;


public class ToDoListTest extends TestCase{
	// Define Test Fixtures

	private ToDoList TO_DO_LIST = new ToDoList();

	public ToDoListTest() {
		super();
	}
	@Before
	 public void setUp() throws Exception{
		//Initialise Test Fixtures
	}
	@After
	 public void tearDown() throws Exception{
		// Uninitialise test Fixtures
	}

	@Test
	public void testAddTask() {
		assertTrue(TO_DO_LIST.getAllTasks().isEmpty());
		Task task = new Task("testAddTask");
		TO_DO_LIST.addTask(task);
		assertTrue(!TO_DO_LIST.getAllTasks().isEmpty());
		//check if ToDoList is empty
		//add into list
		//check list is not empty
		//fail("Not implemented yet");
	}
	@Test
	public void testgetStatus() {
		//create list
		//add task with desc getStatus setStatus = completed/true
		//insert into list
		//get the task from list
		//get the status
		TO_DO_LIST = new ToDoList();
		Task completedTask = new Task("completedTask", true);
		Task incompletedTask = new Task("incompletedTask", false);
		TO_DO_LIST.addTask(completedTask);
		TO_DO_LIST.addTask(incompletedTask);
		Task getCompletedTask = TO_DO_LIST.getTask("completedTask");
		assertTrue(getCompletedTask.isComplete());
		Task getIncompletedTask = TO_DO_LIST.getTask("incompletedTask");
		assertFalse(getIncompletedTask.isComplete());
		//fail("Not implemented yet");
	}
	@Test
	public void testRemoveTask() {
		//create new list
		//list should be empty
		//add task
		//list should not be empty
		//remove task
		//list should be empty
		TO_DO_LIST = new ToDoList();
		assertTrue(TO_DO_LIST.getAllTasks().isEmpty());
		Task task = new Task("testRemoveTask");
		TO_DO_LIST.addTask(task);
		assertTrue(!TO_DO_LIST.getAllTasks().isEmpty());
		Task removedTask = TO_DO_LIST.removeTask("testRemoveTask");
		assertTrue(TO_DO_LIST.getAllTasks().isEmpty());
		assertEquals(task, removedTask);
		//fail("Not implemented yet");
	}
	@Test
	public void testGetCompletedTasks() {
		//create list
		//create 2 completed task
		//create 1 incompleted task
		//add all
		//result = 2 tasks returned
		TO_DO_LIST = new ToDoList();
		Task completedTask1 = new Task("completedTask1", true);
		Task completedTask2 = new Task("completedTask2", true);
		Task incompletedTask1 = new Task("incompletedTask1", false);
		TO_DO_LIST.addTask(completedTask1);
		TO_DO_LIST.addTask(completedTask2);
		TO_DO_LIST.addTask(incompletedTask1);
		Collection<Task> completedTasks = TO_DO_LIST.getCompletedTasks();
		int count = completedTasks.size();
		assertEquals(count, 2);
		assertTrue(completedTasks.contains(completedTask1));
		assertTrue(completedTasks.contains(completedTask2));
		//fail("Not implemented yet");
	}
	@Test
	public void testGetImportantTasks() {
		//create list
		//create 1 completed and important task
		//create 1 incompleted and important task
		//create 1 completed and unimportant task
		//create 1 incompleted and unimportant task
		TO_DO_LIST = new ToDoList();
		Task completedImportantTask1 = new Task("Task1", true, true);
		Task incompletedImportantTask2 = new Task("Task2", false, true);
		Task completedUnimportantTask3 = new Task("Task3", true, false);
		Task incompletedUnimportantTask4 = new Task("Task4", false, false);
		TO_DO_LIST.addTask(completedImportantTask1);
		TO_DO_LIST.addTask(incompletedImportantTask2);
		TO_DO_LIST.addTask(completedUnimportantTask3);
		TO_DO_LIST.addTask(incompletedUnimportantTask4);
		Collection<Task> completedTasks = TO_DO_LIST.getImportantTasks();
		int count1 = completedTasks.size();
		assertEquals(count1, 2);
		assertTrue(completedTasks.contains(completedImportantTask1));
		assertTrue(completedTasks.contains(incompletedImportantTask2));
		Task Task3 = TO_DO_LIST.getTask("Task3");
		Task3.setImportant(true);
		Collection<Task> completedTasks2 = TO_DO_LIST.getImportantTasks();
		int count2 = completedTasks2.size();
		assertEquals(count2, 3);
		assertTrue(completedTasks2.contains(completedImportantTask1));
		assertTrue(completedTasks2.contains(incompletedImportantTask2));
		assertTrue(completedTasks2.contains(Task3));
	}
}
