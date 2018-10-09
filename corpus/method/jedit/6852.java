//}}}
//{{{ smartEnd() method
/**
	 * An override to record the acutual action taken for smartHome().
	 */
@Override
public void smartEnd(boolean select) {
    Macros.Recorder recorder = view.getMacroRecorder();
    switch(view.getInputHandler().getLastActionCount()) {
        case 1:
            if (recorder != null)
                recorder.record("textArea.goToEndOfWhiteSpace(" + select + ");");
            goToEndOfWhiteSpace(select);
            break;
        case 2:
            if (recorder != null)
                recorder.record("textArea.goToEndOfLine(" + select + ");");
            goToEndOfLine(select);
            break;
        default:
            //case 3:
            if (recorder != null)
                recorder.record("textArea.goToLastVisibleLine(" + select + ");");
            goToLastVisibleLine(select);
            break;
    }
}