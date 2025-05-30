package com.DevTino.festino_admin.order.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Builder
public class ResponseOrderCookingGetDTO {

    UUID menuId;
    String menuName;
    Integer tableCount;
    Integer totalRemainCount;
    List<Map<String, Object>> cookList;

}
