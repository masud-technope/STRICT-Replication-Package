//{{{ toString() method
/**
	 * Return a String representation of the keyboard event for
	 * debugging purpose.
	 *
	 * @param evt the keyboard event
	 * @return a String representation for this keyboard event
	 * @since jEdit 4.3pre15
	 */
public static String toString(KeyEvent evt) {
    String id;
    switch(evt.getID()) {
        case KeyEvent.KEY_PRESSED:
            id = "KEY_PRESSED";
            break;
        case KeyEvent.KEY_RELEASED:
            id = "KEY_RELEASED";
            break;
        case KeyEvent.KEY_TYPED:
            id = "KEY_TYPED";
            break;
        default:
            id = "unknown type";
            break;
    }
    StringBuilder b = new StringBuilder(50);
    b.append(id);
    b.append(",keyCode=0x").append(Integer.toString(evt.getKeyCode(), 16));
    b.append(",keyChar=0x").append(Integer.toString(evt.getKeyChar(), 16));
    b.append(",modifiers=0x").append(Integer.toString(evt.getModifiersEx(), 16));
    b.append(",consumed=");
    b.append(evt.isConsumed() ? '1' : '0');
    return b.toString();
}