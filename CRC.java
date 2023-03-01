package dcnlab;
import java.util.*;

// for xor we can use the ^ bitwise operator
// we need to first take in the input from the user about the divisor/ polynomial
//
class Functionalities{
	
}

public class Crc {
	public static void main(String[] args) {
		 Vector<Integer> dividendBits = new Vector<Integer>();
		 Vector<Integer> divisorBits = new Vector<Integer>();
		 Vector<Integer> modifiedBits = new Vector<Integer>();
		 Vector<Integer> recievedBits = new Vector<Integer>();
		 int count=0;
		System.out.println("Enter the degree of the polynomial");
		Scanner sc = new Scanner(System.in);
		int poly_degree = sc.nextInt();
		System.out.println(poly_degree);
		int poly_array[]=new int[poly_degree+1];
		Scanner sc_1 = new Scanner(System.in);
		 
		//Taking user polynomial input
		System.out.println("Answer 0 or 1");
		for (int i = 0;  i < poly_array.length;  i++) {
			System.out.println("value at x^"+i+" ?");
			String answer = sc_1.nextLine();
			if(answer.equals("1")) {
				poly_array[poly_degree-i] = 1;
			}
			else if(answer.equals("0")){
				poly_array[poly_degree-i] = 0;
			}
			
		}
		System.out.print("divisor is: ");
		
		for (int i = 0;  i < poly_array.length;  i++) {
			System.out.print(poly_array[i]);
			divisorBits.add(poly_array[i]); //entering into vector
		}
		//Taking the dividend from the user
		System.out.println("\n Size of data block:");
		int data_size = sc_1.nextInt();
		int data_array[]=new int[data_size];
		
		System.out.println("Enter you data: ");
		for(int i = 0; i<data_array.length; i++) {
			data_array[i] = sc_1.nextInt();
		}
		for(int i = 0; i<data_array.length; i++) {
			dividendBits.add(data_array[i]); //entering into vector
			modifiedBits.add(data_array[i]);
		}

		int n = divisorBits.size();
		
		//stuffing guard bits at the end of the dividend
		for(int i = 0; i <n-1; i++) {
			dividendBits.add(0);
		}
		
		System.out.println("The bits after guard bit addition are:-");
		for(int i= 0; i<dividendBits.size(); i++) {
			System.out.print(dividendBits.get(i));
		}
		
		int N = dividendBits.size();
		
		for(int i =0; i< N-n+1; i++) {
			if(dividendBits.get(i) == 0) {
				for(int j = 0; j<n ; j++) {
					int x = dividendBits.get(i+j)^0;
					dividendBits.set(i+j, x);
				}
			}
			else {
				for(int j = 0; j<n ; j++) {
					int y = dividendBits.get(i+j)^ divisorBits.get(j);
					dividendBits.set(i+j, y);
				}
				
			}
		}
		
		System.out.println("\n After XOR application on input bit");
		for(int i= 0; i<dividendBits.size(); i++) {
			System.out.print(dividendBits.get(i));
		}
		
		
		for (int i =N-n+1; i<N; i++) {
			modifiedBits.add(dividendBits.get(i));
		}
		

		
