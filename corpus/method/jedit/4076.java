public  ModeWidget(final View view) {
    mode = new ToolTipLabel();
    this.view = view;
    mode.setToolTipText(jEdit.getProperty("view.status.mode-tooltip"));
    mode.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent evt) {
            if (evt.getClickCount() == 2)
                new BufferOptions(view, view.getBuffer());
        }
    });
}