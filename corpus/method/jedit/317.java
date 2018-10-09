private static void processClass(Writer out, String pkgPath, String clazz) throws IOException {
    out.write("<ENTRY HREF='");
    out.write(pkgPath);
    out.write(clazz);
    out.write(".html'><TITLE>");
    out.write(clazz);
    out.write("</TITLE>\n");
    out.write("</ENTRY>");
}