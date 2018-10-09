public synchronized void addComponent(Object comp) {
    if (lock != 0) {
        add.add(comp);
        return;
    }
    for (Method m : comp.getClass().getMethods()) {
        EBHandler source = m.getAnnotation(EBHandler.class);
        if (source == null)
            continue;
        Class[] params = m.getParameterTypes();
        if (params.length != 1) {
            Log.log(Log.ERROR, EditBus.class, "Invalid EBHandler method " + m.getName() + " in class " + comp.getClass().getName() + ": too many parameters.");
            continue;
        }
        if (!EBMessage.class.isAssignableFrom(params[0])) {
            Log.log(Log.ERROR, EditBus.class, "Invalid parameter " + params[0].getName() + " in method " + m.getName() + " of class " + comp.getClass().getName());
            continue;
        }
        synchronized (components) {
            safeGet(params[0]).add(new EBMessageHandler(comp, m, source));
        }
    }
    /*
			 * If the component implements EBComponent, then add the
			 * default handler for backwards compatibility.
			 */
    if (comp instanceof EBComponent)
        safeGet(EBMessage.class).add(new EBMessageHandler(comp, null, null));
}