public synchronized void removeComponent(Object comp) {
    if (lock != 0) {
        remove.add(comp);
        return;
    }
    for (Map.Entry<Class<?>, List<EBMessageHandler>> entry : entrySet()) {
        Class<?> msg = entry.getKey();
        List<EBMessageHandler> handlers = entry.getValue();
        if (handlers == null)
            continue;
        for (Iterator<EBMessageHandler> it = handlers.iterator(); it.hasNext(); ) {
            EBMessageHandler emh = it.next();
            if (emh.comp == comp)
                it.remove();
        }
    }
}