
public class SumOfPartTheArea implements Runnable{

	private int[] area;
	private int from;
	private int to;
	private long sum = 0;
	
	public long getSum() {
		return sum;
	}

	public SumOfPartTheArea(int[] area, int from, int to) {
		super();
		this.area = area;
		this.from = from;
		this.to = to;
	}

    private void countSum() {
    	for(int i = from; i < to; i++) {
    		sum += area[i];
    	}
    	
    }
	
	@Override
	public void run() {
		countSum();
	}

}
