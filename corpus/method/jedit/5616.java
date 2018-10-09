//{{{ write() method
public void write(DataOutputStream dout) throws IOException {
    dout.writeInt(MAGIC);
    writeString(dout, jEdit.getBuild());
    dout.writeLong(modTime);
    writeString(dout, actionsURI);
    writeStringArray(dout, cachedActionNames);
    writeBooleanArray(dout, cachedActionToggleFlags);
    writeString(dout, browserActionsURI);
    writeStringArray(dout, cachedBrowserActionNames);
    writeBooleanArray(dout, cachedBrowserActionToggleFlags);
    writeString(dout, dockablesURI);
    writeStringArray(dout, cachedDockableNames);
    writeBooleanArray(dout, cachedDockableActionFlags);
    writeBooleanArray(dout, cachedDockableMovableFlags);
    writeString(dout, servicesURI);
    if (cachedServices == null)
        dout.writeInt(0);
    else {
        dout.writeInt(cachedServices.length);
        for (ServiceManager.Descriptor cachedService : cachedServices) {
            writeString(dout, cachedService.clazz);
            writeString(dout, cachedService.name);
        }
    }
    writeStringArray(dout, classes);
    writeStringArray(dout, resources);
    writeMap(dout, cachedProperties);
    writeLanguages(dout, localizationProperties);
    writeString(dout, pluginClass);
//}}}
}