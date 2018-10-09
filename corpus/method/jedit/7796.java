//{{{ KeymapImpl() constructor
 KeymapImpl(String name, File file) {
    this.name = name;
    this.file = file;
    loadProperties();
}