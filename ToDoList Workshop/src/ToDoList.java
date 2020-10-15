import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ToDoList {
private HashMap<String, Task> tasks = new HashMap<String, Task>();

	public ToDoList() {
	}

	public void addTask (Task task) {
		tasks.put(task.getDescription(),task);
		//Add code here
	}
	public void completeTask(String description) {
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
	public Task removeTask(String description) {
		// Add code here
		return tasks.remove(description);
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
}
