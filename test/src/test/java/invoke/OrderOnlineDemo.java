package invoke;

import com.docking.wsdl.xlt.CreateOrderRequest;
import com.docking.wsdl.xlt.CreateOrderResponse;
import com.docking.wsdl.xlt.DeclareItem;
import com.docking.wsdl.xlt.OrderOnlineService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * 在线订单测试
 *
 * <p>User: zhongwl Date: 13-11-29 Time: 上午9:48
 */
public class OrderOnlineDemo {

  public static void main(String[] args) {
    try {
      JaxWsProxyFactoryBean svr = new JaxWsProxyFactoryBean();
      svr.setServiceClass(OrderOnlineService.class);
      svr.setAddress(URL);
      OrderOnlineService service = (OrderOnlineService) svr.create();
      // 创建订单
      //            CreateOrderResponse createResponse = createOrder(service, false);
      //            System.out.println("createResponse:\n" + createResponse);
      //            //预报订单
      //            AuditOrderResponse auditResponse = auditOrder(service);
      //            System.out.println("auditResponse:\n" + auditResponse);
      //            //创建并预报订单
      CreateOrderResponse createAndAuditResponse = createOrder(service, true);
      System.out.println("createAndAuditResponse:\n" + createAndAuditResponse);
      //            //删除订单
      //            DeleteOrderResponse deleteResponse = deleteOrder(service);
      //            System.out.println("deleteResponse:\n" + deleteResponse);
      // 获取渠道列表
      //            GetTransportWayListResponse transportWayListResponse =
      // service.getTransportWayList(userToken);
      //			System.out.println("getTransportWayList:\n" + transportWayListResponse);
      // 获取订单信息
      //			OrderInfoResponse infoResponse = getOrderInfo(service);
      //           System.out.println("orderInfoResponse:\n" + infoResponse);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 创建订单
  private static CreateOrderResponse createOrder(OrderOnlineService service, boolean audit) {
    CreateOrderRequest req = new CreateOrderRequest();
    req.setTrackingNo("HP000000001SG"); // 服务商跟踪号码
    req.setOrderNo("HP000000001SG"); // 客户单号
    req.setTransportWayCode("XJPPOSTGH"); // 运输方式代码（渠道代码）。必填
    req.setCargoCode("W"); // 货物类型(W包裹/D文件)。必填
    req.setInsured("Y"); // 购买保险（投保：Y，不投保：N）。 必填
    req.setWeight(0.368); // 货物预报重量。必填；0<=value
    req.setGoodsCategory("G"); // 物品类别(G/D/S/R/O)'。必填
    req.setGoodsDescription("Gift"); // 物品类别内容
    req.setPieces(1l);
    // 收货人
    req.setDestinationCountryCode("NL"); // 目的国家二字简码。必填
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

    DeclareItem[] declareItems = new DeclareItem[] {declareItem1, declareItem2};

    if (audit) return service.createAndAuditOrder(userToken, req); // 创建并预报订单
    else return service.createOrder(userToken, req); // 创建订单
  }

  // 测试环境
  private static final String userToken = "8a3ddab172a74ad887be919a2aa41641"; // 从会员系统【物流接口】中获取
  private static final String URL =
      "http://www.360chain.com:8086/xms/services/order"; // 服务地址，不包含?wsdl

  // 正式环境
  //    private final static String userToken = "0ee02d147f1e4cbc882e3fd42e826f2c";//从会员系统【物流接口】中获取
  //    private final static String URL =
  // "http://kd.szice.net:8086/xms/services/order";//服务地址，不包含?wsdl
}
