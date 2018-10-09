private void update() {
    Object[] args = { nbPlugins, formatSize(size) };
    setText(jEdit.getProperty("install-plugins.totalSize", args));
}