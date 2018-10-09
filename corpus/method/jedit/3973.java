//}}}
//{{{ firePrefixStateChange() method
/**
	 * Description of the Method
	 *
	 * @param bindings                       Description of the Parameter
	 * @param listeningForShortcutCompletion Description of the Parameter
	 */
public static void firePrefixStateChange(Hashtable bindings, boolean listeningForShortcutCompletion) {
    //Log.log( Log.DEBUG, ShortcutPrefixActiveEvent.class, "firePrefixStateChange() called, listening? " + listeningForShortcutCompletion );
    // Guaranteed to return a non-null array
    Object[] listeners = listenerList.getListenerList();
    // those that are interested in this event
    for (int i = listeners.length - 2; i >= 0; i -= 2) {
        //Log.log( Log.DEBUG, ShortcutPrefixActiveEvent.class, "firePrefixStateChange() called, listening? " + listeningForShortcutCompletion );
        ChangeEvent event = new ShortcutPrefixActiveEvent(bindings, listeningForShortcutCompletion);
        ((ChangeListener) listeners[i + 1]).stateChanged(event);
    }
}