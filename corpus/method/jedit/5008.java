//}}}
//{{{ addMacro() method
@SuppressWarnings({ "unchecked" })
private static void addMacro(File file, String path, List vector) {
    String fileName = file.getName();
    Handler handler = getHandlerForPathName(file.getPath());
    if (handler == null)
        return;
    try {
        // in case macro file name has a space in it.
        // spaces break the view.toolBar property, for instance,
        // since it uses spaces to delimit action names.
        String macroName = (path + fileName).replace(' ', '_');
        Macro newMacro = handler.createMacro(macroName, file.getPath());
        // see comment in loadMacros().
        if (macroHash.get(newMacro.getName()) != null)
            return;
        vector.add(newMacro.getName());
        jEdit.setTemporaryProperty(newMacro.getName() + ".label", newMacro.label);
        jEdit.setTemporaryProperty(newMacro.getName() + ".mouse-over", handler.getLabel() + " - " + file.getPath());
        macroActionSet.addAction(newMacro);
        macroHash.put(newMacro.getName(), newMacro);
    } catch (Exception e) {
        Log.log(Log.ERROR, Macros.class, e);
        macroHandlers.remove(handler);
    }
}