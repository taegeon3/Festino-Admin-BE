package com.DevTino.festino_admin.menu.domain.DTO;

import com.DevTino.festino_admin.menu.domain.MenuType;
import lombok.Data;

import java.util.UUID;

@Data
public class RequestMenuUpdateDTO {
    UUID menuId;
    UUID boothId;
    String menuName;
    String menuImage;
    String menuDescription;
    Integer menuIndex;
    Integer menuPrice;
    Boolean isSoldOut;
    MenuType menuType;
}
