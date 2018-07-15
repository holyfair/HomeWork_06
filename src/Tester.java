
public class Tester {

	public static void main(String[] args) {
//		Test_1();
        Test_2();
	}

	static void Test_1() {
		for(int i = 0; i < 100; i++) {
			Factorial fac = new Factorial(i, "" + i);
			Thread thr = new Thread(fac);
			thr.start();
		}
	}
	static void Test_2() {
		long sum;
		int[] area = new int[10];
		for(int i = 0; i < area.length; i++) {
			area[i] = i;
		}
		SumOfArea sof = new SumOfArea(area, 4, new Memory());
		sum = sof.sumOfArea();
		System.out.println(sum);
	}
}
