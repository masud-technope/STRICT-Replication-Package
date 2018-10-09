//}}}
//{{{ fireNarrowActive() method
void fireNarrowActive() {
    Object[] listeners = listenerList.getListenerList();
    for (int i = listeners.length - 2; i >= 0; i--) {
        if (listeners[i] == StatusListener.class) {
            try {
                ((StatusListener) listeners[i + 1]).narrowActive(this);
            } catch (Throwable t) {
                Log.log(Log.ERROR, this, t);
            }
        }
    }
}