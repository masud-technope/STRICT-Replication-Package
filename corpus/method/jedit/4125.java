public  WrapWidget(final View view) {
    wrap = new ToolTipLabel();
    wrap.setHorizontalAlignment(SwingConstants.CENTER);
    this.view = view;
    wrap.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent evt) {
            view.getBuffer().toggleWordWrap(view);
        }
    });
}