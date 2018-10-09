/**
	 * Copy a file. Careful, it will <b>overwrite</b> the target.
	 * @param comp   the component that will be used as parent in case of error
	 * @param source the source path
	 * @param target the target path (it is the file path, not a parent directory)
	 */
public  CopyFileWorker(Component comp, String source, String target) {
    this(comp, source, target, null);
}