/**
	* Map an OutputStream to a Writer.
	* Encode-error while writing to this Writer should be reported
	* by throwing an IOException.
	*/
@Nonnull
Writer getTextWriter(@Nonnull OutputStream out) throws IOException;