//}}}
//{{{ parsePermissions() method
/**
	 * Parse a Unix-style permission string (rwxrwxrwx).
	 * @param s The string (must be 9 characters long).
	 * @since jEdit 4.1pre8
	 */
public static int parsePermissions(String s) {
    int permissions = 0;
    if (s.length() == 9) {
        if (s.charAt(0) == 'r')
            permissions += 0400;
        if (s.charAt(1) == 'w')
            permissions += 0200;
        if (s.charAt(2) == 'x')
            permissions += 0100;
        else if (s.charAt(2) == 's')
            permissions += 04100;
        else if (s.charAt(2) == 'S')
            permissions += 04000;
        if (s.charAt(3) == 'r')
            permissions += 040;
        if (s.charAt(4) == 'w')
            permissions += 020;
        if (s.charAt(5) == 'x')
            permissions += 010;
        else if (s.charAt(5) == 's')
            permissions += 02010;
        else if (s.charAt(5) == 'S')
            permissions += 02000;
        if (s.charAt(6) == 'r')
            permissions += 04;
        if (s.charAt(7) == 'w')
            permissions += 02;
        if (s.charAt(8) == 'x')
            permissions += 01;
        else if (s.charAt(8) == 't')
            permissions += 01001;
        else if (s.charAt(8) == 'T')
            permissions += 01000;
    }
    return permissions;
}