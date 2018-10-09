//}}}
//{{{ _save() method
public void _save() {
    jEdit.setBooleanProperty("firewall.enabled", httpEnabled.isSelected());
    jEdit.setProperty("firewall.host", httpHost.getText());
    jEdit.setProperty("firewall.port", httpPort.getText());
    jEdit.setProperty("firewall.user", httpUser.getText());
    jEdit.setProperty("firewall.password", new String(httpPass.getPassword()));
    jEdit.setProperty("firewall.nonProxyHosts", httpNonProxy.getText());
    jEdit.setBooleanProperty("firewall.socks.enabled", socksEnabled.isSelected());
    jEdit.setProperty("firewall.socks.host", socksHost.getText());
    jEdit.setProperty("firewall.socks.port", socksPort.getText());
}