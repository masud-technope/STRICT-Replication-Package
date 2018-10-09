public  PasteSpecialDialog(View view, TextArea textArea) {
    super(view, jEdit.getProperty("paste-special.title"), true);
    this.textArea = textArea;
    JPanel content = new JPanel(new BorderLayout());
    content.setBorder(new EmptyBorder(12, 12, 12, 12));
    setContentPane(content);
    Registers.Register register = Registers.getRegister('$');
    Transferable transferable = register.getTransferable();
    DataFlavor[] flavors = transferable.getTransferDataFlavors();
    List<DataFlavor> flavorList = Arrays.asList(flavors);
    List<DataFlavor> supportedFlavors = new ArrayList<DataFlavor>(this.flavors.length);
    for (DataFlavor flavor : this.flavors) {
        if (flavorList.contains(flavor)) {
            supportedFlavors.add(flavor);
        }
    }
    this.flavorList = new JList<DataFlavor>(supportedFlavors.toArray(new DataFlavor[supportedFlavors.size()]));
    this.flavorList.setCellRenderer(new DefaultListCellRenderer() {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value.equals(DataFlavor.stringFlavor)) {
                setText("Plain text");
            } else if (value.equals(JEditDataFlavor.jEditRichTextDataFlavor)) {
                setText("jEdit rich text");
            } else if (value.equals(JEditDataFlavor.html)) {
                setText("html");
            }
            return this;
        }
    });
    getContentPane().add(new JScrollPane(this.flavorList));
    //{{{ Buttons
    JPanel buttons = new JPanel();
    buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
    buttons.setBorder(new EmptyBorder(17, 0, 0, 0));
    buttons.add(Box.createGlue());
    JButton ok = new JButton(jEdit.getProperty("common.ok"));
    ok.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            ok();
        }
    });
    getRootPane().setDefaultButton(ok);
    buttons.add(ok);
    buttons.add(Box.createHorizontalStrut(6));
    JButton cancel = new JButton(jEdit.getProperty("common.cancel"));
    cancel.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            cancel();
        }
    });
    buttons.add(cancel);
    GenericGUIUtilities.makeSameSize(ok, cancel);
    content.add(BorderLayout.SOUTH, buttons);
    //}}}
    pack();
    setLocationRelativeTo(view);
    setVisible(true);
}