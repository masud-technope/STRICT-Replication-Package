 TextPanel(String file) {
    super(new BorderLayout());
    JEditorPane text = new JEditorPane();
    try {
        text.setPage(TextPanel.this.getClass().getResource(file));
    } catch (Exception e) {
        text.setText("Error loading '" + file + "'");
        e.printStackTrace();
    }
    text.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(text);
    Dimension dim = new Dimension();
    dim.width = 450;
    dim.height = 200;
    scrollPane.setPreferredSize(dim);
    TextPanel.this.add(BorderLayout.CENTER, scrollPane);
}