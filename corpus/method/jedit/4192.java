//}}}
//{{{ nextTip() method
private void nextTip() {
    File[] tips = new File(MiscUtilities.constructPath(jEdit.getJEditHome(), "doc", "tips")).listFiles();
    if (tips == null || tips.length == 0) {
        tipText.setText(jEdit.getProperty("tip.not-found"));
        return;
    }
    int count = tips.length;
    // so that we don't see the same tip again if the user
    // clicks 'Next Tip'
    int tipToShow = currentTip;
    while (tipToShow == currentTip || !tips[tipToShow].getName().endsWith(".html")) tipToShow = (new Random().nextInt(Integer.MAX_VALUE)) % count;
    try {
        tipText.setPage(tips[tipToShow].toURI().toURL());
    } catch (Exception e) {
        Log.log(Log.ERROR, this, e);
    }
}