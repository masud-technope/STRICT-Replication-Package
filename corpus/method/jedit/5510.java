//{{{ getColumnName() method
@Override
public String getColumnName(int index) {
    switch(index) {
        case 0:
            return jEdit.getProperty("options.syntax.object");
        case 1:
            return jEdit.getProperty("options.syntax.style");
        default:
            return null;
    }
//}}}
}