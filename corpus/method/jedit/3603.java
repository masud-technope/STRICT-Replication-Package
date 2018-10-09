//}}}
//{{{ setDefaultMax() method
/**
	 * Sets the default size of all HistoryModels.
	 * Affects the VFS path history, the hypersearch history, etc..
	 * To change the max size of one history, call setMax() instead.
	 */
public static void setDefaultMax(int max) {
    HistoryModel.defaultMax = max;
}