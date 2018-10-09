//{{{ ActionBar constructor
public  ActionBar(View view, boolean temp) {
    this.view = view;
    this.temp = temp;
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    setFloatable(false);
    add(Box.createHorizontalStrut(2));
    JLabel label = new JLabel(jEdit.getProperty("view.action.prompt"));
    add(label);
    add(Box.createHorizontalStrut(12));
    add(action = new ActionTextField());
    action.setEnterAddsToHistory(false);
    Dimension max = action.getPreferredSize();
    max.width = Integer.MAX_VALUE;
    action.setMaximumSize(max);
    action.addActionListener(new ActionHandler());
    action.getDocument().addDocumentListener(new DocumentHandler());
    if (temp) {
        close = new RolloverButton(GUIUtilities.loadIcon("closebox.gif"));
        close.addActionListener(new ActionHandler());
        close.setToolTipText(jEdit.getProperty("view.action.close-tooltip"));
        add(close);
    }
    // if 'temp' is true, hide search bar after user is done with it
    this.temp = temp;
}