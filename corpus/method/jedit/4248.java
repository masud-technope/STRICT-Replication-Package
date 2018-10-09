/**
		 * Constructs a new SizeSaver.
		 *
		 * @param frame The Frame for which to save the size
		 * @param parent The parent to be relative to.
		 * @param name The prefix for the settings
		 */
 SizeSaver(Frame frame, Container parent, String name) {
    if (frame == null || name == null) {
        throw new NullPointerException();
    }
    this.frame = frame;
    this.parent = parent;
    this.name = name;
//}}}
}