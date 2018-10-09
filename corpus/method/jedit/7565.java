//}}}
//}}}
//{{{ private section
//{{{ color2html()
private static String color2html(Color c) {
    StringBuilder cs = new StringBuilder("rgb(");
    cs.append(c.getRed());
    cs.append(",");
    cs.append(c.getGreen());
    cs.append(",");
    cs.append(c.getBlue());
    cs.append(");");
    return cs.toString();
}