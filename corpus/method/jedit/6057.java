//}}}
//{{{ getInputStream()
/**
	 * @return	input stream to read the resource's contents. never null
	 * @throws	IOException	on error
	 * @throws	FileNotFoundException if resource is not found
	 */
@Nonnull
public InputStream getInputStream() throws IOException, FileNotFoundException {
    connect();
    return in;
}