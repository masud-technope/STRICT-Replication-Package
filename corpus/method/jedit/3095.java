public void actionPerformed(ActionEvent evt) {
    current = (current + 1) % frames.length;
    setImage(frames[current]);
    host.repaint();
}