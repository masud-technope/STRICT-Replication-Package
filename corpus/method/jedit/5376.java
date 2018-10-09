//}}}
//{{{ _init() method
public void _init() {
    // checkbox
    addComponent(httpEnabled = new JCheckBox(jEdit.getProperty("options.firewall.http.enabled")));
    // proxy host
    addComponent(jEdit.getProperty("options.firewall.http.host"), httpHost = new JTextField(jEdit.getProperty("firewall.host"), 15));
    // proxy port
    addComponent(jEdit.getProperty("options.firewall.http.port"), httpPort = new JTextField(jEdit.getProperty("firewall.port"), 15));
    // proxy username
    addComponent(jEdit.getProperty("options.firewall.http.user"), httpUser = new JTextField(jEdit.getProperty("firewall.user"), 15));
    // proxy password
    addComponent(jEdit.getProperty("options.firewall.http.password"), httpPass = new JPasswordField(jEdit.getProperty("firewall.password"), 15));
    // no proxy for
    addComponent(jEdit.getProperty("options.firewall.http.nonProxy"), httpNonProxy = new JTextField(jEdit.getProperty("firewall.nonProxyHosts"), 15));
    boolean enabled = jEdit.getBooleanProperty("firewall.enabled");
    httpEnabled.setSelected(enabled);
    httpHost.setEnabled(enabled);
    httpPort.setEnabled(enabled);
    httpUser.setEnabled(enabled);
    httpPass.setEnabled(enabled);
    httpNonProxy.setEnabled(enabled);
    httpEnabled.addActionListener(new ActionHandler());
    // checkbox
    addComponent(socksEnabled = new JCheckBox(jEdit.getProperty("options.firewall.socks.enabled")));
    // proxy host
    addComponent(jEdit.getProperty("options.firewall.socks.host"), socksHost = new JTextField(jEdit.getProperty("firewall.socks.host"), 15));
    // proxy port
    addComponent(jEdit.getProperty("options.firewall.socks.port"), socksPort = new JTextField(jEdit.getProperty("firewall.socks.port"), 15));
    enabled = jEdit.getBooleanProperty("firewall.socks.enabled");
    socksEnabled.setSelected(enabled);
    socksHost.setEnabled(enabled);
    socksPort.setEnabled(enabled);
    socksEnabled.addActionListener(new ActionHandler());
}