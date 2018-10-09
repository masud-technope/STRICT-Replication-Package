//}}}
//{{{ loadMacros() method
// TODO: figure out what is in 'vector', might be a vector of vectors
@SuppressWarnings({ "unchecked" })
private static void loadMacros(List vector, String path, File directory) {
    lastMacro = null;
    File[] macroFiles = directory.listFiles();
    if (macroFiles == null || macroFiles.length == 0)
        return;
    for (File file : macroFiles) {
        String fileName = file.getName();
        if (file.isHidden()) {
            continue;
        } else if (file.isDirectory()) {
            String submenuName = fileName.replace('_', ' ');
            List submenu = null;
            //{{{ try to merge with an existing menu first
            for (Object obj : vector) {
                if (obj instanceof List) {
                    List vec = (List) obj;
                    if (submenuName.equals(vec.get(0))) {
                        submenu = vec;
                        break;
                    }
                }
            //}}}
            }
            if (submenu == null) {
                submenu = new Vector();
                submenu.add(submenuName);
                vector.add(submenu);
            }
            loadMacros(submenu, path + fileName + '/', file);
        } else {
            addMacro(file, path, vector);
        }
    }
}