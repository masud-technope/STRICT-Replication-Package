public  IndentWidget(final View view) {
    indent = new ToolTipLabel();
    indent.setHorizontalAlignment(SwingConstants.CENTER);
    this.view = view;
    indent.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent evt) {
            Buffer buffer = view.getBuffer();
            buffer.toggleAutoIndent(view);
            update();
        }
    });
}