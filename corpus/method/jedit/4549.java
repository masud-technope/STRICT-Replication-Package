/**
	 * Copy a file. Careful, it will <b>overwrite</b> the target.
	 * @param comp   the component that will be used as parent in case of error
	 * @param source the source path
	 * @param target the target path (it is the file path, not a parent directory)
	 * @param latch a latch so the caller knows when the copy is done
	 */
private  CopyFileWorker(Component comp, String source, String target, @Nullable CountDownLatch latch) {
    if (source == null || target == null)
        throw new NullPointerException("The source and target cannot be null");
    if (source.equals(target))
        throw new IllegalArgumentException("The source and target must not be the same");
    this.comp = comp;
    this.source = source;
    this.target = target;
    behavior = Behavior.OVERWRITE;
    this.latch = latch;
    setLabel("Copy " + source + " to " + target);
}