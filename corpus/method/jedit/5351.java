//}}}
//{{{ getColumnClass() method
public Class getColumnClass(int col) {
    switch(col) {
        case 0:
        case 1:
            return String.class;
        default:
            throw new InternalError();
    }
}