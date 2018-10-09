 RectSelectWidget(final View view) {
    rectSelect = new ToolTipLabel();
    rectSelect.setHorizontalAlignment(SwingConstants.CENTER);
    rectSelect.setToolTipText(jEdit.getProperty("view.status.rect-tooltip"));
    this.view = view;
    rectSelect.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent evt) {
            JEditTextArea textArea = view.getTextArea();
            if (textArea != null)
                textArea.toggleRectangularSelectionEnabled();
        }
    });
}