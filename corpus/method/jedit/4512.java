//}}}
//{{{ removeKeyBinding() method
/**
	 * Removes a key binding from this input handler.
	 *
	 * @param keyBinding The key binding
	 */
public void removeKeyBinding(String keyBinding) {
    Hashtable current = bindings;
    StringTokenizer st = new StringTokenizer(keyBinding);
    while (st.hasMoreTokens()) {
        String keyCodeStr = st.nextToken();
        KeyEventTranslator.Key keyStroke = KeyEventTranslator.parseKey(keyCodeStr);
        if (keyStroke == null)
            return;
        if (st.hasMoreTokens()) {
            Object o = current.get(keyStroke);
            if (o instanceof Hashtable)
                current = ((Hashtable) o);
            else if (o != null) {
                // we have binding foo
                // but user asks to remove foo bar?
                current.remove(keyStroke);
                return;
            } else {
                // user asks to remove non-existent
                return;
            }
        } else
            current.remove(keyStroke);
    }
}