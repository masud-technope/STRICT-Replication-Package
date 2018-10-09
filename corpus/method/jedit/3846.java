//{{{ save() method
void save() {
    jEdit.setIntegerProperty("view.dock." + position + ".dimension", dimension);
    if (current == null)
        jEdit.unsetProperty("view.dock." + position + ".last");
    else {
        jEdit.setProperty("view.dock." + position + ".last", current.factory.name);
    }
}