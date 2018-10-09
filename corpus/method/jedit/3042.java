//{{{ AboutDialog constructor
public  AboutDialog(View view) {
    super(view, jEdit.getProperty("about.title"), true);
    setResizable(false);
    JPanel p = new JPanel(new BorderLayout());
    p.setBorder(BorderFactory.createEmptyBorder(12, 12, 11, 11));
    final AboutPanel aboutPanel = new AboutPanel();
    p.add(aboutPanel);
    JButton closeBtn = new JButton(jEdit.getProperty("common.close"));
    closeBtn.addActionListener(this);
    getRootPane().setDefaultButton(closeBtn);
    closeBtn.setToolTipText(jEdit.getProperty("about.navigate"));
    closeBtn.addKeyListener(new KeyAdapter() {

        public void keyPressed(KeyEvent e) {
            aboutPanel.handleKeyEvent(e);
        }
    });
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(17, 0, 0, 0));
    buttonPanel.add(Box.createGlue());
    buttonPanel.add(closeBtn);
    p.add(buttonPanel, BorderLayout.SOUTH);
    setContentPane(p);
    pack();
    setLocationRelativeTo(jEdit.getActiveView());
    addWindowListener(new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent e) {
            closeDialog();
        }
    });
    setVisible(true);
}