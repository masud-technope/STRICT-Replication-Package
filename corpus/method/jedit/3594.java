//}}}
//{{{ getSymbolicName() method
public static String getSymbolicName(int keyCode) {
    if (Debug.DUMP_KEY_EVENTS) {
        Log.log(Log.DEBUG, GrabKeyDialog.class, "getSymbolicName(" + keyCode + ").");
    }
    if (keyCode == KeyEvent.VK_UNDEFINED)
        return null;
    if (keyCode >= KeyEvent.VK_A && keyCode <= KeyEvent.VK_Z)
        return String.valueOf(Character.toLowerCase((char) keyCode));
    try {
        Field[] fields = KeyEvent.class.getFields();
        for (Field field : fields) {
            String name = field.getName();
            if (name.startsWith("VK_") && field.getInt(null) == keyCode)
                return name.substring(3);
        }
    } catch (Exception e) {
        Log.log(Log.ERROR, GrabKeyDialog.class, e);
    }
    return null;
}