/**
	 * Creates a view buffer set.
	 * @param glob The filename glob
	 * @param view The view to check for open buffers
	 * @since jEdit 5.1pre1
	 */
public  AllBufferSet(String glob, View view) {
    this.glob = glob;
    this.view = view;
}