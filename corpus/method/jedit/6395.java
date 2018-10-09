//{{{ finish() method
/**
		 * Perform the final step of saving.
		 */
public void finish() throws IOException {
    close();
    jEdit.backupSettingsFile(file);
    file.delete();
    twoStageSaveFile.renameTo(file);
    knownLastModified = file.lastModified();
//}}}
}