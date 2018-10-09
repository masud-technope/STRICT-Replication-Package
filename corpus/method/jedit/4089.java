 OverwriteWidget(final View view) {
    overwrite = new ToolTipLabel();
    overwrite.setHorizontalAlignment(SwingConstants.CENTER);
    overwrite.setToolTipText(jEdit.getProperty("view.status.overwrite-tooltip"));
    this.view = view;
    overwrite.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent evt) {
            JEditTextArea textArea = view.getTextArea();
            if (textArea != null)
                textArea.toggleOverwriteEnabled();
        }
    });
}