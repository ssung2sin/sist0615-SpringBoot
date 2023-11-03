package boot.data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("sshop")
public class SmartDto {
    private int num;
    private int price;
    private String sangname;
    private String color;
    private String content;
    private String ipgoday;
}
