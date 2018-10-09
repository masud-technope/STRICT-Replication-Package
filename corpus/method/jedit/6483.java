//}}}
//{{{ getModes() method
/**
	 * Returns an array of installed edit modes.
	 * @since jEdit 4.3pre10
	 */
public Mode[] getModes() {
    return modes.values().toArray(new Mode[modes.size()]);
}