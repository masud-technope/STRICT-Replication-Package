@Override
public void focusGained(FocusEvent evt) {
    // walk up hierarchy, looking for an EditPane
    Component comp = (Component) evt.getSource();
    while (!(comp instanceof EditPane)) {
        if (comp == null)
            return;
        comp = comp.getParent();
    }
    if (comp != editPane)
        setEditPane((EditPane) comp);
    else
        updateGutterBorders();
}