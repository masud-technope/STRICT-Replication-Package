//}}}
//{{{ addKeyBinding() method
/**
	 * Adds a key binding to this input handler. The key binding is
	 * a list of white space separated key strokes of the form
	 * <i>[modifiers+]key</i> where modifier is C for Control, A for Alt,
	 * or S for Shift, and key is either a character (a-z) or a field
	 * name in the KeyEvent class prefixed with VK_ (e.g., BACK_SPACE)
	 * @param keyBinding The key binding
	 * @param action The action
	 * @since jEdit 4.3pre1
	 */
@SuppressWarnings({ "unchecked" })
public void addKeyBinding(String keyBinding, Object action) {
    Hashtable current = bindings;
    String prefixStr = null;
    StringTokenizer st = new StringTokenizer(keyBinding);
    while (st.hasMoreTokens()) {
        String keyCodeStr = st.nextToken();
        if (prefixStr == null)
            prefixStr = keyCodeStr;
        else
            prefixStr = new StringBuilder(prefixStr).append(' ').append(keyCodeStr).toString();
        KeyEventTranslator.Key keyStroke = KeyEventTranslator.parseKey(keyCodeStr);
        if (keyStroke == null)
            return;
        if (st.hasMoreTokens()) {
            Object o = current.get(keyStroke);
            if (o instanceof Hashtable)
                current = (Hashtable) o;
            else {
                Hashtable<String, String> hash = new Hashtable<String, String>();
                hash.put(PREFIX_STR, prefixStr);
                o = hash;
                current.put(keyStroke, o);
                current = (Hashtable) o;
            }
        } else
            current.put(keyStroke, action);
    }
}