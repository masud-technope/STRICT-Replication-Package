private void attribute(String aname, String value) {
    if (aname.equals("X"))
        config.x = Integer.parseInt(value);
    else if (aname.equals("Y"))
        config.y = Integer.parseInt(value);
    else if (aname.equals("WIDTH"))
        config.width = Integer.parseInt(value);
    else if (aname.equals("HEIGHT"))
        config.height = Integer.parseInt(value);
    else if (aname.equals("EXT_STATE"))
        config.extState = Integer.parseInt(value);
    else if (aname.equals("PLAIN"))
        config.plainView = ("TRUE".equals(value));
    else if (aname.equals("AUTORELOAD"))
        autoReload = value;
    else if (aname.equals("AUTORELOAD_DIALOG"))
        autoReloadDialog = value;
    else if (aname.equals("UNTITLED"))
        untitled = value;
}