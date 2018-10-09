//}}}
//{{{ fireBracketSelected() method
private void fireBracketSelected(int line, String text) {
    Object[] listeners = listenerList.getListenerList();
    for (int i = listeners.length - 2; i >= 0; i--) {
        if (listeners[i] == StatusListener.class) {
            try {
                ((StatusListener) listeners[i + 1]).bracketSelected(this, line, text);
            } catch (Throwable t) {
                Log.log(Log.ERROR, this, t);
            }
        }
    }
}