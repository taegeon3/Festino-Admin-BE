package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ResponseFoodBoothGetDTO {
    UUID boothId;
    String boothName;
    String adminCategory;
    String adminName;
    String openTime;
    String closeTime;
    String boothIntro;
    List<String> boothImage;
    Integer markerNum;
    String location;
    Boolean isOpen;
}
