//{{{ FilesChangedDialog constructor
public  FilesChangedDialog(View view, int[] states, boolean alreadyReloaded) {
    super(view, jEdit.getProperty("files-changed.title"), false);
    this.view = view;
    JPanel content = new JPanel(new BorderLayout());
    content.setBorder(BorderFactory.createEmptyBorder(12, 12, 11, 11));
    setContentPane(content);
    Box iconBox = new Box(BoxLayout.Y_AXIS);
    iconBox.add(new JLabel(UIManager.getIcon("OptionPane.warningIcon")));
    iconBox.add(Box.createGlue());
    content.add(BorderLayout.WEST, iconBox);
    JPanel centerPanel = new JPanel(new BorderLayout());
    JLabel label = new JLabel(jEdit.getProperty("files-changed.caption"));
    label.setBorder(BorderFactory.createEmptyBorder(0, 0, 6, 0));
    centerPanel.add(BorderLayout.NORTH, label);
    DefaultMutableTreeNode deleted = new DefaultMutableTreeNode(jEdit.getProperty("files-changed.deleted"), true);
    DefaultMutableTreeNode changed = new DefaultMutableTreeNode(jEdit.getProperty("files-changed.changed" + (alreadyReloaded ? "-auto" : "")), true);
    DefaultMutableTreeNode changedDirty = new DefaultMutableTreeNode(jEdit.getProperty("files-changed.changed-dirty" + (alreadyReloaded ? "-auto" : "")), true);
    Buffer[] buffers = jEdit.getBuffers();
    for (int i = 0; i < states.length; i++) {
        Buffer buffer = buffers[i];
        DefaultMutableTreeNode addTo;
        switch(states[i]) {
            case Buffer.FILE_DELETED:
                addTo = deleted;
                break;
            case Buffer.FILE_CHANGED:
                addTo = buffer.isDirty() ? changedDirty : changed;
                break;
            default:
                addTo = null;
                break;
        }
        if (addTo != null) {
            addTo.add(new DefaultMutableTreeNode(buffer.getPath()));
        }
    }
    root = new DefaultMutableTreeNode("", true);
    if (deleted.getChildCount() != 0) {
        root.add(deleted);
    }
    if (changed.getChildCount() != 0) {
        root.add(changed);
    }
    if (changedDirty.getChildCount() != 0) {
        root.add(changedDirty);
    }
    bufferTreeModel = new DefaultTreeModel(root);
    bufferTree = new JTree(bufferTreeModel);
    bufferTree.setRowHeight(0);
    bufferTree.setRootVisible(false);
    bufferTree.setVisibleRowCount(10);
    bufferTree.setCellRenderer(new Renderer());
    bufferTree.getSelectionModel().addTreeSelectionListener(new TreeHandler());
    bufferTree.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
    centerPanel.add(BorderLayout.CENTER, new JScrollPane(bufferTree));
    content.add(BorderLayout.CENTER, centerPanel);
    Box buttons = new Box(BoxLayout.X_AXIS);
    buttons.setBorder(BorderFactory.createEmptyBorder(17, 0, 0, 0));
    buttons.add(Box.createGlue());
    if (!alreadyReloaded) {
        selectAll = new JButton(jEdit.getProperty("files-changed.select-all"));
        selectAll.setMnemonic(jEdit.getProperty("files-changed.select-all.mnemonic").charAt(0));
        buttons.add(selectAll);
        selectAll.addActionListener(new ActionHandler());
        buttons.add(Box.createHorizontalStrut(6));
        reload = new JButton(jEdit.getProperty("files-changed.reload"));
        reload.setMnemonic(jEdit.getProperty("files-changed.reload.mnemonic").charAt(0));
        buttons.add(reload);
        reload.addActionListener(new ActionHandler());
        buttons.add(Box.createHorizontalStrut(6));
        ignore = new JButton(jEdit.getProperty("files-changed.ignore"));
        ignore.setMnemonic(jEdit.getProperty("files-changed.ignore.mnemonic").charAt(0));
        buttons.add(ignore);
        ignore.addActionListener(new ActionHandler());
        buttons.add(Box.createHorizontalStrut(6));
    }
    close = new JButton(jEdit.getProperty("common.close"));
    getRootPane().setDefaultButton(close);
    buttons.add(close);
    close.addActionListener(new ActionHandler());
    content.add(BorderLayout.SOUTH, buttons);
    bufferTree.expandPath(new TreePath(new Object[] { root, deleted }));
    bufferTree.expandPath(new TreePath(new Object[] { root, changed }));
    bufferTree.expandPath(new TreePath(new Object[] { root, changedDirty }));
    GenericGUIUtilities.requestFocus(this, bufferTree);
    updateEnabled();
    pack();
    setLocationRelativeTo(view);
    setVisible(true);
}