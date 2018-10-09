/**
	 * @param b If true, and if include files is true, then retain any remote file
	 * names found in the split configuration.
	 */
public void setIncludeRemoteFiles(boolean b) {
    includeRemotes = includeFiles && b;
}