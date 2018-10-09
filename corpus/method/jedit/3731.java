//}}}
//{{{ isPrintable() method
/**
	 * We need to know if a keycode can potentially result in a
	 * keytyped.
	 * @since jEdit 4.3pre2
	 */
public static boolean isPrintable(int keyCode) {
    switch(keyCode) {
        /* case KeyEvent.VK_ENTER:
		case KeyEvent.VK_TAB: */
        case KeyEvent.VK_SPACE:
        case KeyEvent.VK_COMMA:
        case KeyEvent.VK_MINUS:
        case KeyEvent.VK_PERIOD:
        case KeyEvent.VK_SLASH:
        case KeyEvent.VK_0:
        case KeyEvent.VK_1:
        case KeyEvent.VK_2:
        case KeyEvent.VK_3:
        case KeyEvent.VK_4:
        case KeyEvent.VK_5:
        case KeyEvent.VK_6:
        case KeyEvent.VK_7:
        case KeyEvent.VK_8:
        case KeyEvent.VK_9:
        case KeyEvent.VK_SEMICOLON:
        case KeyEvent.VK_EQUALS:
        case KeyEvent.VK_A:
        case KeyEvent.VK_B:
        case KeyEvent.VK_C:
        case KeyEvent.VK_D:
        case KeyEvent.VK_E:
        case KeyEvent.VK_F:
        case KeyEvent.VK_G:
        case KeyEvent.VK_H:
        case KeyEvent.VK_I:
        case KeyEvent.VK_J:
        case KeyEvent.VK_K:
        case KeyEvent.VK_L:
        case KeyEvent.VK_M:
        case KeyEvent.VK_N:
        case KeyEvent.VK_O:
        case KeyEvent.VK_P:
        case KeyEvent.VK_Q:
        case KeyEvent.VK_R:
        case KeyEvent.VK_S:
        case KeyEvent.VK_T:
        case KeyEvent.VK_U:
        case KeyEvent.VK_V:
        case KeyEvent.VK_W:
        case KeyEvent.VK_X:
        case KeyEvent.VK_Y:
        case KeyEvent.VK_Z:
        case KeyEvent.VK_OPEN_BRACKET:
        case KeyEvent.VK_BACK_SLASH:
        case KeyEvent.VK_CLOSE_BRACKET:
        case KeyEvent.VK_NUMPAD0:
        case KeyEvent.VK_NUMPAD1:
        case KeyEvent.VK_NUMPAD2:
        case KeyEvent.VK_NUMPAD3:
        case KeyEvent.VK_NUMPAD4:
        case KeyEvent.VK_NUMPAD5:
        case KeyEvent.VK_NUMPAD6:
        case KeyEvent.VK_NUMPAD7:
        case KeyEvent.VK_NUMPAD8:
        case KeyEvent.VK_NUMPAD9:
        case KeyEvent.VK_MULTIPLY:
        case KeyEvent.VK_ADD:
        case KeyEvent.VK_SEPARATOR:
        case KeyEvent.VK_SUBTRACT:
        case KeyEvent.VK_DECIMAL:
        case KeyEvent.VK_DIVIDE:
        case KeyEvent.VK_BACK_QUOTE:
        case KeyEvent.VK_QUOTE:
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
        case KeyEvent.VK_AMPERSAND:
        case KeyEvent.VK_ASTERISK:
        case KeyEvent.VK_QUOTEDBL:
        case KeyEvent.VK_LESS:
        case KeyEvent.VK_GREATER:
        case KeyEvent.VK_BRACELEFT:
        case KeyEvent.VK_BRACERIGHT:
        case KeyEvent.VK_AT:
        case KeyEvent.VK_COLON:
        case KeyEvent.VK_CIRCUMFLEX:
        case KeyEvent.VK_DOLLAR:
        case KeyEvent.VK_EURO_SIGN:
        case KeyEvent.VK_EXCLAMATION_MARK:
        case KeyEvent.VK_INVERTED_EXCLAMATION_MARK:
        case KeyEvent.VK_LEFT_PARENTHESIS:
        case KeyEvent.VK_NUMBER_SIGN:
        case KeyEvent.VK_PLUS:
        case KeyEvent.VK_RIGHT_PARENTHESIS:
        case KeyEvent.VK_UNDERSCORE:
            return true;
        default:
            return false;
    }
}