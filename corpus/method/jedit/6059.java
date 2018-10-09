//}}}
//{{{ getHeaderField()
public String getHeaderField(String name) {
    if (name.equals("content-type")) {
        String lcResource = resource.toLowerCase();
        if (lcResource.endsWith(".html"))
            return "text/html";
        else if (lcResource.endsWith(".txt"))
            return "text/plain";
        else if (lcResource.endsWith(".rtf"))
            return "text/rtf";
        else if (lcResource.endsWith(".gif"))
            return "image/gif";
        else if (lcResource.endsWith(".jpg") || lcResource.endsWith(".jpeg"))
            return "image/jpeg";
        else
            return null;
    } else
        return null;
}