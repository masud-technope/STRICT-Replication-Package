//}}}
//}}} Fold painters
//{{{ handlePopupTrigger() method
/**
	 * Do the same thing as right-clicking on the text area. The Gestures
	 * plugin uses this API.
	 * @since jEdit 4.2pre13
	 */
@Override
public void handlePopupTrigger(MouseEvent evt) {
    if (popup.isVisible())
        popup.setVisible(false);
    else {
        super.handlePopupTrigger(evt);
    }
}