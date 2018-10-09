//}}}
//{{{ valueChanged() method
@Override
public void valueChanged(TreeSelectionEvent evt) {
    TreePath path = evt.getPath();
    if (path == null)
        return;
    Object lastPathComponent = path.getLastPathComponent();
    if (!(lastPathComponent instanceof String || lastPathComponent instanceof OptionPane)) {
        return;
    }
    Object[] nodes = path.getPath();
    StringBuilder buf = new StringBuilder();
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
            optionPane = deferredOptionPanes.get(node);
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
        buf.append(label);
        if (i != lastIdx)
            buf.append(": ");
    }
    if (optionPane == null)
        return;
    setTitle(jEdit.getProperty("options.title-template", new Object[] { jEdit.getProperty(name + ".title"), buf.toString() }));
    try {
        optionPane.init();
    } catch (Throwable t) {
        Log.log(Log.ERROR, this, "Error initializing options:", t);
    }
    currentPane = optionPane;
    stage.setViewportView(currentPane.getComponent());
    stage.revalidate();
    stage.repaint();
    updateSize();
    currentPane = optionPane;
}