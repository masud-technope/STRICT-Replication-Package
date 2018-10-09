 SwingProgress() {
    super(new BorderLayout());
    progress = new JProgressBar();
    progress.setStringPainted(true);
    SwingProgress.this.add(BorderLayout.NORTH, progress);
}