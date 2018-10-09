//{{{ flushInput() method
/**
		 * We try to merge consecutive inputs. This helper method is
		 * called when something other than input is to be recorded.
		 */
private void flushInput() {
    if (lastWasInput) {
        lastWasInput = false;
        append("\");");
    }
    if (lastWasOverwrite) {
        lastWasOverwrite = false;
        append("\");\n");
        append("offset = buffer.getLineEndOffset(" + "textArea.getCaretLine()) - 1;\n");
        append("buffer.remove(textArea.getCaretPosition()," + "Math.min(" + overwriteCount + ",offset - " + "textArea.getCaretPosition()));");
    }
//}}}
}