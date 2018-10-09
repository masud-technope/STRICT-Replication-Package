//}}}
//{{{ getTextReader() method
/**
	 * Returns a Reader object that reads the InputStream with
	 * the encoding. This method is same with
	 * "getEncoding(encoding).getTextReader(in)".
	 */
public static Reader getTextReader(InputStream in, String encoding) throws IOException {
    return getEncoding(encoding).getTextReader(in);
}