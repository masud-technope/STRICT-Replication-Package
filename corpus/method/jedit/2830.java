//}}}
//{{{ readContents() method
/**
	 * Read the contents of this load request.
	 * Some auto detection is performed if enabled.
	 *   - GZIPed file
	 *   - The encoding
	 * If fallback encodings are specified, they are used on
	 * encoding errors.
	 * @throws InterruptedException
	 */
private void readContents() throws IOException, InterruptedException {
    long length = getContentLength();
    BufferedInputStream markedStream = AutoDetection.getMarkedStream(getNakedStream());
    try {
        boolean gzipped = false;
        // encodingProviders is consist of given
        // encodings as String or contents-aware
        // detectors as EncodingDetector.
        List<Object> encodingProviders = new ArrayList<Object>();
        boolean autodetect = buffer.getBooleanProperty(Buffer.ENCODING_AUTODETECT);
        if (autodetect) {
            gzipped = AutoDetection.isGzipped(markedStream);
            markedStream.reset();
            encodingProviders.addAll(AutoDetection.getEncodingDetectors());
            // If the detected encoding fail, fallback to
            // the original encoding.
            encodingProviders.add(buffer.getStringProperty(JEditBuffer.ENCODING));
            String fallbackEncodings = jEdit.getProperty("fallbackEncodings");
            if (fallbackEncodings != null && fallbackEncodings.length() > 0)
                Collections.addAll(encodingProviders, fallbackEncodings.split("\\s+"));
        } else {
            gzipped = buffer.getBooleanProperty(Buffer.GZIPPED);
            encodingProviders.add(buffer.getStringProperty(JEditBuffer.ENCODING));
        }
        if (gzipped) {
            Log.log(Log.DEBUG, this, path + ": Stream is gzipped.");
            markedStream = AutoDetection.getMarkedStream(new GZIPInputStream(markedStream));
        }
        Set<String> failedEncodings = new HashSet<String>();
        Exception encodingError = null;
        for (Object encodingProvider : encodingProviders) {
            String encoding = null;
            if (encodingProvider instanceof String) {
                encoding = (String) encodingProvider;
            } else if (encodingProvider instanceof EncodingDetector) {
                markedStream = rewindContentsStream(markedStream, gzipped);
                encoding = ((EncodingDetector) encodingProvider).detectEncoding(new BufferedInputStream(markedStream));
            } else {
                Log.log(Log.DEBUG, this, "Strange encodingProvider: " + encodingProvider);
            }
            if (encoding == null || encoding.length() <= 0 || failedEncodings.contains(encoding)) {
                continue;
            }
            markedStream = rewindContentsStream(markedStream, gzipped);
            try {
                read(EncodingServer.getTextReader(markedStream, encoding), length, false);
                if (autodetect) {
                    // Store the successful properties.
                    if (gzipped) {
                        buffer.setBooleanProperty(Buffer.GZIPPED, true);
                    }
                    buffer.setProperty(JEditBuffer.ENCODING, encoding);
                }
                return;
            } catch (CharConversionException e) {
                encodingError = e;
            } catch (CharacterCodingException e) {
                encodingError = e;
            } catch (UnsupportedEncodingException e) {
                encodingError = e;
            } catch (UnsupportedCharsetException e) {
                encodingError = e;
            }
            Log.log(Log.NOTICE, this, path + ": " + encoding + ": " + encodingError);
            failedEncodings.add(encoding);
        }
        // All possible detectors and encodings failed.
        Object[] pp = { TextUtilities.join(failedEncodings, ","), "" };
        if (failedEncodings.size() < 2) {
            pp[1] = encodingError.toString();
        } else {
            pp[1] = "See details in Activity Log";
        }
        VFSManager.error(view, path, "ioerror.encoding-error", pp, Log.NOTICE);
        markedStream = rewindContentsStream(markedStream, gzipped);
        read(EncodingServer.getEncoding(buffer.getStringProperty(JEditBuffer.ENCODING)).getPermissiveTextReader(markedStream), length, false);
        if (autodetect && gzipped) {
            buffer.setBooleanProperty(Buffer.GZIPPED, true);
        }
    } finally {
        markedStream.close();
    }
}