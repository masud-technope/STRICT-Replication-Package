/**
		Evaluate text in the interpreter at url, returning a possible integer
	 	return value.
	*/
public static int eval(String url, String text) throws IOException {
    String returnValue = null;
    if (url.startsWith("http:")) {
        returnValue = doHttp(url, text);
    } else if (url.startsWith("bsh:")) {
        returnValue = doBsh(url, text);
    } else
        throw new IOException("Unrecognized URL type." + "Scheme must be http:// or bsh://");
    try {
        return Integer.parseInt(returnValue);
    } catch (Exception e) {
        return 0;
    }
}