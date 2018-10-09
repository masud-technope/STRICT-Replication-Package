//{{{ actionPerformed() method
public void actionPerformed(ActionEvent ae) {
    getParentHistoryButton().actionPerformed(ae);
    history.setCurrentEntry(entry);
//}}}
}