private void installListeners() {
    cancelButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            PrintPreview.this.cancel();
        }
    });
    // as suggested by Alan, set the keystrokes so that up, down, left, right,
    // and page up and down go to the next or previous page as appropriate.
    // First remove the default key map:
    pages.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "none");
    pages.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "none");
    pages.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "none");
    pages.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "none");
    pages.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_KP_DOWN, 0, false), "none");
    pages.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_KP_UP, 0, false), "none");
    pages.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_KP_RIGHT, 0, false), "none");
    pages.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_KP_LEFT, 0, false), "none");
    pages.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_DOWN, 0, false), "none");
    pages.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_UP, 0, false), "none");
    // then handle the keystrokes:
    pages.addKeyListener(new KeyAdapter() {

        public void keyPressed(KeyEvent ke) {
            int selectedIndex = pages.getSelectedIndex();
            switch(ke.getKeyCode()) {
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_KP_DOWN:
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_KP_RIGHT:
                case KeyEvent.VK_PAGE_DOWN:
                    selectedIndex += 1;
                    selectedIndex = selectedIndex >= pages.getItemCount() ? 0 : selectedIndex;
                    break;
                case KeyEvent.VK_UP:
                case KeyEvent.VK_KP_UP:
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_KP_LEFT:
                case KeyEvent.VK_PAGE_UP:
                    selectedIndex -= 1;
                    selectedIndex = selectedIndex < 0 ? pages.getItemCount() - 1 : selectedIndex;
                    break;
                // pressing the 1 thru 9 keys jumps directly to that page
                case KeyEvent.VK_1:
                    selectedIndex = 0;
                    break;
                case KeyEvent.VK_2:
                    selectedIndex = 1;
                    break;
                case KeyEvent.VK_3:
                    selectedIndex = 2;
                    break;
                case KeyEvent.VK_4:
                    selectedIndex = 3;
                    break;
                case KeyEvent.VK_5:
                    selectedIndex = 4;
                    break;
                case KeyEvent.VK_6:
                    selectedIndex = 5;
                    break;
                case KeyEvent.VK_7:
                    selectedIndex = 6;
                    break;
                case KeyEvent.VK_8:
                    selectedIndex = 7;
                    break;
                case KeyEvent.VK_9:
                    selectedIndex = 8;
                    break;
                default:
                    return;
            }
            pages.setSelectedIndex(selectedIndex);
            int selectedPage = (Integer) pages.getSelectedItem();
            model.setPageNumber(selectedPage - 1);
            model.setPageRanges(pageRanges);
            model.setZoomLevel(zoomLevel);
            attributes.add(new PageRanges(selectedPage));
            printPreviewPane.setModel(model);
        }
    });
    pages.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent me) {
            if (model != null) {
                int selectedPage = (Integer) pages.getSelectedItem();
                model.setPageNumber(selectedPage - 1);
                model.setPageRanges(pageRanges);
                model.setZoomLevel(zoomLevel);
                attributes.add(new PageRanges(selectedPage));
                printPreviewPane.setModel(model);
            }
        }
    });
    prevPage.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            int selectedIndex = pages.getSelectedIndex();
            if (selectedIndex <= 0) {
                selectedIndex = pages.getItemCount() - 1;
            } else {
                selectedIndex = selectedIndex - 1;
            }
            pages.setSelectedIndex(selectedIndex);
            int selectedPage = (Integer) pages.getSelectedItem();
            model.setPageNumber(selectedPage - 1);
            model.setPageRanges(pageRanges);
            model.setZoomLevel(zoomLevel);
            attributes.add(new PageRanges(selectedPage));
            printPreviewPane.setModel(model);
        }
    });
    nextPage.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            int selectedIndex = pages.getSelectedIndex();
            if (selectedIndex + 1 == pages.getItemCount()) {
                selectedIndex = 0;
            } else {
                selectedIndex = selectedIndex + 1;
            }
            pages.setSelectedIndex(selectedIndex);
            int selectedPage = (Integer) pages.getSelectedItem();
            model.setPageNumber(selectedPage - 1);
            model.setPageRanges(pageRanges);
            model.setZoomLevel(zoomLevel);
            attributes.add(new PageRanges(selectedPage));
            printPreviewPane.setModel(model);
        }
    });
    zoomIn.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            zoomLevel += 0.1f;
            int selectedPage = (Integer) pages.getSelectedItem();
            model.setZoomLevel(zoomLevel);
            model.setPageNumber(selectedPage - 1);
            model.setPageRanges(pageRanges);
            model.setZoom(PrintPreviewModel.Zoom.IN);
            attributes.add(new PageRanges(selectedPage));
            printPreviewPane.setModel(model);
        }
    });
    zoomOut.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            zoomLevel -= 0.1f;
            if (zoomLevel <= 0.0f) {
                zoomLevel = 0.1f;
            }
            int selectedPage = (Integer) pages.getSelectedItem();
            model.setZoomLevel(zoomLevel);
            model.setPageNumber(selectedPage - 1);
            model.setPageRanges(pageRanges);
            model.setZoom(PrintPreviewModel.Zoom.OUT);
            attributes.add(new PageRanges(selectedPage));
            printPreviewPane.setModel(model);
        }
    });
    fullWidth.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            int selectedPage = (Integer) pages.getSelectedItem();
            model.setPageNumber(selectedPage);
            model.setPageRanges(pageRanges);
            model.setZoom(PrintPreviewModel.Zoom.WIDTH);
            attributes.add(new PageRanges(selectedPage));
            printPreviewPane.setModel(model);
        }
    });
    fullPage.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            int selectedPage = (Integer) pages.getSelectedItem();
            model.setPageNumber(selectedPage);
            model.setPageRanges(pageRanges);
            model.setZoom(PrintPreviewModel.Zoom.PAGE);
            attributes.add(new PageRanges(selectedPage));
            printPreviewPane.setModel(model);
        }
    });
}