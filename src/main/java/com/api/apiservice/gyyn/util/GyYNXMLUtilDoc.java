package com.api.apiservice.gyyn.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.apiservice.param.AgentCode;
import com.api.apiservice.util.Constants;
import org.apache.commons.lang3.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class GyYNXMLUtilDoc {
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
            for (int i = 0; i < jiedian.size(); i++) {
                et = (Element) jiedian.get(i);//循环依次得到子元素
                transform(et, ns, map);
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

    public static void transform(Element el, Namespace ns, Map map) {
        if ("header".equals(el.getName())) {
            String appCode = el.getChild("appCode", ns).getText();
            map.put("appCode", appCode);
        } else if ("body".equals(el.getName())) {
            Element dataStores = el.getChild("dataStores");
            List children = dataStores.getChildren();
            List list = new ArrayList();
            for (int j = 0; j < children.size(); j++) {
                Element et = (Element) children.get(j);
                Map<String, String> map0 = new HashMap<>();
                String orderdate = et.getChild("库存日期", ns) == null ? null : et.getChild("库存日期", ns).getText();
                if (StringUtils.isNotBlank(orderdate)) {   map0.put("orderdate", orderdate);  }
                String goodcode = et.getChild("仓库代码", ns) == null ? null : et.getChild("仓库代码", ns).getText();
                if (StringUtils.isNotBlank(goodcode)) {    map0.put("goodcode", goodcode);    }
                String goodname = et.getChild("仓库名称", ns) == null ? null : et.getChild("仓库名称", ns).getText();
                if (StringUtils.isNotBlank(goodname)) {  map0.put("goodname", goodname);  }
                String company = et.getChild("公司代码", ns) == null ? null : et.getChild("公司代码", ns).getText();
                if (StringUtils.isNotBlank(company)) {    map0.put("company", company);     }
                String packageunit = et.getChild("公司名称", ns) == null ? null : et.getChild("公司名称", ns).getText();
                if (StringUtils.isNotBlank(packageunit)) {
                    map0.put("packageunit", packageunit);
                }
                String spec = et.getChild("产品代码", ns) == null ? null : et.getChild("产品代码", ns).getText();
                if (StringUtils.isNotBlank(spec)) {
                    map0.put("spec", spec);
                }
                String unit = et.getChild("产品名称", ns) == null ? null : et.getChild("产品名称", ns).getText();
                if (StringUtils.isNotBlank(unit)) {
                    map0.put("unit", unit);
                }
                String manufactor = et.getChild("产品规格", ns) == null ? null : et.getChild("产品规格", ns).getText();
                if (StringUtils.isNotBlank(manufactor)) {
                    map0.put("manufactor", manufactor);
                }
                //...
                String quantity = et.getChild("批号", ns) == null ? null : et.getChild("批号", ns).getText();
                if (StringUtils.isNotBlank(quantity)) {
                    map0.put("quantity", quantity);
                }
                //..
                String taxprice = et.getChild("批准文号", ns) == null ? null : et.getChild("批准文号", ns).getText();
                if (StringUtils.isNotBlank(taxprice)) {
                    map0.put("taxprice", taxprice);
                }
                //..
                String taxamount = et.getChild("数量", ns) == null ? null : et.getChild("数量", ns).getText();
                if (StringUtils.isNotBlank(taxamount)) {
                    map0.put("taxamount", taxamount);
                }
                //..
                String taxrate = et.getChild("单位", ns) == null ? null : et.getChild("单位", ns).getText();
                if (StringUtils.isNotBlank(taxrate)) {
                    map0.put("taxrate", taxrate);
                }
                //..
                String lotnumber = et.getChild("生产日期", ns) == null ? null : et.getChild("生产日期", ns).getText();
                if (StringUtils.isNotBlank(lotnumber)) {
                    map0.put("lotnumber", lotnumber);
                }
                //..
                String manufacturedate = et.getChild("失效日期", ns) == null ? null : et.getChild("失效日期", ns).getText();
                if (StringUtils.isNotBlank(manufacturedate)) {
                    map0.put("manufacturedate", manufacturedate);
                }
                //..
                String validitydate = et.getChild("生产厂家", ns) == null ? null : et.getChild("生产厂家", ns).getText();
                if (StringUtils.isNotBlank(validitydate)) {
                    map0.put("validitydate", validitydate);
                }

                String approvalnumber = et.getChild("厂牌", ns) == null ? null : et.getChild("厂牌", ns).getText();
                if (StringUtils.isNotBlank(approvalnumber)) {
                    map0.put("approvalnumber", approvalnumber);
                }

                String client = et.getChild("库存类型", ns) == null ? null : et.getChild("库存类型", ns).getText();
                if (StringUtils.isNotBlank(client)) {
                    map0.put("client", client);
                }

                String buyingpeople = et.getChild("业务锁定数量", ns) == null ? null : et.getChild("业务锁定数量", ns).getText();
                if (StringUtils.isNotBlank(buyingpeople)) {
                    map0.put("buyingpeople", buyingpeople);
                }
                //---
                String department = et.getChild("库存状态", ns) == null ? null : et.getChild("库存状态", ns).getText();
                if (StringUtils.isNotBlank(department)) {
                    map0.put("department", department);
                }
                //----------------销售-----------
                String xiaoShouRiQi = et.getChild("销售日期", ns) == null ? null : et.getChild("销售日期", ns).getText();
                if (StringUtils.isNotBlank(xiaoShouRiQi)) {
                    map0.put("xiaoShouRiQi", xiaoShouRiQi);
                }
                String xiaoShouDaiMa= et.getChild("销售方代码", ns) == null ? null : et.getChild("销售方代码", ns).getText();
                if (StringUtils.isNotBlank(xiaoShouDaiMa)) {
                    map0.put("xiaoShouDaiMa", xiaoShouDaiMa);
                }
                String xiaoShouName= et.getChild("销售方名称", ns) == null ? null : et.getChild("销售方名称", ns).getText();
                if (StringUtils.isNotBlank(xiaoShouName)) {
                    map0.put("xiaoShouName", xiaoShouName);
                }
                String danJiuHao= et.getChild("单据号", ns) == null ? null : et.getChild("单据号", ns).getText();
                if (StringUtils.isNotBlank(danJiuHao)) {
                    map0.put("danJiuHao", danJiuHao);
                }
                String chuFangHostiptalCode= et.getChild("处方医院代码", ns) == null ? null : et.getChild("处方医院代码", ns).getText();
                if (StringUtils.isNotBlank(chuFangHostiptalCode)) {
                    map0.put("chuFangHostiptalCode", chuFangHostiptalCode);
                }
                String chuFangHostiptalCodeName= et.getChild("处方医院名称", ns) == null ? null : et.getChild("处方医院名称", ns).getText();
                if (StringUtils.isNotBlank(chuFangHostiptalCodeName)) {
                    map0.put("chuFangHostiptalCodeName", chuFangHostiptalCodeName);
                }
                String purCode= et.getChild("采购方代码", ns) == null ? null : et.getChild("采购方代码", ns).getText();
                if (StringUtils.isNotBlank(purCode)) {
                    map0.put("purCode", purCode);
                }
                String purCodeName= et.getChild("采购方名称", ns) == null ? null : et.getChild("采购方名称", ns).getText();
                if (StringUtils.isNotBlank(purCodeName)) {
                    map0.put("purCodeName", purCodeName);
                }
                String consumerCity= et.getChild("客户城市", ns) == null ? null : et.getChild("客户城市", ns).getText();
                if (StringUtils.isNotBlank(consumerCity)) {
                    map0.put("consumerCity", consumerCity);
                }
                String consumerAddr= et.getChild("客户地址", ns) == null ? null : et.getChild("客户地址", ns).getText();
                if (StringUtils.isNotBlank(consumerAddr)) {
                    map0.put("consumerAddr", consumerAddr);
                }
                String productType= et.getChild("剂型", ns) == null ? null : et.getChild("剂型", ns).getText();
                if (StringUtils.isNotBlank(productType)) {
                    map0.put("productType", productType);
                }
                String hasTaxPrice= et.getChild("含税单价", ns) == null ? null : et.getChild("含税单价", ns).getText();
                if (StringUtils.isNotBlank(hasTaxPrice)) {
                    map0.put("hasTaxPrice", hasTaxPrice);
                }
                String hasTaxMoney= et.getChild("含税金额", ns) == null ? null : et.getChild("含税金额", ns).getText();
                if (StringUtils.isNotBlank(hasTaxMoney)) {
                    map0.put("hasTaxMoney", hasTaxMoney);
                }
                String saleType= et.getChild("销售类型", ns) == null ? null : et.getChild("销售类型", ns).getText();
                if (StringUtils.isNotBlank(saleType)) {
                    map0.put("saleType", saleType);
                }
                String deliverAddr= et.getChild("送货地址", ns) == null ? null : et.getChild("送货地址", ns).getText();
                if (StringUtils.isNotBlank(deliverAddr)) {
                    map0.put("deliverAddr", deliverAddr);
                }
                String businessManager= et.getChild("业务员", ns) == null ? null : et.getChild("业务员", ns).getText();
                if (StringUtils.isNotBlank(businessManager)) {
                    map0.put("businessManager", businessManager);
                }
                String drawer= et.getChild("开票员", ns) == null ? null : et.getChild("开票员", ns).getText();
                if (StringUtils.isNotBlank(drawer)) {
                    map0.put("drawer", drawer);
                }
                String departureDate= et.getChild("出库日期", ns) == null ? null : et.getChild("出库日期", ns).getText();
                if (StringUtils.isNotBlank(departureDate)) {
                    map0.put("departureDate", departureDate);
                }
                String internalAllocation= et.getChild("内部调拨", ns) == null ? null : et.getChild("内部调拨", ns).getText();
                if (StringUtils.isNotBlank(internalAllocation)) {
                    map0.put("internalAllocation", internalAllocation);
                }
                String returnDate= et.getChild("销退上架日期", ns) == null ? null : et.getChild("销退上架日期", ns).getText();
                if (StringUtils.isNotBlank(returnDate)) {
                    map0.put("returnDate", returnDate);
                }
                String releaseDate= et.getChild("释放日期", ns) == null ? null : et.getChild("释放日期", ns).getText();
                if (StringUtils.isNotBlank(releaseDate)) {
                    map0.put("releaseDate", releaseDate);
                }
                String correctionDocuments= et.getChild("单据更正", ns) == null ? null : et.getChild("单据更正", ns).getText();
                if (StringUtils.isNotBlank(correctionDocuments)) {
                    map0.put("correctionDocuments", correctionDocuments);
                }
                String invalidState= et.getChild("作废状态", ns) == null ? null : et.getChild("作废状态", ns).getText();
                if (StringUtils.isNotBlank(invalidState)) {
                    map0.put("invalidState", invalidState);
                }
                String originalNumber= et.getChild("原单号", ns) == null ? null : et.getChild("原单号", ns).getText();
                if (StringUtils.isNotBlank(originalNumber)) {
                    map0.put("originalNumber", originalNumber);
                }
                //--------------------------采购----------------
                String procuremenaDte= et.getChild("采购日期", ns) == null ? null : et.getChild("采购日期", ns).getText();
                if (StringUtils.isNotBlank(procuremenaDte)) {
                    map0.put("procuremenaDte", procuremenaDte);
                }
                String supplierCode= et.getChild("供应商代码", ns) == null ? null : et.getChild("供应商代码", ns).getText();
                if (StringUtils.isNotBlank(supplierCode)) {
                    map0.put("supplierCode", supplierCode);
                }
                String supplierName= et.getChild("供应商名称", ns) == null ? null : et.getChild("供应商名称", ns).getText();
                if (StringUtils.isNotBlank(supplierName)) {
                    map0.put("supplierName", supplierName);
                }
                String procuremenaCode= et.getChild("采购方代码", ns) == null ? null : et.getChild("采购方代码", ns).getText();
                if (StringUtils.isNotBlank(procuremenaCode)) {
                    map0.put("procuremenaCode", procuremenaCode);
                }
                String procuremenName= et.getChild("采购方名称", ns) == null ? null : et.getChild("采购方名称", ns).getText();
                if (StringUtils.isNotBlank(procuremenName)) {
                    map0.put("procuremenName", procuremenName);
                }
                String price= et.getChild("单价", ns) == null ? null : et.getChild("单价", ns).getText();
                if (StringUtils.isNotBlank(price)) {
                    map0.put("price", price);
                }
                String money= et.getChild("金额", ns) == null ? null : et.getChild("金额", ns).getText();
                if (StringUtils.isNotBlank(money)) {
                    map0.put("money", money);
                }
                String procuremenBill= et.getChild("采购单号", ns) == null ? null : et.getChild("采购单号", ns).getText();
                if (StringUtils.isNotBlank(procuremenBill)) {
                    map0.put("procuremenBill", procuremenBill);
                }
                String procuremenType= et.getChild("采购类型", ns) == null ? null : et.getChild("采购类型", ns).getText();
                if (StringUtils.isNotBlank(procuremenType)) {
                    map0.put("procuremenType", procuremenType);
                }
                String cancelOriginalOrder= et.getChild("作废原单", ns) == null ? null : et.getChild("作废原单", ns).getText();
                if (StringUtils.isNotBlank(cancelOriginalOrder)) {
                    map0.put("cancelOriginalOrder", cancelOriginalOrder);
                }
                list.add(map0);
            }
            map.put("detail", list);
        }
    }

    public static void main(String[] args) {
        GyYNXMLUtilDoc doc = new GyYNXMLUtilDoc();
        String str ="<?xml version='1.0' encoding='utf-16' standalone='yes'?><reponseEnvelope><header><appCode>800002</appCode></header><body><dataStores><grid>\n" +
                "<采购日期>2019-07-15 13:42:56</采购日期>\n" +
                "<供应商代码>2144002</供应商代码>\n" +
                "<供应商名称>华润广东医药有限公司</供应商名称>\n" +
                "<采购方代码>1</采购方代码>\n" +
                "<采购方名称>国药控股云南有限公司</采购方名称>\n" +
                "<产品代码>11081636440</产品代码>\n" +
                "<产品名称>艾塞那肽注射液(百泌达)</产品名称>\n" +
                "<产品规格>10μg(0.25 mg/ml, 2.4 ml/支)</产品规格>\n" +
                "<生产日期>20180801</生产日期>\n" +
                "<失效日期>20210731</失效日期>\n" +
                "<批号>19C014</批号>\n" +
                "<批准文号>进口药品注册证号H20140822</批准文号>\n" +
                "<数量>30</数量>\n" +
                "<单位>盒</单位>\n" +
                "<单价>1403.4701</单价>\n" +
                "<金额>42104.1</金额>\n" +
                "<采购单号>205190094211</采购单号>\n" +
                "<采购类型>采购订单</采购类型>\n" +
                "<生产厂家>BaxterpharmaceutlcalSolutionsLLC</生产厂家>\n" +
                "<厂牌>阿斯利康三生</厂牌>\n" +
                "<作废状态>正常</作废状态>\n" +
                "<作废原单></作废原单>\n" +
                "</grid>\n" +
                "<grid>\n" +
                "<采购日期>2019-08-27 15:48:28</采购日期>\n" +
                "<供应商代码>000001</供应商代码>\n" +
                "<供应商名称>国药控股云南有限公司</供应商名称>\n" +
                "<采购方代码>40</采购方代码>\n" +
                "<采购方名称>国药控股普洱有限公司</采购方名称>\n" +
                "<产品代码>1121152868b</产品代码>\n" +
                "<产品名称>注射用重组人II型肿瘤坏死因子受体-抗体融合蛋白(益赛普)</产品名称>\n" +
                "<产品规格>25mg</产品规格>\n" +
                "<生产日期>20190419</生产日期>\n" +
                "<失效日期>20220331</失效日期>\n" +
                "<批号>201906049</批号>\n" +
                "<批准文号>国药准字S20050059</批准文号>\n" +
                "<数量>30</数量>\n" +
                "<单位>支</单位>\n" +
                "<单价>612.91665</单价>\n" +
                "<金额>18387.5</金额>\n" +
                "<采购单号>205190119987</采购单号>\n" +
                "<采购类型>采购订单</采购类型>\n" +
                "<生产厂家>三生国健药业(上海)股份有限公司(原上海中信国健药业股份有限公司)</生产厂家>\n" +
                "<厂牌>三生</厂牌>\n" +
                "<作废状态>正常</作废状态>\n" +
                "<作废原单></作废原单>\n" +
                "</grid>\n" +
                "</dataStores></body></reponseEnvelope>";

//        String str = "<?xml version='1.0' encoding='utf-16' standalone='yes'?><reponseEnvelope><header><appCode>800001</appCode></header><body><dataStores><grid>\n" +
//                "<销售日期>2019-07-12 08:38:33</销售日期>\n" +
//                "<销售方代码>1</销售方代码>\n" +
//                "<销售方名称>国药控股云南有限公司</销售方名称>\n" +
//                "<单据号>19354720</单据号>\n" +
//                "<处方医院代码></处方医院代码>\n" +
//                "<处方医院名称></处方医院名称>\n" +
//                "<采购方代码>41530080</采购方代码>\n" +
//                "<采购方名称>云南省肿瘤医院（昆明医科大学第三附属医院）</采购方名称>\n" +
//                "<客户城市></客户城市>\n" +
//                "<客户地址>昆明市昆州路519号</客户地址>\n" +
//                "<产品代码>11171607890</产品代码>\n" +
//                "<产品名称>重组人血小板生成素注射液(特比澳)</产品名称>\n" +
//                "<产品规格>15000U/1ml</产品规格>\n" +
//                "<批号>201904032</批号>\n" +
//                "<批准文号>国药准字S20050048</批准文号>\n" +
//                "<生产日期>20190403</生产日期>\n" +
//                "<失效日期>20220402</失效日期>\n" +
//                "<生产厂家>沈阳三生制药有限责任公司</生产厂家>\n" +
//                "<剂型>注射液(水针剂)，油针剂，混悬针剂</剂型>\n" +
//                "<数量>30</数量>\n" +
//                "<单位>支</单位>\n" +
//                "<含税单价>1008</含税单价>\n" +
//                "<含税金额>30240</含税金额>\n" +
//                "<销售类型>销售</销售类型>\n" +
//                "<送货地址>昆明市昆州路519号西药针剂库</送货地址>\n" +
//                "<业务员>赵红杏</业务员>\n" +
//                "<开票员>李桃艳</开票员>\n" +
//                "<厂牌>三生</厂牌>\n" +
//                "<出库日期>2019-07-12 10:39:40</出库日期>\n" +
//                "<内部调拨>NO</内部调拨>\n" +
//                "<销退上架日期></销退上架日期>\n" +
//                "<释放日期>2019-07-12</释放日期>\n" +
//                "<单据更正>NO</单据更正>\n" +
//                "<作废状态>正常</作废状态>\n" +
//                "<原单号></原单号>\n" +
//                "</grid>\n" +
//                "<grid>\n" +
//                "<销售日期>2019-09-04 08:41:19</销售日期>\n" +
//                "<销售方代码>1</销售方代码>\n" +
//                "<销售方名称>国药控股云南有限公司</销售方名称>\n" +
//                "<单据号>19478841</单据号>\n" +
//                "<处方医院代码></处方医院代码>\n" +
//                "<处方医院名称></处方医院名称>\n" +
//                "<采购方代码>KM500134a</采购方代码>\n" +
//                "<采购方名称>昆明市呈贡区人民医院</采购方名称>\n" +
//                "<客户城市></客户城市>\n" +
//                "<客户地址>昆明市呈贡区富康路2号</客户地址>\n" +
//                "<产品代码>KM01004348S</产品代码>\n" +
//                "<产品名称>蔗糖铁注射液</产品名称>\n" +
//                "<产品规格>100mg（铁）:5ml</产品规格>\n" +
//                "<批号>21190610</批号>\n" +
//                "<批准文号>国药准字H20055756</批准文号>\n" +
//                "<生产日期>20190629</生产日期>\n" +
//                "<失效日期>20210628</失效日期>\n" +
//                "<生产厂家>成都天台山制药有限公司</生产厂家>\n" +
//                "<剂型>注射液(水针剂)，油针剂，混悬针剂</剂型>\n" +
//                "<数量>100</数量>\n" +
//                "<单位>支</单位>\n" +
//                "<含税单价>40.86</含税单价>\n" +
//                "<含税金额>4086</含税金额>\n" +
//                "<销售类型>销售</销售类型>\n" +
//                "<送货地址>昆明市呈贡区富康路2号  </送货地址>\n" +
//                "<业务员>李世超</业务员>\n" +
//                "<开票员>何昊远</开票员>\n" +
//                "<厂牌>三生</厂牌>\n" +
//                "<出库日期>2019-09-04 09:24:02</出库日期>\n" +
//                "<内部调拨>NO</内部调拨>\n" +
//                "<销退上架日期></销退上架日期>\n" +
//                "<释放日期>2019-09-04</释放日期>\n" +
//                "<单据更正>NO</单据更正>\n" +
//                "<作废状态>正常</作废状态>\n" +
//                "<原单号></原单号>\n" +
//                "</grid>\n" +
//                "</dataStores></body></reponseEnvelope>";

//        String str = "<?xml version='1.0' encoding='utf-16' standalone='yes'?><reponseEnvelope><header><appCode>800003</appCode></header><body><dataStores><grid>\n" +
//                "<库存日期>2019-10-30 15:21:09</库存日期>\n" +
//                "<仓库代码>1</仓库代码>\n" +
//                "<仓库名称>国药控股云南有限公司</仓库名称>\n" +
//                "<公司代码>1</公司代码>\n" +
//                "<公司名称>国药控股云南有限公司</公司名称>\n" +
//                "<产品代码>3108162563b</产品代码>\n" +
//                "<产品名称>精蛋白锌重组人胰岛素混合注射液(优泌林70/30)</产品名称>\n" +
//                "<产品规格>3ml:300单位(笔芯)</产品规格>\n" +
//                "<批号>D006858CC</批号>\n" +
//                "<批准文号>国药准字J20170018</批准文号>\n" +
//                "<数量>80</数量>\n" +
//                "<单位>盒</单位>\n" +
//                "<生产日期>20181113</生产日期>\n" +
//                "<失效日期>20211031</失效日期>\n" +
//                "<生产厂家>礼来苏州制药有限公司</生产厂家>\n" +
//                "<厂牌>三生</厂牌>\n" +
//                "<库存类型>冷藏</库存类型>\n" +
//                "<业务锁定数量>0</业务锁定数量>\n" +
//                "<库存状态>合格</库存状态>\n" +
//                "</grid>\n" +
//                "<grid>\n" +
//                "<库存日期>2019-10-30 15:21:09</库存日期>\n" +
//                "<仓库代码>60</仓库代码>\n" +
//                "<仓库名称>国药控股楚雄有限公司</仓库名称>\n" +
//                "<公司代码>60</公司代码>\n" +
//                "<公司名称>国药控股楚雄有限公司</公司名称>\n" +
//                "<产品代码>KM01002230a</产品代码>\n" +
//                "<产品名称>米诺地尔酊(蔓迪)</产品名称>\n" +
//                "<产品规格>5%(60ml:3.0g)</产品规格>\n" +
//                "<批号>190611</批号>\n" +
//                "<批准文号>国药准字H20010714</批准文号>\n" +
//                "<数量>40</数量>\n" +
//                "<单位>盒</单位>\n" +
//                "<生产日期>20190624</生产日期>\n" +
//                "<失效日期>20210531</失效日期>\n" +
//                "<生产厂家>浙江万晟药业有限公司（原浙江万马药业有限公司）</生产厂家>\n" +
//                "<厂牌>三生</厂牌>\n" +
//                "<库存类型>常温</库存类型>\n" +
//                "<业务锁定数量>0</业务锁定数量>\n" +
//                "<库存状态>合格</库存状态>\n" +
//                "</grid>\n" +
//                "</dataStores></body></reponseEnvelope>";
        Map<String, Object> map = doc.xmlElements(str);
        transMap(map,Constants.GYYNCUSTOM_800003);
    }

    /**
     *
     * @param map
     * @return
     */
    public static List<List> transMap (Map<String, Object> map, String codeType) {
        for (Map.Entry<String, Object>  entry : map.entrySet()){
            if("detail".equals(entry.getKey())){
                List<List> lists  = new ArrayList<>();
               if(Constants.GYYNCUSTOM_800001.equals(codeType)){
                   lists = converToSaleFiled((List<Map<String, String>>) entry.getValue());
                }else if(Constants.GYYNCUSTOM_800002.equals(codeType)){
                    lists = converToPurchaseFiled((List<Map<String, String>>) entry.getValue());
                }else if(Constants.GYYNCUSTOM_800003.equals(codeType)){
                    lists = converStockInFiled((List<Map<String, String>>) entry.getValue());
                }
                System.out.println(">>:"+JSON.toJSON(lists));
                return  lists;
            }
        }
        return null ;
    }
    // 采购
    public static List<List> converToPurchaseFiled(List<Map<String,String>> lists) {
        List<List>  records = new ArrayList<>();
        for(Map<String,String> mp:lists) {
            List<String> item = new ArrayList<>();
            item.add(String.valueOf(mp.get("procuremenaDte")));
            item.add(String.valueOf(mp.get("supplierCode")));
            item.add(String.valueOf(mp.get("supplierName")));
            item.add(String.valueOf(mp.get("procuremenaCode")));
            item.add(String.valueOf(mp.get("procuremenName")));
            item.add(String.valueOf(mp.get("spec")));
            item.add(String.valueOf(mp.get("unit")));
            item.add(String.valueOf(mp.get("manufactor")));
            item.add(String.valueOf(mp.get("lotnumber")));
            item.add(String.valueOf(mp.get("manufacturedate")));
            item.add(String.valueOf(mp.get("quantity")));
            item.add(String.valueOf(mp.get("taxprice")));
            item.add(String.valueOf(mp.get("taxamount")));
            item.add(String.valueOf(mp.get("taxrate")));////单位
            item.add(String.valueOf(mp.get("price")));
            item.add(String.valueOf(mp.get("money")));
            item.add(String.valueOf(mp.get("procuremenBill")));
            item.add(String.valueOf(mp.get("procuremenType")));
            item.add(String.valueOf(mp.get("validitydate")));////生产厂家
            item.add(String.valueOf(mp.get("approvalnumber")));
            item.add(String.valueOf(mp.get("invalidState")));
            item.add(String.valueOf(mp.get("cancelOriginalOrder")));

//                    //todo 取值
//                    item.add((String.valueOf(AgentCode.map.get(mp.get("ownername")))));
//                    item.add((String.valueOf(AgentCode.mapIndex.get(mp.get("ownername")))));
            records.addAll(Collections.singleton(item));
        }
        return records;
    }

    // 销售
    public static List<List> converToSaleFiled(List<Map<String,String>> lists) {
        List<List>  records = new ArrayList<>();
        for(Map<String,String> mp:lists) {
            List<String> item = new ArrayList<>();
            item.add(String.valueOf(mp.get("xiaoShouRiQi")));
            item.add(String.valueOf(mp.get("xiaoShouDaiMa")));
            item.add(String.valueOf(mp.get("xiaoShouName")));
            item.add(String.valueOf(mp.get("danJiuHao")));
            item.add(String.valueOf(mp.get("chuFangHostiptalCode")));
            item.add(String.valueOf(mp.get("chuFangHostiptalCodeName")));
            item.add(String.valueOf(mp.get("purCode")));
            item.add(String.valueOf(mp.get("purCodeName")));
            item.add(String.valueOf(mp.get("consumerCity")));
            item.add(String.valueOf(mp.get("consumerAddr")));
            item.add(String.valueOf(mp.get("spec")));
            item.add(String.valueOf(mp.get("unit")));
            item.add(String.valueOf(mp.get("manufactor")));
            item.add(String.valueOf(mp.get("quantity")));
            item.add(String.valueOf(mp.get("taxprice")));
            item.add(String.valueOf(mp.get("lotnumber")));//生产日期
            item.add(String.valueOf(mp.get("manufacturedate")));
            item.add(String.valueOf(mp.get("validitydate")));////生产厂家
            item.add(String.valueOf(mp.get("productType")));////剂型
            item.add(String.valueOf(mp.get("taxamount")));////
            item.add(String.valueOf(mp.get("taxrate")));////单位
            item.add(String.valueOf(mp.get("hasTaxPrice")));//
            item.add(String.valueOf(mp.get("hasTaxMoney")));//
            item.add(String.valueOf(mp.get("saleType")));//
            item.add(String.valueOf(mp.get("deliverAddr")));//送货地址
            item.add(String.valueOf(mp.get("businessManager")));
            item.add(String.valueOf(mp.get("drawer")));
            item.add(String.valueOf(mp.get("approvalnumber")));
            item.add(String.valueOf(mp.get("departureDate")));
            item.add(String.valueOf(mp.get("returnDate")));
            item.add(String.valueOf(mp.get("releaseDate")));  //释放日期
            item.add(String.valueOf(mp.get("correctionDocuments")));  //
            item.add(String.valueOf(mp.get("invalidState")));
            item.add(String.valueOf(mp.get("originalNumber")));

//                    //todo 取值
//                    item.add((String.valueOf(AgentCode.map.get(mp.get("ownername")))));
//                    item.add((String.valueOf(AgentCode.mapIndex.get(mp.get("ownername")))));
            records.addAll(Collections.singleton(item));
        }
        return records;
    }
   // 入库
    public static List<List> converStockInFiled(List<Map<String,String>> lists) {
        List<List>  records = new ArrayList<>();
        for(Map<String,String> mp:lists) {
            List<String> item = new ArrayList<>();
            item.add(String.valueOf(mp.get("orderdate")));
            item.add(String.valueOf(mp.get("goodcode")));
            item.add(String.valueOf(mp.get("goodname")));
            item.add(String.valueOf(mp.get("company")));
            item.add(String.valueOf(mp.get("packageunit")));
            item.add(String.valueOf(mp.get("spec")));
            item.add(String.valueOf(mp.get("unit")));
            item.add(String.valueOf(mp.get("manufactor")));
            item.add(String.valueOf(mp.get("produnit")));
            item.add(String.valueOf(mp.get("prodproducer")));
            item.add(String.valueOf(mp.get("quantity")));
            item.add(String.valueOf(mp.get("taxprice")));
            item.add(String.valueOf(mp.get("lotnumber")));
            item.add(String.valueOf(mp.get("manufacturedate")));
            item.add(String.valueOf(mp.get("validitydate")));
            item.add(String.valueOf(mp.get("approvalnumber")));
            item.add(String.valueOf(mp.get("client")));
            item.add(String.valueOf(mp.get("buyingpeople")));
            item.add(String.valueOf(mp.get("department")));

//                    //todo 取值
//                    item.add((String.valueOf(AgentCode.map.get(mp.get("ownername")))));
//                    item.add((String.valueOf(AgentCode.mapIndex.get(mp.get("ownername")))));
                    records.addAll(Collections.singleton(item));
        }
        return records;
    }


//    public static HashMap<String, Object> fromJson2Map(String jsonString) {
//        HashMap jsonMap = JSON.parseObject(jsonString, HashMap.class);
//        HashMap<String, Object> resultMap = new HashMap<String, Object>();
//        for (Iterator iter = jsonMap.keySet().iterator(); iter.hasNext(); ) {
//            String key = (String) iter.next();
//            if (jsonMap.get(key) instanceof JSONArray) {
//                JSONArray jsonArray = (JSONArray) jsonMap.get(key);
//                List list = handleJSONArray(jsonArray);
//                resultMap.put(key, list);
//            } else {
//                resultMap.put(key, jsonMap.get(key));
//            }
//        }
//        return resultMap;
//    }

//    private static List<HashMap<String, Object>> handleJSONArray(JSONArray jsonArray) {
//        List list = new ArrayList();
//        for (Object object : jsonArray) {
//            JSONObject jsonObject = (JSONObject) object;
//            HashMap map = new HashMap<String, Object>();
//            for (Map.Entry entry : jsonObject.entrySet()) {
//                if (entry.getValue() instanceof JSONArray) {
//                    map.put((String) entry.getKey(), handleJSONArray((JSONArray) entry.getValue()));
//                } else {
//                    map.put((String) entry.getKey(), entry.getValue());
//                }
//            }
//            list.add(map);
//        }
//        return list;
//    }
}