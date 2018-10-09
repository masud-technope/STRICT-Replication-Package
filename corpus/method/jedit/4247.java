//{{{ windowStateChanged() method
@Override
public void windowStateChanged(WindowEvent wse) {
    int extendedState = wse.getNewState();
    jEdit.setIntegerProperty(name + ".extendedState", extendedState);
    Rectangle bounds = frame.getBounds();
    save(extendedState, bounds);
//}}}
}