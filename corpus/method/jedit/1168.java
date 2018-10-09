public static boolean haveSwing() {
    // classExists caches info for us
    return classExists("javax.swing.JButton");
}