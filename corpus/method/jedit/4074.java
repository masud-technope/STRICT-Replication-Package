//{{{ paintComponent() method
@Override
public void paintComponent(Graphics g) {
    //MemoryStatus.this.getBorder().getBorderInsets(this);
    Insets insets = new Insets(0, 0, 0, 0);
    Runtime runtime = Runtime.getRuntime();
    long free = runtime.freeMemory();
    long total = runtime.totalMemory();
    long used = total - free;
    int width = MemoryStatus.this.getWidth() - insets.left - insets.right;
    int height = MemoryStatus.this.getHeight() - insets.top - insets.bottom - 1;
    float fraction = ((float) used) / total;
    g.setColor(progressBackground);
    g.fillRect(insets.left, insets.top, (int) (width * fraction), height);
    String str = (used / 1024 / 1024) + "/" + (total / 1024 / 1024) + "MB";
    FontRenderContext frc = new FontRenderContext(null, true, false);
    Rectangle2D bounds = g.getFont().getStringBounds(str, frc);
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    g2.setClip(insets.left, insets.top, (int) (width * fraction), height);
    g2.setColor(progressForeground);
    g2.drawString(str, insets.left + ((int) (width - bounds.getWidth()) / 2), (int) (insets.top + lm.getAscent()));
    g2.setClip(insets.left + (int) (width * fraction), insets.top, MemoryStatus.this.getWidth() - insets.left - (int) (width * fraction), height);
    g2.setColor(MemoryStatus.this.getForeground());
    g2.drawString(str, insets.left + ((int) (width - bounds.getWidth()) >> 1), (int) (insets.top + lm.getAscent()));
    g2.dispose();
//}}}
}