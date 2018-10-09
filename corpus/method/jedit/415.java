public OSTask[] getOSTasks(Install installer) {
    return new OSTask[] { new ScriptOSTask(installer), new ManPageOSTask(installer) };
}