//}}}
//{{{ getColumnName() method
public String getColumnName(int index) {
    switch(index) {
        case 0:
            return jEdit.getProperty("options.browser.colors.glob");
        case 1:
            return jEdit.getProperty("options.browser.colors.color");
        default:
            return null;
    }
}