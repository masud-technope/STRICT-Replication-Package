//}}}
//{{{ getUserKeymapFile() method
static File getUserKeymapFile(String name) {
    return new File(userKeymapFolder, name + "_keys.props");
}