 LockedWidget(final View view) {
    cmp = new ToolTipLabel();
    cmp.setHorizontalAlignment(SwingConstants.CENTER);
    this.view = view;
    cmp.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent evt) {
            view.getBuffer().toggleLocked(view);
        }
    });
}