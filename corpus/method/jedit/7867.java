// }}}
// {{{ cancel()
public void cancel() {
    GUIUtilities.saveGeometry(this, getName());
    dispose();
}