//}}}
// {{{ Overrides for macro recording.
//{{{ home() method
/**
	 * An override to record the acutual action taken for home().
	 */
@Override
public void home(boolean select) {
    Macros.Recorder recorder = view.getMacroRecorder();
    switch(getInputHandler().getLastActionCount() % 2) {
        case 1:
            if (recorder != null)
                recorder.record("textArea.goToStartOfWhiteSpace(" + select + ");");
            goToStartOfWhiteSpace(select);
            break;
        default:
            if (recorder != null)
                recorder.record("textArea.goToStartOfLine(" + select + ");");
            goToStartOfLine(select);
            break;
    }
}