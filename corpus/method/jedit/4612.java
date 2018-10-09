//{{{ FileVFS constructor
public  FileVFS() {
    super("file", READ_CAP | WRITE_CAP | BROWSE_CAP | DELETE_CAP | RENAME_CAP | MKDIR_CAP | LOW_LATENCY_CAP | NON_AWT_SESSION_CAP | (OperatingSystem.isCaseInsensitiveFS() ? CASE_INSENSITIVE_CAP : 0), new String[] { EA_SIZE, EA_MODIFIED, EA_STATUS, EA_TYPE });
}