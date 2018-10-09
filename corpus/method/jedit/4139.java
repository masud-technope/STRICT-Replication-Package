//{{{ getWidget() method
private Widget getWidget(String name) {
    if ("mode".equals(name))
        return modeWidget;
    if ("fold".equals(name))
        return foldWidget;
    if ("encoding".equals(name))
        return encodingWidget;
    if ("wrap".equals(name))
        return wrapWidget;
    if ("indent".equals(name))
        return indentWidget;
    if ("multiSelect".equals(name))
        return multiSelectWidget;
    if ("rectSelect".equals(name))
        return rectSelectWidget;
    if ("overwrite".equals(name))
        return overwriteWidget;
    if ("lineSep".equals(name))
        return lineSepWidget;
    if ("locked".equals(name))
        return lockedWidget;
    return _getWidget(name);
}