@SuppressWarnings({ "unchecked" })
public void valueChanged(ListSelectionEvent e) {
    selectedPrintService = printers.getSelectedValue();
    // get the supported attribute categories and values
    Map<Class, Object> categoryValueMap = new HashMap<Class, Object>();
    Class<?>[] classes = selectedPrintService.getSupportedAttributeCategories();
    for (Class c : classes) {
        Object values = selectedPrintService.getSupportedAttributeValues(c, DocFlavor.SERVICE_FORMATTED.PRINTABLE, null);
        categoryValueMap.put(c, values);
    }
    // set range for number of copies
    SpinnerNumberModel copiesModel = new SpinnerNumberModel(1, 1, 999, 1);
    Object value = categoryValueMap.get(Copies.class);
    if (value != null) {
        String maxCopies = value.toString();
        if (maxCopies.indexOf('-') > 0) {
            maxCopies = maxCopies.substring(maxCopies.indexOf('-') + 1);
        }
        copiesModel = new SpinnerNumberModel(1, 1, (int) Integer.valueOf(maxCopies), 1);
    }
    copies.setModel(copiesModel);
    // paper sizes
    value = categoryValueMap.get(Media.class);
    Set<MediaSizeName> sizeNames = new HashSet<MediaSizeName>();
    for (Media m : (Media[]) value) {
        if (m instanceof MediaSizeName) {
            sizeNames.add((MediaSizeName) m);
        }
    }
    MediaSizeName[] sizes = sizeNames.toArray(new MediaSizeName[sizeNames.size()]);
    Arrays.sort(sizes, new Comparator<MediaSizeName>() {

        public int compare(MediaSizeName a, MediaSizeName b) {
            return a.toString().compareTo(b.toString());
        }
    });
    Media previousPaper = (Media) attributes.get(Media.class);
    MediaSizeName previousSize = null;
    if (previousPaper instanceof MediaSizeName) {
        previousSize = (MediaSizeName) previousPaper;
    }
    if (paperSize != null) {
        String[] paperNames = new String[sizes.length];
        paperSizes = new ArrayList<Media>();
        int index = -1;
        int letterSizeIndex = 0;
        for (int i = 0; i < sizes.length; i++) {
            MediaSizeName m = sizes[i];
            if (MediaSizeName.NA_LETTER.equals(m)) {
                letterSizeIndex = i;
            } else if (m.equals(previousSize)) {
                index = i;
            }
            paperSizes.add(m);
            paperNames[i] = getMessage(m.toString());
        }
        index = index == -1 ? letterSizeIndex : index;
        paperSize.setModel(new DefaultComboBoxModel<String>(paperNames));
        paperSize.setEnabled(true);
        paperSize.setSelectedIndex(index);
    }
    // finishing
    if (finishing != null) {
        value = categoryValueMap.get(Finishings.class);
        if (value == null) {
            finishing.setModel(new DefaultComboBoxModel<Finishings>());
            finishing.setEnabled(false);
        } else {
            Finishings[] finishings = (Finishings[]) value;
            if (finishings.length == 0 || (finishings.length == 1 && Finishings.NONE.equals(finishings[0]))) {
                finishing.setModel(new DefaultComboBoxModel<Finishings>());
                finishing.setEnabled(false);
            } else {
                finishing.setModel(new DefaultComboBoxModel<Finishings>(finishings));
                finishing.setEnabled(true);
            }
        }
    }
    // sides
    if (sides != null) {
        value = categoryValueMap.get(Sides.class);
        if (value == null) {
            sides.setEnabled(false);
        } else {
            sides.setModel(new DefaultComboBoxModel<Sides>((Sides[]) value));
            Sides previousSides = (Sides) attributes.get(Sides.class);
            sides.setSelectedItem(previousSides == null ? Sides.ONE_SIDED : previousSides);
            sides.setEnabled(true);
        }
    }
    // pages per side
    if (pagesPerSide != null) {
        value = categoryValueMap.get(NumberUp.class);
        if (value == null) {
            pagesPerSide.setEnabled(false);
        } else {
            NumberUp[] numberUp = (NumberUp[]) value;
            Arrays.sort(numberUp, new Comparator<NumberUp>() {

                public int compare(NumberUp a, NumberUp b) {
                    int m = a.getValue();
                    int n = b.getValue();
                    if (m < n) {
                        return -1;
                    } else if (m == n) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
            pagesPerSide.setModel(new DefaultComboBoxModel<NumberUp>(numberUp));
            pagesPerSide.setEnabled(true);
        }
    }
    // ordering of pages per side
    if (pageOrdering != null) {
        value = categoryValueMap.get(PresentationDirection.class);
        if (value == null) {
            pageOrdering.setEnabled(false);
        } else {
            PresentationDirection[] po = (PresentationDirection[]) value;
            pageOrdering.setModel(new DefaultComboBoxModel<PresentationDirection>(po));
            pageOrdering.setEnabled(true);
        }
    }
    // paper source tray
    if (paperSource != null) {
        value = categoryValueMap.get(Media.class);
        if (value == null) {
            paperSource.setEnabled(false);
        } else {
            Set<MediaTray> trayNames = new HashSet<MediaTray>();
            for (Media m : (Media[]) value) {
                if (m instanceof MediaTray) {
                    trayNames.add((MediaTray) m);
                }
            }
            if (trayNames.size() > 0) {
                MediaTray[] trays = trayNames.toArray(new MediaTray[trayNames.size()]);
                paperSource.setModel(new DefaultComboBoxModel<MediaTray>(trays));
                paperSource.setEnabled(true);
                MediaTray lastUsedTray = (MediaTray) attributes.get(MediaTray.class);
                paperSource.setSelectedItem(lastUsedTray == null ? trays[0] : lastUsedTray);
            } else {
                paperSource.setEnabled(false);
            }
        }
    }
    // orientation, eg. portrait or landscape
    if (orientation != null) {
        value = categoryValueMap.get(OrientationRequested.class);
        if (value == null) {
            orientation.setEnabled(false);
        } else {
            OrientationRequested[] or = (OrientationRequested[]) value;
            orientation.setModel(new DefaultComboBoxModel<OrientationRequested>(or));
            orientation.setEnabled(true);
            OrientationRequested previousOrientation = (OrientationRequested) attributes.get(OrientationRequested.class);
            orientation.setSelectedItem(previousOrientation == null ? OrientationRequested.PORTRAIT : previousOrientation);
        }
    }
}