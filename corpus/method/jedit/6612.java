public void fromString(String v) {
    m_val = 0;
    if (v.equals(SUBPIXEL))
        v = SUBPIXEL_HRGB;
    for (int i = 0; i < comboChoices.length; ++i) {
        if (comboChoices[i].equals(v)) {
            m_val = i;
            break;
        }
    }
}