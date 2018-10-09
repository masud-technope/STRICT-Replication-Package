//{{{ implements EncodingDetector
public String detectEncoding(InputStream sample) throws IOException {
    // Length of longest XML PI used for encoding detection.
    // <?xml version="1.0" encoding="................"?>
    final int XML_PI_LENGTH = 50;
    byte[] _xmlPI = new byte[XML_PI_LENGTH];
    int offset = 0;
    int count;
    while ((count = sample.read(_xmlPI, offset, XML_PI_LENGTH - offset)) != -1) {
        offset += count;
        if (offset == XML_PI_LENGTH)
            break;
    }
    return getXMLEncoding(new String(_xmlPI, 0, offset, "ASCII"));
}