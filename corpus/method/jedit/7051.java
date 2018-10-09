//{{{ uninstallUI() method
@Override
public void uninstallUI(JComponent c) {
    super.uninstallUI(c);
    ((JLayer) c).setLayerEventMask(0);
//}}}
}