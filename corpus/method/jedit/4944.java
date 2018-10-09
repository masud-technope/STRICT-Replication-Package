/**
	 * Creates a new action set.
	 * @param cachedActionNames The list of cached action names
	 * @param uri The actions.xml URI
	 * @since jEdit 4.3pre13
	 */
protected  JEditActionSet(String[] cachedActionNames, URL uri) {
    this();
    this.uri = uri;
    if (cachedActionNames != null) {
        for (String cachedActionName : cachedActionNames) actions.put(cachedActionName, placeholder);
    }
    loaded = false;
}