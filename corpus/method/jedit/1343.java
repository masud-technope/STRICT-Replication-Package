/**
		This is a degenerate implementation.
		I don't know how to keep this from blocking if we try to read more
		than one char...  There is no available() for Readers ??
	*/
public int read(char buff[], int off, int len) throws IOException {
    int b = read();
    if (b == -1)
        // EOF, not zero read apparently
        return -1;
    else {
        buff[off] = (char) b;
        return 1;
    }
}