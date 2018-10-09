//{{{ updateColors() method
private void updateColors() {
    if (UIManager.getLookAndFeel() instanceof MetalLookAndFeel) {
        color1 = MetalLookAndFeel.getControlHighlight();
        color2 = MetalLookAndFeel.getControlDarkShadow();
        color3 = MetalLookAndFeel.getControl();
    } else {
        color1 = color2 = color3 = null;
    }
//}}}
}