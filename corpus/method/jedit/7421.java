//}}}
//{{{ isUriList() method
private boolean isUriList(DataFlavor flavor) {
    return ("text".equals(flavor.getPrimaryType()) && "uri-list".equals(flavor.getSubType()) && flavor.getRepresentationClass() == String.class);
}