//{{{ printf() method
/**
		 * This is a hack to allow "printf" to not print weird
		 * stuff to the output. Since "printf" doesn't seem to
		 * print the whole message in one shot, our output
		 * stream above would break a line of log into several
		 * lines; so we buffer the result of the printf call and
		 * print the whole thing in one shot. A similar hack
		 * would be needed for the "other" printf method, but
		 * I'll settle for the common case only.
		 */
public PrintStream printf(String format, Object... args) {
    synchronized (orig) {
        buffer.reset();
        out = buffer;
        super.printf(format, args);
        try {
            byte[] data = buffer.toByteArray();
            orig.write(data, 0, data.length);
            out = orig;
        } catch (IOException // NOPMD
        ioe) {
        } finally {
            buffer.reset();
        }
    }
    return this;
//}}}
}