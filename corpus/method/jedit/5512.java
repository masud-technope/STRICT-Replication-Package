//{{{ getValueAt() method
public Object getValueAt(int row, int col) {
    StyleChoice ch = styleChoices.get(row);
    switch(col) {
        case 0:
            return ch.label;
        case 1:
            return ch.style;
        default:
            return null;
    }
//}}}
}