@Override
public void mouseClicked(MouseEvent evt) {
    switch(abbrevsTable.getTableHeader().columnAtPoint(evt.getPoint())) {
        case 0:
            ((AbbrevsModel) abbrevsTable.getModel()).sort(0);
            break;
        case 1:
            ((AbbrevsModel) abbrevsTable.getModel()).sort(1);
            break;
    }
}