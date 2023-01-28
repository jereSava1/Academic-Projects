package simulacionThreads;

import java.util.ArrayList;
import java.util.Random;

public class Util {

	private static Random r = new Random();

	public static void espera() {

		try {
			Thread.sleep(r.nextInt(3000));
		} catch (InterruptedException e) {

		}
	}

	// random numbers are 0,1,2,3,4
	public static ArrayList<Integer> generaRandom() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Random randomGenerator = new Random();
		while (numbers.size() < 5) {
			int random = randomGenerator.nextInt(5);
			if (!numbers.contains(random)) {
				numbers.add(random);
			}
			}
	return numbers;
	}

}