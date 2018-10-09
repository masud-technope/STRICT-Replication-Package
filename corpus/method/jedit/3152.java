//}}}
//}}}
//{{{ keyPressed() medhod
protected void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
        textArea.backspace();
        e.consume();
        if (word.length() == 1) {
            dispose();
        } else {
            resetWords(word.substring(0, word.length() - 1));
        }
    }
}