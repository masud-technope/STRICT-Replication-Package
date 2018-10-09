//}}}
//{{{ getRegisteredDockableWindows() method
public String[] getRegisteredDockableWindows() {
    String[] retVal = new String[dockableWindowFactories.size()];
    Iterator<Window> entries = dockableWindowFactories.values().iterator();
    int i = 0;
    while (entries.hasNext()) {
        Window factory = entries.next();
        retVal[i++] = factory.name;
    }
    return retVal;
}