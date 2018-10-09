//{{{ actionPerformed() method
public void actionPerformed(ActionEvent evt) {
    if (evt.getSource() == ok)
        dispose();
    else if (evt.getSource() == pluginMgr) {
        PluginManager.showPluginManager(JOptionPane.getFrameForComponent(ErrorListDialog.this));
    }
//}}}
}