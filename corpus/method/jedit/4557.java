//}}}
//{{{ hasEncoding() method
/**
	 * Returns if the specified name is supported as a name for an Encoding.
	 */
public static boolean hasEncoding(String name) {
    try {
        if (Charset.isSupported(name)) {
            return true;
        }
    } catch (IllegalCharsetNameException e) {
    }
    return Arrays.asList(ServiceManager.getServiceNames(serviceClass)).contains(name);
}