/**
	*/
public  ExternalNameSpace(NameSpace parent, String name, Map externalMap) {
    super(parent, name);
    if (externalMap == null)
        externalMap = new HashMap();
    this.externalMap = externalMap;
}