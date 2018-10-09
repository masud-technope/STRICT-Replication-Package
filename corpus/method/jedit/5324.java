//{{{ actionPerformed() method
public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == mode) {
        Mode _mode = (Mode) mode.getSelectedItem();
        folding.setSelectedItem(_mode.getProperty("folding"));
        wrap.setSelectedItem(_mode.getProperty("wrap"));
        maxLineLen.setSelectedItem(_mode.getProperty("maxLineLen"));
        tabSize.setSelectedItem(_mode.getProperty("tabSize"));
        indentSize.setSelectedItem(_mode.getProperty("indentSize"));
        noTabs.setSelected(_mode.getBooleanProperty("noTabs"));
        elasticTabstops.setSelected(_mode.getBooleanProperty("elasticTabstops"));
    }
//}}}
}