//{{{ PasteFromListDialog constructor
public  PasteFromListDialog(String name, View view, MutableListModel<String> model) {
    super(view, jEdit.getProperty(name + ".title"), true);
    this.view = view;
    this.listModel = model;
    JPanel content = new JPanel(new BorderLayout());
    content.setBorder(BorderFactory.createEmptyBorder(12, 12, 11, 11));
    setContentPane(content);
    JPanel center = new JPanel(new GridLayout(2, 1, 2, 12));
    int maxItemLength = jEdit.getIntegerProperty("paste-from-list.max-item-length", 1000);
    clips = new JList<String>(model);
    clips.setCellRenderer(new Renderer(maxItemLength));
    clips.setVisibleRowCount(12);
    clips.addMouseListener(new MouseHandler());
    clips.addListSelectionListener(new ListHandler());
    insert = new JButton(jEdit.getProperty("common.insert"));
    cancel = new JButton(jEdit.getProperty("common.cancel"));
    JLabel label = new JLabel(jEdit.getProperty(name + ".caption"));
    label.setBorder(BorderFactory.createEmptyBorder(0, 0, 6, 0));
    content.add(BorderLayout.NORTH, label);
    JScrollPane scroller = new JScrollPane(clips);
    scroller.setPreferredSize(new Dimension(500, 150));
    center.add(scroller);
    clipText = new JTextArea();
    clipText.setEditable(false);
    scroller = new JScrollPane(clipText);
    scroller.setPreferredSize(new Dimension(500, 150));
    center.add(scroller);
    content.add(center, BorderLayout.CENTER);
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
    panel.setBorder(new EmptyBorder(17, 0, 0, 0));
    panel.add(Box.createGlue());
    panel.add(insert);
    panel.add(Box.createHorizontalStrut(6));
    panel.add(cancel);
    GenericGUIUtilities.makeSameSize(insert, cancel);
    content.add(panel, BorderLayout.SOUTH);
    if (model.getSize() >= 1)
        clips.setSelectedIndex(0);
    updateButtons();
    getRootPane().setDefaultButton(insert);
    insert.addActionListener(new ActionHandler());
    cancel.addActionListener(new ActionHandler());
    GenericGUIUtilities.requestFocus(this, clips);
    pack();
    setLocationRelativeTo(view);
    setVisible(true);
}