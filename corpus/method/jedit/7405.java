//}}}
//{{{ setFractionalFontMetricsEnabled() method
/**
	 * Sets if fractional font metrics should be enabled. Has no effect when
	 * running on Java 1.1.
	 * @since jEdit 3.2pre6
	 */
public void setFractionalFontMetricsEnabled(boolean fracFontMetrics) {
    this.fracFontMetrics = fracFontMetrics;
    updateRenderingHints();
}