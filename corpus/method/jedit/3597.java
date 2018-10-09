//}}}
//{{{ setDefaultMaxSize() method
/**
	 * Sets the default max size (in characters) for all history models. To change the max
	 * size of one history, call {@link #setMaxSize} instead.
	 * @since jEdit 4.5pre1
	 */
public static void setDefaultMaxSize(int newMax) {
    HistoryModel.defaultMaxSize = newMax;
}