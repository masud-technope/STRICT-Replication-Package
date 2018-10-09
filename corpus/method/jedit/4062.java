//{{{ MemoryStatus constructor
 MemoryStatus(View view) {
    this.view = view;
    // fucking GTK look and feel
    Font font = new JLabel().getFont();
    //Font font = UIManager.getFont("Label.font");
    MemoryStatus.this.setFont(font);
    FontRenderContext frc = new FontRenderContext(null, true, false);
    Rectangle2D bounds = font.getStringBounds(memoryTestStr, frc);
    Dimension dim = new Dimension((int) bounds.getWidth(), (int) bounds.getHeight());
    setPreferredSize(dim);
    setMaximumSize(dim);
    lm = font.getLineMetrics(memoryTestStr, frc);
    setForeground(jEdit.getColorProperty("view.status.foreground"));
    setBackground(jEdit.getColorProperty("view.status.background"));
    progressForeground = jEdit.getColorProperty("view.status.memory.foreground");
    progressBackground = jEdit.getColorProperty("view.status.memory.background");
    addMouseListener(new MouseHandler());
//}}}
}