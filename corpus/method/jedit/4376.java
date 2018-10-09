//}}}
//{{{ loadTOC() method
private void loadTOC(DefaultMutableTreeNode root, String path) {
    TOCHandler h = new TOCHandler(root, MiscUtilities.getParentOfPath(path));
    try {
        XMLUtilities.parseXML(new URL(baseURL + '/' + path).openStream(), h);
    } catch (FileNotFoundException e) {
        if ("api/toc.xml".equals(path)) {
            Log.log(Log.NOTICE, this, "The API docs for jEdit will not be available (reinstall jEdit if you want them)");
            root.add(createNode("http://www.jedit.org/api/overview-summary.html", jEdit.getProperty("helpviewer.toc.online-apidocs")));
        } else {
            Log.log(Log.ERROR, this, e);
        }
    } catch (IOException e) {
        Log.log(Log.ERROR, this, e);
    }
}