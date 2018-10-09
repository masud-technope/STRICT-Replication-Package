//}}}
//{{{ getColumnClass() method
public Class getColumnClass(int col) {
    switch(col) {
        case 0:
            return String.class;
        case 1:
            return Color.class;
        default:
            throw new InternalError();
    }
}