public  FoldWidget(final View view) {
    fold = new ToolTipLabel();
    this.view = view;
    fold.setToolTipText(jEdit.getProperty("view.status.mode-tooltip"));
    fold.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent evt) {
            if (evt.getClickCount() == 2)
                new BufferOptions(view, view.getBuffer());
        }
    });
}