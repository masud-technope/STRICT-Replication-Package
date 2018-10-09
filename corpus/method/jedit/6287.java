//}}}
//{{{ record() method
private static void record(View view, String action, boolean replaceAction, boolean recordFileSet) {
    Macros.Recorder recorder = view.getMacroRecorder();
    if (recorder != null) {
        recorder.record("SearchAndReplace.setSearchString(\"" + StandardUtilities.charsToEscapes(search) + "\");");
        if (replaceAction) {
            recorder.record("SearchAndReplace.setReplaceString(\"" + StandardUtilities.charsToEscapes(replace) + "\");");
            recorder.record("SearchAndReplace.setBeanShellReplace(" + beanshell + ");");
        } else {
            // only record this if doing a find next
            recorder.record("SearchAndReplace.setAutoWrapAround(" + wrap + ");");
            recorder.record("SearchAndReplace.setReverseSearch(" + reverse + ");");
        }
        recorder.record("SearchAndReplace.setWholeWord(" + wholeWord + ");");
        recorder.record("SearchAndReplace.setIgnoreCase(" + ignoreCase + ");");
        recorder.record("SearchAndReplace.setRegexp(" + regexp + ");");
        if (recordFileSet) {
            recorder.record("SearchAndReplace.setSearchFileSet(" + fileset.getCode() + ");");
        }
        recorder.record("SearchAndReplace." + action + ';');
    }
}