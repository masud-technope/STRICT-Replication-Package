public void actionPerformed(ActionEvent evt) {
    // TODO: update this, use CombinedOptins instead of GlobalOptions
    // and PluginOptions
    Object source = evt.getSource();
    if (source == done)
        ok();
    else if (source == mgrOptions)
        new GlobalOptions(PluginManager.this, "plugin-manager");
    else if (source == pluginOptions)
        new PluginOptions(PluginManager.this);
}