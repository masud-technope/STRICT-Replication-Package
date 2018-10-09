public void addConfiguredHelpBook(HelpBook helpBook) {
    // Validity check on 'foldername'
    if (helpBook.getFolderName() == null) {
        if (bundleProperties.getCFBundleHelpBookFolder() == null)
            throw new BuildException("Either the '<helpbook>' attribute 'foldername' or the '<jarbundler>' attribute 'helpbookfolder' must be defined");
        helpBook.setFolderName(bundleProperties.getCFBundleHelpBookFolder());
    }
    // Validity check on 'title'
    if (helpBook.getName() == null) {
        if (bundleProperties.getCFBundleHelpBookName() == null)
            throw new BuildException("Either the '<helpbook>' attribute 'name' or the '<jarbundler>' attribute 'helpbookname' must be defined");
        helpBook.setName(bundleProperties.getCFBundleHelpBookName());
    }
    // Make sure some file were selected...
    List fileLists = helpBook.getFileLists();
    List fileSets = helpBook.getFileSets();
    if (fileLists.isEmpty() && fileSets.isEmpty())
        throw new BuildException("The '<helpbook>' task must have either " + "'<fileset>' or  '<filelist>' nested tags");
    mHelpBooks.add(helpBook);
}