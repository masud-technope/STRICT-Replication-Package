@Override
public long skip(long toSkip) throws IOException {
    if (toSkip < 0) {
        throw new IllegalArgumentException("skip value is negative");
    }
    int skipBufferSize = (int) Math.min(toSkip, MAX_SKIP_BUFFER_SIZE);
    if ((skipBuffer == null) || (skipBuffer.length < skipBufferSize)) {
        skipBuffer = new char[skipBufferSize];
    }
    long remaining = toSkip;
    synchronized (in) {
        while (remaining > 0) {
            int skipped = read(skipBuffer, 0, (int) Math.min(remaining, skipBufferSize));
            if (skipped == -1) {
                break;
            }
            remaining -= skipped;
        }
    }
    return toSkip - remaining;
}