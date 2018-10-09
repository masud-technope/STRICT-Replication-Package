//{{{ isExpansionToggle() method
public static boolean isExpansionToggle(int level, int x) {
    return (x >= level * LEVEL_WIDTH) && (x <= level * LEVEL_WIDTH + ICON_WIDTH);
//}}}
}