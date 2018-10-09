private void installComponents() {
    // toolbar components
    pages = new JComboBox<Integer>();
    nextPage = new JButton(GUIUtilities.loadIcon("22x22/actions/go-next.png"));
    nextPage.setToolTipText(jEdit.getProperty("printpreview.dialog.nextPage", "Next Page"));
    prevPage = new JButton(GUIUtilities.loadIcon("22x22/actions/go-previous.png"));
    prevPage.setToolTipText(jEdit.getProperty("printpreview.dialog.prevPage", "Previous Page"));
    zoomIn = new JButton(GUIUtilities.loadIcon("22x22/actions/zoom-in.png"));
    zoomIn.setToolTipText(jEdit.getProperty("printpreview.dialog.zoomin", "Zoom In"));
    zoomOut = new JButton(GUIUtilities.loadIcon("22x22/actions/zoom-out.png"));
    zoomOut.setToolTipText(jEdit.getProperty("printpreview.dialog.zoomout", "Zoom Out"));
    // horisontal! yes, that's right
    fullWidth = new JButton(GUIUtilities.loadIcon("22x22/actions/resize-horisontal.png"));
    fullWidth.setToolTipText(jEdit.getProperty("printpreview.dialog.pageWidth", "Show page full width"));
    fullPage = new JButton(GUIUtilities.loadIcon("22x22/actions/resize-vertical.png"));
    fullPage.setToolTipText(jEdit.getProperty("printpreview.dialog.fullPage", "Show full page"));
    // create toolbar
    JPanel toolbar = new JPanel();
    toolbar.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 6));
    toolbar.add(new JLabel("Page "));
    toolbar.add(pages);
    toolbar.add(prevPage);
    toolbar.add(nextPage);
    // TODO: these need to be finished
    // toolbar.add( zoomIn );
    // toolbar.add( zoomOut );
    // toolbar.add( fullWidth );
    // toolbar.add( fullPage );
    // main area to see print preview
    printPreviewPane = new PrintPreviewPane();
    // print/close buttons
    cancelButton = new JButton(jEdit.getProperty("common.cancel"));
    // create bottom panel
    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 6, 11));
    bottomPanel.add(cancelButton);
    // main content holder
    JPanel content = new JPanel();
    content.setLayout(new BorderLayout());
    content.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
    // add all the pieces
    content.add(toolbar, BorderLayout.NORTH);
    content.add(printPreviewPane, BorderLayout.CENTER);
    content.add(bottomPanel, BorderLayout.SOUTH);
    setContentPane(content);
}