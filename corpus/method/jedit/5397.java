//}}}
//{{{ _init() method
public void _init() {
    /* Gutter enable */
    gutterEnabled = new JCheckBox(jEdit.getProperty("options.gutter.enabled"));
    gutterEnabled.setSelected(isGutterEnabled());
    addComponent(gutterEnabled);
    /* Gutter components frame */
    GridBagConstraints cons = new GridBagConstraints();
    cons.gridheight = 1;
    cons.gridwidth = GridBagConstraints.REMAINDER;
    cons.fill = GridBagConstraints.HORIZONTAL;
    cons.anchor = GridBagConstraints.WEST;
    cons.weightx = 1.0f;
    cons.ipadx = 0;
    cons.ipady = 0;
    cons.insets = new Insets(0, 0, 0, 0);
    gutterComponents = new JPanel(new GridBagLayout());
    gutterComponents.setBorder(BorderFactory.createTitledBorder(jEdit.getProperty("options.gutter.optionalComponents")));
    IntegerInputVerifier integerInputVerifier = new IntegerInputVerifier();
    /* Line numbering */
    lineNumbersEnabled = new JCheckBox(jEdit.getProperty("options.gutter.lineNumbers"));
    lineNumbersEnabled.setSelected(jEdit.getBooleanProperty("view.gutter.lineNumbers"));
    gutterComponents.add(lineNumbersEnabled, cons);
    minLineNumberDigits = new JTextField(String.valueOf(getMinLineNumberDigits()), 1);
    minLineNumberDigits.setInputVerifier(integerInputVerifier);
    JPanel minLineNumberDigitsPanel = new JPanel();
    minLineNumberDigitsPanel.add(new JLabel(jEdit.getProperty("options.gutter.minLineNumberDigits")));
    minLineNumberDigitsPanel.add(minLineNumberDigits);
    cons.gridy = 1;
    gutterComponents.add(minLineNumberDigitsPanel, cons);
    /* Selection area enable */
    selectionAreaEnabled = new JCheckBox(jEdit.getProperty("options.gutter.selectionAreaEnabled"));
    selectionAreaEnabled.setSelected(isSelectionAreaEnabled());
    cons.gridy = 2;
    gutterComponents.add(selectionAreaEnabled, cons);
    addComponent(gutterComponents);
    // Disable gutter components when 'show gutter' is unchecked
    setGutterComponentsEnabledState();
    gutterEnabled.addChangeListener(new ChangeListener() {

        public void stateChanged(ChangeEvent e) {
            setGutterComponentsEnabledState();
        }
    });
    /* Selection area background color */
    addComponent(jEdit.getProperty("options.gutter.selectionAreaBgColor"), selectionAreaBgColor = new ColorWellButton(getSelectionAreaBackground()), GridBagConstraints.VERTICAL);
    /* Selection area width */
    selectionAreaWidth = new JTextField(String.valueOf(getSelectionAreaWidth()), DEFAULT_SELECTION_GUTTER_WIDTH);
    selectionAreaWidth.setInputVerifier(integerInputVerifier);
    addComponent(jEdit.getProperty("options.gutter.selectionAreaWidth"), selectionAreaWidth);
    /* Text font */
    gutterFont = new FontSelector(jEdit.getFontProperty("view.gutter.font", new Font("Monospaced", Font.PLAIN, 10)));
    addComponent(jEdit.getProperty("options.gutter.font"), gutterFont);
    /* Text color */
    addComponent(jEdit.getProperty("options.gutter.foreground"), gutterForeground = new ColorWellButton(jEdit.getColorProperty("view.gutter.fgColor")), GridBagConstraints.VERTICAL);
    /* Background color */
    addComponent(jEdit.getProperty("options.gutter.background"), gutterBackground = new ColorWellButton(jEdit.getColorProperty("view.gutter.bgColor")), GridBagConstraints.VERTICAL);
    /* Border width */
    /* gutterBorderWidth = new JTextField(jEdit.getProperty(
			"view.gutter.borderWidth"));
		addComponent(jEdit.getProperty("options.gutter.borderWidth"),
			gutterBorderWidth); */
    /* Number alignment */
    /* String[] alignments = new String[] {
			"Left", "Center", "Right"
		};
		gutterNumberAlignment = new JComboBox(alignments);
		String alignment = jEdit.getProperty("view.gutter.numberAlignment");
		if("right".equals(alignment))
			gutterNumberAlignment.setSelectedIndex(2);
		else if("center".equals(alignment))
			gutterNumberAlignment.setSelectedIndex(1);
		else
			gutterNumberAlignment.setSelectedIndex(0);
		addComponent(jEdit.getProperty("options.gutter.numberAlignment"),
			gutterNumberAlignment); */
    /* Current line highlight */
    gutterCurrentLineHighlightEnabled = new JCheckBox(jEdit.getProperty("options.gutter.currentLineHighlight"));
    gutterCurrentLineHighlightEnabled.setSelected(jEdit.getBooleanProperty("view.gutter.highlightCurrentLine"));
    addComponent(gutterCurrentLineHighlightEnabled, gutterCurrentLineHighlight = new ColorWellButton(jEdit.getColorProperty("view.gutter.currentLineColor")), GridBagConstraints.VERTICAL);
    /* Highlight interval and color */
    gutterHighlightInterval = new JTextField(jEdit.getProperty("view.gutter.highlightInterval"), 3);
    Box gutterHighlightBox = new Box(BoxLayout.X_AXIS);
    gutterHighlightBox.add(new JLabel(jEdit.getProperty("options.gutter.interval-1")));
    gutterHighlightBox.add(Box.createHorizontalStrut(3));
    gutterHighlightBox.add(gutterHighlightInterval);
    gutterHighlightBox.add(Box.createHorizontalStrut(3));
    gutterHighlightBox.add(new JLabel(jEdit.getProperty("options.gutter.interval-2")));
    gutterHighlightBox.add(Box.createHorizontalStrut(12));
    addComponent(gutterHighlightBox, gutterHighlightColor = new ColorWellButton(jEdit.getColorProperty("view.gutter.highlightColor")), GridBagConstraints.VERTICAL);
    /* Structure highlight */
    gutterStructureHighlightEnabled = new JCheckBox(jEdit.getProperty("options.gutter.structureHighlight"));
    gutterStructureHighlightEnabled.setSelected(jEdit.getBooleanProperty("view.gutter.structureHighlight"));
    addComponent(gutterStructureHighlightEnabled, gutterStructureHighlight = new ColorWellButton(jEdit.getColorProperty("view.gutter.structureHighlightColor")), GridBagConstraints.VERTICAL);
    /* Marker highlight */
    gutterMarkerHighlightEnabled = new JCheckBox(jEdit.getProperty("options.gutter.markerHighlight"));
    gutterMarkerHighlightEnabled.setSelected(jEdit.getBooleanProperty("view.gutter.markerHighlight"));
    addComponent(gutterMarkerHighlightEnabled, gutterMarkerHighlight = new ColorWellButton(jEdit.getColorProperty("view.gutter.markerColor")), GridBagConstraints.VERTICAL);
    /* Fold marker color */
    addComponent(jEdit.getProperty("options.gutter.foldColor"), gutterFoldMarkers = new ColorWellButton(jEdit.getColorProperty("view.gutter.foldColor")), GridBagConstraints.VERTICAL);
    /* Focused border color */
    addComponent(jEdit.getProperty("options.gutter.focusBorderColor"), gutterFocusBorder = new ColorWellButton(jEdit.getColorProperty("view.gutter.focusBorderColor")), GridBagConstraints.VERTICAL);
    /* unfocused border color */
    addComponent(jEdit.getProperty("options.gutter.noFocusBorderColor"), gutterNoFocusBorder = new ColorWellButton(jEdit.getColorProperty("view.gutter.noFocusBorderColor")), GridBagConstraints.VERTICAL);
    addFoldStyleChooser();
}