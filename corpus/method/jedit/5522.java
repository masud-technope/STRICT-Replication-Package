//}}}
//{{{ _init() method
public void _init() {
    /* Font */
    font = new FontSelector(jEdit.getFontProperty("view.font"));
    addComponent(jEdit.getProperty("options.textarea.font"), font);
    fontSubst = new JCheckBox(jEdit.getProperty("options.textarea.fontSubst"));
    fontSubst.setToolTipText(jEdit.getProperty("options.textarea.fontSubst.tooltip"));
    fontSubst.setSelected(jEdit.getBooleanProperty("view.enableFontSubst"));
    fontSubst.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
            fontSubstList.setVisible(fontSubst.isSelected());
            fontSubstSystemFonts.setVisible(fontSubst.isSelected());
        }
    });
    addComponent(fontSubst);
    fontSubstList = new FontList();
    fontSubstList.setVisible(fontSubst.isSelected());
    addComponent(fontSubstList, GridBagConstraints.HORIZONTAL);
    fontSubstSystemFonts = new JCheckBox(jEdit.getProperty("options.textarea.fontSubstSystemFonts"));
    fontSubstSystemFonts.setSelected(jEdit.getBooleanProperty("view.enableFontSubstSystemFonts"));
    fontSubstSystemFonts.setVisible(fontSubst.isSelected());
    fontSubstSystemFonts.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
            if (!fontSubstSystemFonts.isSelected() && (fontSubstList.listSize() == 0)) {
                JOptionPane.showMessageDialog(fontSubstSystemFonts.getParent(), jEdit.getProperty("options.textarea.fontSubstWarning"), jEdit.getProperty("options.textarea.fontSubstWarning.label"), JOptionPane.WARNING_MESSAGE);
            }
        }
    });
    addComponent(fontSubstSystemFonts, GridBagConstraints.HORIZONTAL);
    /* Anti-aliasing */
    antiAlias = new JComboBox<String>(AntiAlias.comboChoices);
    antiAlias.setToolTipText(jEdit.getProperty("options.textarea.antiAlias.tooltip"));
    AntiAlias antiAliasValue = new AntiAlias(jEdit.getProperty("view.antiAlias"));
    font.setAntiAliasEnabled(antiAliasValue.val() > 0);
    antiAlias.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
            int idx = antiAlias.getSelectedIndex();
            font.setAntiAliasEnabled(idx > 0);
            font.repaint();
        }
    });
    antiAlias.setSelectedIndex(antiAliasValue.val());
    addComponent(jEdit.getProperty("options.textarea" + ".antiAlias"), antiAlias);
    /* Fractional font metrics */
    fracFontMetrics = new JCheckBox(jEdit.getProperty("options.textarea" + ".fracFontMetrics"));
    fracFontMetrics.setToolTipText(jEdit.getProperty("options.textarea.fracFontMetrics.tooltip"));
    fracFontMetrics.setSelected(jEdit.getBooleanProperty("view.fracFontMetrics"));
    addComponent(fracFontMetrics);
    /* Extra line spacing */
    IntegerInputVerifier integerInputVerifier = new IntegerInputVerifier();
    JPanel lineSpacingPanel = new JPanel();
    lineSpacing = new JTextField(String.valueOf(jEdit.getIntegerProperty("options.textarea.lineSpacing", 0)));
    lineSpacing.setColumns(4);
    lineSpacing.setHorizontalAlignment(JTextField.RIGHT);
    lineSpacing.setInputVerifier(integerInputVerifier);
    lineSpacingPanel.add(new JLabel(jEdit.getProperty("options.textarea.lineSpacing.label")));
    lineSpacingPanel.add(lineSpacing);
    addComponent(lineSpacingPanel);
    addSeparator();
    /* Text color */
    addComponent(jEdit.getProperty("options.textarea.foreground"), foregroundColor = new ColorWellButton(jEdit.getColorProperty("view.fgColor")), GridBagConstraints.VERTICAL);
    /* Background color */
    addComponent(jEdit.getProperty("options.textarea.background"), backgroundColor = new ColorWellButton(jEdit.getColorProperty("view.bgColor")), GridBagConstraints.VERTICAL);
    /* Caret color, caret blink, block caret */
    blinkCaret = new JCheckBox(jEdit.getProperty("options.textarea" + ".blinkCaret"));
    blinkCaret.setSelected(jEdit.getBooleanProperty("view.caretBlink"));
    blockCaret = new JCheckBox(jEdit.getProperty("options.textarea" + ".blockCaret"));
    blockCaret.setSelected(jEdit.getBooleanProperty("view.blockCaret"));
    thickCaret = new JCheckBox(jEdit.getProperty("options.textarea" + ".thickCaret"));
    thickCaret.setSelected(jEdit.getBooleanProperty("view.thickCaret"));
    Box caretSettings = new Box(BoxLayout.X_AXIS);
    caretSettings.add(new JLabel(jEdit.getProperty("options.textarea.caret")));
    caretSettings.add(Box.createHorizontalStrut(6));
    caretSettings.add(blinkCaret);
    caretSettings.add(blockCaret);
    caretSettings.add(thickCaret);
    addComponent(caretSettings, caretColor = new ColorWellButton(jEdit.getColorProperty("view.caretColor")), GridBagConstraints.VERTICAL);
    /* Selection color */
    addComponent(jEdit.getProperty("options.textarea.selection"), selectionColor = new ColorWellButton(jEdit.getColorProperty("view.selectionColor")), GridBagConstraints.VERTICAL);
    /* Multiple selection color */
    addComponent(jEdit.getProperty("options.textarea.multipleSelection"), multipleSelectionColor = new ColorWellButton(jEdit.getColorProperty("view.multipleSelectionColor")), GridBagConstraints.VERTICAL);
    /* Selection foreground color */
    selectionFg = new JCheckBox(jEdit.getProperty("options.textarea.selectionFg"));
    selectionFg.setName("selectionFg");
    selectionFg.setSelected(jEdit.getBooleanProperty("view.selectionFg"));
    addComponent(selectionFg, selectionFgColor = new ColorWellButton(jEdit.getColorProperty("view.selectionFgColor")), GridBagConstraints.VERTICAL);
    /* Line highlight */
    lineHighlight = new JCheckBox(jEdit.getProperty("options.textarea.lineHighlight"));
    lineHighlight.setSelected(jEdit.getBooleanProperty("view.lineHighlight"));
    addComponent(lineHighlight, lineHighlightColor = new ColorWellButton(jEdit.getColorProperty("view.lineHighlightColor")), GridBagConstraints.VERTICAL);
    /* Structure highlight */
    structureHighlight = new JCheckBox(jEdit.getProperty("options.textarea.structureHighlight"));
    structureHighlight.setSelected(jEdit.getBooleanProperty("view.structureHighlight"));
    addComponent(structureHighlight, structureHighlightColor = new ColorWellButton(jEdit.getColorProperty("view.structureHighlightColor")), GridBagConstraints.VERTICAL);
    /* EOL markers */
    eolMarkers = new JCheckBox(jEdit.getProperty("options.textarea.eolMarkers"));
    eolMarkers.setSelected(jEdit.getBooleanProperty("view.eolMarkers"));
    addComponent(eolMarkers, eolMarkerColor = new ColorWellButton(jEdit.getColorProperty("view.eolMarkerColor")), GridBagConstraints.VERTICAL);
    /* Wrap guide */
    wrapGuide = new JCheckBox(jEdit.getProperty("options.textarea.wrapGuide"));
    wrapGuide.setSelected(jEdit.getBooleanProperty("view.wrapGuide"));
    addComponent(wrapGuide, wrapGuideColor = new ColorWellButton(jEdit.getColorProperty("view.wrapGuideColor")), GridBagConstraints.VERTICAL);
    /* page breaks */
    pageBreaks = new JCheckBox(jEdit.getProperty("options.textarea.pageBreaks"));
    pageBreaks.setSelected(jEdit.getBooleanProperty("view.pageBreaks", false));
    addComponent(pageBreaks, pageBreaksColor = new ColorWellButton(jEdit.getColorProperty("view.pageBreaksColor")), GridBagConstraints.VERTICAL);
    addSeparator();
    /* Electric borders */
    electricBorders = new JCheckBox(jEdit.getProperty("options.textarea.electricBorders"));
    electricBorders.setSelected(!"0".equals(jEdit.getProperty("view.electricBorders")));
    addComponent(electricBorders);
    /* Strip trailing EOL */
    stripTrailingEOL = new JCheckBox(jEdit.getProperty("options.textarea.stripTrailingEOL"));
    stripTrailingEOL.setSelected(jEdit.getBooleanProperty("stripTrailingEOL"));
    addComponent(stripTrailingEOL);
    completeFromAllBuffers = new JCheckBox(jEdit.getProperty("options.textarea.completeFromAllBuffers"));
    completeFromAllBuffers.setSelected(jEdit.getBooleanProperty("completeFromAllBuffers"));
    addComponent(completeFromAllBuffers);
    insertCompletionWithDigit = new JCheckBox(jEdit.getProperty("options.textarea.insertCompletionWithDigit"));
    insertCompletionWithDigit.setSelected(jEdit.getBooleanProperty("insertCompletionWithDigit"));
    addComponent(insertCompletionWithDigit);
}