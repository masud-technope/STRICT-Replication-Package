/**
	* Map an InputStream to a Reader.
	* Decode-error while reading from this Reader should be reported
	* by throwing an IOException.
	*/
@Nonnull
Reader getTextReader(@Nonnull InputStream in) throws IOException;