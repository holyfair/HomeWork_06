
public class SumOfPartTheArea implements Runnable{

	private int[] area;
	private int from;
	private int to;
	private long sum = 0;
	Memory memory;
	

	public SumOfPartTheArea(int[] area, int from, int to, Memory memory) {
		super();
		this.area = area;
		this.from = from;
		this.to = to;
		this.memory = memory;
	}

    private void countSum() {
    	for(int i = from; i < to; i++) {
    		sum = sum + area[i];
    	}
    	
    }
	
	@Override
	public void run() {
		countSum();
		memory.setMemory(sum);
		System.out.println(sum);
	}

}
