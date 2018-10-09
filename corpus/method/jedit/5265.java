//{{{ getColumnName() method
@Override
public String getColumnName(int index) {
    switch(index) {
        case 0:
            return jEdit.getProperty("options.abbrevs.abbrev");
        case 1:
            return jEdit.getProperty("options.abbrevs.expand");
        default:
            return null;
    }
//}}}
}