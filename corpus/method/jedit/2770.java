//}}}
//{{{ isBackup() method
/**
	 * @return if this buffer most probably contains backup file
	 */
public boolean isBackup() {
    return MiscUtilities.isBackup(MiscUtilities.getFileName(getPath()));
}