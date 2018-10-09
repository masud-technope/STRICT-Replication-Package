//}}}
//{{{ Private members
/**
	 * Returns a service of EncodingDetector for name.
	 */
private static EncodingDetector getEncodingDetectorService(String name) {
    String serviceClass = "org.gjt.sp.jedit.io.EncodingDetector";
    Object service = ServiceManager.getService(serviceClass, name);
    if (service != null && service instanceof EncodingDetector) {
        return (EncodingDetector) service;
    } else {
        return null;
    }
}