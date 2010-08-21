package training.hl.flex.amf;

import flex.messaging.io.BeanProxy;
import flex.messaging.io.PropertyProxyRegistry;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
 
public class EnumPropertyProxy extends BeanProxy
{
 
	private static final long serialVersionUID = 2287876544968355458L;

	public EnumPropertyProxy()
	{
		super();
    }
 
    /////////////////////////////////////////////
    // Serialization
    /////////////////////////////////////////////
 
    @Override 
    public String getAlias(final Object aInstance)
    {
        return super.getClassName(aInstance);
    }
 
    @Override 
    public List<String> getPropertyNames(final Object aInstance)
    {
        final List<String> propertyNames = new ArrayList<String>(1);
        propertyNames.add("name");
        return propertyNames;
    }
 
    @Override
    public Class<String> getType(final Object aInstance, final String aPropertyName)
    {
        if("name".equals(aPropertyName))
        {
            return String.class;
        }
        return null;
    }
 
    @Override
    public Object getValue(final Object aInstance, final String aPropertyName)
    {
        if("name".equals(aPropertyName) && aInstance instanceof Enum<?>) 
        {
            final Enum<?> enumValue = (Enum<?>) aInstance;
            return enumValue.toString();
        }
        return null;
    }
 
 
    /////////////////////////////////////////////
    // Deserialization
    /////////////////////////////////////////////
 
    @Override 
    public Object createInstance(String className)
    {
        final Map<String, String> tempInstance = new HashMap<String, String>(2);
        tempInstance.put("className", className);
        return tempInstance;
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public void setValue(java.lang.Object o, java.lang.String s, java.lang.Object o1)
    {
        final Map<String, String> tempInstance = (Map<String, String>) o;
        tempInstance.put("name", (String) o1);
    }
 
    @SuppressWarnings("unchecked")
	@Override
	public Object instanceComplete(java.lang.Object o)
    {
        final Map<String, String> tempInstance = (Map<String, String>) o;
        final String className = tempInstance.get("className");
        final String name = tempInstance.get("name");
        final Class<Enum<?>> enumClass = getClassFromClassName(className);
 
        for(final Enum<?> constant : enumClass.getEnumConstants())
        {
            if(constant.toString().equals(name))
            {
                return constant;
            }
        }
        return null;
    }
 
 
    /////////////////////////////////////////////
    // Registration
    /////////////////////////////////////////////
 
    public static EnumPropertyProxy registerPropertyProxy()
    {
        PropertyProxyRegistry.getRegistry().register(Enum.class, new EnumPropertyProxy());
 
        // Sort of stupid, just to prevent NPEs in Spring.
        return new EnumPropertyProxy();
    }
 
}
