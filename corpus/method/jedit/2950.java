//}}}
//{{{ sendImpl() method
private static void sendImpl(EBMessage message) {
    boolean isExact = true;
    Class<?> type = message.getClass();
    while (!type.equals(Object.class)) {
        List<EBMessageHandler> handlers = components.get(type);
        if (handlers != null) {
            try {
                for (EBMessageHandler emh : handlers) {
                    if (!isExact && emh.source != null && emh.source.exact()) {
                        continue;
                    }
                    if (Debug.EB_TIMER) {
                        long start = System.nanoTime();
                        dispatch(emh, message);
                        long time = System.nanoTime() - start;
                        if (time >= 1000000) {
                            Log.log(Log.DEBUG, EditBus.class, emh.comp + ": " + time + " ns");
                        }
                    } else
                        dispatch(emh, message);
                }
            } catch (InvocationTargetException t) {
                Log.log(Log.ERROR, EditBus.class, "Exception" + " while sending message on EditBus:");
                Log.log(Log.ERROR, EditBus.class, t.getCause());
            } catch (Throwable t) {
                Log.log(Log.ERROR, EditBus.class, "Exception" + " while sending message on EditBus:");
                Log.log(Log.ERROR, EditBus.class, t);
            }
        }
        type = type.getSuperclass();
        isExact = false;
    }
}