//}}}
//{{{ getColumnName() method
public String getColumnName(int index) {
    switch(index) {
        case 0:
            return jEdit.getProperty("options.docking.title");
        case 1:
            return jEdit.getProperty("options.docking.dockPosition");
        default:
            throw new InternalError();
    }
}