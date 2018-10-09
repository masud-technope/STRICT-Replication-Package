//{{{ getColumnClass() method
@Override
public Class getColumnClass(int columnIndex) {
    switch(columnIndex) {
        case 0:
            return Boolean.class;
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
            return Object.class;
        default:
            throw new Error("Column out of range");
    }
//}}}
}