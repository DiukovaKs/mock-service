package parcer.project.mockservice.dto;

import lombok.Getter;

@Getter
public enum WorkType {
    FULL_TIME("Full time", "Full time"),
    PART_TIME("Part time", "Part time"),
    CASUAL("Casual", "Casual/Vacation"),
    CONTRACT("Contract", "Contract");

    WorkType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    private final String type;
    private final String description;
}
