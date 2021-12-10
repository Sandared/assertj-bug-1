
package io.qbilon;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;


public class ApplicationTest {

  @Test
  public void test() {
    // given the following two hierarchical nodes 
    NodeDTO vs1 = node("Virtual Server 1",
      properties(
        prop("sevenDayAverageCPU", "Double", Double.MAX_VALUE)
      )
    );

    NodeDTO app1 = node("Application 1",
      properties(
        prop("accountNr", "Integer", Integer.MAX_VALUE)
      )
    );

    assertThat(vs1).usingRecursiveComparison().ignoringCollectionOrderInFields("properties").isEqualTo(app1);
  }

  private NodeDTO node(String name, List<PropertyDTO> properties) {
    NodeDTO dto = new NodeDTO();
    dto.name = name;
    dto.properties = properties;
    return dto;
  }

  private List<PropertyDTO> properties(PropertyDTO... props) {
    return List.of(props);
  }

  private PropertyDTO prop(String name, String datatype, Object value) {
    PropertyDTO dto = new PropertyDTO();
    dto.name = name;
    dto.value = value;
    dto.dataType = datatype;
    return dto;
  }
}
