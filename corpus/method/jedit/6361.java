//}}}
//{{{ endElement() method
public void endElement(String uri, String localName, String name) {
    String tag = peekElement();
    if (name.equals(tag)) {
        if (tag.equals("SERVICE")) {
            ServiceManager.Descriptor d = new ServiceManager.Descriptor(serviceClass, serviceName, code.toString(), plugin);
            ServiceManager.registerService(d);
            cachedServices.add(d);
            code.setLength(0);
        }
        popElement();
    } else {
        // can't happen
        throw new InternalError();
    }
}