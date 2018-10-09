//}}}
//}}}
//{{{ Property methods
//{{{ propertiesChanged() method
/**
	 * Reloads settings from the properties. This should be called
	 * after the <code>syntax</code> or <code>folding</code>
	 * buffer-local properties are changed.
	 */
@Override
public void propertiesChanged() {
    super.propertiesChanged();
    longLineLimit = jEdit.getIntegerProperty("longLineLimit", 4000);
    String largefilemode = getStringProperty("largefilemode");
    longBufferMode = "limited".equals(largefilemode) || "nohighlight".equals(largefilemode);
    if (!autoreloadOverridden) {
        setAutoReloadDialog(jEdit.getBooleanProperty("autoReloadDialog"));
        setAutoReload(jEdit.getBooleanProperty("autoReload"));
    }
    if (!isTemporary())
        EditBus.send(new BufferUpdate(this, null, BufferUpdate.PROPERTIES_CHANGED));
}