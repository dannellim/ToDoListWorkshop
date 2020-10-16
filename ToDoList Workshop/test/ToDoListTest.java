import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	public void testSortByPriority() {
		
		TO_DO_LIST = new ToDoList();
		Task task1 = new Task("1");
		task1.setPriority(1);
		Task task2 = new Task("2");
		task2.setPriority(2);
		Task task3 = new Task("3");
		task3.setPriority(3);
		
		TO_DO_LIST.addTask(task1);
		TO_DO_LIST.addTask(task2);
		TO_DO_LIST.addTask(task3);
		List<Task> sortByPrioritys = (List<Task>) TO_DO_LIST.getSortByPriority();
		assertEquals(task1.getDescription(),sortByPrioritys.get(0).getDescription());
		assertEquals(task2.getDescription(),sortByPrioritys.get(1).getDescription());
		assertEquals(task3.getDescription(),sortByPrioritys.get(2).getDescription());
	}
	
	@Test
	public void testSortByColor() {
		
		TO_DO_LIST = new ToDoList();
		Task redTask = new Task("Red Task");
		redTask.setColorCode(0);
		Task greenTask = new Task("Green Task");
		greenTask.setColorCode(1);
		Task blueTask = new Task("Blue Task");
		blueTask.setColorCode(2);
		
		TO_DO_LIST.addTask(blueTask);
		TO_DO_LIST.addTask(redTask);
		TO_DO_LIST.addTask(greenTask);
		List<Task> sortByColorTasks = (List<Task>) TO_DO_LIST.getSortByColor();
		assertEquals(redTask.getDescription(),sortByColorTasks.get(0).getDescription());
		assertEquals(greenTask.getDescription(),sortByColorTasks.get(1).getDescription());
		assertEquals(blueTask.getDescription(),sortByColorTasks.get(2).getDescription());

		//fail("Not implemented yet");
	}
	
	@Test
	public void testGroupByColor() {
		
		TO_DO_LIST = new ToDoList();
		Task redTask1 = new Task("Red Task1");
		redTask1.setColorCode(0);

		Task redTask2 = new Task("Red Task2");
		redTask2.setColorCode(0);
		
		Task greenTask1 = new Task("Green Task1");
		greenTask1.setColorCode(1);
		Task greenTask2 = new Task("Green Task2");
		greenTask2.setColorCode(1);
		
		Task blueTask1 = new Task("Blue Task1");
		blueTask1.setColorCode(2);
		
		Task blueTask2 = new Task("Blue Task2");
		blueTask2.setColorCode(2);
		
		
		
		TO_DO_LIST.addTask(blueTask1);
		TO_DO_LIST.addTask(blueTask2);

		TO_DO_LIST.addTask(redTask2);
		TO_DO_LIST.addTask(redTask1);
		TO_DO_LIST.addTask(greenTask1);
		TO_DO_LIST.addTask(greenTask2);

		Map<Integer, List<Task>> groupByColorTasks =  TO_DO_LIST.getGroupByColor();;
        
        
        //check group by color red
        assertTrue(groupByColorTasks.get(0).contains(redTask1));
        assertTrue(groupByColorTasks.get(0).contains(redTask2));
        assertFalse(groupByColorTasks.get(0).contains(greenTask1));
        assertFalse(groupByColorTasks.get(0).contains(greenTask2));
        assertFalse(groupByColorTasks.get(0).contains(blueTask1));
        assertFalse(groupByColorTasks.get(0).contains(blueTask2));

      //check group by color green
        assertTrue(groupByColorTasks.get(1).contains(greenTask1));
        assertTrue(groupByColorTasks.get(1).contains(greenTask2));

        assertFalse(groupByColorTasks.get(1).contains(redTask1));
        assertFalse(groupByColorTasks.get(1).contains(redTask2));
        assertFalse(groupByColorTasks.get(1).contains(blueTask1));
        assertFalse(groupByColorTasks.get(1).contains(blueTask2));
        
      //check group by color blue
        assertTrue(groupByColorTasks.get(2).contains(blueTask1));
        assertTrue(groupByColorTasks.get(2).contains(blueTask2));

        assertFalse(groupByColorTasks.get(2).contains(redTask1));
        assertFalse(groupByColorTasks.get(2).contains(redTask2));
        assertFalse(groupByColorTasks.get(2).contains(greenTask1));
        assertFalse(groupByColorTasks.get(2).contains(greenTask2));
        
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
	@Test
	public void testSortByCompletion() {
		TO_DO_LIST = new ToDoList();
		Task completedTask1 = new Task("Task1", true);
		Task incompletedTask2 = new Task("Task2", false);
		Task completedTask3 = new Task("Task3", true);
		Task incompletedTask4 = new Task("Task4", false);
		Task incompletedTask5 = new Task("Task5", false);
		TO_DO_LIST.addTask(completedTask1);
		TO_DO_LIST.addTask(incompletedTask2);
		TO_DO_LIST.addTask(completedTask3);
		TO_DO_LIST.addTask(incompletedTask4);
		TO_DO_LIST.addTask(incompletedTask5);
		Collection<Task> td =  TO_DO_LIST.getAllTasks();
		Iterator<Task> it = td.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
		Collection<Task> tdl =  TO_DO_LIST.sortByCompletion();
		Iterator<Task> it2 = tdl.iterator();
		while(it2.hasNext()) {
			System.out.println(((Task)it.next()).toString());
		}
	}
	
}
