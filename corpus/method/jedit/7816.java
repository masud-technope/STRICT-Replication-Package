//}}}
//{{{ getKeymapNames() method
@Override
public Collection<String> getKeymapNames() {
    Collection<String> systemKeymapNames = getKeymapsFromFolder(systemKeymapFolder);
    Collection<String> userKeymapNames = getKeymapsFromFolder(userKeymapFolder);
    Set<String> keyMaps = new HashSet<String>();
    keyMaps.addAll(systemKeymapNames);
    keyMaps.addAll(userKeymapNames);
    return keyMaps;
}