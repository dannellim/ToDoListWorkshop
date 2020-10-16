
public class Task {
	
	private static final int RED = 0;
	private static final int GREEN = 1;
	private static final int BLUE = 2;
	private static final int NONE = 3;
	
	private String description = null;
	private boolean isComplete = false;
	private boolean isImportant = false;
	private int colorCode = NONE;
	
	public Task(String description) {
		super();
		this.description = description;
	}
	
	public Task(String description, boolean isComplete) {
		super();
		this.description = description;
		this.isComplete = isComplete;
	}

	public Task(String description, boolean isComplete, boolean isImportant) {
		super();
		this.description = description;
		this.isComplete = isComplete;
		this.isImportant = isImportant;
	}
	
	
	
	public int getColorCode() {
		return colorCode;
	}

	public void setColorCode(int colorCode) {
		this.colorCode = colorCode;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	public boolean isImportant() {
		return isImportant;
	}
	public void setImportant(boolean isImportant){
		this.isImportant = isImportant;
	}

}
