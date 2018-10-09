//{{{ getEncoding() method
/**
	 * Returns an instance of Encoding for specified name.
	 * The name is used for search the following domains in the
	 * listed order.
	 *   - java.nio.charset.Charset
	 *   - jEdit ServiceManager
	 */
public static Encoding getEncoding(String name) {
    try {
        return new CharsetEncoding(name);
    } catch (IllegalCharsetNameException e) {
    } catch (UnsupportedCharsetException e) {
    }
    Object namedService = ServiceManager.getService(serviceClass, name);
    if (namedService != null && namedService instanceof Encoding) {
        return (Encoding) namedService;
    }
    // an encoding error by catch clause for general I/O code.
    throw new UnsupportedCharsetException("No such encoding: \"" + name + "\"");
}