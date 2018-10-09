private void attribute(String aname, String value) {
    if (aname.equals("TOP"))
        top = value;
    else if (aname.equals("LEFT"))
        left = value;
    else if (aname.equals("BOTTOM"))
        bottom = value;
    else if (aname.equals("RIGHT"))
        right = value;
    else if (aname.equals("TOP_POS"))
        topPos = Integer.parseInt(value);
    else if (aname.equals("LEFT_POS"))
        leftPos = Integer.parseInt(value);
    else if (aname.equals("BOTTOM_POS"))
        bottomPos = Integer.parseInt(value);
    else if (aname.equals("RIGHT_POS"))
        rightPos = Integer.parseInt(value);
}