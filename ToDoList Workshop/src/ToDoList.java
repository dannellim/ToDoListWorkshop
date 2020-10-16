import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ToDoList {
private HashMap<String, Task> tasks = new HashMap<String, Task>();
//this is dannel here
//hihi
	public ToDoList() {
	}

	//Add item to task list
	public void addTask (Task task) {
		tasks.put(task.getDescription(),task);
		//Add code here
	}

	//remove item from task list
	public Task removeTask(String description) {
		// Add code here
		return tasks.remove(description);
	}

	public void completeTask(String description) {
		// Add code here
	}

	//set important task
	public void importantTask(String description) {
		// Add code here
	}

	public boolean getStatus(String description) {
		Task task = tasks.get(description);
		return task.isComplete();
		//Add code here
		//return false;
	}
	public Task getTask(String description) {
		return tasks.get(description);
		// Add code here
		//return null;
	}
	public Collection<Task> getAllTasks() {
		return tasks.values();

	}
	public Collection<Task> getCompletedTasks() {
		// Add code here
		Collection<Task> list = new ArrayList<Task>();
		tasks.forEach((k, v) -> {
			if(v.isComplete())
				list.add(v);
        });
		return list;
	}

	public Collection<Task> getImportantTasks() {
		Collection<Task> list = new ArrayList<Task>();
		tasks.forEach((k, v) -> {
			if(v.isImportant())
				list.add(v);
        });
		return list;
	}
	public Collection<Task> getSortByColor() {
		
		List<Task> temp = tasks.values().stream()
				.collect(Collectors.toList());
		Collections.sort(temp, (task1, task2) -> {
			return task1.getColorCode() -task2.getColorCode();
		});
		return temp;
	}
	
	public Map<Integer, List<Task>> getGroupByColor() {
		List<Task> tempTasks = tasks.values().stream()
				.collect(Collectors.toList());
		 Map<Integer, List<Task>> groupByColorTasks =
					tempTasks.stream().collect(Collectors.groupingBy(Task::getColorCode));

		 return groupByColorTasks;
	}
}
