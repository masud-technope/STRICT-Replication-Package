public void actionPerformed(ActionEvent evt) {
    int ind = Integer.parseInt(evt.getActionCommand());
    if (ind == -1) {
        if (index != -1)
            setText(current);
    } else {
        setText(historyModel.getItem(ind));
        index = ind;
    }
    if (instantPopups) {
        addCurrentToHistory();
        fireActionPerformed();
    }
}