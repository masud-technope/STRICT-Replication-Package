private void copyHelpBooks() {
    for (Iterator itor = mHelpBooks.iterator(); itor.hasNext(); ) {
        HelpBook helpBook = (HelpBook) itor.next();
        String folderName = helpBook.getFolderName();
        String name = helpBook.getName();
        String locale = helpBook.getLocale();
        List fileLists = helpBook.getFileLists();
        List fileSets = helpBook.getFileSets();
        File helpBookDir = null;
        if (locale == null) {
            // Set the Bundle entries for a nonlocalized Help Book
            if (folderName != null)
                bundleProperties.setCFBundleHelpBookFolder(folderName);
            if (name != null)
                bundleProperties.setCFBundleHelpBookName(name);
            // The non-localized Help Book is top level "/Resources"
            helpBookDir = new File(mResourcesDir, folderName);
            helpBookDir.mkdir();
            if (mVerbose)
                log("Creating Help Book at \"" + bundlePath(helpBookDir) + "\"");
        } else {
            // The localized Help Book is "/Resources/locale.lproj"
            File lproj = new File(mResourcesDir, locale + ".lproj");
            lproj.mkdir();
            helpBookDir = new File(lproj, folderName);
            helpBookDir.mkdir();
            if (mVerbose)
                log("Creating Help Book for \"" + locale + "\" at \"" + bundlePath(helpBookDir) + "\"");
            // Create a local file to override the Bundle settings
            File infoPList = new File(lproj, "InfoPlist.strings");
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(new FileWriter(infoPList));
                writer.println("CFBundleHelpBookFolder = \"" + folderName + "\";");
                writer.println("CFBundleHelpBookName = \"" + name + "\";");
                writer.println("CFBundleName = \"" + bundleProperties.getCFBundleName() + "\";");
            } catch (IOException ioe) {
                throw new BuildException("IOException in writing Help Book locale: " + locale);
            } finally {
                mFileUtils.close(writer);
            }
        }
        // Write the Help Book source files into the bundle
        processCopyingFileSets(fileSets, helpBookDir, false);
        processCopyingFileLists(fileLists, helpBookDir, false);
    }
}