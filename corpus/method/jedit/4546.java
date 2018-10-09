/**
	 * Copy all files from the list to the target directory.
	 * If some files already exist in the target directory the files will 
	 * be skipped.
	 * @param comp   the component that will be used as parent in case of error
	 * @param sources the sources path to copy
	 * @param target the target path (it must be a directory otherwise nothing will be copied)
	 * @since jEdit 5.0
	 */
public  CopyFileWorker(Component comp, List<String> sources, String target) {
    this(comp, sources, target, Behavior.SKIP);
}