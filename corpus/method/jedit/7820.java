//}}}
//{{{ getKeymapFile() method
private File getKeymapFile(String name) {
    File file = getUserKeymapFile(name);
    if (!file.isFile())
        file = getSystemKeymapFile(name);
    return file;
}