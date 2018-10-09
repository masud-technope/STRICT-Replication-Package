/**
		 * Returns the clipboard contents.
		 */
@Override
public String toString() {
    try {
        if (false) {
            /*
						This is to debug clipboard problems.

						Apparently, jEdit is unable to copy text from clipbard into the current
						text buffer if the clipboard was filled using the command
							echo test | xselection CLIPBOARD -
						under Linux. However, it seems that Java does not offer any
						data flavor for this clipboard content (under J2RE 1.5.0_06-b05)
						Thus, copying from clipboard seems to be plainly impossible.
					*/
            Log.log(Log.DEBUG, this, "clipboard.getContents(this)=" + clipboard.getContents(this) + '.');
            debugListDataFlavors(clipboard.getContents(this));
        }
        String selection = (String) clipboard.getContents(this).getTransferData(DataFlavor.stringFlavor);
        return stripEOLChars(selection);
    } catch (Exception e) {
        Log.log(Log.NOTICE, this, e);
        return null;
    }
}