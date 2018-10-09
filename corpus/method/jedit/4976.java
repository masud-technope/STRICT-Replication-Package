//{{{ endElement() method
@Override
public void endElement(String uri, String localName, String name) {
    if ("REGISTER".equals(name)) {
        if (registerName == null || registerName.length() != 1)
            Log.log(Log.ERROR, this, "Malformed NAME: " + registerName);
        else
            Registers.setRegister(registerName.charAt(0), charData.toString());
        inRegister = false;
        charData.setLength(0);
    }
//}}}
}