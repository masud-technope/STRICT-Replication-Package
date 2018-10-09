//}}}
//{{{ fireStatusChanged() method
private void fireStatusChanged(int flag, boolean value) {
    Object[] listeners = listenerList.getListenerList();
    for (int i = listeners.length - 2; i >= 0; i--) {
        if (listeners[i] == StatusListener.class) {
            try {
                ((StatusListener) listeners[i + 1]).statusChanged(this, flag, value);
            } catch (Throwable t) {
                Log.log(Log.ERROR, this, t);
            }
        }
    }
}