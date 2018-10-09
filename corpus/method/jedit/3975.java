//}}}
//{{{ addChangeEventListener() method
/**
	 * Adds a feature to the ChangeEventListener attribute of the
	 * ShortcutPrefixActiveEvent class
	 *
	 * @param l The feature to be added to the ChangeEventListener attribute
	 */
public static void addChangeEventListener(ChangeListener l) {
    listenerList.add(ChangeListener.class, l);
    Log.log(Log.DEBUG, ShortcutPrefixActiveEvent.class, "Listener added.  " + listenerList.getListenerList().length + " left.");
}