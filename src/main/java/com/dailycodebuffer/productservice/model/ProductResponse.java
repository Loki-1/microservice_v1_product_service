package com.dailycodebuffer.productservice.model;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private long price;
    private long quantity;

}
[root@ip-172-31-5-21 model]# ls
ErrorResponse.java  ProductRequest.java  ProductResponse.java
[root@ip-172-31-5-21 model]# cat ProductResponse.java
package com.dailycodebuffer.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductResponse {
    private String productName;
    private long productId;
    private long quantity;
    private long price;
}
