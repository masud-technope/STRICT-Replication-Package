//}}}
//{{{ dump() method
void dump() {
    for (Plugin plugin : plugins) {
        System.err.println(plugin);
        System.err.println();
    }
}