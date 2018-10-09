//}}}
//{{{ Private members
private static String buildMirror(String id) {
    return ((id != null) && !id.equals(MirrorList.Mirror.NONE)) ? id : "default";
}