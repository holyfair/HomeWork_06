
public class Memory {

	private long memory;

	public long getMemory() {
		return memory;
	}

	public synchronized void setMemory(long memory) {
		this.memory = this.memory + memory;
	}
	
	
}
