package invoke;

import cn.yogjun.docking.invoke.handler.wsdl.WebServiceUtil;
import com.docking.wsdl.xlt.*;
import com.google.common.collect.Lists;
import org.junit.Test;

/**
 * {@link WsdlTest}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/4/4
 */
public class WsdlTest {

  private static final String URL = "http://47.92.33.48:8086/xms/services/order";

  @Test
  public void testQuery() {
    OrderOnlineService service = WebServiceUtil.getWebServiceByUrl(OrderOnlineService.class, URL);
    LookupOrderRequest request = new LookupOrderRequest();
    request.setOrderId("1140920243");
    LookupOrderResponse res = service.lookupOrder("1958538970ce46b79081437d8d3d35b4", request);
    System.out.println(res);
  }

  @Test
  public void testWsdl() {

    String jsonInfo = null;
    try {
      OrderOnlineService service = WebServiceUtil.getWebServiceByUrl(OrderOnlineService.class, URL);

      CreateOrderRequest req = new CreateOrderRequest();
      req.setTrackingNo("HP000000001SG"); // 服务商跟踪号码
      req.setOrderNo("HGJKJ00001"); // 客户单号
      req.setTransportWayCode("LT110"); // 运输方式代码（渠道代码）。必填
      req.setCargoCode("W"); // 货物类型(W包裹/D文件)。必填
      req.setInsured("Y"); // 购买保险（投保：Y，不投保：N）。 必填
      req.setWeight(0.368); // 货物预报重量。必填；0<=value
      req.setGoodsCategory("G"); // 物品类别(G/D/S/R/O)'。必填
      req.setGoodsDescription("Gift"); // 物品类别内容
      req.setPieces(1l);
      // 收货人
      req.setDestinationCountryCode("US"); // 目的国家二字简码。必填
      req.setConsigneeCompanyName("XXX Company "); // 收件人公司名称。length<=100
      req.setConsigneeName("Wuyun"); // 收件人姓名。 length<=100
      req.setConsigneeTelephone("333333"); // 收件人电话号码。length<=32
      req.setConsigneeMobile("3222222"); // 收件人手机号码。length<=32
      req.setStreet(
          "--15D number three Building Xinghu Luohu Distractadsfghjkl;zzxvcbnm,.wertyuidfsghjkzxcvbnm,.sdfghjkl;'cxcvbnm,./asdfghjkl;'zxcvbnm,./qwertyuiop["); // 街道。必填；length<=200
      req.setCity("Madrid"); // 城市。必填；length<=60
      req.setProvince("Spain"); // 省/州。必填；length<=60
      req.setConsigneePostcode("12345678901234567890123456789012"); // 收件人邮编。length<=10
      // 发货人
      req.setOriginCountryCode("");
      req.setShipperCompanyName("Hlt Limited Company"); // 发件人公司名称。length<=100
      req.setShipperName("Wenlong Zhong"); // 发件人姓名.length<=100
      req.setShipperTelephone("0710-66666666"); // 发件人电话号码。length<=32
      req.setShipperMobile("15989511190"); // 发件人手机号码。length<=32
      req.setShipperAddress(
          "Beautiful street 368#, Nanshan area,Shenzhen,Guangdong"); // 发件人地址。length<=200
      // 报关明细
      DeclareItem declareItem1 = new DeclareItem();
      declareItem1.setName("Clear paper(Red)"); // 申报品名。必填；0<length<100
      declareItem1.setNetWeight(0.123); // 净重(kg)。必填;0<=value
      declareItem1.setUnitPrice(3.6); // 单价。必填；0<value
      declareItem1.setPieces(2l); // 件数。必填；1<value
      declareItem1.setProductMemo("配货备注abc123");

      DeclareItem declareItem2 = new DeclareItem();
      declareItem2.setName("Clear paper(Blue)");
      declareItem2.setNetWeight(0.123);
      declareItem2.setUnitPrice(5.6);
      declareItem2.setPieces(2l);
      req.setDeclareItems(Lists.newArrayList(declareItem1));

      CreateOrderResponse res = service.createOrder("1958538970ce46b79081437d8d3d35b4", req);
      System.out.println(res);

    } catch (Exception se) {
      se.printStackTrace();
    }
  }
}
