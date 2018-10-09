//}}}
//{{{ setValue() method
/**
	 * Update the progress value.
	 *
	 * @param value the new value
	 * @since jEdit 4.3pre3
	 */
public void setValue(final long value) {
    SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            progress.setValue(valueSoFar + (int) value);
        }
    });
}