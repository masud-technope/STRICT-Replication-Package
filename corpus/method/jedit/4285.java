//}}}
//}}}
//{{{ menuAcceleratorFont() method
/**
	 * Menu accelerator font according to L&amp;F defaults, with workarounds.
	 */
public static Font menuAcceleratorFont() {
    if (OperatingSystem.isMacOSLF()) {
        return UIManager.getFont("Menu.acceleratorFont");
    } else {
        // Menu.acceleratorFont is unreliable, often not properly scaled:
        // imitate Menu.font instead.
        Font font1 = UIManager.getFont("Menu.font");
        if (font1 == null) {
            return new Font("Monospaced", Font.PLAIN, 12);
        } else {
            Font font2 = new Font("Lucida Sans Typewriter", Font.PLAIN, font1.getSize());
            FontRenderContext frc = new FontRenderContext(null, true, false);
            float scale = font1.getLineMetrics("", frc).getHeight() / font2.getLineMetrics("", frc).getHeight();
            return new Font(font2.getFamily(), font2.getStyle(), (int) (scale * font1.getSize()));
        }
    }
}