//}}}
//{{{ setPerspectiveDirty() method
/**
	 * We only autosave the perspective if it has changed, to avoid spinning
	 * up the disk on laptops.
	 * @since jEdit 4.2pre13
	 */
public static void setPerspectiveDirty(boolean dirty) {
    PerspectiveManager.dirty = dirty;
}