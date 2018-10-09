/**
	 * Copy all files from the list to the target directory.
	 * If some files already exist in the target directory the <code>Behavior</code> will decide what
	 * to do.
	 * @param comp   the component that will be used as parent in case of error
	 * @param sources the sources path to copy
	 * @param target the target path (it must be a directory otherwise nothing will be copied)
	 * @param behavior the behavior if the target file already exists
	 * @since jEdit 5.0
	 */
public  CopyFileWorker(Component comp, List<String> sources, String target, Behavior behavior) {
    if (sources == null || target == null)
        throw new NullPointerException("The source and target cannot be null");
    this.comp = comp;
    this.sources = sources;
    this.target = target;
    this.behavior = behavior;
}