//}}}
//{{{ fireCaretEvent() method
private void fireCaretEvent() {
    Object[] listeners = listenerList.getListenerList();
    for (int i = listeners.length - 2; i >= 0; i--) {
        if (listeners[i] == CaretListener.class) {
            try {
                ((CaretListener) listeners[i + 1]).caretUpdate(caretEvent);
            } catch (Throwable t) {
                Log.log(Log.ERROR, this, t);
            }
        }
    }
}