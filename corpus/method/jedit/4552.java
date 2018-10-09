//}}}
//{{{ getTargetName() method
@Nullable
private String getTargetName(Object session, VFS vfs, String path, String baseName) throws IOException {
    if (behavior == Behavior.OVERWRITE) {
        // We want to overwrite, no need to check anything
        return baseName;
    }
    String s = MiscUtilities.constructPath(target, baseName);
    VFSFile file = vfs._getFile(session, s, comp);
    if (file == null) {
        // The target file do not exist, perfect
        return baseName;
    }
    if (behavior == Behavior.SKIP)
        return null;
    String extension = MiscUtilities.getFileExtension(baseName);
    String nameNoExtension = MiscUtilities.getBaseName(baseName);
    for (int i = 1; i < 1000; i++) {
        String name = nameNoExtension + "-copy-" + i;
        if (extension != null)
            name += extension;
        s = MiscUtilities.constructPath(path, name);
        file = vfs._getFile(session, s, comp);
        if (file == null)
            return name;
    }
    return null;
}