//}}}
//{{{ setBorderPainted() method
public void setBorderPainted(boolean b) {
    try {
        revalidateBlocked = true;
        super.setBorderPainted(b);
        setContentAreaFilled(b);
    } finally {
        revalidateBlocked = false;
    }
}