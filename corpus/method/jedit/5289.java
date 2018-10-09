//}}}
//{{{ _save() method
@Override
protected void _save() {
    if (lnfChanged) {
        String lf = lfs[lookAndFeel.getSelectedIndex()].getClassName();
        jEdit.setProperty("lookAndFeel", lf);
    }
    jEdit.setFontProperty("metal.primary.font", primaryFont.getFont());
    jEdit.setFontProperty("metal.secondary.font", secondaryFont.getFont());
    jEdit.setFontProperty("helpviewer.font", helpViewerFont.getFont());
    jEdit.setProperty("history", history.getText());
    jEdit.setProperty("menu.spillover", menuSpillover.getText());
    jEdit.setBooleanProperty("tip.show", showTips.isSelected());
    jEdit.setBooleanProperty("systrayicon", systemTrayIcon.isSelected());
    IconTheme.set(iconThemes.getSelectedItem().toString());
    /* AntiAlias nv = AntiAlias.appearance();
		 int idx = antiAliasExtras.getSelectedIndex();
		nv.set(idx);
		primaryFont.setAntiAliasEnabled(idx > 0);
		secondaryFont.setAntiAliasEnabled(idx > 0);
		primaryFont.repaint();
		secondaryFont.repaint(); */
    // This is handled a little differently from other jEdit settings
    // as this flag needs to be known very early in the
    // startup sequence, before the user properties have been loaded
    setFileFlag("nosplash", !showSplash.isSelected());
    jEdit.setBooleanProperty("textColors", textColors.isSelected());
    jEdit.setBooleanProperty("decorate.frames", decorateFrames.isSelected());
    jEdit.setBooleanProperty("decorate.dialogs", decorateDialogs.isSelected());
}