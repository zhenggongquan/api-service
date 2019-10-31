/*
package com.api.apiservice.util;


import java.util.ArrayList;

public class JsonHelper {

    private static ObjectMapper getJsonmapper() {
        //ObjectMapper jsonmap = new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        ObjectMapper jsonmap = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
//        jsonmap.configure(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT,true);
//        jsonmap.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        jsonmap.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return jsonmap;
    }

    */
/**
     * 获取实体列表
     *
     * @param javaType
     * @param json
     * @param <T>
     * @return
     * @throws IOException
     *//*

    public static <T> T getList(JavaType javaType, String json) throws IOException {
        return getJsonmapper().readValue(json, javaType);
    }

    */
/**
     * 获取类型
     *
     * @param beanType
     * @return
     *//*

    public static JavaType getArrayType(Class<?> beanType) {
        return getCollectionType(ArrayList.class, beanType);
    }

    */
/**
     * 获取类型
     *
     * @param collectionType
     * @param elementClasses
     * @return
     *//*

    public static JavaType getCollectionType(Class<?> collectionType, Class<?>... elementClasses) {
        return getJsonmapper().getTypeFactory().constructParametricType(collectionType, elementClasses);
    }

    */
/**
     * 获取Json
     *
     * @param t
     * @param <T>
     * @return
     *//*

    public static <T> String getJson(T t) {
        if (t == null) return null;
        return new JsonMapper(JsonInclude.Include.NON_EMPTY).toJson(t);
    }
}

}
*/
