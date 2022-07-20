package org.terenin.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Train {

    private Long id;
    private String type;
    private Date arrivalTime;
    private Date departureTime;
    private Long passageId;

}
