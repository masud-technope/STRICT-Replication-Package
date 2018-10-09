//}}}
//{{{ updateEnabled() method
private void updateEnabled() {
    String className = lfs[lookAndFeel.getSelectedIndex()].getClassName();
    if (className.equals("javax.swing.plaf.metal.MetalLookAndFeel") || className.equals("com.incors.plaf.kunststoff.KunststoffLookAndFeel")) {
        primaryFont.setEnabled(true);
        secondaryFont.setEnabled(true);
    } else {
        primaryFont.setEnabled(false);
        secondaryFont.setEnabled(false);
    }
}