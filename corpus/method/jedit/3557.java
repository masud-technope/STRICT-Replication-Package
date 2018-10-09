//}}}
//{{{ setAntiAliasEnabled() method
void setAntiAliasEnabled(Graphics g) {
    if (antiAlias) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
}