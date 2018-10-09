@Override
protected void configureTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
    String name = null;
    if (value instanceof OptionGroup) {
        setText(((OptionGroup) value).getLabel());
        setFont(groupFont);
    } else if (value instanceof OptionPane) {
        name = ((OptionPane) value).getName();
        setFont(paneFont);
    } else if (value instanceof String) {
        name = (String) value;
        setFont(paneFont);
    }
    if (name != null) {
        String label = jEdit.getProperty("options." + name + ".label");
        if (label == null) {
            setText("NO LABEL PROPERTY: " + name);
        } else {
            setText(label);
        }
    }
    setIcon(null);
}