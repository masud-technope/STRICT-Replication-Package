//}}}
//{{{ getEncodingDetectors() method
/**
	 * Returns the user configured ordered list of encoding detectors.
	 * This method reads property "encodingDetectors".
	 */
public static List<EncodingDetector> getEncodingDetectors() {
    List<EncodingDetector> detectors = new ArrayList<EncodingDetector>();
    String propName = "encodingDetectors";
    String selectedDetectors = jEdit.getProperty(propName);
    if (selectedDetectors != null && selectedDetectors.length() > 0) {
        for (String name : selectedDetectors.split("\\s+")) {
            EncodingDetector service = getEncodingDetectorService(name);
            if (service != null) {
                detectors.add(service);
            } else {
                Log.log(Log.ERROR, AutoDetection.class, "getEncodingDetectors():" + " No EncodingDetector for the name" + " \"" + name + "\"");
            }
        }
    }
    return detectors;
}