//}}}
//{{{ processKeyEventKeyStrokeHandling() method
/**
	 *
	 * @param evt the keyboard event
	 * @param from the source, it can be {@link org.gjt.sp.jedit.View#VIEW},
	 * {@link org.gjt.sp.jedit.View#ACTION_BAR} or {@link org.gjt.sp.jedit.View#TEXT_AREA}
	 * @param mode the mode is "press" or "type" and is used for debug only
	 * @param global tell if the event comes from the DefaultKeyboardFocusManager or not
	 */
protected void processKeyEventKeyStrokeHandling(KeyEvent evt, int from, String mode, boolean global) {
    KeyEventTranslator.Key keyStroke = KeyEventTranslator.translateKeyEvent(evt);
    if (keyStroke != null) {
        keyStroke.setIsFromGlobalContext(global);
        if (Debug.DUMP_KEY_EVENTS) {
            Log.log(Log.DEBUG, this, "Translated (key " + mode + "): " + keyStroke + " from " + from);
        }
        boolean consumed = false;
        if (handleKey(keyStroke, false)) {
            evt.consume();
            consumed = true;
        }
        if (Debug.DUMP_KEY_EVENTS) {
            Log.log(Log.DEBUG, this, "Translated (key " + mode + "): " + keyStroke + " from " + from + ": consumed=" + consumed + '.');
        }
    }
}