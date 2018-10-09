//}}}
//{{{ removeChangeEventListener() method
/**
	 * Description of the Method
	 *
	 * @param l Description of the Parameter
	 */
public static void removeChangeEventListener(ChangeListener l) {
    listenerList.remove(ChangeListener.class, l);
    Log.log(Log.DEBUG, ShortcutPrefixActiveEvent.class, "Listener removed.  " + listenerList.getListenerList().length + " left.");
}