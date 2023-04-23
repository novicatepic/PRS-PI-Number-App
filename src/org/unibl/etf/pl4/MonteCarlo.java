package org.unibl.etf.pl4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.Scanner;

public class MonteCarlo {

	public static final int NUM_ITERATIONS_STATIC = 50000;
	
	public static void main(String[] args) {
		int numIterations = 0;
		int decimalPrecision = 0;
		String input = "";
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("Unesite KRAJ za kraj, 1 za specifikaciju broja iteracija, 2 za preciznost u decimali: ");
		do {
			int numberOfHits = 0;
			input = scan.nextLine();
			if("1".equals(input)) {
				System.out.println("Unesite broj slucajno generisanih vrijednosti: ");
				numIterations = scan.nextInt();
				if(numIterations >= 1) {
					
					for(int i=0; i < numIterations; i++) {
						double x = rand.nextDouble();
						double y = rand.nextDouble();
						if(x*x + y*y <= 1) {
							numberOfHits++;
						}
					}
					double piApp = 4.0 * numberOfHits / numIterations;
					System.out.println("Dobijena vrijednost za broj Pi je = " + piApp);
					
				} else {
					System.out.println("Broj slucajno generisanih vrijednosti mora biti veci od 1!");
				}
			} else if("2".equals(input)) {
				System.out.println("Unesite broj decimala za preciznost: ");
				decimalPrecision = scan.nextInt();
				if(decimalPrecision >= 1) {
					for(int i=0; i < NUM_ITERATIONS_STATIC; i++) {
						double x = rand.nextDouble();
						double y = rand.nextDouble();
						if(x*x + y*y <= 1) {
							numberOfHits++;
						}
					}
					double piApp = 4.0 * numberOfHits / NUM_ITERATIONS_STATIC;
					BigDecimal piBigDecimal = new BigDecimal(piApp).setScale(decimalPrecision, RoundingMode.HALF_UP);
			        System.out.println("Approximate value of Pi: " + piBigDecimal);
				} else {
					System.out.println("Broj decimala za preciznost mora biti veci od 1!");
				}
			} else if("KRAJ".equals(input)) {
				
			} else {
				//System.out.println("Pogresna opcija, pokusajte ponovo!");
			}
		} while(!"KRAJ".equals(input));
		scan.close();
	}
	
}
