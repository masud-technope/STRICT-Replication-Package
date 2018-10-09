//}}}
//{{{ getKeyBinding() method
/**
	 * Returns either an edit action, or a hashtable if the specified key
	 * is a prefix.
	 * @param keyBinding The key binding
	 * @since jEdit 3.2pre5
	 */
@Nullable
public Object getKeyBinding(@Nonnull String keyBinding) {
    Hashtable current = bindings;
    StringTokenizer st = new StringTokenizer(keyBinding);
    while (st.hasMoreTokens()) {
        KeyEventTranslator.Key keyStroke = KeyEventTranslator.parseKey(st.nextToken());
        if (keyStroke == null)
            return null;
        if (st.hasMoreTokens()) {
            Object o = current.get(keyStroke);
            if (o instanceof Hashtable) {
                if (!st.hasMoreTokens())
                    return o;
                else
                    current = (Hashtable) o;
            } else
                return o;
        } else {
            return current.get(keyStroke);
        }
    }
    return null;
}