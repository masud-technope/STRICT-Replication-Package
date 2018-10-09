//}}}
//{{{ setBorderPainted() method
public void setBorderPainted(boolean b) {
    try {
        revalidateBlocked = true;
        super.setBorderPainted(b);
        setContentAreaFilled(false);
    } finally {
        revalidateBlocked = false;
    }
}