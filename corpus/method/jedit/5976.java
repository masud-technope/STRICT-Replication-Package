public AttributeSet getAttributes() {
    AttributeSet as = new HashAttributeSet();
    as.add((Chromaticity) chromaticity.getSelectedItem());
    as.add((PrintQuality) quality.getSelectedItem());
    return as;
}