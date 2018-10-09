private ActionListener getCancelButtonListener() {
    return new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            PrinterDialog.this.setVisible(false);
            PrinterDialog.this.dispose();
            canceled = true;
        }
    };
}