//{{{ isBindable() method
public static boolean isBindable(int keyCode) {
    switch(keyCode) {
        case KeyEvent.VK_ALT:
        case KeyEvent.VK_ALT_GRAPH:
        case KeyEvent.VK_CONTROL:
        case KeyEvent.VK_SHIFT:
        case KeyEvent.VK_META:
        case KeyEvent.VK_DEAD_GRAVE:
        case KeyEvent.VK_DEAD_ACUTE:
        case KeyEvent.VK_DEAD_CIRCUMFLEX:
        case KeyEvent.VK_DEAD_TILDE:
        case KeyEvent.VK_DEAD_MACRON:
        case KeyEvent.VK_DEAD_BREVE:
        case KeyEvent.VK_DEAD_ABOVEDOT:
        case KeyEvent.VK_DEAD_DIAERESIS:
        case KeyEvent.VK_DEAD_ABOVERING:
        case KeyEvent.VK_DEAD_DOUBLEACUTE:
        case KeyEvent.VK_DEAD_CARON:
        case KeyEvent.VK_DEAD_CEDILLA:
        case KeyEvent.VK_DEAD_OGONEK:
        case KeyEvent.VK_DEAD_IOTA:
        case KeyEvent.VK_DEAD_VOICED_SOUND:
        case KeyEvent.VK_DEAD_SEMIVOICED_SOUND:
            return false;
        default:
            return true;
    }
}