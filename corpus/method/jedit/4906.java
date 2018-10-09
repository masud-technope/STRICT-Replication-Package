@Override
public boolean postProcessKeyEvent(KeyEvent evt) {
    if (!evt.isConsumed()) {
        Component comp = (Component) evt.getSource();
        if (!comp.isShowing())
            return true;
        for (; ; ) {
            if (comp instanceof View) {
                ((View) comp).getInputHandler().processKeyEvent(evt, View.VIEW, false);
                return true;
            } else if (comp == null || comp instanceof Window || comp instanceof JEditTextArea) {
                if (comp instanceof PluginManager) {
                    evt.setSource(comp);
                    ((PluginManager) comp).processKeyEvents(evt);
                }
                break;
            } else
                comp = comp.getParent();
        }
    }
    return super.postProcessKeyEvent(evt);
}