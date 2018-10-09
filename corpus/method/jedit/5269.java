//{{{ getValueAt() method
public Object getValueAt(int row, int col) {
    Abbrev abbrev = abbrevs.get(row);
    switch(col) {
        case 0:
            return abbrev.abbrev;
        case 1:
            return abbrev.expand;
        default:
            return null;
    }
//}}}
}