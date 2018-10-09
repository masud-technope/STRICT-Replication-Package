public static void tell(Object obj) {
    String str = obj == null ? "NULL" : obj.toString();
    JOptionPane.showMessageDialog(jEdit.getActiveView(), str, "Title", 1);
}