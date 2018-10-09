//}}}
//{{{ addMode() method
/**
	 * Do not call this method. It is only public so that classes
	 * in the org.gjt.sp.jedit.syntax package can access it.
	 * @since jEdit 4.3pre10
	 * @see org.gjt.sp.jedit.jEdit#reloadModes reloadModes
	 * @param mode The edit mode
	 */
public void addMode(Mode mode) {
    String name = mode.getName();
    // The removal makes the "insertion order" in modes
    // (LinkedHashMap) follow the order of addMode() calls.
    modes.remove(name);
    modes.put(name, mode);
}