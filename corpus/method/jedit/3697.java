@Override
public Class getColumnClass(int col) {
    switch(col) {
        case 0:
            return Boolean.class;
        case 1:
            return String.class;
        default:
            throw new InternalError();
    }
}