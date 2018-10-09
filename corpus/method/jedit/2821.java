//}}}
//{{{ getByteIOBufferSize() method
/**
	 * Size of byte I/O buffers.
	 */
public static int getByteIOBufferSize() {
    // 2 is sizeof char in byte;
    return IOBUFSIZE * 2;
}