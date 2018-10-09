//{{{ installUI() method
@Override
public void installUI(JComponent c) {
    super.installUI(c);
    ((JLayer) c).setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK);
//}}}
}