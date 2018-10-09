//}}}
/* read() and write() must be kept perfectly in sync...
		 * its a very simple file format. doing it this way is
		 * faster than serializing since serialization calls
		 * reflection, etc. */
//{{{ read() method
public boolean read(DataInputStream din) throws IOException {
    int cacheMagic = din.readInt();
    if (cacheMagic != MAGIC)
        return false;
    String cacheBuild = readString(din);
    if (!cacheBuild.equals(jEdit.getBuild()))
        return false;
    long cacheModTime = din.readLong();
    if (cacheModTime != modTime)
        return false;
    actionsURI = readURI(din);
    cachedActionNames = readStringArray(din);
    cachedActionToggleFlags = readBooleanArray(din);
    browserActionsURI = readURI(din);
    cachedBrowserActionNames = readStringArray(din);
    cachedBrowserActionToggleFlags = readBooleanArray(din);
    dockablesURI = readURI(din);
    cachedDockableNames = readStringArray(din);
    cachedDockableActionFlags = readBooleanArray(din);
    cachedDockableMovableFlags = readBooleanArray(din);
    servicesURI = readURI(din);
    int len = din.readInt();
    if (len == 0)
        cachedServices = null;
    else {
        cachedServices = new ServiceManager.Descriptor[len];
        for (int i = 0; i < len; i++) {
            ServiceManager.Descriptor d = new ServiceManager.Descriptor(readString(din), readString(din), null, plugin);
            cachedServices[i] = d;
        }
    }
    classes = readStringArray(din);
    resources = readStringArray(din);
    cachedProperties = readMap(din);
    localizationProperties = readLanguagesMap(din);
    pluginClass = readString(din);
    return true;
//}}}
}