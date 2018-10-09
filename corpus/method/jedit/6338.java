//}}}
//{{{ initFocusOrder() method
private void initFocusOrder() {
    // find and replace history fields
    focusOrder.add(find);
    focusOrder.add(replace);
    // buttons
    focusOrder.add(findBtn);
    focusOrder.add(replaceBtn);
    focusOrder.add(replaceAndFindBtn);
    focusOrder.add(replaceAllBtn);
    focusOrder.add(closeBtn);
    // replace with text or beanshell snippet radio buttons
    focusOrder.add(stringReplace);
    focusOrder.add(beanShellReplace);
    // search in settings
    focusOrder.add(searchSelection);
    focusOrder.add(searchCurrentBuffer);
    focusOrder.add(searchAllBuffers);
    focusOrder.add(searchDirectory);
    // search settings
    focusOrder.add(keepDialog);
    focusOrder.add(ignoreCase);
    focusOrder.add(regexp);
    focusOrder.add(hyperSearch);
    focusOrder.add(wholeWord);
    // direction settings
    focusOrder.add(searchBack);
    focusOrder.add(searchForward);
    focusOrder.add(wrap);
    // directory controls
    focusOrder.add(filter);
    focusOrder.add(synchronize);
    focusOrder.add(directoryField);
    focusOrder.add(choose);
    focusOrder.add(searchSubDirectories);
    focusOrder.add(skipHidden);
    focusOrder.add(skipBinaryFiles);
}