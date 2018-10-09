//}}}
//{{{ getFirstGuiltyCharacterIndex() method
// Look for the first character which causes encoding error.
private static int getFirstGuiltyCharacterIndex(Encoding encoding, Segment line) throws IOException {
    if (line.count < 1) {
        return -1;
    } else if (line.count == 1) {
        return 0;
    }
    Writer tester = encoding.getTextWriter(new OutputStream() {

        public void write(int b) {
        }
    });
    for (int i = 0; i < line.count; ++i) {
        try {
            tester.write(line.array[line.offset + i]);
        } catch (CharacterCodingException e) {
            return i;
        }
    }
    return -1;
}