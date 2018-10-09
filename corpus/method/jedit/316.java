private static void processPackage(Writer out, PackageDoc pkg) throws IOException {
    out.write("<ENTRY HREF='");
    String pkgPath = pkg.name().replace('.', '/') + "/";
    out.write(pkgPath);
    out.write("package-summary.html'><TITLE>");
    out.write(pkg.name());
    out.write("</TITLE>\n");
    ClassDoc[] classes = pkg.allClasses();
    String[] classNames = new String[classes.length];
    for (int i = 0; i < classes.length; i++) {
        classNames[i] = classes[i].name();
    }
    Arrays.sort(classNames);
    for (int i = 0; i < classes.length; i++) {
        processClass(out, pkgPath, classNames[i]);
    }
    out.write("</ENTRY>");
}