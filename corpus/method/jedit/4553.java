/**
	* Map an InputStream to a Reader.
	* Decode-error while reading from this Reader should be ignored
	* or replaced.
	*/
@Nonnull
Reader getPermissiveTextReader(@Nonnull InputStream in) throws IOException;