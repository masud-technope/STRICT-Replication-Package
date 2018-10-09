// {{{ valueChanged() method
public void valueChanged(TreeSelectionEvent evt) {
    TreePath path = evt.getPath();
    if (path == null)
        return;
    Object lastPathComponent = path.getLastPathComponent();
    if (!(lastPathComponent instanceof String || lastPathComponent instanceof OptionPane)) {
        return;
    }
    Object[] nodes = path.getPath();
    StringBuilder sb = new StringBuilder();
    OptionPane optionPane = null;
    int lastIdx = nodes.length - 1;
    for (int i = paneTree.isRootVisible() ? 0 : 1; i <= lastIdx; i++) {
        String label;
        Object node = nodes[i];
        if (node instanceof OptionPane) {
            optionPane = (OptionPane) node;
            label = jEdit.getProperty("options." + optionPane.getName() + ".label");
        } else if (node instanceof OptionGroup) {
            label = ((OptionGroup) node).getLabel();
        } else if (node instanceof String) {
            label = jEdit.getProperty("options." + node + ".label");
            optionPane = (OptionPane) deferredOptionPanes.get((String) node);
            if (optionPane == null) {
                String propName = "options." + node + ".code";
                String code = jEdit.getProperty(propName);
                if (code != null) {
                    optionPane = (OptionPane) BeanShell.eval(jEdit.getActiveView(), BeanShell.getNameSpace(), code);
                    if (optionPane != null) {
                        deferredOptionPanes.put(node, optionPane);
                    } else
                        continue;
                } else {
                    Log.log(Log.ERROR, this, propName + " not defined");
                    continue;
                }
            }
        } else {
            continue;
        }
        if (label != null)
            sb.append(label);
        if (i > 0 && i < lastIdx)
            sb.append(": ");
    }
    if (optionPane == null)
        return;
    String ttext = jEdit.getProperty("optional.title-template", new Object[] { optionGroup.getName(), sb.toString() });
    setTitle(ttext);
    try {
        optionPane.init();
    } catch (Throwable t) {
        Log.log(Log.ERROR, this, "Error initializing option pane:");
        Log.log(Log.ERROR, this, t);
    }
    if (currentPane != null)
        stage.remove(currentPane.getComponent());
    currentPane = optionPane;
    stage.add(BorderLayout.CENTER, currentPane.getComponent());
    stage.revalidate();
    stage.repaint();
    currentPane = optionPane;
}