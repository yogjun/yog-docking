package jsonpath;

import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.util.List;

/**
 * {@link JsonPathTest}
 *
 * @author <a href="mailto:matthew.miao@yunlsp.com">matthew.miao</a>
 * @version ${project.version} - 2023/3/27
 */
public class JsonPathTest {

  private String json =
      "{\"store\":{\"book\":[{\"category\":\"reference\",\"author\":\"NigelRees\",\"title\":\"SayingsoftheCentury\",\"price\":8.95},{\"category\":\"fiction\",\"author\":\"EvelynWaugh\",\"title\":\"SwordofHonour\",\"price\":12.99},{\"category\":\"fiction\",\"author\":\"HermanMelville\",\"title\":\"MobyDick\",\"isbn\":\"0-553-21311-3\",\"price\":8.99},{\"category\":\"fiction\",\"author\":\"J.R.R.Tolkien\",\"title\":\"TheLordoftheRings\",\"isbn\":\"0-395-19395-8\",\"price\":22.99}],\"bicycle\":{\"color\":\"red\",\"price\":19.95}},\"expensive\":10}";

  @Test
  public void refs() {
    String newJson =
        JsonPath.parse(json).set("$['store']['book'][0]['author']", "Paul").jsonString();
    System.out.println(newJson);
  }

  @Test
  public void testFromBean() {
    List<String> authors = JsonPath.read(json, "$.store.book[*].author");
    System.out.println(authors);
  }
}
