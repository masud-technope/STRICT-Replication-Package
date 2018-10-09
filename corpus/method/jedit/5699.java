//{{{ getColumnClass() method
@Override
public Class getColumnClass(int columnIndex) {
    switch(columnIndex) {
        case 0:
            return Boolean.class;
        default:
            return Object.class;
    }
//}}}
}