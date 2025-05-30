package com.DevTino.festino_admin.booth.bean.small;

import com.DevTino.festino_admin.booth.domain.DTO.ResponseDayBoothGetDTO;
import com.DevTino.festino_admin.booth.domain.DayBoothDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateDayBoothDTOBean {

    // 주간부스 DTO 생성
    public ResponseDayBoothGetDTO exec(DayBoothDAO dayBoothDAO) {
        return ResponseDayBoothGetDTO.builder()
                .boothId(dayBoothDAO.getBoothId())
                .boothIntro(dayBoothDAO.getBoothIntro())
                .boothImage(dayBoothDAO.getBoothImage())
                .boothName(dayBoothDAO.getBoothName())
                .openTime(dayBoothDAO.getOpenTime())
                .closeTime(dayBoothDAO.getCloseTime())
                .adminName(dayBoothDAO.getAdminName())
                .adminCategory(dayBoothDAO.getAdminCategory())
                .location(dayBoothDAO.getLocation())
                .markerNum(dayBoothDAO.getMarkerNum())
                .isOpen(dayBoothDAO.getIsOpen())
                .build();
    }
}
