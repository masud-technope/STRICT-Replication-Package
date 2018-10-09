//{{{ FileRootsVFS constructor
public  FileRootsVFS() {
    super("roots", LOW_LATENCY_CAP | BROWSE_CAP | NON_AWT_SESSION_CAP, new String[] { EA_TYPE });
}