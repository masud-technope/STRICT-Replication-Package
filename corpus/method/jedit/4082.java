 MultiSelectWidget(final View view) {
    multiSelect = new ToolTipLabel();
    multiSelect.setHorizontalAlignment(SwingConstants.CENTER);
    multiSelect.setToolTipText(jEdit.getProperty("view.status.multi-tooltip"));
    this.view = view;
    multiSelect.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {
            JEditTextArea textArea = view.getTextArea();
            if (textArea != null)
                textArea.toggleMultipleSelectionEnabled();
        }
    });
}