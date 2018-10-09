public static void redirectOutputToFile(String filename) {
    try {
        PrintStream pout = new PrintStream(new FileOutputStream(filename));
        System.setOut(pout);
        System.setErr(pout);
    } catch (IOException e) {
        System.err.println("Can't redirect output to file: " + filename);
    }
}