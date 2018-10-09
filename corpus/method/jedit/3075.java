//}}}
//{{{ invoke() method
private void invoke() {
    String cmd;
    if (popup != null)
        cmd = popup.list.getSelectedValue().toString();
    else {
        cmd = action.getText().trim();
        int index = cmd.indexOf('=');
        if (index != -1) {
            action.addCurrentToHistory();
            String propName = cmd.substring(0, index).trim();
            String propValue = cmd.substring(index + 1).trim();
            StringBuilder code = new StringBuilder(128);
            /* construct a BeanShell snippet instead of
				 * invoking directly so that user can record
				 * property changes in macros. */
            if (propName.startsWith("buffer.")) {
                if (propName.equals("buffer.mode")) {
                    code.append("buffer.setMode(\"").append(StandardUtilities.charsToEscapes(propValue)).append("\");");
                } else {
                    code.append("buffer.setStringProperty(\"").append(StandardUtilities.charsToEscapes(propName.substring("buffer.".length()))).append("\",\"").append(StandardUtilities.charsToEscapes(propValue)).append("\");");
                }
                code.append("\nbuffer.propertiesChanged();");
            } else if (propName.startsWith("!buffer.")) {
                code.append("jEdit.setProperty(\"").append(StandardUtilities.charsToEscapes(propName.substring(1))).append("\",\"").append(StandardUtilities.charsToEscapes(propValue)).append("\");\njEdit.propertiesChanged();");
            } else {
                code.append("jEdit.setProperty(\"").append(StandardUtilities.charsToEscapes(propName)).append("\",\"").append(StandardUtilities.charsToEscapes(propValue)).append("\");\njEdit.propertiesChanged();");
            }
            Macros.Recorder recorder = view.getMacroRecorder();
            if (recorder != null)
                recorder.record(code.toString());
            BeanShell.eval(view, namespace, code.toString());
            cmd = null;
        } else if (cmd.length() != 0) {
            String[] completions = getCompletions(cmd);
            if (completions.length != 0) {
                cmd = completions[0];
            }
        } else
            cmd = null;
    }
    if (popup != null) {
        popup.dispose();
        popup = null;
    }
    final String finalCmd = cmd;
    final EditAction act = (finalCmd == null ? null : jEdit.getAction(finalCmd));
    if (temp)
        view.removeToolBar(this);
    SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            view.getTextArea().requestFocus();
            if (act == null) {
                if (finalCmd != null) {
                    view.getStatus().setMessageAndClear(jEdit.getProperty("view.action.no-completions"));
                }
            } else {
                view.getInputHandler().setRepeatCount(repeatCount);
                view.getInputHandler().invokeAction(act);
            }
        }
    });
}