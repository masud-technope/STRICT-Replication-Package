private void pageChanged() {
    switch(currentPage) {
        case 0:
            caption.setText("Installing " + appName);
            nextButton.setText("Next");
            prevButton.setEnabled(false);
            nextButton.setEnabled(true);
            break;
        case 1:
            caption.setText(installer.getProperty("app.license.title"));
            nextButton.setText("Next");
            prevButton.setEnabled(true);
            nextButton.setEnabled(true);
            break;
        case 2:
            caption.setText("Specify where " + appName + " is to be installed");
            nextButton.setText("Next");
            prevButton.setEnabled(true);
            if (!chooseDirectory.isOK())
                nextButton.setEnabled(false);
            break;
        case 3:
            caption.setText("Choose components to install");
            nextButton.setText("Install");
            prevButton.setEnabled(true);
            nextButton.setEnabled(true);
            break;
        case 4:
            caption.setText("Installing " + appName);
            nextButton.setText("Finish");
            prevButton.setEnabled(false);
            nextButton.setEnabled(false);
            install();
            break;
        case 5:
            caption.setText("Installation complete");
            nextButton.setText("Finish");
            prevButton.setEnabled(false);
            nextButton.setEnabled(true);
            cancelButton.setEnabled(false);
            break;
    }
    getRootPane().invalidate();
    getRootPane().validate();
}