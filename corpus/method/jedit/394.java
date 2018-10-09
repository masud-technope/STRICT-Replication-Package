private static void errorAndExit(boolean isGUI, String message) {
    if (isGUI) {
        JTextArea messageCnt = new JTextArea(message);
        JOptionPane.showMessageDialog(null, messageCnt, "jEdit installer error...", JOptionPane.ERROR_MESSAGE);
    } else {
        System.err.println(message);
    }
    System.exit(1);
}