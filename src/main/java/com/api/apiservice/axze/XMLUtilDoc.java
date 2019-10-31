package com.api.apiservice.axze;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

public class XMLUtilDoc {
    /***
     * jdom解析XML
     * @param xmlDoc
     * @return
     */
    public static Map xmlElements(String xmlDoc) {
        //创建一个新的字符串
        StringReader read = new StringReader(xmlDoc);
        //创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
        InputSource source = new InputSource(read);
        //创建一个新的SAXBuilder
        SAXBuilder sb = new SAXBuilder();
        try {
            //通过输入源构造一个Document
            Document doc = sb.build(source);
            //取的根元素
            Element root = doc.getRootElement();
            System.out.println(root.getName());//输出根元素的名称（测试）
            //得到根元素所有子元素的集合
            List jiedian = root.getChildren();
            //获得XML中的命名空间（XML中未定义可不写）
            Namespace ns = root.getNamespace();
            Element et = null;
            Map map = new HashMap();
            for(int i=0;i<jiedian.size();i++){
                et = (Element) jiedian.get(i);//循环依次得到子元素
                transform(et,ns,map);
            }
            return map;
        } catch (JDOMException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
        return null;
    }
    public static void transform(Element el,Namespace ns,Map map){
        if("main".equals(el.getName())){
            String recordcount = el.getChild("recordcount", ns).getText();
            if(StringUtils.equals(recordcount,"-1")){
                System.out.printf("异常");
            }else {
                map.put("recordcount",recordcount);
            }
        }else if("detail".equals(el.getName())){
            List zjiedian = el.getChildren();
            List list =new ArrayList();
            for(int j=0;j<zjiedian.size();j++){
                Element et = (Element) zjiedian.get(j);
                Map<String,String> map0 =new HashMap<>();
                String orderdate = et.getChild("orderdate", ns)==null?null:et.getChild("orderdate", ns).getText();
                if(StringUtils.isNotBlank(orderdate)){ map0.put("orderdate", orderdate); }
                String goodcode = et.getChild("goodcode", ns)==null?null:et.getChild("goodcode", ns).getText();
                if(StringUtils.isNotBlank(goodcode)){ map0.put("goodcode", goodcode); }
                String goodname = et.getChild("goodname", ns)==null?null:et.getChild("goodname", ns).getText();
                if(StringUtils.isNotBlank(goodname)){ map0.put("goodname", goodname); }
                String ordertype = et.getChild("ordertype", ns)==null?null:et.getChild("ordertype", ns).getText();
                if(StringUtils.isNotBlank(ordertype)){ map0.put("ordertype", ordertype); }
                String packageunit = et.getChild("packageunit", ns)==null?null:et.getChild("packageunit", ns).getText();
                if(StringUtils.isNotBlank(packageunit)){ map0.put("packageunit", packageunit); }
                String spec = et.getChild("spec", ns)==null?null:et.getChild("spec", ns).getText();
                if(StringUtils.isNotBlank(spec)){ map0.put("spec", spec); }
                String unit = et.getChild("unit", ns)==null ?null:et.getChild("unit", ns).getText();
                if(StringUtils.isNotBlank(unit)){ map0.put("unit", unit); }
                String manufactor = et.getChild("manufactor", ns) == null?null: et.getChild("manufactor", ns).getText();
                if(StringUtils.isNotBlank(manufactor)){ map0.put("manufactor", manufactor); }
                //...
                String quantity = et.getChild("quantity", ns)==null ?null:et.getChild("quantity", ns).getText();
                if(StringUtils.isNotBlank(quantity)){ map0.put("quantity", quantity); }
                //..
                String taxprice = et.getChild("taxprice", ns)==null?null:et.getChild("taxprice", ns).getText();
                if(StringUtils.isNotBlank(taxprice)){ map0.put("taxprice", taxprice); }
                //..
                String taxamount = et.getChild("taxamount", ns)==null ?null:et.getChild("taxamount", ns).getText();
                if(StringUtils.isNotBlank(taxamount)){ map0.put("taxamount", taxamount); }
                //..
                String taxrate = et.getChild("taxrate", ns)==null? null: et.getChild("taxrate", ns).getText();
                if(StringUtils.isNotBlank(taxrate)){ map0.put("taxrate", taxrate); }
                //..
                String lotnumber = et.getChild("lotnumber", ns)==null?null:et.getChild("lotnumber", ns).getText();
                if(StringUtils.isNotBlank(lotnumber)){ map0.put("lotnumber", lotnumber); }
                //..
                String manufacturedate = et.getChild("manufacturedate", ns)==null?null:et.getChild("manufacturedate", ns).getText();
                if(StringUtils.isNotBlank(manufacturedate)){ map0.put("manufacturedate", manufacturedate); }
                //..
                String validitydate = et.getChild("validitydate", ns)==null?null: et.getChild("validitydate", ns).getText();
                if(StringUtils.isNotBlank(validitydate)){ map0.put("validitydate", validitydate); }

                String approvalnumber = et.getChild("approvalnumber",ns)==null?null :et.getChild("approvalnumber", ns).getText();
                if(StringUtils.isNotBlank(approvalnumber)){ map0.put("approvalnumber", approvalnumber); }

                String client = et.getChild("client", ns)==null?null :et.getChild("client", ns).getText();
                if(StringUtils.isNotBlank(client)){ map0.put("client", client); }

                String buyingpeople =et.getChild("buyingpeople",ns)== null ?null:et.getChild("buyingpeople", ns).getText();
                if(StringUtils.isNotBlank(buyingpeople)){ map0.put("buyingpeople", buyingpeople); }
                //---
                String department =et.getChild("department",ns) == null ?null :et.getChild("department", ns).getText();
                if(StringUtils.isNotBlank(department)){ map0.put("department", department); }
                //---
                String indays =et.getChild("indays",ns) == null ?null :et.getChild("indays", ns).getText();
                if(StringUtils.isNotBlank(indays)){ map0.put("indays", indays); }
                String validdays =et.getChild("validdays",ns) == null ?null :et.getChild("validdays", ns).getText();
                if(StringUtils.isNotBlank(validdays)){ map0.put("validdays", validdays); }
                String restrictioncompany =et.getChild("restrictioncompany",ns) == null ?null :et.getChild("restrictioncompany", ns).getText();
                if(StringUtils.isNotBlank(restrictioncompany)){ map0.put("restrictioncompany", restrictioncompany); }
                list.add(map0);
                map.put("detail",list);
            }
        }
    }

    public static void main(String[] args){
        XMLUtilDoc doc = new XMLUtilDoc();
        String xml ="<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>\n" +
                "<data>\n" +
                "    <detail>\n" +
                "        <item>\n" +
                "            <approvalnumber>国药准字S20050048</approvalnumber>\n" +
                "            <buyingpeople>韩晴晴</buyingpeople>\n" +
                "            <client>徐建港</client>\n" +
                "            <goodcode>3898</goodcode>\n" +
                "            <goodname>重组人血小板生成素注射液/特比澳</goodname>\n" +
                "            <lotnumber>201906051</lotnumber>\n" +
                "            <manufactor>沈阳三生制药有限责任公司</manufactor>\n" +
                "            <manufacturedate>2019-06-02</manufacturedate>\n" +
                "            <orderdate>2019-09-18</orderdate>\n" +
                "            <ordertype>采购入库</ordertype>\n" +
                "            <packageunit>瓶</packageunit>\n" +
                "            <quantity>600.000</quantity>\n" +
                "            <salesId>DWI00000839</salesId>\n" +
                "            <salesName>沈阳三生制药有限责任公司</salesName>\n" +
                "            <spec>15000单位(1毫升)/瓶</spec>\n" +
                "            <taxamount>573270.00</taxamount>\n" +
                "            <taxprice>955.4500</taxprice>\n" +
                "            <taxrate>3.00</taxrate>\n" +
                "            <unit>瓶</unit>\n" +
                "            <validitydate>2022-06-01</validitydate>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <approvalnumber>国药准字S20050048</approvalnumber>\n" +
                "            <buyingpeople>韩晴晴</buyingpeople>\n" +
                "            <client>徐建港</client>\n" +
                "            <goodcode>3898</goodcode>\n" +
                "            <goodname>重组人血小板生成素注射液/特比澳</goodname>\n" +
                "            <lotnumber>201905044</lotnumber>\n" +
                "            <manufactor>沈阳三生制药有限责任公司</manufactor>\n" +
                "            <manufacturedate>2019-05-13</manufacturedate>\n" +
                "            <orderdate>2019-08-26</orderdate>\n" +
                "            <ordertype>采购入库</ordertype>\n" +
                "            <packageunit>瓶</packageunit>\n" +
                "            <quantity>240.000</quantity>\n" +
                "            <salesId>DWI00000839</salesId>\n" +
                "            <salesName>沈阳三生制药有限责任公司</salesName>\n" +
                "            <spec>15000单位(1毫升)/瓶</spec>\n" +
                "            <taxamount>229308.00</taxamount>\n" +
                "            <taxprice>955.4500</taxprice>\n" +
                "            <taxrate>3.00</taxrate>\n" +
                "            <unit>瓶</unit>\n" +
                "            <validitydate>2022-05-12</validitydate>\n" +
                "        </item>\n" +
                "    </detail>\n" +
                "    <main>\n" +
                "        <recordcount>2</recordcount>\n" +
                "    </main>\n" +
                "</data>"
                ;
        Map<String,String> map = doc.xmlElements(xml);
        List<List<String>> details = new ArrayList<>();
        HashMap jsonMap = fromJson2Map(JSON.toJSONString(map));
        List<HashMap> itemList = (List<HashMap>)jsonMap.get("detail");
        for(HashMap mp : itemList ){
            List<String> item = new ArrayList<>();
            item.addAll(mp.values());
            details.addAll(Collections.singleton(item));
        }
        System.out.printf(":"+ JSON.toJSON(details));
    }


    public static HashMap<String, Object> fromJson2Map(String jsonString) {
        HashMap jsonMap = JSON.parseObject(jsonString, HashMap.class);
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        for(Iterator iter = jsonMap.keySet().iterator(); iter.hasNext();){
            String key = (String)iter.next();
            if(jsonMap.get(key) instanceof JSONArray){
                JSONArray jsonArray = (JSONArray)jsonMap.get(key);
                List list = handleJSONArray(jsonArray);
                resultMap.put(key, list);
            }else{
                resultMap.put(key, jsonMap.get(key));
            }
        }
        return resultMap;
    }

    private static List<HashMap<String, Object>> handleJSONArray(JSONArray jsonArray){
        List list = new ArrayList();
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            HashMap map = new HashMap<String, Object>();
            for (Map.Entry entry : jsonObject.entrySet()) {
                if(entry.getValue() instanceof  JSONArray){
                    map.put((String)entry.getKey(), handleJSONArray((JSONArray)entry.getValue()));
                }else{
                    map.put((String)entry.getKey(), entry.getValue());
                }
            }
            list.add(map);
        }
        return list;
    }
}