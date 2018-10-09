//{{{ recordInput() method
/**
		 * @since jEdit 4.2pre5
		 */
public void recordInput(String str, boolean overwrite) {
    String charStr = StandardUtilities.charsToEscapes(str);
    if (overwrite) {
        if (lastWasOverwrite) {
            overwriteCount++;
            append(charStr);
        } else {
            flushInput();
            overwriteCount = 1;
            lastWasOverwrite = true;
            append("\ntextArea.setSelectedText(\"" + charStr);
        }
    } else {
        if (lastWasInput)
            append(charStr);
        else {
            flushInput();
            lastWasInput = true;
            append("\ntextArea.setSelectedText(\"" + charStr);
        }
    }
//}}}
}