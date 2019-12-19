package cn.gjing.tools.excel.util;

import cn.gjing.tools.excel.ExcelField;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Bean tools
 *
 * @author Gjing
 **/
public class BeanUtils {
    /**
     * Finds methods declared in a given class
     *
     * @param clazz      class
     * @param methodName method name
     * @param paramTypes param types
     * @return Method
     */
    public static Method findDeclaredMethod(Class<?> clazz, String methodName, Class<?>... paramTypes) {
        try {
            return clazz.getDeclaredMethod(methodName, paramTypes);
        } catch (NoSuchMethodException var4) {
            return clazz.getSuperclass() != null ? findDeclaredMethod(clazz.getSuperclass(), methodName, paramTypes) : null;
        }
    }

    /**
     * Sets the value of a field of an object
     *
     * @param o     object
     * @param field field
     * @param value value
     */
    public static void setFieldValue(Object o, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(o, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the value in the field
     *
     * @param o     object
     * @param field field
     * @return Object
     */
    public static Object getFieldValue(Object o, Field field) {
        try {
            field.setAccessible(true);
            return field.get(o);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    /**
     * Gets all annotated fields of the parent and child classes
     *
     * @param excelClass Excel mapped entity
     * @param ignores    The exported field is to be ignored
     * @return Annotated fields
     */
    public static List<Field> getFields(Class<?> excelClass, String[] ignores) {
        Field[] declaredFields = excelClass.getDeclaredFields();
        List<Field> hasExcelFieldList = Arrays.stream(declaredFields)
                .filter(e -> e.isAnnotationPresent(ExcelField.class))
                .filter(e -> ParamUtils.noContains(ignores, e.getName()))
                .collect(Collectors.toList());
        Class<?> superclass = excelClass.getSuperclass();
        if (superclass != Object.class) {
            hasExcelFieldList.addAll(Arrays.stream(superclass.getDeclaredFields())
                    .filter(e -> e.isAnnotationPresent(ExcelField.class))
                    .filter(e -> ParamUtils.noContains(ignores, e.getName()))
                    .collect(Collectors.toList()));
        }
        return hasExcelFieldList;
    }

    /**
     * Gets the class of a generic in a generic interface
     *
     * @param source        A class that implements a generic interface
     * @param typeInterface A generic interface
     * @param paramIndex    Parameter subscript, starting at 0
     * @return Class
     */
    public static Class<?> getInterfaceType(Class<?> source, Class<?> typeInterface, int paramIndex) {
        Type[] genericInterfaces = source.getGenericInterfaces();
        for (Type type : genericInterfaces) {
            if (type.getTypeName().startsWith(typeInterface.getName())) {
                ParameterizedType pt = (ParameterizedType) type;
                return (Class<?>) pt.getActualTypeArguments()[paramIndex];
            }
        }
        return null;
    }

    /**
     * Gets the corresponding enum by value
     * @param enumClass The enum class to get
     * @param value Enum value
     * @return Enum
     */
    public static Enum<?> getEnum(Class<? extends Enum<?>> enumClass, String value) {
        Enum<?>[] enumConstants = enumClass.getEnumConstants();
        for (Enum<?> constant : enumConstants) {
            if (value.equals(constant.name())) {
                return constant;
            }
        }
        throw new NullPointerException("No found your enum");
    }
}
