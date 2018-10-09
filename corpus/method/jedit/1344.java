// Test it
public static void main(String[] args) throws Exception {
    Reader in = new CommandLineReader(new InputStreamReader(System.in));
    while (true) System.out.println(in.read());
}