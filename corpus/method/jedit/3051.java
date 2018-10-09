@Override
protected void _save() {
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < listModel.getSize(); i++) {
        if (i != 0)
            buf.append(' ');
        buf.append(((MenuItem) listModel.elementAt(i)).actionName);
    }
    saveContextMenu(buf.toString());
}