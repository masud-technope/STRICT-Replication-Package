//{{{ LineSepWidget constructor
 LineSepWidget(final View view) {
    lineSep = new ToolTipLabel();
    lineSep.setHorizontalAlignment(SwingConstants.CENTER);
    lineSep.setToolTipText(jEdit.getProperty("view.status.linesep-tooltip"));
    this.view = view;
    lineSep.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent evt) {
            view.getBuffer().toggleLineSeparator(view);
        }
    });
//}}}
}