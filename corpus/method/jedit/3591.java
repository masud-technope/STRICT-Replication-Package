//}}}
//{{{ init() method
private void init(KeyBinding binding, List<KeyBinding> allBindings, Buffer debugBuffer) {
    this.binding = binding;
    this.allBindings = allBindings;
    this.debugBuffer = debugBuffer;
    enableEvents(AWTEvent.KEY_EVENT_MASK);
    // create a panel with a BoxLayout. Can't use Box here
    // because Box doesn't have setBorder().
    JPanel content = new JPanel(new GridLayout(0, 1, 0, 6)) {

        /**
			 * Makes the tab key work in Java 1.4.
			 * @since jEdit 3.2pre4
			 */
        @Override
        public boolean getFocusTraversalKeysEnabled() {
            return false;
        }
    };
    content.setBorder(new EmptyBorder(12, 12, 12, 12));
    setContentPane(content);
    JLabel label = new JLabel(debugBuffer == null ? jEdit.getProperty("grab-key.caption", new String[] { binding.label }) : jEdit.getProperty("grab-key.keyboard-test"));
    Box input = Box.createHorizontalBox();
    shortcut = new InputPane();
    Dimension size = shortcut.getPreferredSize();
    size.width = Integer.MAX_VALUE;
    shortcut.setMaximumSize(size);
    input.add(shortcut);
    input.add(Box.createHorizontalStrut(12));
    clear = new JButton(jEdit.getProperty("grab-key.clear"));
    clear.addActionListener(new ActionHandler());
    input.add(clear);
    assignedTo = new JLabel();
    if (debugBuffer == null)
        updateAssignedTo(null);
    Box buttons = Box.createHorizontalBox();
    buttons.setBorder(BorderFactory.createEmptyBorder(17, 0, 0, 0));
    buttons.add(Box.createGlue());
    if (debugBuffer == null) {
        ok = new JButton(jEdit.getProperty("common.ok"));
        ok.addActionListener(new ActionHandler());
        buttons.add(ok);
        buttons.add(Box.createHorizontalStrut(6));
        if (binding.isAssigned()) {
            // show "remove" button
            remove = new JButton(jEdit.getProperty("grab-key.remove"));
            remove.addActionListener(new ActionHandler());
            buttons.add(remove);
            buttons.add(Box.createHorizontalStrut(6));
        }
    }
    cancel = new JButton(jEdit.getProperty("common.cancel"));
    cancel.addActionListener(new ActionHandler());
    buttons.add(cancel);
    GenericGUIUtilities.makeSameSize(ok, cancel);
    content.add(label);
    content.add(input);
    if (debugBuffer == null)
        content.add(assignedTo);
    content.add(buttons);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    pack();
    setLocationRelativeTo(getParent());
    setResizable(false);
    setVisible(true);
}