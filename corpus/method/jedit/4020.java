@Override
public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source == removeThisError) {
        Throwable throwable = (Throwable) combo.getSelectedItem();
        if (throwable != null) {
            Log.throwables.remove(throwable);
            combo.removeItem(throwable);
            if (combo.getItemCount() == 0) {
                dispose();
            }
        }
    } else if (source == removeAllErrors) {
        for (Object throwable : throwables) {
            Log.throwables.remove(throwable);
        }
        dispose();
    }
}