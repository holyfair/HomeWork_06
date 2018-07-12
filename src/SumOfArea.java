
public class SumOfArea {

	private int[] area;
    private int step;
    private long sumOfArea;
	private Thread[] listThread = new Thread[0];
    private SumOfPartTheArea[] listClasses = new SumOfPartTheArea[0];
	
	public SumOfArea(int[] area, int step) {
		super();
		this.area = area;
		this.step = step;
	}
	
	private void addThreads(Thread[] list, Thread thr) {
		if(thr == null) {
			throw new NullPointerException();
		}
		for(int i = 0; i < list.length; i++) {
			if(list[i] == null) {
				list[i] = thr;
				return;
			}
			Thread[] newList = new Thread[list.length + 1];
			newList = list;
			addThreads(newList, thr);
		}
	}
	
	private void addClasses(SumOfPartTheArea[] list, SumOfPartTheArea sum) {
		if(sum == null) {
			throw new NullPointerException();
		}
		for(int i = 0; i < list.length; i++) {
			if(list[i] == null) {
				list[i] = sum;
				return;
			}
			SumOfPartTheArea[] newList = new SumOfPartTheArea[list.length + 1];
			newList = list;
			addClasses(newList, sum);
		}
	}
	
	private void startThreads() {
		for(int i = 0; i < listClasses.length; i++) {
			Thread thr = new Thread(listClasses[i]);
			addThreads(listThread,thr);
		}
		for(int i = 0; i < listThread.length; i++) {
			listThread[i].start();
		}
		for(int i = 0; i < listThread.length; i++) {
			try {
				listThread[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i = 0; i < listThread.length; i++) {
			sumOfArea += listClasses[i].getSum();
		}
	}
	
	public long sumOfArea() {
		int numberOfThreads = area.length / step;
		int rest = area.length % step;
		int countSteps = 0;
		
		for(int i = 0; i <= numberOfThreads; i++) {
			SumOfPartTheArea sum = new SumOfPartTheArea(area, i * countSteps , i + step * countSteps );
			addClasses(listClasses, sum);
		}
		startThreads();
		for(int i = area.length; i > area.length - rest; i--) {
			sumOfArea += area[i];
		}
		return sumOfArea;
	}
	
}
