package br.com.banco.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class DateDto {
       @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
        private String startDate;
       @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
        private String endDate;

    public DateDto(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
