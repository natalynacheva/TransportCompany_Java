package Entity;

import javax.persistence.*;


@Entity
@Table(name="goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goodsId;

    @Column(name="weight", nullable = false)
    private double weight;




    public Goods() {

    }
    public Goods(double weight) {
        if(weight > 0) {
            this.weight = weight;
        }else throw new IllegalArgumentException();
    }
    public Goods(int goodsId, double weight) {
        this.goodsId = goodsId;
        if(weight > 0) {
            this.weight = weight;
        }else throw new IllegalArgumentException();
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        if(weight > 0) {
            this.weight = weight;
        }else throw new IllegalArgumentException();
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }


    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", weight=" + weight +
                '}';
    }
}
