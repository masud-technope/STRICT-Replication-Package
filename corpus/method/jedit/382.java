private String readLine(BufferedReader in) {
    try {
        String line = in.readLine();
        if (line == null) {
            System.err.println("\nEOF in input!");
            System.exit(1);
            // can't happen
            throw new InternalError();
        }
        return line;
    } catch (IOException io) {
        System.err.println("\nI/O error: " + io);
        System.exit(1);
        throw new InternalError();
    }
}