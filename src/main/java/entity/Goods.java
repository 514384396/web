package entity;

import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;
@Data
public class Goods {
    private Integer id;
    private String name;
    private String introduce;
    private Integer stock;
    private String unit;
    private Integer price;//商品价格  12.34  -》 1234
    private Integer discount;
    private Integer buyGoodsNum;

    public double getPrice() {
        return price * 1.0 / 100;
    }
    //这个是返回整数的价格
    public int getPriceInt() {
        return price;
    }
}





















