/**
	* Same as {@link #createVFSSession}, but may be called from any
	* thread. It first checks the <code>NON_AWT_SESSION_CAP</code>
	* capability and enters EDT thread if necessary.
	*/
public Object createVFSSessionSafe(final String path, final Component comp) {
    Object session = null;
    if ((getCapabilities() & NON_AWT_SESSION_CAP) != 0) {
        session = createVFSSession(path, comp);
    } else {
        SessionGetter getter = new SessionGetter(path, comp);
        ThreadUtilities.runInDispatchThreadAndWait(getter);
        session = getter.get();
    }
    return session;
}