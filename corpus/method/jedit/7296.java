//}}}
//{{{ fireScrollEvent() method
private void fireScrollEvent(boolean vertical) {
    Object[] listeners = listenerList.getListenerList();
    for (int i = listeners.length - 2; i >= 0; i--) {
        if (listeners[i] == ScrollListener.class) {
            try {
                if (vertical)
                    ((ScrollListener) listeners[i + 1]).scrolledVertically(this);
                else
                    ((ScrollListener) listeners[i + 1]).scrolledHorizontally(this);
            } catch (Throwable t) {
                Log.log(Log.ERROR, this, t);
            }
        }
    }
}