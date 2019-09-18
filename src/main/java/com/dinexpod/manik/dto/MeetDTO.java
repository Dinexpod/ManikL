package com.dinexpod.manik.dto;

import com.dinexpod.manik.entity.Day;
import com.dinexpod.manik.entity.Meet;
import com.dinexpod.manik.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeetDTO {

    private Long id = null;
    private User client;
    private Day day;
    private String startMeet;
    private String endMeet;

    public static Meet toDTO(Meet meet) {
        Meet meetDTO = new Meet();

        meetDTO.setClient(meet.getClient());
        meetDTO.setDay(meet.getDay());
        meetDTO.setStartMeet(meet.getStartMeet());
        meetDTO.setEndMeet(meet.getEndMeet());

        return meetDTO;
    }
}
