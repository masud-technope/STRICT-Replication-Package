//{{{ getCode() method
@Override
public String getCode() {
    return "Macros.getMacro(\"" + getName() + "\").invoke(view);";
//}}}
}