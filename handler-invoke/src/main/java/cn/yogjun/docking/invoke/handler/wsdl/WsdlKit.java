package cn.yogjun.docking.invoke.handler.wsdl;

/**
 * {@link WsdlKit}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/3/31
 */
public class WsdlKit {

  private static AbstractWsDelegate delegate = new DefaultWsdlKit();

  public static AbstractWsDelegate getDelegate() {
    return delegate;
  }

  public static void setDelegate(AbstractWsDelegate delegate) {
    WsdlKit.delegate = delegate;
  }
}

class DefaultWsdlKit extends AbstractWsDelegate {}
