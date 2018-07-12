import java.math.BigInteger;

public class Factorial implements Runnable{

	private int number;
	private String name;
	
	
	public Factorial(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	
	public Factorial() {
		super();
	}


	private BigInteger countFactorial(int number) {
        BigInteger factorial = new BigInteger(Integer.toString(number));
		
		if(number == 0) {
			return new BigInteger(Integer.toString(1));
		}
		if(number == 1) {
			return new BigInteger(Integer.toString(1));
		}
		return factorial.multiply(countFactorial(number - 1));
		
	}

	@Override
	public void run() {
		System.out.println(name + ": " + countFactorial(number));
		
	}

}
