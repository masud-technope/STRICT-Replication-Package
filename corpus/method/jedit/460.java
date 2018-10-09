 SelectComponents() {
    super(new BorderLayout());
    comp = createCompPanel();
    SelectComponents.this.add(BorderLayout.NORTH, comp);
    sizeLabel = new JLabel("", SwingConstants.LEFT);
    SelectComponents.this.add(BorderLayout.SOUTH, sizeLabel);
    updateSize();
}