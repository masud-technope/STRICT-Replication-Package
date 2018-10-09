//}}}
//{{{ getTextWriter() method
/**
	 * Returns a Writer object that writes to the OutputStream with
	 * the encoding. This method is same with
	 * "getEncoding(encoding).getTextWriter(out)".
	 */
public static Writer getTextWriter(OutputStream out, String encoding) throws IOException {
    return getEncoding(encoding).getTextWriter(out);
}