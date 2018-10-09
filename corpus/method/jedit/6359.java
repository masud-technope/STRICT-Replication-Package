//}}}
//{{{ getCachedServices() method
public ServiceManager.Descriptor[] getCachedServices() {
    return cachedServices.toArray(new ServiceManager.Descriptor[cachedServices.size()]);
}