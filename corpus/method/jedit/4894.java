//}}}
//{{{ initProxy() method
private static void initProxy() {
    boolean socksEnabled = jEdit.getBooleanProperty("firewall.socks.enabled");
    if (!socksEnabled) {
        Log.log(Log.DEBUG, jEdit.class, "SOCKS proxy disabled");
        System.getProperties().remove("socksProxyHost");
        System.getProperties().remove("socksProxyPort");
    } else {
        String socksHost = jEdit.getProperty("firewall.socks.host");
        if (socksHost != null) {
            System.setProperty("socksProxyHost", socksHost);
            Log.log(Log.DEBUG, jEdit.class, "SOCKS proxy enabled: " + socksHost);
        }
        String socksPort = jEdit.getProperty("firewall.socks.port");
        if (socksPort != null)
            System.setProperty("socksProxyPort", socksPort);
    }
    boolean httpEnabled = jEdit.getBooleanProperty("firewall.enabled");
    if (!httpEnabled) {
        Log.log(Log.DEBUG, jEdit.class, "HTTP proxy disabled");
        System.getProperties().remove("proxySet");
        System.getProperties().remove("proxyHost");
        System.getProperties().remove("proxyPort");
        System.getProperties().remove("http.proxyHost");
        System.getProperties().remove("http.proxyPort");
        System.getProperties().remove("http.nonProxyHosts");
        Authenticator.setDefault(null);
    } else {
        // set proxy host
        String host = jEdit.getProperty("firewall.host");
        if (host == null)
            return;
        System.setProperty("http.proxyHost", host);
        Log.log(Log.DEBUG, jEdit.class, "HTTP proxy enabled: " + host);
        // set proxy port
        String port = jEdit.getProperty("firewall.port");
        if (port != null)
            System.setProperty("http.proxyPort", port);
        // set non proxy hosts list
        String nonProxyHosts = jEdit.getProperty("firewall.nonProxyHosts");
        if (nonProxyHosts != null)
            System.setProperty("http.nonProxyHosts", nonProxyHosts);
        // set proxy authentication
        String username = jEdit.getProperty("firewall.user");
        String password = jEdit.getProperty("firewall.password");
        // null not supported?
        if (password == null)
            password = "";
        if (username == null || username.length() == 0) {
            Log.log(Log.DEBUG, jEdit.class, "HTTP proxy without user");
            Authenticator.setDefault(new FirewallAuthenticator(null));
        } else {
            Log.log(Log.DEBUG, jEdit.class, "HTTP proxy user: " + username);
            PasswordAuthentication pw = new PasswordAuthentication(username, password.toCharArray());
            Authenticator.setDefault(new FirewallAuthenticator(pw));
        }
    }
}