//}}}
//{{{ setAutosaveFile() method
/**
	 * Set the autosave file, based on the autosettings dir.
	 * @since jEdit 5.5pre1
	 */
private void setAutosaveFile() {
    File autosaveDir = MiscUtilities.prepareAutosaveDirectory(symlinkPath);
    autosaveFile = new File(autosaveDir, '#' + name + '#');
}