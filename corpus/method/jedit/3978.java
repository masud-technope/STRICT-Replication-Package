//}}}
//{{{ paintString() method
private void paintString(Graphics g, String version, int drawOffsetX, int drawOffsetY) {
    g.setFont(labelFont);
    g.setColor(versionColor1);
    g.drawString(version, drawOffsetX, drawOffsetY);
    // Draw a highlight effect
    g.setColor(versionColor2);
    g.drawString(version, drawOffsetX + 1, drawOffsetY + 1);
}