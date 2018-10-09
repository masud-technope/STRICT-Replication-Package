//}}}
//{{{ getSystemKeymapFile() method
private File getSystemKeymapFile(String name) {
    return new File(systemKeymapFolder, name + "_keys.props");
}