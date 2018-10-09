//}}}
//{{{ update() method
public void update() {
    if (encodingMenuItems != null && browser.currentEncoding != null) {
        JRadioButtonMenuItem mi = encodingMenuItems.get(browser.currentEncoding);
        if (mi != null) {
            mi.setSelected(true);
            otherEncoding.setText(jEdit.getProperty("vfs.browser.other-encoding.label"));
        } else {
            otherEncoding.setSelected(true);
            otherEncoding.setText(jEdit.getProperty("vfs.browser.other-encoding-2.label", new String[] { browser.currentEncoding }));
        }
    }
}