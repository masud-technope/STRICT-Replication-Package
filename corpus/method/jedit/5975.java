public  AdvancedPanel() {
    super();
    quality = new JComboBox<PrintQuality>();
    quality.addItem(PrintQuality.DRAFT);
    quality.addItem(PrintQuality.NORMAL);
    quality.addItem(PrintQuality.HIGH);
    PrintQuality pq = (PrintQuality) attributes.get(PrintQuality.class);
    quality.setSelectedItem(pq == null ? PrintQuality.NORMAL : pq);
    quality.setRenderer(new QualityCellRenderer());
    chromaticity = new JComboBox<Chromaticity>();
    chromaticity.addItem(Chromaticity.MONOCHROME);
    chromaticity.addItem(Chromaticity.COLOR);
    Chromaticity value = (Chromaticity) attributes.get(Chromaticity.class);
    chromaticity.setSelectedItem(value == null ? Chromaticity.MONOCHROME : value);
    chromaticity.setRenderer(new ChromaticityCellRenderer());
    JPanel content = new JPanel(new VariableGridLayout(VariableGridLayout.FIXED_NUM_COLUMNS, 2, 6, 6));
    content.add(new JLabel(jEdit.getProperty("print.dialog.Quality", "Quality")));
    content.add(quality);
    content.add(new JLabel(jEdit.getProperty("print.dialog.Ink", "Ink")));
    content.add(chromaticity);
    add(content, BorderLayout.NORTH);
}