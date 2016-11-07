package com.clearing.zendaimoney.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtilsBean;

/**
 * POJO类工具
 * @version 1.0
 */
public abstract class ModelUtils {

	/**
	 * 新增对象时辅助加入创建人信息等
	 * @param model
	 * @param user
	 */
//	public static final void setCreatorInfo(BaseModel model, User user) {
//		if ( null != user ) {
//			Date now = new Date();
//			model.setCreator(user.getUserName());
//			model.setLastModifier(user.getUserName());
//			model.setCreateDate(now);
//			model.setLastModifyDate(now);
//		}
//	}
	
	/**
	 * 修改对象时辅助更新最后修改人信息等
	 * @param model
	 * @param user
	 */
//	public static final void setModifierInfo(BaseLogicalDeletableModel model, User user) {
//		if ( null != user ) {
//			model.setLastModifier(user.getUserName());
//			model.setLastModifyDate(new Date());
//		}
//	}
	
	/**
     * set的参数必须只有一个，set的返回类型为void，set方法是public的
     * @param method
     * @return
     */
    public static final boolean isSetMethod(Method method) {
        if (method == null) {
            return false;
        }
        if (!method.getName().startsWith("set")) {
            return false;
        }
        if (method.getParameterTypes().length != 1) {
            return false;
        }
        if (method.getReturnType() != Void.TYPE) {
            return false;
        }
        if (!Modifier.isPublic(method.getModifiers())) {
            return false;
        }
        return true;
    }
    
    /**	
     * 根据Class得到他的属性名
     * @param beanClass
     * @return List
     */
	public static List<String> getPropertyNames(Class<?> beanClass) {
    	List<String> propertyNames = new LinkedList<String>();
    	Method[] methods = beanClass.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if (isSetMethod(method)) {
				propertyNames.add(getPropertyName(method.getName()));
			}
		}
    	return propertyNames;
    }
	
	 /**
     * 根据一个方法名，得到它的属性名，方法只有两种get方法和set方法，属性名第一个强制变小写
     * @param methodName
     * @return
     */
    public static String getPropertyName(String methodName) {
        return methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
    }
    
    /**
     * 调用set方法，转换非RuntimeException 
     * @param object
     * @param method
     * @return
     */
    public static void invokeSetMethod(Object object, Method method, Object value) {
        try {
            method.invoke(object, new Object[] {value});
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
            throw new IllegalArgumentException(ex.getMessage());
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
    
    /**
     * 把source对象中非空的值COPY到target中
     * ModelUtils.transferValue(source, target);
     * @param source
     * @param target
     */
    public static void transferValue(Object source, Object target) {
    	BeanUtilsBean beanUtils = BeanUtilsBean.getInstance();
		if (target == null)
			throw new IllegalArgumentException("No destination bean specified");
		if (source == null)
			throw new IllegalArgumentException("No origin bean specified");
		PropertyDescriptor[] origDescriptors = beanUtils.getPropertyUtils()
				.getPropertyDescriptors(source);
		for (int i = 0; i < origDescriptors.length; i++) { 
			String name = origDescriptors[i].getName();
			if ("class".equals(name)) continue;
			if (beanUtils.getPropertyUtils().isReadable(source, name)
					&& beanUtils.getPropertyUtils().isWriteable(target, name)) {
				try {
					Object value = beanUtils.getPropertyUtils().getSimpleProperty(
							source, name);
					if (value != null) {
						beanUtils.copyProperty(target, name, value);
					}
				} catch (NoSuchMethodException e) {
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
    }
}
