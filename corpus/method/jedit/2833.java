//}}}
//{{{ wantTwoStageSave() method
private static boolean wantTwoStageSave(Buffer buffer) {
    return !buffer.getBooleanProperty("forbidTwoStageSave") && (buffer.getBooleanProperty("overwriteReadonly") || jEdit.getBooleanProperty("twoStageSave"));
}