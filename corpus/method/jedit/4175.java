//{{{ TaskTableEditor constructor
private  TaskTableEditor() {
    button = new JButton(GUIUtilities.loadIcon(jEdit.getProperty("close-buffer.icon")));
    button.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            task.cancel();
            stopCellEditing();
        }
    });
//}}}
}