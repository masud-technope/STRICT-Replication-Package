//}}}
//{{{ dispose() method
/**
	 * Quit completion.
	 */
@Override
public void dispose() {
    if (isDisplayable()) {
        if (view.getKeyEventInterceptor() == keyHandler) {
            view.setKeyEventInterceptor(null);
        }
        super.dispose();
        // This is a workaround to ensure setting the
        // focus back to the textArea. Without this, the
        // focus gets lost after closing the popup in
        // some environments. It seems to be a bug in
        // J2SE 1.4 or 5.0. Probably it relates to the
        // following one.
        // "Frame does not receives focus after closing
        // of the owned window"
        // http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4810575
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                view.getTextArea().requestFocus();
            }
        });
    }
}