import java.util.Stack;

public class SumOfArea {

	private int[] area;
    private int step;
    private long sumOfArea;
	private Stack<Thread> stack = new Stack<Thread>();
    private Memory memory;
	
	public SumOfArea(int[] area, int step, Memory memory) {
		super();
		this.area = area;
		this.step = step;
		this.memory = memory;
	}
	
	
	public long sumOfArea() {
		int rest = area.length % step;
		
		for(int i = 0; i < area.length; i += step) {
			if(i + step < area.length) {
				SumOfPartTheArea sum = new SumOfPartTheArea(area, i , i + step , memory);
				Thread thr = new Thread(sum);
				thr.start();
				stack.push(thr);
			}
		}
		for(int i = area.length - rest; i < area.length; i++) {
			sumOfArea += area[i];
		}
		memory.setMemory(sumOfArea);
		for(int i = 0; i < stack.size(); i++) {
			try {
				stack.pop().join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return memory.getMemory();
	}
	
}
