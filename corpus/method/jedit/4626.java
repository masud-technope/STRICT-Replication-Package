/**
	 * @see org.gjt.sp.util.Task#_run()
	 */
@Override
public void _run() {
    FileOutputStream os = null;
    FileChannel ch = null;
    try {
        os = new FileOutputStream(file);
        ch = os.getChannel();
        byte[] src = body.getBytes(charset);
        os = new FileOutputStream(file);
        ch = os.getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BUFFER_SIZE);
        int length = src.length;
        setMaximum(length);
        //TODO: Change this
        setStatus("Saving " + length + " bytes to " + file.getPath());
        int written = 0;
        while (written < length) {
            written += ch.write((ByteBuffer) buff.put(src, written, Math.min(BUFFER_SIZE, length - written)).flip());
            buff.rewind();
            setValue(written);
        }
    } catch (IOException e) {
        Log.log(Log.ERROR, this, e, e);
    } finally {
        IOUtilities.closeQuietly((Closeable) ch);
        IOUtilities.closeQuietly((Closeable) os);
    }
}