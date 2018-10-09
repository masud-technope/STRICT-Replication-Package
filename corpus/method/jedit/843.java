@Override
public Object getItem() {
    if (current == null) {
        current = new GlobVFSFileFilter(getText());
    }
    if (!current.getGlob().equals(getText())) {
        current.setGlob(getText());
    }
    return current;
}