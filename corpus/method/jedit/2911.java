/**
	 * Does a computational delay. Simulates heavy computations for
	 * the given period of time. Used to force conditions that are
	 * hard to reproduce, for example deadlock cases.
	 * @param time Required delay, in ms
	 * @return an integer
	 */
public static int compDelay(long time) {
    long start = System.currentTimeMillis();
    long elapsed = 0;
    int a = 0, b = 0, c = 0;
    while (elapsed >= 0 && elapsed < time) {
        // the compiler doesn't optimize them
        for (int i = 0; i < 500 * 1000; i++) {
            a = (b + 1) * (c + 1);
            b = (a + 1) * (c + 1);
            c = (a + 1) * (b + 1);
        }
        elapsed = System.currentTimeMillis() - start;
    }
    return a + b + c;
}