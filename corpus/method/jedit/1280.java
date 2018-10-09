static List traverseDirForClassesAux(File topDir, File dir) throws IOException {
    List list = new ArrayList();
    String top = topDir.getAbsolutePath();
    File[] children = dir.listFiles();
    for (int i = 0; i < children.length; i++) {
        File child = children[i];
        if (child.isDirectory())
            list.addAll(traverseDirForClassesAux(topDir, child));
        else {
            String name = child.getAbsolutePath();
            if (isClassFileName(name)) {
                /* 
						Remove absolute (topdir) portion of path and leave 
						package-class part 
					*/
                if (name.startsWith(top))
                    name = name.substring(top.length() + 1);
                else
                    throw new IOException("problem parsing paths");
                name = canonicalizeClassName(name);
                list.add(name);
            }
        }
    }
    return list;
}