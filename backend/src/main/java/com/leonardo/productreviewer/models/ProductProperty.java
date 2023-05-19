package com.leonardo.productreviewer.models;

import com.leonardo.productreviewer.models.PKs.ProductPropertyPK;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(of = {"id"})

@Entity
@IdClass(ProductPropertyPK.class)
public class ProductProperty {

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @Column(length = 255, nullable = false)
    private String value;

}
