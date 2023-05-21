package uz.najottalim.javan6.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private String status;
    private Long customerId;
    private Long[] productIds;
}
