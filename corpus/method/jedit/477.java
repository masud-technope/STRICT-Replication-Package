private boolean checkRelative(String dir) {
    File f = new File(dir);
    if (!f.isAbsolute()) {
        String msg = installer.getProperty("dir.relative");
        try {
            String full = f.getCanonicalPath();
            message.setForeground(Color.orange);
            message.setText(msg + '\n' + full);
        } catch (IOException ioe) {
            message.setForeground(Color.red);
            msg = installer.getProperty("dir.cant-resolve");
            message.setText(msg);
        }
        return false;
    } else
        return true;
}