package versus;

public class BitwiseShiftVSMultiplication {
    public static void main(String[] args) {
	int num = 10, fu = 0;
	for (int i = 0; i < 1000000000L; i++) {
	    fu = num << 1;
	}
	long timeme = System.nanoTime();
	num = 10; fu = 0;
	for (int i = 0; i < 1000000000L; i++) {
	    fu = i * 2;
	}
	System.out.println("Time - " + (System.nanoTime() - timeme) / 1000000000.0);
	timeme = System.nanoTime();
	for (int i = 0; i < 1000000000L; i++) {
	    fu = i << 1;
	}
	System.out.println("Time - " + (System.nanoTime() - timeme) / 1000000000f);
	System.out.println(fu);
    }
}
