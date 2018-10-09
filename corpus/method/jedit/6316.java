//}}}
//{{{ save() method
/**
	 * @param cancel If true, we don't bother the user with warning messages
	 */
private boolean save(boolean cancel) {
    try {
        // prevents us from handling SearchSettingsChanged
        // as a result of below
        saving = true;
        SearchAndReplace.setWholeWord(wholeWord.isSelected());
        SearchAndReplace.setIgnoreCase(ignoreCase.isSelected());
        SearchAndReplace.setRegexp(regexp.isSelected());
        SearchAndReplace.setReverseSearch(searchBack.isSelected());
        SearchAndReplace.setAutoWrapAround(wrap.isSelected());
        jEdit.setBooleanProperty("search.subdirs.toggle", searchSubDirectories.isSelected());
        jEdit.setBooleanProperty("search.skipHidden.toggle", skipHidden.isSelected());
        jEdit.setBooleanProperty("search.skipBinary.toggle", skipBinaryFiles.isSelected());
        String filter = this.filter.getText();
        this.filter.addCurrentToHistory();
        if (filter.length() == 0)
            filter = "*";
        SearchFileSet fileset = SearchAndReplace.getSearchFileSet();
        boolean recurse = searchSubDirectories.isSelected();
        if (searchSelection.isSelected())
            fileset = new CurrentBufferSet();
        else if (searchCurrentBuffer.isSelected()) {
            fileset = new CurrentBufferSet();
            jEdit.setBooleanProperty("search.hypersearch.toggle", hyperSearch.isSelected());
        } else if (searchAllBuffers.isSelected())
            fileset = new AllBufferSet(filter, view);
        else if (searchDirectory.isSelected()) {
            String directory = this.directoryField.getText();
            directory = MiscUtilities.expandVariables(directory);
            this.directoryField.addCurrentToHistory();
            directory = MiscUtilities.constructPath(view.getBuffer().getDirectory(), directory);
            if ((VFSManager.getVFSForPath(directory).getCapabilities() & VFS.LOW_LATENCY_CAP) == 0) {
                if (cancel)
                    return false;
                int retVal = GUIUtilities.confirm(this, "remote-dir-search", null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (retVal != JOptionPane.YES_OPTION)
                    return false;
            }
            if (fileset instanceof DirectoryListSet) {
                DirectoryListSet dset = (DirectoryListSet) fileset;
                // dset may be a subclass of DirectoryListSet so
                // we can't create a new DirectoryListSet object here
                // as it's done with other filesets (#3549670)
                dset.setDirectory(directory);
                dset.setFileFilter(filter);
                dset.setRecursive(recurse);
            } else
                fileset = new DirectoryListSet(directory, filter, recurse);
        } else {
            // can't happen
            fileset = null;
            throw new IllegalStateException("One of search Selection, " + "current Buffer, directory, " + "all buffers must be selected!");
        }
        jEdit.setBooleanProperty("search.subdirs.toggle", recurse);
        jEdit.setBooleanProperty("search.keepDialog.toggle", keepDialog.isSelected());
        SearchAndReplace.setSearchFileSet(fileset);
        replace.addCurrentToHistory();
        SearchAndReplace.setReplaceString(replace.getText());
        if (find.getText().length() == 0) {
            if (!cancel)
                javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
            return false;
        }
        find.addCurrentToHistory();
        SearchAndReplace.setSearchString(find.getText());
        return true;
    } finally {
        saving = false;
    }
}