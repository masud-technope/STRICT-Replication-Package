//}}}
//{{{ smartHome() method
/**
	 * An override to record the acutual action taken for smartHome().
	 */
@Override
public void smartHome(boolean select) {
    Macros.Recorder recorder = view.getMacroRecorder();
    switch(view.getInputHandler().getLastActionCount()) {
        case 1:
            if (recorder != null)
                recorder.record("textArea.goToStartOfWhiteSpace(" + select + ");");
            goToStartOfWhiteSpace(select);
            break;
        case 2:
            if (recorder != null)
                recorder.record("textArea.goToStartOfLine(" + select + ");");
            goToStartOfLine(select);
            break;
        default:
            //case 3:
            if (recorder != null)
                recorder.record("textArea.goToFirstVisibleLine(" + select + ");");
            goToFirstVisibleLine(select);
            break;
    }
}