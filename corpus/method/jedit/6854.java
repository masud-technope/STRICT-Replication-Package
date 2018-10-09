//}}}
//{{{ end() method
/**
	 * An override to record the acutual action taken for end().
	 */
@Override
public void end(boolean select) {
    Macros.Recorder recorder = view.getMacroRecorder();
    switch(getInputHandler().getLastActionCount() % 2) {
        case 1:
            if (recorder != null)
                recorder.record("textArea.goToEndOfWhiteSpace(" + select + ");");
            goToEndOfWhiteSpace(select);
            break;
        default:
            if (recorder != null)
                recorder.record("textArea.goToEndOfLine(" + select + ");");
            goToEndOfLine(select);
            break;
    }
}