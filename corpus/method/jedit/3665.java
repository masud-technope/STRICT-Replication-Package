//{{{ mouseReleased() method
public void mouseReleased(MouseEvent evt) {
    SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            if (selectAll)
                selectAll();
        }
    });
//}}}
}