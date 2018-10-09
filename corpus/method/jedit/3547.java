//}}}
public void propertyChange(PropertyChangeEvent evt) {
    if (dockableName == null)
        return;
    String pn = evt.getPropertyName();
    if (pn.startsWith(dockableName) && pn.endsWith("title"))
        setTitle(evt.getNewValue().toString());
}