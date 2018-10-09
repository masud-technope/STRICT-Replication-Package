public void actionPerformed(ActionEvent evt) {
    replace.setModel(beanShellReplace.isSelected() ? "replace.script" : "replace");
    SearchAndReplace.setBeanShellReplace(beanShellReplace.isSelected());
}