import lombok.Getter;
import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column(name = "min_price_wanted")
    private Long minPriceWanted;

    @Column
    private String writer;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    private ProductStatus status = ProductStatus.FOR_SALE;

    @Column(name = "image_url")
    private String imageUrl;

    public enum ProductStatus {
        FOR_SALE("판매중"),
        SOLD("판매 완료");

        private String description;

        ProductStatus(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}

