private void handlePopupTrigger(MouseEvent me) {
    int caret = viewer.getUI().viewToModel(viewer, me.getPoint());
    //int caret = viewer.getUI().viewToModel2D(viewer, me.getPoint(), null);
    if (caret >= 0 && viewer.getDocument() instanceof HTMLDocument) {
        HTMLDocument hdoc = (HTMLDocument) viewer.getDocument();
        Element elem = hdoc.getCharacterElement(caret);
        if (elem.getAttributes().getAttribute(HTML.Tag.A) != null) {
            Object attribute = elem.getAttributes().getAttribute(HTML.Tag.A);
            if (attribute instanceof AttributeSet) {
                AttributeSet set = (AttributeSet) attribute;
                final String href = (String) set.getAttribute(HTML.Attribute.HREF);
                if (href != null) {
                    JPopupMenu popup = new JPopupMenu();
                    JMenuItem copy = popup.add(jEdit.getProperty("helpviewer.copy-link.label"));
                    copy.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            StringSelection url = new StringSelection(href);
                            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(url, url);
                        }
                    });
                    popup.show(viewer, me.getX(), me.getY());
                }
            }
        }
    }
}