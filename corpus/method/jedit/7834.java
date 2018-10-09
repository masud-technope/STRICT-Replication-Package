// }}}
// {{{ CombinedOptions Constructors	
/**
	 * Static constructor that remembers the previously used tab.
	 */
public static CombinedOptions combinedOptions(Frame parent) {
    int startingIndex = jEdit.getIntegerProperty("optional.last.tab", 0);
    if (startingIndex > 1)
        startingIndex = 0;
    return new CombinedOptions(parent, startingIndex);
}