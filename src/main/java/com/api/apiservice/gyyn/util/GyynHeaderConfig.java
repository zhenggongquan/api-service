package com.api.apiservice.gyyn.util;

import com.api.apiservice.util.Constants;
import java.util.HashMap;
import java.util.Map;

public class GyynHeaderConfig {
    public static Map<String,String[]> hashMap = new HashMap<>(4);
    static {
        String[] companySaleHeader = {"销售日期","销售方代码","销售方名称","单据号","处方医院代码","处方医院名称","采购方代码",
        "采购方名称","客户城市","客户地址","产品代码","产品名称","产品规格","批号","批准文号","生产日期","失效日期","生产厂家",
        "剂型","数量","单位","含税单价","含税金额","销售类型","送货地址","业务员","开票员","厂牌","出库日期","内部调拨","销退上架日期","释放日期",
        "单据更正","作废状态","原单号"};
        hashMap.put(Constants.GYYNCUSTOM_800001,companySaleHeader);

        String[] purchaseHeader = {"采购日期", "供应商代码", "供应商名称", "采购方代码", "采购方名称", "产品代码", "产品名称",
                "产品规格", "生产日期", "失效日期", "批号", "批准文号", "数量","单位","单价","金额","采购单号","采购类型","生产厂家",
                "厂牌", "作废状态", "作废原单"};
        hashMap.put(Constants.GYYNCUSTOM_800002,purchaseHeader);

        String[] stockHeader = {"库存日期", "仓库代码", "仓库名称", "公司代码", "公司名称", "产品代码", "产品名称", "产品规格","批号","批准文号",
                                "数量",     "单位", "生产日期", "失效日期", "生产厂家", "厂牌", "库存类型","业务锁定数量","库存状态"};
        hashMap.put(Constants.GYYNCUSTOM_800003,stockHeader);
    }
}
