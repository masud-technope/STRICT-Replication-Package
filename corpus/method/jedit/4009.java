public  EncodingWidget(final View view) {
    encoding = new ToolTipLabel();
    this.view = view;
    encoding.setToolTipText(jEdit.getProperty("view.status.mode-tooltip"));
    encoding.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent evt) {
            if (evt.getClickCount() == 2)
                new BufferOptions(view, view.getBuffer());
        }
    });
}