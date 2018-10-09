// Unfortunately, this does not work, as this DataFlavor is internally changed into another DataFlavor which does not match the intented DataFlavor anymore. :-( So, below, we are iterating.
/*
	protected static DataFlavor	textURIlistDataFlavor = null;
	
	static {
		try {
			textURIlistDataFlavor = new DataFlavor("text/uri-list;representationclass=java.lang.String");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Cannot create DataFlavor. This should not happen.",e);
		}
	}
	*/
//{{{ createTransferable
@Override
protected Transferable createTransferable(JComponent c) {
    Log.log(Log.DEBUG, this, "createTransferable()");
    JEditTextArea textArea = (JEditTextArea) c;
    if (textArea.getSelectionCount() == 0)
        return null;
    else {
        dragSource = textArea;
        return new TextAreaSelection(textArea);
    }
}