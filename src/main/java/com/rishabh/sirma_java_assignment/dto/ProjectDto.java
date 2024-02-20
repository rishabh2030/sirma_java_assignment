package com.rishabh.sirma_java_assignment.dto;

import com.rishabh.sirma_java_assignment.helper.Messages;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDto {
    private Long id;
    @NotNull(message = Messages.REQUIRED_NAME)
    private String name;
    @NotNull(message = Messages.REQUIRED_DESCRIPTION)
    private String description;
    @NotNull(message = Messages.REQUIRED_START_DATE)
    private LocalDate startDate;
    @NotNull(message = Messages.REQUIRED_END_DATE)
    private LocalDate endDate;
}
