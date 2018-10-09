private static void sendLine(String line, OutputStream outPipe) throws IOException {
    outPipe.write(line.getBytes());
    outPipe.flush();
}